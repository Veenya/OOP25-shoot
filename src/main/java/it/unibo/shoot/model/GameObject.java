package it.unibo.shoot.model;

import java.awt.Graphics;
import java.awt.Rectangle;

// Every object in the game derives from this
// Class needs to be abstract because it is a blueprint for other classes
// and cannot be instantiated directly.
public abstract class GameObject {

    // Location of object
    protected int x, y; 
    // Speed of object
    protected float velX = 0, velY = 0;

    // Constructor
    public GameObject(int x, int  y) {
        // Because when we inherit this class
        // for other classes we want to be able to
        // input x and y positions
        this.x = x;
        this.y = y;
    }

    // Methods every object has in common
    public abstract void tick(); // they need to update
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    // -------- Getters --------

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }

    // -------- Setters --------

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
    
}
