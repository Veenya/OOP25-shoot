package it.unibo.shoot.model;
// 6. MANTELLO SCHIVATA (Difesa)
public class EvasionUpgrade extends Upgrade {
    public EvasionUpgrade() { 
        
        super("Mantello Schivata", "+5% Possibilità di schivata", 4); }
    @Override 
    public void apply(Player p) { 
        //TODO
        //p.setDodgeChance(p.getDodgeChance() + 0.05); 
        this.currentLevel++; 
    }
}