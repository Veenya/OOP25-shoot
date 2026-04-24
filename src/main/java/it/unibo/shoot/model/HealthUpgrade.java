package it.unibo.shoot.model;

import it.unibo.shoot.model.Player;
import it.unibo.shoot.model.Upgrade;

// 2. ARMATURA PESANTE
public class HealthUpgrade extends Upgrade {

    public HealthUpgrade() {
         super("Armatura Pesante", "+20 HP Massimi", 5); }
    @Override 
    public void apply(Player p) {
     //TODO    
     //p.setMaxHealth(p.getMaxHealth() + 20); p.heal(20); 
         this.currentLevel++; 
        }
}