package it.unibo.shoot.model;

import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import it.unibo.shoot.view.PlayerView;
import it.unibo.shoot.controller.PlayerController;
import it.unibo.shoot.loader.SpriteSheet;
import it.unibo.shoot.GameObjects.GameObject;
import it.unibo.shoot.audio.Sound;

/**
 * Entità principale del giocatore.
 * Fungere da aggregatore (Facade) per il pattern MVC interno (Model, View, Controller)
 * e mappa l'entità nel sistema globale dei GameObject.
 * tra questa classe (ereditata da GameObject) e PlayerModel.
 */
public class Player extends GameObject {

    private PlayerModel model;
    private PlayerView view;
    private PlayerController controller;
    private Handler handler;
    Game game;

    /**
     * Costruisce il giocatore inizializzando il suo ecosistema MVC interno.
     * * @param x Coordinata logica iniziale X.
     * @param y Coordinata logica iniziale Y.
     * @param id Identificatore per il collision system.
     * @param canvas Contesto di rendering per la registrazione degli input.
     * @param ss Asset grafico.
     * @param handler Riferimento al gestore globale per calcolare le collisioni.
     * @param game Riferimento al motore di gioco per transizioni di stato.
     */
    public Player(int x, int y, ID id, Canvas canvas, SpriteSheet ss, Handler handler, Game game) {
        super(x, y, id, ss);
        this.handler = handler;
        
        // Inizializzazione hardcoded delle statistiche base
        this.model = new PlayerModel(x, y, 5.0, 100); 
        this.view = new PlayerView(model, ss); 
        this.controller = new PlayerController(model, game);
        this.game = game;

        
        // interfacciarsi direttamente con componenti grafiche AWT.
        canvas.addKeyListener(controller);
    }

    /**
     * Aggiorna lo stato logico, processa gli input pendenti e sincronizza 
     * le coordinate fisiche (x, y, velX, velY) con quelle del PlayerModel.
     * Gestisce inoltre le condizioni di sconfitta.
     */
    @Override
    public void tick() {
        if (model.isDead()) {
            game.setGameState(STATE.GAME_OVER);
            game.getSound().play(Sound.SoundType.GAME_OVER);
            return; 
        }
        
        controller.update(); 
        model.updatePosition();
        model.updateAnimation(); 
        
        
        this.x = (int) model.getX();
        this.y = (int) model.getY();
        this.velX = model.getVelX();
        this.velY = model.getVelY();

        collision();
    }

    /**
     * Risolve le collisioni AABB (Axis-Aligned Bounding Box) con le altre entità attive.
     * Gestisce la compenetrazione solida (Block), il recupero munizioni (Crate) 
     * e i danni ricevuti (Enemy).
     */
    public void collision() {
        // Valutare il passaggio a un Iterator o gestire la rimozione a fine loop (Garbage List).
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            
            if (tempObject.getId() == ID.Block) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    // Risoluzione grossolana della collisione (annulla l'ultimo movimento)
                    this.x -= velX;
                    this.y -= velY;

                    model.setX(this.x);
                    model.setY(this.y);
                    model.setVelocity(0, 0);
                }
            }

            if (tempObject.getId() == ID.Crate) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    game.ammo += 50;
                    handler.removeObject(tempObject);
                    i--; 
                }
            }

            if (tempObject.getId() == ID.Enemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    model.takeDamage(1); 
                    
                }
            }
        }
    }

    
    // Metodi di Delega (Boilerplate) - Non documentati 
   

    public void takeDamage(int amount){
        model.takeDamage(amount);
    }

    @Override
    public void render(Graphics g) {
        view.render((Graphics2D) g);
    }

    @Override
    public Rectangle getBounds() {
        return model.getHitbox();
    }
    
    public double getSpeed() {
        return model.getSpeed();
    }

    public void setSpeed(double speed) {
        model.setSpeed(speed);
    }

    public int getMaxHealth() {
        return model.getMaxHealth();
    }

    public void setMaxHealth(int maxHealth) {
        model.setMaxHealth(maxHealth);
    }
    
    public void setHealth(int Health) {
        model.setHealth(Health);
    }

    public void heal(int amount) {
        model.heal(amount);
    }

    public double getDamageMultiplier() {
        return model.getDamageMultiplier();
    }

    public void setDamageMultiplier(double damageMultiplier) {
        model.setDamageMultiplier(damageMultiplier);
    }

    public double getDodgeChance() {
        return model.getDodgeChance();
    }

    public void setDodgeChance(double dodgeChance) {
        model.setDodgeChance(dodgeChance);
    }

    public double getPickupRange() {
        return model.getPickupRange();
    }

    public void setPickupRange(double pickupRange) {
        model.setPickupRange(pickupRange);
    }
    
    public int getHealth() {
        return model.getHealth();
    }
    
    public Game getGame() {
        return this.game; 
    }
}

