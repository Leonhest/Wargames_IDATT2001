package edu.ntnu.idatt2001.wargames.army;

/**
 * Represents a Unit in an army.
 * Contains necessary unit stats, including methods for attacking.
 */
public abstract class Unit {
    private String name;
    private int health;
    private int attack;
    private int armor;

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
     * Sets health of the unit.
     * If negative health, set health to 0.
     * Sets health.
     *
     * @param health    New unit health as int
     */
    public void setHealth(int health) {
        if(health<0){
            this.health = 0;
        }
        else{
            this.health = health;
        }

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
                "armor: " + armor;
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
}
