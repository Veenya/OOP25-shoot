package it.unibo.shoot.model;

import java.util.LinkedList;
import java.awt.Graphics;

/*
To update game object
to do tick
runs through loop 
update stuff
tick

*/

public class Handler {
     
    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick() {
        // Runs through all game objects,
        // stores each object into temporary object
        // and ticks every object
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject tempObject) {
        object.add(tempObject);
    }

    public void removeObject(GameObject tempObject) {
        object.remove(tempObject);
    }
}
