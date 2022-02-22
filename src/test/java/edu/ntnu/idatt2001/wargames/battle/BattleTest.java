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
    void SimpleConstructorInitializesCorrectly() {
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
        void simulateGivesCorrectWinner() {
            //Arrange
            List<Unit> units1 = new ArrayList<>();
            units1.add(new CavalryUnit("Knight", 50));
            units1.add(new InfantryUnit("Peasant", 30));
            units1.add(new CommanderUnit("King Kong", 100));

            List<Unit> units2 = new ArrayList<>();
            units2.add(new RangedUnit("Archer", 40));
            units2.add(new CavalryUnit("Knight", 40));
            units2.add(new RangedUnit("Trebuchet1", 80));
            units2.add(new RangedUnit("Trebuchet2", 80));
            units2.add(new CommanderUnit("King Midas", 90));

            var armyOne = new Army("ArmyOne", units1);
            var armyTwo = new Army("ArmyTwo", units2);
            //Act
            var battle = new Battle(armyOne, armyTwo);
            var winner = battle.simulate();
            //Assert
            assertThat(winner, Matchers.either(Matchers.is(armyOne)).or(Matchers.is(armyTwo)).or(Matchers.is(new Army("Tie"))));
        }

        @Test
        @DisplayName("simulate empty armies results in tie")
        void simulateEmptyArmiesResultsInTie() {
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
        void getArmyOneReturnsArmyOne() {
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
        void getArmyTwoReturnsArmyTwo() {
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