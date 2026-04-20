package it.unibo.shoot.model;
import java.awt.Rectangle;

public class PlayerModel {
    private double x, y;
    private double speed;
    private int health;
    private int maxHealth;

    // Dimensioni per la Hitbox
    private final int width = 32;
    private final int height = 32;

    public PlayerModel(double startX, double startY, double speed, int maxHealth) {
        this.x = startX;
        this.y = startY;
        this.speed = speed;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }



private float velX = 0, velY = 0;

public void setVelocity(float dx, float dy) {
    // Calcoliamo la velocità finale (direzione * velocità base)
    this.velX = dx * (float)speed;
    this.velY = dy * (float)speed;
}

public void updatePosition() {
    // Qui applichiamo la velocità alla posizione fisica
    this.x += velX;
    this.y += velY;
}

// Aggiungi i getter per Vera
public float getVelX() { return velX; }
public float getVelY() { return velY; }

    // Restituisce il rettangolo per le collisioni (per Leroy)
    public Rectangle getHitbox() {
        return new Rectangle((int)x, (int)y, width, height);
    }

    // Getter per la posizione (per la View)
    public double getX() { return x; }
    public double getY() { return y; }
    public int getHealth() { return health; }
    
}
