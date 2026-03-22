package it.unibo.shoot.view;

import it.unibo.shoot.model.GameObject;

public class Camera {
    private float x, y;

    public Camera(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void tick(GameObject object) {

        // TODO: Put globals instead of this horrific numbers
        x = object.getX() + 1000/2;
        y = object.getY() + 563/2;

        // Alternative (smoother)
        /*
        x += ((object.getX() - x) - 1000/2 * 0.05f);
        y += ((object.getY() - y) - 563/2 * 0.05f);
        */
    }

    // -------- Getters --------

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    // -------- Setters --------

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
