package edu.ntnu.idatt2001.wargames.army;

import edu.ntnu.idatt2001.wargames.battle.Terrain;

/**
 * Represents an infantry unit in an army.
 * A melee unit that possesses moderate attack bonus.
 */
public class InfantryUnit extends Unit {

    /**
     * Initializes a InfantryUnit object with an attack value of 15 and an armor value of 10.
     *
     * @param name      Infantry unit name as String
     * @param health    Infantry unit health as int
     */
    public InfantryUnit(String name, int health) {
        super(name, health,15,10);
    }

    /**
     * Initializes a InfantryUnit object with custom defined stats.
     *
     * @param name      Infantry unit name as String
     * @param health    Infantry unit health as int
     * @param attack    Infantry unit attack value
     * @param armor     Infantry unit armor value
     */
    public InfantryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * {@inheritDoc}<br>
     * Gives a moderate attack bonus for melee units.
     *
     * @return attack bonus as int
     */
    @Override
    public int getAttackBonus() {
        if(getTerrain() == Terrain.FOREST){
            return 3;
        }
        return 2;
    }

    /**
     * {@inheritDoc}<br>
     * Gives a low resistance bonus for melee units.
     *
     * @return  resistance bonus as int
     */
    @Override
    public int getResistBonus() {
        if(getTerrain() == Terrain.FOREST){
            return 2;
        }
        return 1;
    }


}
