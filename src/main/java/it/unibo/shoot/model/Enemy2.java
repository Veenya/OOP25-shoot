package it.unibo.shoot.model;

import it.unibo.shoot.loader.SpriteSheet;

public class Enemy2 extends Enemy{

    public Enemy2(int x, int y, ID id, SpriteSheet ss, Handler handler) {
        super(x, y, id, ss, handler, 1.5f);
        this.COL_OFFSET = 3;
        this.hp = 200;
        this.damage = 25;
    }
}