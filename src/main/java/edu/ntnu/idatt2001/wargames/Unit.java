package edu.ntnu.idatt2001.wargames;

/**
 * Represents a Unit in a Field army.
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
     * @return Name as String
     */
    public String getName() {
        return name;
    }

    /**
     * @return Health as int
     */
    public int getHealth() {
        return health;
    }

    /**
     * @return Attack as int
     */
    public int getAttack() {
        return attack;
    }

    /**
     * @return Armor as int
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Sets health.
     *
     * @param health    New unit health as int
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Converts unit stats to String.
     *
     * @return  String
     */
    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", armor=" + armor +
                '}';
    }

    /**
     * Attack bonus of the unit.
     *
     * @return  AttackBonus as int
     */
    public abstract int getAttackBonus();

    /**
     * Resistance bonus of the unit.
     *
     * @return  ResistanceBonus as int
     */
    public abstract int getResistBonus();
}
