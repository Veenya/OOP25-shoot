package it.unibo.shoot.model;

import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import it.unibo.shoot.view.PlayerView;
import it.unibo.shoot.controller.PlayerController;
import it.unibo.shoot.loader.SpriteSheet;

public class Player extends GameObject {

    private PlayerModel model;
    private PlayerView view;
    private PlayerController controller;
    private Handler handler;

    public Player(int x, int y, ID id, Canvas canvas, SpriteSheet ss, Handler handler) {
        super(x, y, id, ss);
        this.handler = handler;
        
        this.model = new PlayerModel(x, y, 5.0, 100); 
        this.view = new PlayerView(model, ss); 
        this.controller = new PlayerController(model);

        canvas.addKeyListener(controller);
    }

    @Override
    public void tick() {
        controller.update(); 
        model.updatePosition();
        model.updateAnimation(); 
        
        this.x = (int) model.getX();
        this.y = (int) model.getY();
        this.velX = model.getVelX();
        this.velY = model.getVelY();

        collision();
    }

    public void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            
            if (tempObject.getId() == ID.Block) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    // Torna indietro
                    this.x -= velX;
                    this.y -= velY;

                    // Sincronizza il model
                    model.setX(this.x);
                    model.setY(this.y);

                    // Ferma la velocità
                    model.setVelocity(0, 0);
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        view.render((Graphics2D) g);
    }

    @Override
    public Rectangle getBounds() {
        return model.getHitbox();
    }
}