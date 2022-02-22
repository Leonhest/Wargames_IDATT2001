package edu.ntnu.idatt2001.wargames;

/**
 * Represents a Commander unit in an army.
 * A Commander unit is a stronger unit of type {@link CavalryUnit}
 */
public class CommanderUnit extends CavalryUnit{

    /**
     * Initializes a CommanderUnit object with an attack value of 25 and an armor value of 15.
     *
     * @param name      Commander unit name as String
     * @param health    Commander unit health as int
     */
    public CommanderUnit(String name, int health) {
        super(name, health, 25, 15);
    }

    /**
     * Initializes a CommanderUnit object with custom defined stats.
     *
     * @param name      Commander unit name as String
     * @param health    Commander unit health as int
     * @param attack    Commander unit attack value as int
     * @param armor     Commander unit armor value as int
     */
    public CommanderUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }
}
