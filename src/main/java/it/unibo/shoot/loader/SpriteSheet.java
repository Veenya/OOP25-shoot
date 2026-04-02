package it.unibo.shoot.loader;

import java.awt.image.BufferedImage;
import it.unibo.shoot.util.Constants;


/**
 * Loads a spritesheet image and allows cropping individual tiles from it.
 */
public class SpriteSheet {
    
    private BufferedImage image;

    /** Creates a new SpriteSheet by loading an image from the given resource path. */
    public SpriteSheet(String path) {
        this.image = new BufferedImageLoader().loadImage(path);
    }

    /**
     * Takes a subsection image from the spritesheet.
     * 
     * @param col the column number of the image (starts at 0).
     * @param row the row number of the image (starts at 0).
     * @return the subimage from the spritesheet.
     */
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
