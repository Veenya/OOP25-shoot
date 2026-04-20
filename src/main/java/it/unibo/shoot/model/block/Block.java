package it.unibo.shoot.model.block;

import it.unibo.shoot.loader.SpriteSheet;
import it.unibo.shoot.model.GameObject;
import it.unibo.shoot.model.ID;
import it.unibo.shoot.util.Constants;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * Represents a solid, impassable block in the game world.
 * 
 * Used for walls, obstacles, etc. It has a fixed size of 32x32 and it has a black color.
 */
public class Block extends GameObject{
	
    /**
     * Creates a new block object in the specified position.
     * 
     * @param x is the x position of the block
     * @param y is the y position of the block
     * @param id is the enum used to identify what kind of objec it is, in this case ID.Block.
     */

    private BufferedImage block_image;

	public Block(int x, int y, ID id, SpriteSheet ss) {
		super(x, y, id, ss);
        this.layer = Constants.TILES_LAYER;
        block_image = ss.grabImage(1, 0);
	}


    /**
     * Updates block state each frame.
     */
	@Override 
	public void tick() {
	}
	
    /**
     * Renders the block object, making it black, in position (x, y), and of size 32x32 pixels.
     * 
     * @param g the graphics context used to draw things on.
     */
	@Override
	public void render(Graphics g) {
		//g.setColor(Color.BLACK);
		//g.fillRect(x, y, 32, 32);
        g.drawImage(block_image, x, y, null);
	}
	
    /**
     * Returns the collision borders of the block.
     * 
     * @return a rectangle representing the 32x32 solid area.
     */
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
}
