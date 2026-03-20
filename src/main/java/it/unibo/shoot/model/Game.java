package it.unibo.shoot.model;

//import java.awt.Window;
import java.awt.Canvas;
import it.unibo.shoot.view.Window;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    public Game() {
        new Window(1000, 563, "ShOOt", this);
    }

    public void run() {
    }

    public static void main(String args[]) {
        new Game();
    }
}
