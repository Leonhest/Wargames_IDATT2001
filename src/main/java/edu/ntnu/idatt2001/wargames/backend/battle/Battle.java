package edu.ntnu.idatt2001.wargames.backend.battle;
import  edu.ntnu.idatt2001.wargames.backend.army.*;
import edu.ntnu.idatt2001.wargames.backend.army.Army;
import edu.ntnu.idatt2001.wargames.backend.army.Unit;

/**
 * Represents a battle between two armies.
 * Contains methods for simulating the battle
 */
public class Battle {
    private Army armyOne;
    private Army armyTwo;

    /**
     * Initializes a Battle object with two opposing armies of type {@link Army}.
     *
     * @param armyOne   first army
     * @param armyTwo   second army
     */
    public Battle(Army armyOne, Army armyTwo, Terrain terrain) {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;

        armyOne.getAllUnits().forEach(e -> e.setTerrain(terrain));
        armyTwo.getAllUnits().forEach(e -> e.setTerrain(terrain));
    }

    /**
     * Simulates a battle between the two armies.
     * Chooses two random {@link Unit} to attack each other.
     * When one army has no more units the battle is over.
     *
     * @return  victorious army
     */
    public Army simulate(){
        while(armyOne.hasUnits() && armyTwo.hasUnits()){
            Unit fighter1 = armyOne.getRandom();
            Unit fighter2 = armyTwo.getRandom();

            fighter1.attack(fighter2);

            if(fighter2.getHealth() <= 0){
                armyTwo.remove(fighter2);

                if(armyTwo.hasUnits()){
                    fighter2 = armyTwo.getRandom();
                }
                else break;
            }

            fighter2.attack(fighter1);
            if(fighter1.getHealth() <= 0){
                armyOne.remove(fighter1);
            }
        }

        if(armyOne.hasUnits()){
            return armyOne;
        }
        else if(armyTwo.hasUnits()){
            return armyTwo;
        }
        else{
            return new Army("Tie");
        }
    }

    /**
     * Gets armyOne.
     *
     * @return armyOne
     */
    public Army getArmyOne() {
        return armyOne;
    }

    /**
     * Gets armyTwo.
     *
     * @return armyTwo
     */
    public Army getArmyTwo() {
        return armyTwo;
    }

    /**
     * Converts battle to a string.
     *
     * @return battle as string
     */
    @Override
    public String toString() {
        return "Battle: " + '\n' +
                armyOne + '\n' + "VS" + '\n' +
                armyTwo;
    }
}