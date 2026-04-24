package it.unibo.shoot.model;

// Questo file DEVE chiamarsi LevelManager.java
import java.util.*;

public class LevelManager {
    private int currentLevel = 1;
    private int currentXP = 0;
    private int nextLevelXP = 100;
    
    private List<Upgrade> availableUpgrades;
    private Player player;

    public LevelManager(Player player) {
        this.player = player;
        this.availableUpgrades = new ArrayList<>();
        
        // Inizializzo il pool con i 6 upgrade che abbiamo creato
        availableUpgrades.add(new SpeedUpgrade());
        availableUpgrades.add(new HealthUpgrade());
        availableUpgrades.add(new DamageUpgrade());
        availableUpgrades.add(new MagnetUpgrade());
        //availableUpgrades.add(new AttackSpeedUpgrade());
        availableUpgrades.add(new EvasionUpgrade());
    }

    public void addXP(int amount) {
        currentXP += amount;
        if (currentXP >= nextLevelXP) {
            levelUp();
        }
    }

    private void levelUp() {
        currentXP -= nextLevelXP;
        currentLevel++;
        nextLevelXP = (int) (nextLevelXP * 1.25);
        triggerLevelUpMenu();
    }

    private void triggerLevelUpMenu() {
        // Qui chiameremo la UI di Habashi passandogli queste opzioni:
        List<Upgrade> options = getRandomUpgrades(3);
        // Esempio: UI.display(options);
    }

    public List<Upgrade> getRandomUpgrades(int count) {
        List<Upgrade> eligible = new ArrayList<>(availableUpgrades.stream()
                .filter(u -> !u.isMaxed())
                .toList());
        
        Collections.shuffle(eligible);
        return eligible.subList(0, Math.min(count, eligible.size()));
    }
}