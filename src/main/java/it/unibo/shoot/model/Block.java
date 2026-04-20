
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
public class Block extends GameObject{

    private BufferedImage block_tile.png;

    public Block(int x, int y, ID id, SpriteSheet ss) {
        super(x, y, id, ss);
        block_tile.png = ss.grabImage();
    }
    public void tick(){

    }
    public void render(Graphics g){
       g.drawImage(block_tile.png, x, y, null);
        
    }public Rectangle getBounds(){
        return new Rectangle(x,y,32,32);
        
    }

}
 