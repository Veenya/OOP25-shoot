package it.unibo.shoot.model;

import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import it.unibo.shoot.view.PlayerView;
import it.unibo.shoot.controller.PlayerController;
import it.unibo.shoot.util.Constants;

public class Player extends GameObject {

    // I tuoi tre pezzi MVC
    private PlayerModel model;
    private PlayerView view;
    private PlayerController controller;

    public Player(int x, int y, ID id, Canvas canvas) {
        super(x, y, id); // Passiamo i dati al costruttore di Vera
        
        // Inizializziamo il tuo MVC
        // Passiamo x e y iniziali al tuo model
        this.model = new PlayerModel(x, y, 5.0, 100); 
        this.view = new PlayerView(model);
        this.controller = new PlayerController(model);

        this.layer = Constants.PLAYER_LAYER;

        canvas.addKeyListener(controller);
    }

    @Override
    public void tick() {
        // 1. Chiamiamo il tuo controller per gestire l'input
        controller.update(); 
        
        // 2. Sincronizziamo la posizione del GameObject di Vera con il tuo Model
        // Questo è fondamentale perché Vera userà x e y per le collisioni
        this.x = (int) model.getX();
        this.y = (int) model.getY();
    }

    @Override
    public void render(Graphics g) {
        // Usiamo la tua View per disegnare!
        // Trasformiamo Graphics in Graphics2D (più moderno)
        view.render((Graphics2D) g);
    }

    @Override
    public Rectangle getBounds() {
        // Usiamo la hitbox che hai già definito nel Model
        return model.getHitbox();
    }
}