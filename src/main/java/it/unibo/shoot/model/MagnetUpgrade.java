// 4. CALAMITA RAGGIO-X (Raccolta)
public class MagnetUpgrade extends Upgrade {
    public MagnetUpgrade() { 
        super("Calamita Raggio-X", "+25% Raggio raccolta XP", 3); 
    }
    @Override 
    public void apply(Player p) {
         p.setPickupRange(p.getPickupRange() * 1.25); 
         this.currentLevel++; }
}
