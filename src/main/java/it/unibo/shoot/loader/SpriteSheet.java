package it.unibo.shoot.loader;

import java.awt.image.BufferedImage;
import it.unibo.shoot.util.Constants;


/**
 * this class gets the image and crops it into the images
 * from the spritesheet so we get what we want, for example the player
 */
public class SpriteSheet {
    
    private BufferedImage image;

    /** when we create it we put the image we'll work in */
    public SpriteSheet(String path) {
        this.image = new BufferedImageLoader().loadImage(path);
    }

    public BufferedImage grabImage(int col, int row) {
        int x = col * Constants.TILE_SIZE;
        int y = row * Constants.TILE_SIZE;
        if (x + Constants.TILE_SIZE > image.getWidth() || y + Constants.TILE_SIZE > image.getHeight()) {
            throw new IllegalArgumentException(
                "Tile (" + col + ", " + row + ") is out of bounds for spritesheet of size "
                + image.getWidth() + "x" + image.getHeight()
            );
        }
        return image.getSubimage(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
    }
}
