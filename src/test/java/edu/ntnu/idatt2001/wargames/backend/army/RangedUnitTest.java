package edu.ntnu.idatt2001.wargames.backend.army;

import edu.ntnu.idatt2001.wargames.backend.battle.Terrain;
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
        void Simple_Constructor_Initializes_Correctly() {
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
        void General_Constructor_Initializes_Correctly() {
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
        void Simple_Constructor_Throws_IllegalArgumentException(int health) {
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
        void General_Constructor_Throws_IllegalArgumentException(String placeholder, int attack, int armor, int health) {
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
        void getAttackBonus_Returns_3() {
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
        void getResistBonus_Returns_6_Then_4_Then_2(int numOfDefenses, int expectedResistBonus) {
            //Arrange
            String name = "Archer";
            int health = 12;
            //Act
            var archer = new RangedUnit(name,health);
            archer.setNumOfDefenses(numOfDefenses);
            //Assert
            assertEquals(expectedResistBonus, archer.getResistBonus());
        }

        @Test
        @DisplayName("getAttackBonus returns 4 for hill terrain")
        void getAttackBonus_Returns_4_For_Hill_Terrain() {
            //Arrange
            String name = "Archer";
            int attackBonus = 4;
            Terrain terrain = Terrain.HILL;
            //Act
            var archer = new RangedUnit(name,12);
            archer.setTerrain(terrain);
            //Assert
            assertEquals(attackBonus, archer.getAttackBonus());
        }

        @Test
        @DisplayName("getAttackBonus returns 2 for forrest terrain")
        void getResistanceBonus_Returns_2_For_Forrest_Terrain() {
            //Arrange
            String name = "Archer";
            int attackBonus = 2;
            Terrain terrain = Terrain.FORREST;
            //Act
            var archer = new RangedUnit(name,12);
            archer.setTerrain(terrain);
            //Assert
            assertEquals(attackBonus, archer.getAttackBonus());
        }
    }
    @Nested
    class GetterAndSetter {

        @Test
        @DisplayName("setHealth set the correct health")
        void setHealth_Sets_Correct_Health() {
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
        void getName_Returns_Correct_Name(){
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
        void getHealth_Returns_Correct_Health(){
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
        void getAttack_Returns_Correct_Attack(){
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
        void getArmor_Returns_Correct_Armor(){
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

        @Test
        @DisplayName("getTerrain returns correct Terrain")
        void getTerrain_Returns_Correct_Terrain(){
            //Arrange
            String name = "Archer";
            int health = 50;
            int attack = 10;
            int armor = 12;
            Terrain expectedTerrain = Terrain.DEFAULT;
            //Act
            var archer = new RangedUnit(name, health, attack, armor);
            //Assert
            assertEquals(expectedTerrain, archer.getTerrain());

        }

        @Test
        @DisplayName("setTerrain sets correct Terrain")
        void setTerrain_Sets_Correct_Terrain(){
            //Arrange
            String name = "Archer";
            int health = 50;
            int attack = 10;
            int armor = 12;
            Terrain expectedTerrain = Terrain.FORREST;
            //Act
            var archer = new RangedUnit(name, health, attack, armor);
            archer.setTerrain(expectedTerrain);
            //Assert
            assertEquals(expectedTerrain, archer.getTerrain());

        }
    }

    @ParameterizedTest(name = "{0} previous defenses results in {1} remaining health after attack")
    @CsvSource({"0, 46",
                "1, 44",
                "2, 42",
                "3, 42"})
    @DisplayName("Attack deals correct damage to enemy")
    void attack_Deals_Correct_Damage(int numOfDefenses, int expectedHealth){
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