package edu.ntnu.idatt2001.wargames.army;

/**
 * Represents a ranged unit in an army.
 * A ranged unit that possesses high attack bonus and
 * variable resistance bonus depending on range.
 */
public class RangedUnit extends Unit{

    private int numOfDefenses = 0;

    /**
     * Initializes a RangedUnit object with an attack value of 15 and an armor value of 8.
     *
     * @param name      Ranged unit name as String
     * @param health    Ranged unit health as int
     */
    public RangedUnit(String name, int health) {
        super(name, health, 15, 8);
    }

    /**
     * Initializes a RangedUnit object with custom defined stats.
     *
     * @param name      Ranged unit name as String
     * @param health    Ranged unit health as int
     * @param attack    Ranged unit attack value as int
     * @param armor     Ranged unit armor value as int
     */
    public RangedUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * {@inheritDoc}<br>
     * Gives a high attack bonus for ranged units.
     *
     * @return Attack bonus as int
     */
    @Override
    public int getAttackBonus() {
        return 3;
    }

    /**
     * {@inheritDoc}<br>
     * Gives a variable resistance value based on opponent range.
     * Calculated using number of attacks by opponents.
     * <ul>
     *     <li>6 for first hit</li>
     *     <li>4 for second hit</li>
     *     <li>2 for remaining hits</li>
     * </ul>
     *
     * @return Resistance bonus as int
     */
    @Override
    public int getResistBonus() {

        if(numOfDefenses == 0){
            numOfDefenses += 1;
            return 6;
        }
        else if(numOfDefenses == 1){
            numOfDefenses += 1;
            return 4;
        }
        else{
            return 2;
        }
    }

    /**
     * Sets number of defenses from attacks.
     *
     * Used for JUnit testing
     *
     * @param numOfDefenses     Number of defenses as int
     */
    public void setNumOfDefenses(int numOfDefenses){
        this.numOfDefenses = numOfDefenses;
    }

}
