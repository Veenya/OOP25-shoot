package it.unibo.shoot.view;

import it.unibo.shoot.model.GameObject;


/**
 * Handles the camera position during the game, it keeps it centered on the player based on it's movements.
 */
public class Camera {
    private float x, y;

    /**
     * Creates a camera at a specified position (x, y).
     * 
     * @param x starting x position
     * @param y starting y position
     */
    public Camera(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Updates camera position and keeps it centered on the object.
     * 
     * @param object the focus of the camera's center (usually the player).
     */
    public void tick(GameObject object) {
        // TODO: Put globals instead of this horrific numbers
        x = object.getX() - 1000/2;
        y = object.getY() - 563/2;

        // Alternative (smoother)
        /*
        x += ((object.getX() - x) - 1000/2 * 0.05f);
        y += ((object.getY() - y) - 563/2 * 0.05f);
        */
    }

    // -------- Getters --------

    /**
     * Returns the camera x position
     * 
     * @return camera x position
     */
    public float getX() {
        return x;
    }

    /**
     * Returns the camera y position
     * 
     * @return camera y position
     */
    public float getY() {
        return y;
    }

    // -------- Setters --------

    /**
     * Sets the x position of the camera
     * 
     * @param x new x position
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Sets the y position of the camera
     * 
     * @param y new x position
     */
    public void setY(float y) {
        this.y = y;
    }
}
