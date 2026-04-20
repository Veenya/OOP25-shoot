package it.unibo.shoot.model;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import it.unibo.shoot.view.Window;
import it.unibo.shoot.loader.*;  //TODO: maybe it's better to specify the file?
import it.unibo.shoot.model.block.Block;
import it.unibo.shoot.view.Camera;
import it.unibo.shoot.util.Constants;


/**
 * Main game class: handles window, game loop, rendering and level loading.
 * 
 * Uses a fixed 60 ticks per second to update the loop.
 */
public class Game extends Canvas implements Runnable {

    //private static final long serialVersionUID = 1L;
    private boolean isRunning = false;
    private Thread thread;
    private Handler handler;
    private Camera camera;
    private SpriteSheet tile_ss;
    //TODO: other spritesheets
    //private SpriteSheet player_ss;
    //private Spritesheet enemy_ss;

    private BufferedImage level = null;
    //private BufferedImage tile_sheet = null;
    private BufferedImage floor = null;
    private BufferedImage block = null;
    //private BufferedImage player_sheet = null;
    //private BufferedImage enemy_sheet = null;
    // TODO other sheets if needed...

    

    int width = Constants.SCREEN_WIDTH;
    int height = Constants.SCREEN_HEIGHT;
    String title = Constants.TITLE;
    


    //TODO: da finire
    /**
     * Constructof of Game object.
     * Initializes window, handler, image loader. 
     */
    public Game() {
        new Window(width, height, title, this);
        

        handler = new Handler();
        camera = new Camera(0, 0);
        

        BufferedImageLoader loader = new BufferedImageLoader();
        level = loader.loadImage("/maps/map1.png"); //TODO: check if it works with every OS
        //tile_sheet = loader.loadImage("/tiles/floor_tile.png");
        //TODO: put other sheets here

        tile_ss = new SpriteSheet("/tiles/tileset.png");
        floor = tile_ss.grabImage(0, 0);
        block = tile_ss.grabImage(1, 0);
        //TODO other spritesheets

        loadLevel(level);
        start();
    }


    // Notch (Markus Persson) made this game loop
    // TODO: this is wrong, fix it. Also make better javadoc.
    /**
     * Updates window 60 times per second, updating the render method a couple thousands times per second.
    */
    @Override
    public void run() {
        this.requestFocus();// TODO: why
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

    /**
     * Updates everything in the game. It runs 60 times per second.
     */
    public void tick() {
        for (int i = 0; i<handler.object.size(); i++) {
            if (handler.object.get(i).getId() == ID.Player) {
                camera.tick(handler.object.get(i));
            }
        }
        handler.tick();
    }

    /**
     * Renders everything in the game using graphics.
     * It runs a couple thousand times per second.
     */
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            // Preloads (3) frames behind the actual window
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;
        ////////////////
        // Background
        g.setColor(Color.pink);
        g.fillRect(0, 0, width, height);
        
        g2d.translate(-camera.getX(), -camera.getY());

        //TODO change numbers
        for (int xx = 0; xx < 30*72; xx+=32) {
            for (int yy=0; yy < 30*72; yy+=32) {
                g.drawImage(floor, xx, yy, null);
            }
        }
        
        /*
        NOTE: it is important to put handler after the background
        because graphics is placed top to bottom
        */
       
        handler.render(g);

        g2d.translate(camera.getX(), camera.getY());

        //TODO: HUD coordinate fisse sullo schermo
        //renderHUD(g);

        /////////////
        g.dispose();
        bs.show();
    }

    /**
     * Loads level from image.
     * @param image that will be displayed as level map.
     */
    private void loadLevel(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();

        System.out.println(w);

        // TODO: use global variables
        for (int xx = 0; xx < w; xx++) {
            for (int yy = 0; yy < h; yy++) {
                int pixel = image.getRGB(xx, yy);
                // TODO: understand this
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if (red == 255) {
                    handler.addObject(new Block(xx*Constants.TILE_SIZE, yy*Constants.TILE_SIZE, ID.Block, tile_ss));
                }

                if (blue == 255) {
                    //TODO: player
                    handler.addObject(new Player(xx*32, yy*32, ID.Player, this, tile_ss));
                    //TODO: change, this i sonly a test
                  
                }

                if (green == 255) {
                    //TODO ...
                }
            }
        }
    }

    /** Starts thread */
    private void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    /** Stops thread */
    private void stop() {
        isRunning = false;
        try {
            thread.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates new instance of Game calling the constructor.
     * @param args
     */
    public static void main(String args[]) {
        new Game();
    }
}
