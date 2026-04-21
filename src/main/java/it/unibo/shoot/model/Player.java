package it.unibo.shoot.model;

import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import it.unibo.shoot.view.PlayerView;
import it.unibo.shoot.controller.PlayerController;
import it.unibo.shoot.loader.SpriteSheet;
import it.unibo.shoot.util.Constants;

public class Player extends GameObject {

    // I tuoi tre pezzi MVC
    private PlayerModel model;
    private PlayerView view;
    private PlayerController controller;

    private Handler handler;
    //private GameObject gameObject;

    public Player(int x, int y, ID id, Canvas canvas, SpriteSheet ss, Handler handler) {
        super(x, y, id, ss); // Passiamo i dati al costruttore di Vera
        
        // Inizializziamo il tuo MVC
        // Passiamo x e y iniziali al tuo model
        this.model = new PlayerModel(x, y, 5.0, 100); 
        this.view = new PlayerView(model);
        this.controller = new PlayerController(model);

        this.handler = handler;

        this.layer = Constants.PLAYER_LAYER;

        canvas.addKeyListener(controller);
    }

   // Nel tuo Player.java (quello che estende GameObject)

@Override
public void tick() {


    // 1. Il controller legge i tasti e imposta la velocità nel Model
    controller.update(); 

    // 2. Il model aggiorna la sua posizione interna
    model.updatePosition();
    
    // 3. SINCRONIZZAZIONE: Copiamo i dati dal Model al GameObject di Vera
    // Così Vera può usarli per le sue collisioni nell'Handler
    this.x = (int) model.getX();
    this.y = (int) model.getY();
    this.velX = model.getVelX();
    this.velY = model.getVelY();

    collision();
}
/* 
public void collision(){
    for(int i = 0; i<handler.object.size(); i++) {
        GameObject tempObject = handler.object.get(i);
        if (tempObject.getId() == ID.Block){
            if (getBounds().intersects(tempObject.getBounds())){
                x+=velX * -1;
                y += velY * -1;
            }
        }

    }
}
*/

public void collision() {
    for (int i = 0; i < handler.object.size(); i++) {
        GameObject tempObject = handler.object.get(i);
        if (tempObject.getId() == ID.Block) {
            if (getBounds().intersects(tempObject.getBounds())) {
                // Push back
                this.x -= velX;
                this.y -= velY;

                // Sync back to model!
                model.setX(this.x);
                model.setY(this.y);

                // Stop velocity
                model.setVelocity(0, 0);
            }
        }
    }
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