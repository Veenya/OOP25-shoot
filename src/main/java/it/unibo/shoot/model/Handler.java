package it.unibo.shoot.model;

import java.util.LinkedList;
import java.util.Comparator;
import java.awt.Graphics;



/**
 * Class used to update game objects.
 * Every tick it runs through the list of objects, and updates each one.
 * Provides methods to add and remove objects from the game, using a list of objects.
 */
public class Handler {
     
    /** List of all active objects in the game. */
    LinkedList<GameObject> object = new LinkedList<GameObject>();


    /**
     * Updates the state of all objects in the game.
     * 
     * It runs through every object, stores each one into a temporary object, and ticks every object.
     */
    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    /**
     * Renders all game objects and places them in graphics context.
     * @param g graphics context.
     */
    public void render(Graphics g) {
        // Ordina per layer (ordine crescente)
        object.sort(Comparator.comparingInt(GameObject::getLayer));

        for (int i = 0; i < object.size(); i++) {
            object.get(i).render(g);
        }
    }

    /**
     * Adds object to the handler.
     * @param tempObject object to be added to the handler.
     */
    public void addObject(GameObject tempObject) {
        object.add(tempObject);
    }

    /**
     * Remove object to the handler.
     * @param tempObject object to be removed from the handler.
     */
    public void removeObject(GameObject tempObject) {
        object.remove(tempObject);
    }
}
