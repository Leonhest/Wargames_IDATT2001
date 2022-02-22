package edu.ntnu.idatt2001.wargames;

/**
 * Represents a cavalry unit in a Field army.
 * A cavalry unit that possesses variable attack bonus depending on attack type.
 */
public class CavalryUnit extends Unit{

    private int numAttack = 0;

    /**
     * Initializes a CavalryUnit object with an attack value of 20 and an armor value of 12.
     *
     * @param name      Cavalry unit name as String
     * @param health    Cavalry unit health as int
     */
    public CavalryUnit(String name, int health) {
        super(name, health, 20, 12);
    }

    /**
     * Initializes a CavalryUnit object with custom defined stats.
     *
     * @param name      Cavalry unit name as String
     * @param health    Cavalry unit health as int
     * @param attack    Cavalry unit attack value as int
     * @param armor     Cavalry unit armor value as int
     */
    public CavalryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * {@inheritDoc}<br>
     * Preforms a charge on first attack which has high attack bonus.
     *
     * @return  Attack bonus as int
     */
    @Override
    public int getAttackBonus() {

        if(numAttack==0){
            numAttack += 1;
            return 6;
        }
        else{
            return 2;
        }
    }

    /**
     * {@inheritDoc}<br>
     * Gives low resistance bonus for cavalry units.
     * @return
     */
    @Override
    public int getResistBonus() {
        return 1;
    }

    /**
     * Sets number of attacks done
     *
     * Used for testing
     * @param numAttack     Number of defenses as int
     */
    public void setNumAttack(int numAttack){
        this.numAttack = numAttack;
    }
}
