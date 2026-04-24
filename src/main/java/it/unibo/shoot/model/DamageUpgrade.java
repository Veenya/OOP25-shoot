package it.unibo.shoot.model;

// 3. PROIETTILI AFFILATI (Danno)
public class DamageUpgrade extends Upgrade {

    public DamageUpgrade() {
         super("Proiettili Affilati", "+15% Danno inflitto", 5); }

    public void apply(Player p) {
          //TODO
         //p.setDamageMultiplier(p.getDamageMultiplier() * 1.15); 
         this.currentLevel++; }
}