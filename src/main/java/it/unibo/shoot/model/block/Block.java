package it.unibo.shoot.model.block;

import it.unibo.shoot.model.GameObject;
import it.unibo.shoot.model.ID;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends GameObject{
	
	public Block(int x, int y, ID id) {
		super(x, y, id);
	}

    //TODO: keep @Override?
	
	//@Override 
	public void tick() {
	}
	
	//@Override
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, 32, 32);
	}
	
	//@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
}
