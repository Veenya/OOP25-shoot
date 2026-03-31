package it.unibo.shoot.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import it.unibo.shoot.model.PlayerModel;

public class PlayerController implements KeyListener {
    private PlayerModel model;
    
    // La nostra "lista della spesa" dei tasti attualmente abbassati
    private Set<Integer> pressedKeys = new HashSet<>();

    public PlayerController(PlayerModel model) {
        this.model = model;
    }

    // Questo metodo verrà chiamato 60 volte al secondo da Murgia (Game Loop)
    public void update() {
        double dx = 0;
        double dy = 0;

        // Controlliamo cosa c'è nella nostra lista dei tasti
        if (pressedKeys.contains(KeyEvent.VK_W)) dy--; // Su (Y diminuisce)
        if (pressedKeys.contains(KeyEvent.VK_S)) dy++; // Giù (Y aumenta)
        if (pressedKeys.contains(KeyEvent.VK_A)) dx--; // Sinistra (X diminuisce)
        if (pressedKeys.contains(KeyEvent.VK_D)) dx++; // Destra (X aumenta)

        // Diciamo al Model di aggiornare la sua posizione
        model.move(dx, dy);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Quando premi un tasto, lo aggiungiamo alla lista
        pressedKeys.add(e.getKeyCode());
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