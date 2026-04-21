package it.unibo.shoot.model;
import java.awt.Rectangle;

public class PlayerModel {
    private double x, y;
    private double speed;
    private int health;
    private int maxHealth;
    
    private float velX = 0, velY = 0;
    
    // Variabili per l'animazione
    private int aniTick, aniIndex, aniSpeed = 10; 
    private boolean isMoving = false;
    private int row = 0; // 0: Giù, 1: Su, 2: Sinistra, 3: Destra

    // Dimensioni per la Hitbox (rimangono 32x32 per la fisica del gioco)
    private final int width = 32;
    private final int height = 32;

    public PlayerModel(double startX, double startY, double speed, int maxHealth) {
        this.x = startX;
        this.y = startY;
        this.speed = speed;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void setVelocity(float dx, float dy) {
        this.velX = dx * (float)speed;
        this.velY = dy * (float)speed;
        this.isMoving = (dx != 0 || dy != 0);

        if (dy > 0) row = 0;      // Cammina in giù 
        else if (dy < 0) row = 1; // Cammina in su 
        else if (dx < 0) row = 3; // <--- INVERTITO: Sinistra ora legge la riga 3
        else if (dx > 0) row = 2; // <--- INVERTITO: Destra ora legge la riga 2
    }

    public void updatePosition() {
        this.x += velX;
        this.y += velY;
    }

    public void updateAnimation() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= 4) { 
                aniIndex = 0;
            }
        }
        
        if (!isMoving) {
            aniIndex = 0;
        }
    }

    // Setters e Getters
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    
    public int getRow() { return row; }
    public int getAniIndex() { return aniIndex; }
    public boolean isMoving() { return isMoving; }
    
    public float getVelX() { return velX; }
    public float getVelY() { return velY; }
    public double getX() { return x; }
    public double getY() { return y; }
    public int getHealth() { return health; }

    public Rectangle getHitbox() {
        return new Rectangle((int)x, (int)y, width, height);
    }
}