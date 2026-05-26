package it.unibo.shoot.model;

import it.unibo.shoot.loader.SpriteSheet;

public class Enemy1 extends Enemy{

    public Enemy1(int x, int y, ID id, SpriteSheet ss, Handler handler) {
        super(x, y, id, ss, handler, 2.5f);
        this.hp = 100;
    }
}