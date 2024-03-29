package edu.ntnu.idatt2001.wargames.backend.army;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory class used to generate an object of type {@link Unit}.
 */
public class UnitFactory {

    /**
     * Instantiates a new object of type {@link Unit}.
     * Uses enum {@link UnitType} to determine which Unit subclass to instantiate.
     *
     * @param unitType  Unit type to create
     * @param name      Name of Unit
     * @param health    Health of unit
     * @return          Subclass of the Unit class
     */
    public static Unit getUnit(UnitType unitType, String name, int health){
        switch (unitType){
            case INFANTRY:
                return new InfantryUnit(name, health);
            case RANGED:
                return new RangedUnit(name, health);
            case CAVALRY:
                return new CavalryUnit(name, health);
            case COMMANDER:
                return new CommanderUnit(name, health);
        }
        return null;
    }

    /**
     * Instantiates a new object of type {@link Unit}.
     * Used when attack and armor of unit is specified.
     * Uses enum {@link UnitType} to determine which Unit subclass to instantiate.
     *
     * @param unitType  Unit type to create
     * @param name      Name of Unit
     * @param health    Health of unit
     * @param attack    Attack of unit
     * @param armor     Armor of unit
     * @return          Subclass of the Unit class
     */
    public static Unit getComplexUnit(UnitType unitType, String name, int health, int attack, int armor){
        switch (unitType){
            case INFANTRY:
                return new InfantryUnit(name, health, attack, armor);
            case RANGED:
                return new RangedUnit(name, health, attack, armor);
            case CAVALRY:
                return new CavalryUnit(name, health, attack, armor);
            case COMMANDER:
                return new CommanderUnit(name, health, attack, armor);
        }
        return null;
    }

    /**
     * Instantiates n number of Objects of type {@link Unit} and adds them to a List.
     * Uses {@link #getUnit} in a for loop.
     *
     * @param unitType      Unit type to create
     * @param name          Name of Unit
     * @param health        Health of unit
     * @param numberOfUnits number of units to create
     * @return              List of units
     */
    public static List<Unit> getListUnits(UnitType unitType, String name, int health, int numberOfUnits){
        List<Unit> unitList = new ArrayList<>();
        for(int i = 0; i < numberOfUnits; i++){
            unitList.add(getUnit(unitType, name, health));
        }
        return unitList;
    }

    /**
     * Instantiates n number of Objects of type {@link Unit} and adds them to a List.
     * Used when attack and armor of unit is specified.
     * Uses {@link #getUnit} in a for loop.
     *
     * @param unitType      Unit type to create
     * @param name          Name of Unit
     * @param health        Health of unit
     * @param attack        Attack of unit
     * @param armor         Armor of unit
     * @param numberOfUnits number of units to create
     * @return              List of units
     */
    public static List<Unit> getListComplexUnits(UnitType unitType, String name, int health, int attack, int armor,int numberOfUnits){
        List<Unit> unitList = new ArrayList<>();
        for(int i = 0; i < numberOfUnits; i++){
            unitList.add(getComplexUnit(unitType, name, health, attack, armor));
        }
        return unitList;
    }
}
