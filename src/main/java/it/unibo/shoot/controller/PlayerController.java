package it.unibo.shoot.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import it.unibo.shoot.model.*;

public class PlayerController implements KeyListener {

    private PlayerModel model;
    private Game game; // AGGIUNTO: Ora il controller conosce l'handler!
    private Set<Integer> pressedKeys = new HashSet<>();

    // AGGIUNTO: Abbiamo messo l'handler nel costruttore
    public PlayerController(PlayerModel model, Game game) {
        this.model = model;
        this.game = game;
    }

    // ... (il metodo update() rimane uguale a prima) ...

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode(); // CORREZIONE 1: Salviamo il tasto premuto in una variabile
        pressedKeys.add(key);

        //if (e.getKeyCode() == KeyEvent.VK_R) {
          //if (game.getGameState() == STATE.GAME_OVER) {
          //game.restartGame(); 
          //}
          //}

        //if (key == KeyEvent.VK_X) {
            // Only exit if the game is over or in the main menu
          //  if (game.getGameState() == STATE.GAME_OVER || game.getGameState() == STATE.MENU) {
            //    System.exit(0);
            //}   
        //} 



        
    }
    public void update() {
    if (game.getGameState() == STATE.GAME_OVER) {
            return;
    }
    
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
        
        int key = e.getKeyCode();

        // RESTART TRIGGER WHEN GAME OVER
        if (game.getGameState() == STATE.GAME_OVER) {
            if (key == KeyEvent.VK_R) {
                game.restartGame();  // Run complete game reset pipeline
                pressedKeys.clear(); // Clear standard cached directions
            }
            return; // Skip standard movement tracking
        }

        pressedKeys.add(key);
    
    }
    
}