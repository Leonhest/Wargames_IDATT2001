package edu.ntnu.idatt2001.wargames;

/**
 * Represents a ranged unit in a Field army.
 * A ranged unit that possesses high attack bonus.
 */
public class RangedUnit extends Unit{

    private int numAttack = 0;

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
     * Gives a variable armor value based on opponent range.
     * Calculated using number of attacks by opponents.
     * <ul>
     *     <li>6 for first hit</li>
     *     <li>4 for second hit</li>
     *     <li>2 for remaining hits</li>
     * </ul>
     *
     * @return Armor bonus as int
     */
    @Override
    public int getResistBonus() {
        numAttack += 1;

        if(numAttack == 1){
            return 6;
        }
        else if(numAttack == 2){
            return 4;
        }
        else{
            return 2;
        }
    }

}
