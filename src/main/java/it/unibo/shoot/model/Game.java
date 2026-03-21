package it.unibo.shoot.model;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import it.unibo.shoot.view.Window;

import it.unibo.shoot.model.box.Box; //tODO remove

public class Game extends Canvas implements Runnable {

    //private static final long serialVersionUID = 1L;
    private boolean isRunning = false;
    private Thread thread;
    private Handler handler;

    // Constructor
    public Game() {
        // Calls a new window
        new Window(1000, 563, "ShOOt", this); // TODO: change values
        start();

        handler = new Handler();

        //TODO: remove
        handler.addObject(new Box(20, 20, ID.Box));
    }


    // Notch (Markus Persson) made this game loop
    /*
     Our window is getting updated 60 times per second,
     updating the render method a couple thousand times per second.
    */
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
                //updates++;
                delta --;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
                //updates = 0;
            }
        }
        stop();
    }

    // Used to update everything in the game
    // Runs 60 times per second
    public void tick() {
        handler.tick();
    }

    // To use graphics (render everything in the game)
    // Runs a couple times per second
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            // Preloads (3) frames behind the actual window
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        //

        // Things we need to draw go here
        // eg. Sample background
        g.setColor(Color.blue);
        g.fillRect(0, 0, 1000, 563);

        /*
        NOTE: it is important to put handler after the background
        because graphics is placed top to bottom
        */
        handler.render(g);

        //
        g.dispose();
        bs.show();
    }

    // Starts thread
    private void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    // Stops thread
    private void stop() {
        isRunning = false;
        try {
            thread.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        // Creates new instance of Game calling constructor
        new Game();
    }
}
