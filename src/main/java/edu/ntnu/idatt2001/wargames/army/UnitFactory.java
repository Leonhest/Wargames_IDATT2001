package edu.ntnu.idatt2001.wargames.army;

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
}
