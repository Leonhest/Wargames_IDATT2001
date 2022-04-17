package edu.ntnu.idatt2001.wargames.backend.army;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.*;
import java.util.List;
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
     * Constructor used for deep copying.
     *
     * @param army army to be copied
     */
    public Army(Army army){
        this.name = army.getName();
        List<Unit> units = new ArrayList<>();
        for (Unit unit: army.getAllUnits()){
            units.add(UnitFactory.getComplexUnit(unit.getType(), unit.getName(), unit.getHealth(), unit.getAttack(), unit.getArmor()));
        }
        this.units = units;
    }

    /**
     * Initializes an Army object from a .csv file
     * The .csv file contains army name on first row
     * Repeating rows are units written in the format:
     * UnitType,Name,Health
     *
     * @param file csv file with army
     */
    public Army(File file){
        try (
                Reader reader = Files.newBufferedReader(file.toPath());
                CSVReader csvReader = new CSVReader(reader)
        ) {

            this.units = new ArrayList<>();
            String[] fileLine;

            if ((fileLine = csvReader.readNext()) != null && (fileLine.length == 1)) {
                this.name = fileLine[0];
            }
            else throw new IllegalArgumentException("Army does not have a name");

            while ((fileLine = csvReader.readNext()) != null) {

                if(!(fileLine.length == 5) || fileLine[2].equals("")|| fileLine[3].equals("")|| fileLine[4].equals("")){
                    throw new IllegalArgumentException("Missing unit attributes");
                }

                String name = fileLine[1];
                int health = Integer.parseInt(fileLine[2]);
                int attack = Integer.parseInt(fileLine[3]);
                int armor = Integer.parseInt(fileLine[4]);

                if(fileLine[0].toLowerCase(Locale.ROOT).matches(".*infantry.*")){
                    units.add(new InfantryUnit(name, health, attack, armor));
                }
                else if(fileLine[0].toLowerCase(Locale.ROOT).matches(".*ranged.*")){
                    units.add(new RangedUnit(name, health, attack, armor));
                }
                else if(fileLine[0].toLowerCase(Locale.ROOT).matches(".*cavalry.*")){
                    units.add(new CavalryUnit(name, health, attack, armor));
                }
                else if(fileLine[0].toLowerCase(Locale.ROOT).matches(".*commander.*")){
                    units.add(new CommanderUnit(name, health, attack, armor));
                }
                else throw new IllegalArgumentException("Invalid unit type");
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

    }

    /**
     * Saves an Army object to a .csv file
     * The .csv file contains army name on first row
     * Repeating rows are units written in the format:
     * UnitType,Name,Health
     *
     * @param path file path to save location
     */
    public void armyToCsv(String path, String fileName){
        File file = new File(path+"/"+fileName+".csv");
        try (FileWriter output = new FileWriter(file);
             CSVWriter writer = new CSVWriter(output))
        {


            String[] title = {this.name};
            writer.writeNext(title);

            for(Unit i: units){
                String[] unitData = {i.getClass().getSimpleName(), i.getName(), String.valueOf(i.getHealth()), String.valueOf(i.getAttack()), String.valueOf(i.getArmor())};
                writer.writeNext(unitData);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
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
     * Sets name of army.
     *
     * @param name  name of army
     */
    public void setName(String name){
        this.name = name;
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
