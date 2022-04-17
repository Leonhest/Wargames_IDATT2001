package edu.ntnu.idatt2001.wargames.backend.army;

import edu.ntnu.idatt2001.wargames.backend.battle.Terrain;

import java.util.Objects;

/**
 * Represents a Unit in an army.
 * Contains necessary unit stats, including methods for attacking.
 */
public abstract class Unit {
    private String type = this.getClass().getSimpleName().replace("Unit", "");
    private String name;
    private int health;
    private int attack;
    private int armor;
    private Terrain terrain = Terrain.DEFAULT;

    /**
     * Initializes a Unit object.
     *
     * @param name      Unit name as String
     * @param health    Unit health as int
     * @param attack    Unit attack value as int
     * @param armor     Unit armor value as int
     */
    public Unit(String name, int health, int attack, int armor) {
        if(health <= 0 | attack < 0 | armor < 0){
            throw new IllegalArgumentException("Stats cannot be negative");
        }
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * Attacks an opposing unit.
     * Formula:
     * Opponent Health - this(attack + attackBonus) + opponent(armor + armorBonus)
     *
     * @param opponent  Opposing unit
     */
    public void attack(Unit opponent){
        int newHealth = opponent.getHealth() - (this.getAttack() + this.getAttackBonus()) + (opponent.getArmor()+ opponent.getResistBonus());
        opponent.setHealth(newHealth);
    }

    /**
     * Gets name of unit.
     * @return Name as String
     */
    public String getName() {
        return name;
    }

    /**
     * Gets health of unit.
     * @return Health as int
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets attack of unit
     * @return Attack as int
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Gets armor of unit.
     * @return Armor as int
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Gets type of unit.
     *
     * @return unit type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets health of the unit.
     * If negative health, set health to 0.
     * Sets health.
     *
     * @param health    New unit health as int
     */
    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    /**
     * Gets terrain of unit.
     *
     * @return Terrain as {@link Terrain}
     */
    public Terrain getTerrain() {
        return terrain;
    }

    /**
     * Sets terrain of the unit.
     *
     * @param terrain   Terrain of the unit
     */
    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    /**
     * Converts unit stats to String.
     *
     * @return  String
     */
    @Override
    public String toString() {
        return
                name + '\n' +
                "health: " + health + "\n" +
                "attack: " + attack + "\n" +
                "armor: " + armor + "\n";
    }

    /**
     * Gets attack bonus of the unit.
     *
     * @return  AttackBonus as int
     */
    public abstract int getAttackBonus();

    /**
     * Gets resistance bonus of the unit.
     *
     * @return  ResistanceBonus as int
     */
    public abstract int getResistBonus();

    /**
     * Checks if a Unit equals another object.
     *
     * @param o object to be checked against
     * @return  true if objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return health == unit.health && attack == unit.attack && armor == unit.armor && Objects.equals(name, unit.name);
    }

    /**
     * Generates a hashcode of the instance variables of Unit.
     *
     * @return hashcode as int
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, health, attack, armor);
    }
}
