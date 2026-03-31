package it.unibo.shoot.model.box;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.logging.Handler;

import it.unibo.shoot.model.GameObject;
import it.unibo.shoot.model.ID;

// Just an example class
public class Box extends GameObject{

    Handler handler;

    public Box(int x, int y, ID id) {
        super(x, y, ID.Box);
        //this.handler = handler;
        velX = 1;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
    return new Rectangle(x, y, 32, 48);
    }
}
