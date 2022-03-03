package edu.ntnu.idatt2001.wargames.army;

import edu.ntnu.idatt2001.wargames.army.InfantryUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InfantryUnitTest {

    @Nested
    @DisplayName("Constructor test")
    class ConstructorTest {

        @Test
        @DisplayName("Simple Constructor initializes correctly")
        void Simple_Constructor_Initializes_Correctly() {
            //Arrange:
            String name = "Peasant";
            int health = 50;
            //Act
            var peasant = new InfantryUnit(name, health);
            //Assert
            assertEquals(name, peasant.getName());
            assertEquals(health, peasant.getHealth());
            assertEquals(15, peasant.getAttack());
            assertEquals(10, peasant.getArmor());
        }

        @Test
        @DisplayName("General Constructor initializes correctly")
        void General_Constructor_Initializes_Correctly() {
            //Arrange:
            String name = "Peasant";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var peasant = new InfantryUnit(name, health, attack, armor);
            //Assert
            assertEquals(name, peasant.getName());
            assertEquals(health, peasant.getHealth());
            assertEquals(attack, peasant.getAttack());
            assertEquals(armor, peasant.getArmor());
        }

        @ParameterizedTest
        @ValueSource(ints = {0, -1, -30})
        @DisplayName("Simple Constructor Throws IllegalArgumentException for 0 health or lower")
        void Simple_Constructor_Throws_IllegalArgumentException(int health) {
            //Arrange:
            String name = "Peasant";
            //Act
            //Assert
            assertThrows(IllegalArgumentException.class, () -> {
                var peasant = new InfantryUnit(name, health);
            });
        }

        @ParameterizedTest(name = "Invalid {0} value throws IllegalArgumentException")
        @CsvSource({//Negative attack:
                    "attack, -1, 1, 1",
                    //Negative armor:
                    "armor, 1, -1, 1",
                    //0 health
                    "health, 1, 1, 0"})
        @DisplayName("General Constructor Throws IllegalArgumentException for negative stats and 0 health")
        void General_Constructor_Throws_IllegalArgumentException(String placeholder, int attack, int armor, int health) {
            //Arrange:
            String name = "Peasant";
            //Act
            //Assert
            assertThrows(IllegalArgumentException.class, () -> {
                var peasant = new InfantryUnit(name, health, attack, armor);
            });
        }
    }

    @Nested
    @DisplayName("Bonus stat tests")
    class BonusStatTest {


        @Test
        @DisplayName("getAttackBonus returns 2")
        void getAttackBonus_Returns_2() {
            //Arrange
            String name = "Peasant";
            int attackBonus = 2;
            //Act
            var peasant = new InfantryUnit(name,12);
            //Assert
            assertEquals(attackBonus, peasant.getAttackBonus());
        }

        @Test
        @DisplayName("getResistBonus returns 1")
        void getResistBonus_Returns_1() {
            //Arrange
            String name = "Peasant";
            int health = 12;
            int resistBonus = 1;
            //Act
            var peasant = new InfantryUnit(name,health);
            //Assert
            assertEquals(resistBonus, peasant.getResistBonus());
        }
    }
    @Nested
    class GetterAndSetter {

        @Test
        @DisplayName("setHealth set the correct health")
        void setHealth_Sets_Correct_Health() {
            //Arrange
            String name = "Peasant";
            int health = 10;
            int expectedHealth = 15;
            //Act
            var peasant = new InfantryUnit(name, health);
            peasant.setHealth(expectedHealth);
            //Assert
            assertEquals(expectedHealth, peasant.getHealth());
        }

        @Test
        @DisplayName("getName returns correct name")
        void getName_Returns_Correct_Name(){
            //Arrange
            String name = "Peasant";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var peasant = new InfantryUnit(name, health, attack, armor);
            //Assert
            assertEquals(name, peasant.getName());

        }

        @Test
        @DisplayName("getHealth returns correct health")
        void getHealth_Returns_Correct_Health(){
            //Arrange
            String name = "Peasant";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var peasant = new InfantryUnit(name, health, attack, armor);
            //Assert
            assertEquals(health, peasant.getHealth());

        }

        @Test
        @DisplayName("getAttack returns correct attack value")
        void getAttack_Returns_Correct_Attack(){
            //Arrange
            String name = "Peasant";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var peasant = new InfantryUnit(name, health, attack, armor);
            //Assert
            assertEquals(attack, peasant.getAttack());

        }

        @Test
        @DisplayName("getArmor returns correct armor value")
        void getArmor_Returns_Correct_Armor(){
            //Arrange
            String name = "Peasant";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var peasant = new InfantryUnit(name, health, attack, armor);
            //Assert
            assertEquals(armor, peasant.getArmor());

        }
    }

    @Test
    @DisplayName("Attack deals correct damage to enemy")
    void attack_Deals_Correct_Damage(){
        //Arrange
        String name1 = "Allied peasant";
        String name2 = "Enemy peasant";
        int health = 50;
        int expectedHealth = 44;
        //Act
        var alliedPeasant = new InfantryUnit(name1, health);
        var enemyPeasant = new InfantryUnit(name2, health);
        alliedPeasant.attack(enemyPeasant);
        //Assert
        assertEquals(expectedHealth, enemyPeasant.getHealth());
    }

}


