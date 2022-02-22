package edu.ntnu.idatt2001.wargames;

import edu.ntnu.idatt2001.wargames.army.CommanderUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CommanderUnitTest {

    @Nested
    @DisplayName("Constructor test")
    class ConstructorTest {

        @Test
        @DisplayName("Simple Constructor initializes correctly")
        void SimpleConstructorInitializesCorrectly() {
            //Arrange:
            String name = "King";
            int health = 50;
            //Act
            var king = new CommanderUnit(name, health);
            //Assert
            assertEquals(name, king.getName());
            assertEquals(health, king.getHealth());
            assertEquals(25, king.getAttack());
            assertEquals(15, king.getArmor());
        }

        @Test
        @DisplayName("General Constructor initializes correctly")
        void GeneralConstructorInitializesCorrectly() {
            //Arrange:
            String name = "King";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var king = new CommanderUnit(name, health, attack, armor);
            //Assert
            assertEquals(name, king.getName());
            assertEquals(health, king.getHealth());
            assertEquals(attack, king.getAttack());
            assertEquals(armor, king.getArmor());
        }

        @ParameterizedTest
        @ValueSource(ints = {0, -1, -30})
        @DisplayName("Simple Constructor Throws IllegalArgumentException for 0 health or lower")
        void SimpleConstructorThrowsIllegalArgumentException(int health) {
            //Arrange:
            String name = "King";
            //Act
            //Assert
            assertThrows(IllegalArgumentException.class, () -> {
                var king = new CommanderUnit(name, health);
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
        void GeneralConstructorThrowsIllegalArgumentException(String placeholder, int attack, int armor, int health) {
            //Arrange:
            String name = "King";
            //Act
            //Assert
            assertThrows(IllegalArgumentException.class, () -> {
                var king = new CommanderUnit(name, health, attack, armor);
            });
        }
    }

    @Nested
    @DisplayName("Bonus stat tests")
    class BonusStatTest {


        @ParameterizedTest(name = "{0} attacks and {1} attack bonus")
        @CsvSource({"0, 6",
                "1, 2",
                "2, 2",})
        @DisplayName("getAttackBonus returns 6 then 2 per attack")
        void getAttackBonusReturns6tThen2(int numAttack, int expectedAttackBonus) {
            //Arrange
            String name = "King";
            int health = 12;
            //Act
            var king = new CommanderUnit(name,health);
            king.setNumAttack(numAttack);
            //Assert
            assertEquals(expectedAttackBonus, king.getAttackBonus());
        }

        @Test
        @DisplayName("getResistBonus returns 1")
        void getResistBonusReturns1() {
            //Arrange
            String name = "King";
            int health = 12;
            int resistBonus = 1;
            //Act
            var king = new CommanderUnit(name,health);
            //Assert
            assertEquals(resistBonus, king.getResistBonus());
        }
    }
    @Nested
    class GetterAndSetter {

        @Test
        @DisplayName("setHealth set the correct health")
        void setHealthSetsCorrectHealth() {
            //Arrange
            String name = "King";
            int health = 10;
            int expectedHealth = 15;
            //Act
            var king = new CommanderUnit(name, health);
            king.setHealth(expectedHealth);
            //Assert
            assertEquals(expectedHealth, king.getHealth());
        }

        @Test
        @DisplayName("getName returns correct name")
        void getNameReturnsCorrectName(){
            //Arrange
            String name = "King";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var king = new CommanderUnit(name, health, attack, armor);
            //Assert
            assertEquals(name, king.getName());

        }

        @Test
        @DisplayName("getHealth returns correct health")
        void getHealthReturnsCorrectHealth(){
            //Arrange
            String name = "King";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var king = new CommanderUnit(name, health, attack, armor);
            //Assert
            assertEquals(health, king.getHealth());

        }

        @Test
        @DisplayName("getAttack returns correct attack value")
        void getAttackReturnsCorrectAttack(){
            //Arrange
            String name = "King";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var king = new CommanderUnit(name, health, attack, armor);
            //Assert
            assertEquals(attack, king.getAttack());

        }

        @Test
        @DisplayName("getArmor returns correct armor value")
        void getArmorReturnsCorrectArmor(){
            //Arrange
            String name = "King";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var king = new CommanderUnit(name, health, attack, armor);
            //Assert
            assertEquals(armor, king.getArmor());

        }
    }

    @ParameterizedTest(name = "{0} previous attacks results in {1} remaining health after attack")
    @CsvSource({"0, 35",
            "1, 39",
            "2, 39",})
    @DisplayName("Attack deals correct damage to enemy")
    void attackDealsCorrectDamage(int numAttack, int expectedHealth){
        //Arrange
        String name1 = "Allied king";
        String name2 = "Enemy king";
        int health = 50;
        //Act
        var alliedKing = new CommanderUnit(name1, health);
        var enemyKing = new CommanderUnit(name2, health);
        alliedKing.setNumAttack(numAttack);
        alliedKing.attack(enemyKing);
        //Assert
        assertEquals(expectedHealth, enemyKing.getHealth());
    }
}