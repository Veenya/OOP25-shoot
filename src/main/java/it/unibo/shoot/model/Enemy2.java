package it.unibo.shoot.model;
import java.awt.Graphics;

import it.unibo.shoot.loader.SpriteSheet;

public class Enemy2 extends Enemy{

    private static final int COL_OFFSET = 3; // gli sprite di Enemy2 partono dalla colonna 3

    public Enemy2(int x, int y, ID id, SpriteSheet ss, Handler handler) {
        super(x, y, id, ss, handler, 1.5f);
        this.hp = 200;
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