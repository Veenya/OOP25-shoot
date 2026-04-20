// 2. ARMATURA PESANTE
public class HealthUpgrade extends Upgrade {

    public HealthUpgrade() {
         super("Armatura Pesante", "+20 HP Massimi", 5); }
    @Override 
    public void apply(Player p) {
         p.setMaxHealth(p.getMaxHealth() + 20); p.heal(20); 
         this.currentLevel++; 
        }
}