// Questo file DEVE chiamarsi Upgrade.java
package it.unibo.shoot.model;

import java.util.*;

public abstract class Upgrade {
    protected String name;
    protected String description;
    protected int currentLevel = 0; 
    protected int maxLevel;

    public Upgrade(String name, String description, int maxLevel) {
        this.name = name;
        this.description = description;
        this.maxLevel = maxLevel;
    }

    // Vera (Player) userà questo metodo quando il giocatore sceglie l'upgrade
    public abstract void apply(Player player);

    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean isMaxed() { return currentLevel >= maxLevel; }
}