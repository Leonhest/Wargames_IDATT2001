package edu.ntnu.idatt2001.wargames.army;

import edu.ntnu.idatt2001.wargames.army.Army;
import edu.ntnu.idatt2001.wargames.army.CavalryUnit;
import edu.ntnu.idatt2001.wargames.army.InfantryUnit;
import edu.ntnu.idatt2001.wargames.army.Unit;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {

    @Nested
    @DisplayName("Constructor test")
    class ConstructorTest {

        @Test
        @DisplayName("Simple Constructor initializes correctly")
        void Simple_Constructor_Initializes_Correctly() {
            //Arrange:
            String name = "Army";
            //Act
            var army = new Army(name);
            //Assert
            assertEquals(name, army.getName());

        }

        @Test
        @DisplayName("General Constructor initializes correctly")
        void General_Constructor_Initializes_Correctly() {
            //Arrange:
            String name = "Army";
            List<Unit> units = new ArrayList<>();
            units.add(new CavalryUnit("Knight", 50));
            units.add(new InfantryUnit("Peasant", 50));
            //Act
            var army = new Army(name, units);
            //Assert
            assertEquals(name, army.getName());
            assertEquals(units, army.getAllUnits());

        }
    }

    @Nested
    class getInfantryUnitTest{


        @Test
        @DisplayName("getInfantryUnits returns list containing only InfantryUnit")
        void getInfantryUnits_Returns_List_Containing_Only_InfantryUnit () {
        //Arrange
        String name = "Army";
        var knight = new CavalryUnit("Knight", 50);
        var peasant = new InfantryUnit("Peasant", 30);
        var archer = new RangedUnit("Knight", 50);
        var peasant2 = new InfantryUnit("Peasant2", 30);

        var army = new Army(name);
        army.add(knight);
        army.add(peasant);
        army.add(archer);
        army.add(peasant2);
        //Act
        List<Unit> infantryUnits = army.getInfantryUnits();
        //Assert
        assertTrue(infantryUnits.stream().allMatch(e -> e instanceof InfantryUnit));
        }

        @Test
        @DisplayName("getInfantryUnits returns list not containing other than InfantryUnit")
        void getInfantryUnits_Returns_List_Not_Containing_Other_Than_InfantryUnit () {
        //Arrange
        String name = "Army";
        var knight = new CavalryUnit("Knight", 50);
        var peasant = new InfantryUnit("Peasant", 30);
        var archer = new RangedUnit("Knight", 50);
        var peasant2 = new InfantryUnit("Peasant2", 30);

        var army = new Army(name);
        army.add(knight);
        army.add(peasant);
        army.add(archer);
        army.add(peasant2);
        //Act
        List<Unit> infantryUnits = army.getInfantryUnits();
        //Assert
        assertTrue(infantryUnits.stream().noneMatch(e -> e instanceof RangedUnit));
        assertTrue(infantryUnits.stream().noneMatch(e -> e instanceof CavalryUnit));
        }

        @Test
        @DisplayName("getInfantryUnits returns list of correct size")
        void getInfantryUnits_Returns_List_Of_Correct_Size () {
            //Arrange
            String name = "Army";
            var knight = new CavalryUnit("Knight", 50);
            var peasant = new InfantryUnit("Peasant", 30);
            var archer = new RangedUnit("Knight", 50);
            var peasant2 = new InfantryUnit("Peasant2", 30);

            var army = new Army(name);
            army.add(knight);
            army.add(peasant);
            army.add(archer);
            army.add(peasant2);
            //Act
            List<Unit> infantryUnits = army.getInfantryUnits();
            //Assert
            assertEquals(2, infantryUnits.size());
        }
    }

    @Nested
    class getRangedUnitTest{


        @Test
        @DisplayName("getRangedUnits returns list containing only RangedUnit")
        void getRangedUnits_Returns_List_Containing_Only_RangedUnit () {
            //Arrange
            String name = "Army";
            var knight = new CavalryUnit("Knight", 50);
            var peasant = new InfantryUnit("Peasant", 30);
            var archer = new RangedUnit("Knight", 50);
            var archer2 = new RangedUnit("Archer2", 30);

            var army = new Army(name);
            army.add(knight);
            army.add(peasant);
            army.add(archer);
            army.add(archer2);
            //Act
            List<Unit> rangedUnits = army.getRangedUnits();
            //Assert
            assertTrue(rangedUnits.stream().allMatch(e -> e instanceof RangedUnit));
        }

        @Test
        @DisplayName("getRangedUnits returns list not containing other than RangedUnit")
        void getRangedUnits_Returns_List_Not_Containing_Other_Than_RangedUnit () {
            //Arrange
            String name = "Army";
            var knight = new CavalryUnit("Knight", 50);
            var peasant = new InfantryUnit("Peasant", 30);
            var archer = new RangedUnit("Knight", 50);
            var archer2 = new RangedUnit("Archer2", 30);

            var army = new Army(name);
            army.add(knight);
            army.add(peasant);
            army.add(archer);
            army.add(archer2);
            //Act
            List<Unit> rangedUnits = army.getRangedUnits();
            //Assert
            assertTrue(rangedUnits.stream().noneMatch(e -> e instanceof InfantryUnit));
            assertTrue(rangedUnits.stream().noneMatch(e -> e instanceof CavalryUnit));
        }

        @Test
        @DisplayName("getRangedUnits returns list of correct size")
        void getRangedUnits_Returns_List_Of_Correct_Size () {
            //Arrange
            String name = "Army";
            var knight = new CavalryUnit("Knight", 50);
            var peasant = new InfantryUnit("Peasant", 30);
            var archer = new RangedUnit("Knight", 50);
            var archer2 = new RangedUnit("Archer2", 30);

            var army = new Army(name);
            army.add(knight);
            army.add(peasant);
            army.add(archer);
            army.add(archer2);
            //Act
            List<Unit> rangedUnits = army.getRangedUnits();
            //Assert
            assertEquals(2, rangedUnits.size());
        }
    }

    @Nested
    class getCavalryUnitTest{


        @Test
        @DisplayName("getCavalryUnits returns list containing only CavalryUnit")
        void getCavalryUnits_Returns_List_Containing_Only_CavalryUnit () {
            //Arrange
            String name = "Army";
            var knight = new CavalryUnit("Knight", 50);
            var peasant = new InfantryUnit("Peasant", 30);
            var archer = new RangedUnit("Knight", 50);
            var knight2 = new CavalryUnit("Knight2", 30);

            var army = new Army(name);
            army.add(knight);
            army.add(peasant);
            army.add(archer);
            army.add(knight2);
            //Act
            List<Unit> cavalryUnits = army.getCavalryUnits();
            //Assert
            assertTrue(cavalryUnits.stream().allMatch(e -> e instanceof CavalryUnit));
        }

        @Test
        @DisplayName("getCavalryUnits returns list not containing other than CavalryUnit")
        void getCavalryUnits_Returns_List_Not_Containing_Other_Than_CavalryUnit () {
            //Arrange
            String name = "Army";
            var knight = new CavalryUnit("Knight", 50);
            var peasant = new InfantryUnit("Peasant", 30);
            var archer = new RangedUnit("Knight", 50);
            var knight2 = new CavalryUnit("Knight2", 30);

            var army = new Army(name);
            army.add(knight);
            army.add(peasant);
            army.add(archer);
            army.add(knight2);
            //Act
            List<Unit> cavalryUnits = army.getCavalryUnits();
            //Assert
            assertTrue(cavalryUnits.stream().noneMatch(e -> e instanceof InfantryUnit));
            assertTrue(cavalryUnits.stream().noneMatch(e -> e instanceof RangedUnit));
            assertTrue(cavalryUnits.stream().noneMatch(e -> e instanceof CommanderUnit));
        }

        @Test
        @DisplayName("getCavalryUnits returns list of correct size")
        void getCavalryUnits_Returns_List_Of_Correct_Size () {
            //Arrange
            String name = "Army";
            var knight = new CavalryUnit("Knight", 50);
            var peasant = new InfantryUnit("Peasant", 30);
            var archer = new RangedUnit("Knight", 50);
            var knight2 = new CavalryUnit("Knight2", 30);

            var army = new Army(name);
            army.add(knight);
            army.add(peasant);
            army.add(archer);
            army.add(knight2);
            //Act
            List<Unit> cavalryUnits = army.getCavalryUnits();
            //Assert
            assertEquals(2, cavalryUnits.size());
        }
    }

    @Nested
    class getCommanderUnitTest{


        @Test
        @DisplayName("getCommanderUnits returns list containing only CommanderUnit")
        void getCommanderUnits_Returns_List_Containing_Only_CommanderUnit () {
            //Arrange
            String name = "Army";
            var king = new CommanderUnit("King", 50);
            var peasant = new InfantryUnit("Peasant", 30);
            var archer = new RangedUnit("Knight", 50);
            var knight2 = new CavalryUnit("Knight2", 30);
            var queen = new CommanderUnit("Queen", 30);

            var army = new Army(name);
            army.add(king);
            army.add(peasant);
            army.add(archer);
            army.add(knight2);
            army.add(queen);
            //Act
            List<Unit> commanderUnits = army.getCommanderUnits();
            //Assert
            assertTrue(commanderUnits.stream().allMatch(e -> e instanceof CommanderUnit));
        }

        @Test
        @DisplayName("getCommanderUnits returns list not containing other than CommanderUnit")
        void getCommanderUnits_Returns_List_Not_Containing_Other_Than_CommanderUnit () {
            //Arrange
            String name = "Army";
            var king = new CommanderUnit("King", 50);
            var peasant = new InfantryUnit("Peasant", 30);
            var archer = new RangedUnit("Knight", 50);
            var knight2 = new CavalryUnit("Knight2", 30);
            var queen = new CommanderUnit("Queen", 30);

            var army = new Army(name);
            army.add(king);
            army.add(peasant);
            army.add(archer);
            army.add(knight2);
            army.add(queen);
            //Act
            List<Unit> commanderUnits = army.getCommanderUnits();
            //Assert
            assertTrue(commanderUnits.stream().noneMatch(e -> e instanceof RangedUnit));
            assertTrue(commanderUnits.stream().noneMatch(e -> e instanceof InfantryUnit));
            assertTrue(commanderUnits.stream().noneMatch(e -> e instanceof CavalryUnit && !(e instanceof CommanderUnit)));
        }

        @Test
        @DisplayName("getCommanderUnits returns list of correct size")
        void getCommanderUnits_Returns_List_Of_Correct_Size () {
            //Arrange
            String name = "Army";
            var king = new CommanderUnit("King", 50);
            var peasant = new InfantryUnit("Peasant", 30);
            var archer = new RangedUnit("Knight", 50);
            var knight2 = new CavalryUnit("Knight2", 30);
            var queen = new CommanderUnit("Queen", 30);

            var army = new Army(name);
            army.add(king);
            army.add(peasant);
            army.add(archer);
            army.add(knight2);
            army.add(queen);
            //Act
            List<Unit> commanderUnits = army.getCommanderUnits();
            //Assert
            assertEquals(2, commanderUnits.size());
        }
    }

    @Test
    @DisplayName("add places unit in army")
    void add_Places_Unit_In_Army() {
        //Arrange
        String name = "Army";
        var king = new CommanderUnit("King", 50);
        var peasant = new InfantryUnit("Peasant", 30);
        var archer = new RangedUnit("Knight", 50);
        var knight2 = new CavalryUnit("Knight2", 30);
        var queen = new CommanderUnit("Queen", 30);

        var army = new Army(name);
        army.add(king);
        army.add(peasant);
        army.add(archer);
        army.add(knight2);
        army.add(queen);
        //Act
        List<Unit> commanderUnits = army.getCommanderUnits();
        //Assert
        assertEquals(2, commanderUnits.size());
    }

    @Test
    @DisplayName("addAll places all units in army")
    void addAll_Places_All_Units_In_Army() {
        //Arrange:
        String name = "Army";
        List<Unit> units = new ArrayList<>();
        units.add(new CavalryUnit("Knight", 50));
        units.add(new InfantryUnit("Peasant", 50));
        //Act
        var army = new Army(name);
        army.addAll(units);
        //Assert
        assertTrue(army.getAllUnits().containsAll(units));
    }

    @Test
    @DisplayName("remove should remove unit from army")
    void remove_Should_Remove_Unit_From_Army() {
        //Arrange:
        String name = "Army";
        List<Unit> units = new ArrayList<>();
        units.add(new CavalryUnit("Knight", 50));
        units.add(new InfantryUnit("Peasant", 50));
        //Act
        var army = new Army(name);
        army.addAll(units);
        army.remove(new CavalryUnit("Knight", 50));
        //Assert
        assertFalse(army.getAllUnits().contains(new CavalryUnit("Knight", 50)));
    }

    @Nested
    class HasUnitsTest {

        @Test
        @DisplayName("hasUnits returns true for non-empty army")
        void hasUnits_Returns_True_For_NonEmpty_Army() {
            //Arrange:
            String name = "Army";
            List<Unit> units = new ArrayList<>();
            units.add(new CavalryUnit("Knight", 50));
            units.add(new InfantryUnit("Peasant", 50));
            //Act
            var army = new Army(name);
            army.addAll(units);
            //Assert
            assertTrue(army.hasUnits());
        }

        @Test
        @DisplayName("hasUnits returns false for empty army")
        void hasUnits_Returns_False_For_Empty_Army() {
            //Arrange:
            String name = "Army";
            //Act
            var army = new Army(name);
            //Assert
            assertFalse(army.hasUnits());
        }
    }

    @Nested
    class GetRandomTest {

        @Test
        @DisplayName("getRandom returns unit on non-empty army")
        void getRandom_Returns_Unit_On_NonEmpty_Army() {
            //Arrange:
            String name = "Army";
            List<Unit> units = new ArrayList<>();
            units.add(new CavalryUnit("Knight", 50));
            units.add(new InfantryUnit("Peasant", 50));
            //Act
            var army = new Army(name);
            army.addAll(units);
            Unit randomUnit = army.getRandom();
            //Assert
            assertTrue(randomUnit instanceof Unit);
        }

        @Test
        @DisplayName("getRandom throw IllegalStatException on empty army")
        void getRandom_Throws_IllegalStateException_On_EmptyArmy() {
            //Arrange:
            String name = "Army";
            //Act
            var army = new Army(name);
            //Assert
            assertThrows(IllegalStateException.class, () -> {
                Unit randomUnit = army.getRandom();
            });
        }

    }

    @Nested
    @DisplayName("Getter test")
    class GetterTest {


        @Test
        @DisplayName("getAllUnits returns all units in army")
        void getAllUnits_Returns_All_Units_In_Army() {
            //Arrange:
            String name = "Army";
            List<Unit> units = new ArrayList<>();
            units.add(new CavalryUnit("Knight", 50));
            units.add(new InfantryUnit("Peasant", 50));
            //Act
            var army = new Army(name, units);
            //Assert
            assertEquals(units, army.getAllUnits());
        }

        @Test
        @DisplayName("getName returns name of army")
        void getName_Returns_Name_Of_Army() {
            //Arrange:
            String name = "Army";
            //Act
            var army = new Army(name);
            //Assert
            assertEquals(name, army.getName());
        }
    }

    @Nested
    class EqualsTest {


        @Test
        @DisplayName("equals returns true for same army")
        void equals_Returns_True_For_Same_Army() {
            //Arrange:
            String name = "Army";
            //Act
            var army = new Army(name);
            var army2 = new Army(name);
            //Assert
            assertTrue(army.equals(army2));
        }

        @Test
        @DisplayName("equals returns false for different army")
        void equals_Returns_False_For_Different_Army() {
            //Arrange:
            String name1 = "Army1";
            String name2 = "Army2";
            //Act
            var army = new Army(name1);
            var army2 = new Army(name2);
            //Assert
            assertFalse(army.equals(army2));
        }
    }
}