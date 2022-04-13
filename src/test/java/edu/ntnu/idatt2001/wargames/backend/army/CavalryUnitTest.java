package edu.ntnu.idatt2001.wargames.backend.army;

import edu.ntnu.idatt2001.wargames.backend.battle.Terrain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CavalryUnitTest {

    @Nested
    @DisplayName("Constructor test")
    class ConstructorTest {

        @Test
        @DisplayName("Simple Constructor initializes correctly")
        void Simple_Constructor_InitializesCorrectly() {
            //Arrange:
            String name = "Knight";
            int health = 50;
            //Act
            var knight = new CavalryUnit(name, health);
            //Assert
            assertEquals(name, knight.getName());
            assertEquals(health, knight.getHealth());
            assertEquals(20, knight.getAttack());
            assertEquals(12, knight.getArmor());
        }

        @Test
        @DisplayName("General Constructor initializes correctly")
        void General_Constructor_Initializes_Correctly() {
            //Arrange:
            String name = "Knight";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var knight = new CavalryUnit(name, health, attack, armor);
            //Assert
            assertEquals(name, knight.getName());
            assertEquals(health, knight.getHealth());
            assertEquals(attack, knight.getAttack());
            assertEquals(armor, knight.getArmor());
        }

        @ParameterizedTest
        @ValueSource(ints = {0, -1, -30})
        @DisplayName("Simple Constructor Throws IllegalArgumentException for 0 health or lower")
        void Simple_Constructor_Throws_IllegalArgumentException(int health) {
            //Arrange:
            String name = "Knight";
            //Act
            //Assert
            assertThrows(IllegalArgumentException.class, () -> {
                var knight = new CavalryUnit(name, health);
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
            String name = "Knight";
            //Act
            //Assert
            assertThrows(IllegalArgumentException.class, () -> {
                var knight = new CavalryUnit(name, health, attack, armor);
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
        void getAttackBonus_Returns_6_Then_2(int numAttack, int expectedAttackBonus) {
            //Arrange
            String name = "Knight";
            int health = 12;
            //Act
            var knight = new CavalryUnit(name,health);
            knight.setNumAttack(numAttack);
            //Assert
            assertEquals(expectedAttackBonus, knight.getAttackBonus());
        }

        @Test
        @DisplayName("getResistBonus returns 1")
        void getResistBonus_Returns_1() {
            //Arrange
            String name = "Knight";
            int health = 12;
            int resistBonus = 1;
            //Act
            var knight = new CavalryUnit(name,health);
            //Assert
            assertEquals(resistBonus, knight.getResistBonus());
        }

        @ParameterizedTest(name = "{0} attacks and {1} attack bonus")
        @CsvSource({"0, 8",
                "1, 4",
                "2, 4",})
        @DisplayName("getAttackBonus returns 8 then 4 per attack for plains terrain")
        void getAttackBonus_Returns_8_Then_4_For_Plains_Terrain(int numAttack, int expectedAttackBonus) {
            //Arrange
            String name = "Knight";
            int health = 12;
            //Act
            var knight = new CavalryUnit(name,health);
            knight.setTerrain(Terrain.PLAINS);
            knight.setNumAttack(numAttack);
            //Assert
            assertEquals(expectedAttackBonus, knight.getAttackBonus());
        }

        @Test
        @DisplayName("getResistBonus returns 0 for forrest terrain")
        void getResistBonus_Returns_0_For_Forrest_Terrain() {
            //Arrange
            String name = "Knight";
            int health = 12;
            int resistBonus = 0;
            //Act
            var knight = new CavalryUnit(name,health);
            knight.setTerrain(Terrain.FORREST);
            //Assert
            assertEquals(resistBonus, knight.getResistBonus());
        }
    }
    @Nested
    class GetterAndSetter {

        @Test
        @DisplayName("setHealth set the correct health")
        void setHealth_Sets_Correct_Health() {
            //Arrange
            String name = "Knight";
            int health = 10;
            int expectedHealth = 15;
            //Act
            var knight = new CavalryUnit(name, health);
            knight.setHealth(expectedHealth);
            //Assert
            assertEquals(expectedHealth, knight.getHealth());
        }

        @Test
        @DisplayName("getName returns correct name")
        void getName_Returns_Correct_Name(){
            //Arrange
            String name = "Knight";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var knight = new CavalryUnit(name, health, attack, armor);
            //Assert
            assertEquals(name, knight.getName());

        }

        @Test
        @DisplayName("getHealth returns correct health")
        void getHealth_Returns_Correct_Health(){
            //Arrange
            String name = "Knight";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var knight = new CavalryUnit(name, health, attack, armor);
            //Assert
            assertEquals(health, knight.getHealth());

        }

        @Test
        @DisplayName("getAttack returns correct attack value")
        void getAttack_Returns_Correct_Attack(){
            //Arrange
            String name = "Knight";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var knight = new CavalryUnit(name, health, attack, armor);
            //Assert
            assertEquals(attack, knight.getAttack());

        }

        @Test
        @DisplayName("getArmor returns correct armor value")
        void getArmor_Returns_Correct_Armor(){
            //Arrange
            String name = "Knight";
            int health = 50;
            int attack = 10;
            int armor = 12;
            //Act
            var knight = new CavalryUnit(name, health, attack, armor);
            //Assert
            assertEquals(armor, knight.getArmor());

        }

        @Test
        @DisplayName("getTerrain returns correct Terrain")
        void getTerrain_Returns_Correct_Terrain(){
            //Arrange
            String name = "Knight";
            int health = 50;
            int attack = 10;
            int armor = 12;
            Terrain expectedTerrain = Terrain.DEFAULT;
            //Act
            var knight = new CavalryUnit(name, health, attack, armor);
            //Assert
            assertEquals(expectedTerrain, knight.getTerrain());

        }

        @Test
        @DisplayName("setTerrain sets correct Terrain")
        void setTerrain_Sets_Correct_Terrain(){
            //Arrange
            String name = "Knight";
            int health = 50;
            int attack = 10;
            int armor = 12;
            Terrain expectedTerrain = Terrain.FORREST;
            //Act
            var knight = new CavalryUnit(name, health, attack, armor);
            knight.setTerrain(expectedTerrain);
            //Assert
            assertEquals(expectedTerrain, knight.getTerrain());

        }
    }

    @ParameterizedTest(name = "{0} previous attacks results in {1} remaining health after attack")
    @CsvSource({"0, 37",
            "1, 41",
            "2, 41",})
    @DisplayName("Attack deals correct damage to enemy")
    void attack_Deals_Correct_Damage(int numAttack, int expectedHealth){
        //Arrange
        String name1 = "Allied knight";
        String name2 = "Enemy knight";
        int health = 50;
        //Act
        var alliedKnight = new CavalryUnit(name1, health);
        var enemyKnight = new CavalryUnit(name2, health);
        alliedKnight.setNumAttack(numAttack);
        alliedKnight.attack(enemyKnight);
        //Assert
        assertEquals(expectedHealth, enemyKnight.getHealth());
    }
}