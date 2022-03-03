package edu.ntnu.idatt2001.wargames.battle;

import edu.ntnu.idatt2001.wargames.army.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    @Test
    @DisplayName("Constructor initializes correctly")
    void Simple_Constructor_Initializes_Correctly() {
        //Arrange:
        var armyOne = new Army("ArmyOne");
        var armyTwo = new Army("ArmyTwo");
        //Act
        var battle = new Battle(armyOne, armyTwo);
        //Assert
        assertEquals(armyOne, battle.getArmyOne());
        assertEquals(armyTwo, battle.getArmyTwo());
    }

    @Nested
    class SimulationTest {

        @Test
        @DisplayName("simulate gives correct winner")
        void simulate_Gives_Correct_Winner() {
            //Arrange
            List<Unit> units1 = new ArrayList<>();
            units1.add(new CavalryUnit("Knight", 50));
            units1.add(new InfantryUnit("Peasant", 30));
            units1.add(new CommanderUnit("King Kong", 100));

            List<Unit> units2 = new ArrayList<>();
            units2.add(new RangedUnit("Archer", 40));
            units2.add(new CavalryUnit("Knight", 40));
            units2.add(new RangedUnit("Trebuchet", 80));
            units2.add(new CommanderUnit("King Midas", 90));

            var armyOne = new Army("ArmyOne", units1);
            var armyTwo = new Army("ArmyTwo", units2);
            //Act
            var battle = new Battle(armyOne, armyTwo);
            var winner = battle.simulate();
            //Assert
            System.out.println(winner);
            assertThat(winner, Matchers.either(Matchers.is(armyOne)).or(Matchers.is(armyTwo)).or(Matchers.is(new Army("Tie"))));
        }

        @Test
        @DisplayName("simulate empty armies results in tie")
        void simulate_Empty_Armies_Results_In_Tie() {
            //Arrange
            var armyOne = new Army("ArmyOne");
            var armyTwo = new Army("ArmyTwo");
            //Act
            var battle = new Battle(armyOne, armyTwo);
            var winner = battle.simulate();
            //Assert
            assertEquals(new Army("Tie"), winner);
        }
    }

    @Nested
    class GetterTest{

        @Test
        @DisplayName("getArmyOne returns armyOne")
        void getArmyOne_Returns_ArmyOne() {
            //Arrange:
            String name = "ArmyOne";
            String name2 = "ArmyTwo";
            var armyOne = new Army(name);
            var armyTwo = new Army(name2);
            //Act
            var battle = new Battle(armyOne,armyTwo);
            //Assert
            assertEquals(armyOne, battle.getArmyOne());
        }

        @Test
        @DisplayName("getArmyTwo returns armyTwo")
        void getArmyTwo_Returns_ArmyTwo() {
            //Arrange:
            String name = "ArmyOne";
            String name2 = "ArmyTwo";
            var armyOne = new Army(name);
            var armyTwo = new Army(name2);
            //Act
            var battle = new Battle(armyOne,armyTwo);
            //Assert
            assertEquals(armyTwo, battle.getArmyTwo());
        }
    }
}