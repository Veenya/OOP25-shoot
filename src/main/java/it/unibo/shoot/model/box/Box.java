package it.unibo.shoot.model.box;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import it.unibo.shoot.model.GameObject;
import it.unibo.shoot.model.ID;

// Just an example class
public class Box extends GameObject{
    public Box(int x, int y, ID id) {
        super(x, y, ID.Box);
    }

    public void tick() {
        x += velX;
        y += velY;
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 32, 32);
    }

    public Rectangle getBounds() {
        return null;
    }
}
