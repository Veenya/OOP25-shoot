package it.unibo.shoot.model;

//import java.awt.Window;
import java.awt.Canvas;
import it.unibo.shoot.view.Window;

public class Game extends Canvas implements Runnable {

    //private static final long serialVersionUID = 1L;
    private boolean isRunning = false;
    private Thread thread;

    public Game() {
        new Window(1000, 563, "ShOOt", this);
        start();
    }


    // Noch
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                //update++;
                delta --;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
                //update = 0;
            }
        }
        stop();
    }

    public void tick() {}

    public void render() {}

    private void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    private void stop() {
        isRunning = false;
        try {
            thread.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Game();
    }
}
