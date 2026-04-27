package it.unibo.shoot.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import it.unibo.shoot.model.Bullet;
import it.unibo.shoot.model.ID;
import it.unibo.shoot.model.PlayerModel;
import it.unibo.shoot.model.Handler;

public class PlayerController implements KeyListener {

    private PlayerModel model;
    private Handler handler; // AGGIUNTO: Ora il controller conosce l'handler!
    private Set<Integer> pressedKeys = new HashSet<>();

    // AGGIUNTO: Abbiamo messo l'handler nel costruttore
    public PlayerController(PlayerModel model, Handler handler) {
        this.model = model;
        this.handler = handler;
    }

    // ... (il metodo update() rimane uguale a prima) ...

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode(); // CORREZIONE 1: Salviamo il tasto premuto in una variabile
        pressedKeys.add(key);

        // CORREZIONE 2: Logica di sparo con la barra spaziatrice
       /* if (key == KeyEvent.VK_SPACE) {
            
            // Capiamo da che parte sta guardando il player (0:Giù, 1:Su, 2:Sinistra, 3:Destra)
            int targetX = (int)model.getX() + 16;
            int targetY = (int)model.getY() + 16;
            
            // "Spingiamo" il bersaglio lontano nella direzione in cui guardiamo
            if (model.getRow() == 0) targetY += 100;      // Spara in Giù
            else if (model.getRow() == 1) targetY -= 100; // Spara in Su
            else if (model.getRow() == 2) targetX += 100; // Spara a Destra
            else if (model.getRow() == 3) targetX -= 100; // Spara a Sinistra

            // Creiamo il proiettile verso il bersaglio (niente più mouseX o mouseY!)
            handler.addObject(new Bullet((int)model.getX()+16, (int)model.getY()+16, ID.Bullet, handler, targetX, targetY, null));
        } */
    }
    public void update() {
    float dx = 0;
    float dy = 0;

    if (pressedKeys.contains(KeyEvent.VK_W)) dy--;
    if (pressedKeys.contains(KeyEvent.VK_S)) dy++;
    if (pressedKeys.contains(KeyEvent.VK_A)) dx--;
    if (pressedKeys.contains(KeyEvent.VK_D)) dx++;

    // Diciamo al model quanta velocità deve avere in base ai tasti
    model.setVelocity(dx, dy);
}

    @Override
    public void keyReleased(KeyEvent e) {
        // Quando lo rilasci, lo togliamo
        pressedKeys.remove(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Non ci serve per muovere il player
    }
}