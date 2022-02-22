package edu.ntnu.idatt2001.wargames;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RangedUnitTest {

    @Nested
    @DisplayName("Constructor test")
    class ConstructorTest {

        @Test
        @DisplayName("Simple Constructor initializes correctly")
        void SimpleConstructorInitializesCorrectly() {
            //Arrange:
            String name = "Archer";
            int health = 50;
            //Act
            var archer = new RangedUnit(name, health);
            //Assert
            assertEquals(name, archer.getName());
            assertEquals(health, archer.getHealth());
            assertEquals(15, archer.getAttack());
            assertEquals(8, archer.getArmor());
        }

        @Test
        @DisplayName("General Constructor initializes correctly")
        void GeneralConstructorInitializesCorrectly() {
            //Arrange:
            String name = "Archer";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var archer = new RangedUnit(name, health, attack, armor);
            //Assert
            assertEquals(name, archer.getName());
            assertEquals(health, archer.getHealth());
            assertEquals(attack, archer.getAttack());
            assertEquals(armor, archer.getArmor());
        }

        @ParameterizedTest
        @ValueSource(ints = {0, -1, -30})
        @DisplayName("Simple Constructor Throws IllegalArgumentException for 0 health or lower")
        void SimpleConstructorThrowsIllegalArgumentException(int health) {
            //Arrange:
            String name = "Archer";
            //Act
            //Assert
            assertThrows(IllegalArgumentException.class, () -> {
                var archer = new RangedUnit(name, health);
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
            String name = "Archer";
            //Act
            //Assert
            assertThrows(IllegalArgumentException.class, () -> {
                var archer = new RangedUnit(name, health, attack, armor);
            });
        }
    }

    @Nested
    @DisplayName("Bonus stat tests")
    class BonusStatTest {


        @Test
        @DisplayName("getAttackBonus returns 3")
        void getAttackBonusReturns3() {
            //Arrange
            String name = "Archer";
            int attackBonus = 3;
            //Act
            var archer = new RangedUnit(name,12);
            //Assert
            assertEquals(attackBonus, archer.getAttackBonus());
        }

        @ParameterizedTest(name = "{0} defenses and {1} resistance bonus")
        @CsvSource({"0, 6",
                    "1, 4",
                    "2, 2",
                    "3, 2"})
        @DisplayName("getResistBonus returns 6 then 4 then 2")
        void getResistBonusReturns6Then4Then2(int numOfDefenses, int expectedResistBonus) {
            //Arrange
            String name = "Archer";
            int health = 12;
            //Act
            var archer = new RangedUnit(name,health);
            archer.setNumOfDefenses(numOfDefenses);
            //Assert
            assertEquals(expectedResistBonus, archer.getResistBonus());
        }
    }
    @Nested
    class GetterAndSetter {

        @Test
        @DisplayName("setHealth set the correct health")
        void setHealthSetsCorrectHealth() {
            //Arrange
            String name = "Archer";
            int health = 10;
            int expectedHealth = 15;
            //Act
            var archer = new RangedUnit(name, health);
            archer.setHealth(expectedHealth);
            //Assert
            assertEquals(expectedHealth, archer.getHealth());
        }

        @Test
        @DisplayName("getName returns correct name")
        void getNameReturnsCorrectName(){
            //Arrange
            String name = "Archer";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var archer = new RangedUnit(name, health, attack, armor);
            //Assert
            assertEquals(name, archer.getName());

        }

        @Test
        @DisplayName("getHealth returns correct health")
        void getHealthReturnsCorrectHealth(){
            //Arrange
            String name = "Archer";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var archer = new RangedUnit(name, health, attack, armor);
            //Assert
            assertEquals(health, archer.getHealth());

        }

        @Test
        @DisplayName("getAttack returns correct attack value")
        void getAttackReturnsCorrectAttack(){
            //Arrange
            String name = "Archer";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var archer = new RangedUnit(name, health, attack, armor);
            //Assert
            assertEquals(attack, archer.getAttack());

        }

        @Test
        @DisplayName("getArmor returns correct armor value")
        void getArmorReturnsCorrectArmor(){
            //Arrange
            String name = "Archer";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var archer = new RangedUnit(name, health, attack, armor);
            //Assert
            assertEquals(armor, archer.getArmor());

        }
    }

    @ParameterizedTest(name = "{0} previous defenses results in {1} remaining health after attack")
    @CsvSource({"0, 46",
                "1, 44",
                "2, 42",
                "3, 42"})
    @DisplayName("Attack deals correct damage to enemy")
    void attackDealsCorrectDamage(int numOfDefenses, int expectedHealth){
        //Arrange
        String name1 = "Allied archer";
        String name2 = "Enemy archer";
        int health = 50;
        //Act
        var alliedArcher = new RangedUnit(name1, health);
        var enemyArcher = new RangedUnit(name2, health);
        enemyArcher.setNumOfDefenses(numOfDefenses);
        alliedArcher.attack(enemyArcher);
        //Assert
        assertEquals(expectedHealth, enemyArcher.getHealth());
    }
}