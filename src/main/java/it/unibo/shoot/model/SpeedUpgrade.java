package it.unibo.shoot.model;

// 1. SCARPE RAPIDE 
public class SpeedUpgrade extends Upgrade {

    public SpeedUpgrade() {
         super("Scarpe Rapide", "+10% Velocità di movimento", 5); }

     
    public void apply(Player p) { 
        //TODO
        //p.setSpeed(p.getSpeed() * 1.10); 
        this.currentLevel++; 
    
    }
}


