package edu.ntnu.idatt2001.wargames.army;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Represents an army.
 * Contains necessary methods for creating and running and army.
 */
public class Army {
    private String name;
    private List<Unit> units;

    /**
     * Initializes a simple Army object with no units.
     *
     * @param name  name of army as String
     */
    public Army(String name) {
        this.name = name;
        this.units = new ArrayList<>();
    }

    /**
     * Initializes an Army object with a list of {@link Unit}.
     *
     * @param name  name of army as String
     * @param units List of units
     */
    public Army(String name, List<Unit> units) {
        this.name = name;
        if(!units.contains(null)){
            this.units = new ArrayList<>(units);
        }
        else throw new NullPointerException("A unit cannot be null");
    }

    /**
     * Gets all {@link Unit} of type {@link InfantryUnit}
     *
     * @return Infantry units as a List
     */
    public List<Unit> getInfantryUnits(){
        return units.stream()
                .filter(e -> e instanceof InfantryUnit)
                .collect(Collectors.toList());
    }

    /**
     * Gets all {@link Unit} of type {@link RangedUnit}
     *
     * @return Ranged units as a List
     */
    public List<Unit> getRangedUnits(){
        return units.stream()
                .filter(e -> e instanceof RangedUnit)
                .collect(Collectors.toList());
    }

    /**
     * Gets all {@link Unit} of type {@link CavalryUnit}
     * This does not include Units of type{@link CommanderUnit}
     *
     * @return Cavalry units as a List
     */
    public List<Unit> getCavalryUnits(){
        return units.stream()
                .filter(e -> e instanceof CavalryUnit)
                .filter(e -> !(e instanceof CommanderUnit))
                .collect(Collectors.toList());
    }

    /**
     * Gets all {@link Unit} of type {@link CommanderUnit}
     *
     * @return Commander units as a List
     */
    public List<Unit> getCommanderUnits(){
        return units.stream()
                .filter(e -> e instanceof CommanderUnit)
                .collect(Collectors.toList());
    }

    /**
     * Adds a {@link Unit} to the army.
     *
     * @param unit unit to be added
     */
    public void add(Unit unit){
        if(unit != null){
            this.units.add(unit);
        }
        else throw new NullPointerException("A unit cannot be null");

    }

    /**
     * Adds a list of {@link Unit} to the army.
     *
     * @param units list of units to be added
     */
    public void addAll(List<Unit> units){
        if(!units.contains(null)){
            this.units.addAll(units);
        }
        else throw new NullPointerException("A unit cannot be null");
    }

    /**
     * Removes a {@link Unit} from the army.
     *
     * @param unit unit to be removed
     */
    public void remove(Unit unit){
        units.remove(unit);
    }

    /**
     * Checks if army is empty.
     *
     * @return true if not empty and false if empty
     */
    public boolean hasUnits(){
        return !units.isEmpty();
    }

    /**
     * Gets a random {@link Unit} from the army.
     *
     * @return  random unit
     */
    public Unit getRandom(){
        if(this.hasUnits()){
            Random rand = new Random();
            return units.get(rand.nextInt(units.size()));
        }
        else{
            throw new IllegalStateException("Army is empty");
        }
    }

    /**
     * Gets all units from army.
     *
     * @return list of units
     */
    public List<Unit> getAllUnits(){
        return units;
    }

    /**
     * Gets name of army.
     *
     * @return name of army
     */
    public String getName() {
        return name;
    }

    /**
     * Converts army to a string.
     *
     * @return army as string
     */
    @Override
    public String toString() {
        return name + '\n' +
                "units:" + units;
    }

    /**
     * Checks if army equals another object.
     *
     * @param o object to be checked against
     * @return  true if objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Army army = (Army) o;
        return name.equals(army.name) && units.equals(army.units);
    }

    /**
     * Generates a hashcode of the name and unit list in army.
     *
     * @return hashcode as int
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, units);
    }
}
