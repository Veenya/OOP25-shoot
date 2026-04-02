package it.unibo.shoot.model;

/**
 * Enum for different types of game objects in the game.
 */
public enum ID {
    /**Player object that can be controlled.*/
    Player,
    
    /**Block that is used to create solid and impenetrable elements like walls. */
    Block,
    
    /**Projectile that damages the player on collision. */
    Bullet,

    /**Enemy that autonoumosly moves and damages the player.*/
    Enemy,

    /**Item that can be picked up by player and grants upgrades. */
    Weapon,

    /**Experience that when picked up gives progression to the player. */
    Experience;


}
