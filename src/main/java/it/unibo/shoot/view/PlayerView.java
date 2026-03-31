package it.unibo.shoot.view;
import java.awt.Color;
import java.awt.Graphics2D;
import it.unibo.shoot.model.PlayerModel;

public class PlayerView {
    private PlayerModel model;

    public PlayerView(PlayerModel model) {
        this.model = model;
    }

    public void render(Graphics2D g2) {
        // Disegniamo un quadrato rosso come segnaposto
        g2.setColor(Color.RED);
        g2.fillRect((int)model.getX(), (int)model.getY(), 32, 32);
    }
    
}
