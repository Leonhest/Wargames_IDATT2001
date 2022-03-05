package edu.ntnu.idatt2001.wargames.army;

import edu.ntnu.idatt2001.wargames.army.Army;
import edu.ntnu.idatt2001.wargames.army.CavalryUnit;
import edu.ntnu.idatt2001.wargames.army.InfantryUnit;
import edu.ntnu.idatt2001.wargames.army.Unit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    @DisplayName("add places unit in army")
    void add_Places_Unit_In_Army() {
        //Arrange
        String name = "Army";
        var knight = new CavalryUnit("Knight", 50);
        var peasant = new InfantryUnit("Peasant", 30);
        //Act
        var army = new Army(name);
        army.add(knight);
        army.add(peasant);
        //Assert
        assertEquals(knight, army.getAllUnits().get(0));
        assertEquals(peasant, army.getAllUnits().get(1));
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