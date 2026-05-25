package it.unibo.shoot.model;
import java.awt.Graphics;

import it.unibo.shoot.loader.SpriteSheet;

public class Enemy1 extends Enemy{

    private static final int COL_OFFSET = 0; // gli sprite di Enemy1 partono dalla colonna 0

    public Enemy1(int x, int y, ID id, SpriteSheet ss, Handler handler) {
        super(x, y, id, ss, handler, 2.5f);
        this.hp = 100;
    }

    @Override
    public void tick(){
        super.tick();

        frameDelay++;                                           
        if (frameDelay >= 10) {                                        
            frameDelay = 0;
            frame++;                                                    //animazione avanza di 1
            if (frame >= 3) {
                frame = 0;                                              //ritorna al frame 1
            } 
        }
    }

    @Override
    public void render(Graphics g) {
        int row;
        switch (dir) {
            case DOWN:
                row = 0;
                break;
            case LEFT:  
                row = 1;
                break;
            case RIGHT:
                row = 2;
                break;
            default:
                row = 3;
                break;
        };

        enemy_ss = ss.grabImage(COL_OFFSET + frame, row, 16, 16);
        g.drawImage(enemy_ss, (int)x, (int)y, null);
    }
}