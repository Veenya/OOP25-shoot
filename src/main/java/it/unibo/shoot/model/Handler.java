package it.unibo.shoot.model;

import java.awt.Graphics;
// CANCELLIAMO LinkedList
// import java.util.LinkedList; 

// AGGIUNGIAMO QUESTE DUE:
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Handler {

    // LA MAGIA È QUI: Usiamo la lista ultra-sicura per i thread
    public List<GameObject> object = new CopyOnWriteArrayList<>();

    public void tick() {
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

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

    // Il getter che abbiamo creato prima, aggiornato per usare "List"
    public List<GameObject> getObjects() {
        return object;
    }
}