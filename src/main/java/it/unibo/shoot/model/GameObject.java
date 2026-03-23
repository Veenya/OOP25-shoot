package it.unibo.shoot.model;

import java.awt.Graphics;
import java.awt.Rectangle;

// Class needs to be abstract because it is a blueprint for other classes
// and cannot be instantiated directly.

/**
 * Base class for each object present in the game, every object derives from this.
 * 
 * It provides all the functions and parameters that are in common to every object in the game.
 */
public abstract class GameObject {

    /** (x, y) position of object. */
    protected int x, y; 
    /** Speed of object in pixels per tick. */
    protected float velX = 0, velY = 0;
    /**ID of object type. */
    protected ID id;

    /**
     * Constructor for a new game object in the specified position.
     * @param x starting x position.
     * @param y starting y position.
     * @param id object type identifier.
     */
    public GameObject(int x, int  y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    // Methods every object has in common

    /** 
     * Updates object state each game tick 
     */
    public abstract void tick();

    /**
     * Renders object in graphics context. 
     * 
     * @param g graphics context.
     */
    public abstract void render(Graphics g);

    /**
     * Returns the bounding rectangle of the object, used for collisions.
     * 
     * @return bounding rectangle.
     */
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

    public ID getId() {
        return id;
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

    public void setId(ID id) {
        this.id = id;
    }
    
}
