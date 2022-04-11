package edu.ntnu.idatt2001.wargames.army;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnitFactoryTest {

    @Test
    @DisplayName("getUnit returns correct unit")
    void getUnit_Returns_Correct_Unit(){
        //Arrange:
        UnitType type = UnitType.INFANTRY;
        String name = "Peasant";
        int health = 50;
        InfantryUnit expectedUnit = new InfantryUnit(name, health);
        //Act
        var peasant = UnitFactory.getUnit(type, name, health);
        //Assert
        assertEquals(expectedUnit, peasant);
    }

    @Test
    @DisplayName("getComplexUnit returns correct unit")
    void getComplexUnit_Returns_Correct_Unit(){
        //Arrange:
        UnitType type = UnitType.INFANTRY;
        String name = "Peasant";
        int health = 50;
        int attack = 20;
        int armor = 20;
        InfantryUnit expectedUnit = new InfantryUnit(name, health, attack, armor);
        //Act
        var peasant = UnitFactory.getComplexUnit(type, name, health, attack, armor);
        //Assert
        assertEquals(expectedUnit, peasant);
    }

    @Nested
    class getListUnitTest {

        @Test
        @DisplayName("getListUnit returns List with correct units")
        void getListUnit_Returns_List_With_Correct_Units() {
            //Arrange:
            List<Unit> expectedUnitList = new ArrayList<>();
            UnitType type = UnitType.INFANTRY;
            String name = "Peasant";
            int health = 50;
            InfantryUnit expectedUnit = new InfantryUnit(name, health);
            for (int i = 0; i < 3; i++) {
                expectedUnitList.add(expectedUnit);
            }
            //Act
            List<Unit> unitList = UnitFactory.getListUnits(type, name, health, 3);
            //Assert
            assertTrue(expectedUnitList.containsAll(unitList));
        }

        @Test
        @DisplayName("getListUnit returns List with correct units")
        void getListUnit_Returns_List_Of_Correct_Size() {
            //Arrange:
            UnitType type = UnitType.INFANTRY;
            String name = "Peasant";
            int health = 50;
            int expectedSize = 3;
            //Act
            List<Unit> unitList = UnitFactory.getListUnits(type, name, health, 3);
            //Assert
            assertEquals(expectedSize, unitList.size());
        }
    }

    @Nested
    class getListComplexUnitTest {

        @Test
        @DisplayName("getListComplexUnit returns List with correct units")
        void getListComplexUnit_Returns_List_With_Correct_Units() {
            //Arrange:
            List<Unit> expectedUnitList = new ArrayList<>();
            UnitType type = UnitType.INFANTRY;
            String name = "Peasant";
            int health = 50;
            int attack = 20;
            int armor = 20;
            InfantryUnit expectedUnit = new InfantryUnit(name, health, attack, armor);
            for (int i = 0; i < 3; i++) {
                expectedUnitList.add(expectedUnit);
            }
            //Act
            List<Unit> unitList = UnitFactory.getListComplexUnits(type, name, health, attack, armor, 3);
            //Assert
            assertTrue(expectedUnitList.containsAll(unitList));
        }

        @Test
        @DisplayName("getListUnit returns List with correct units")
        void getListUnit_Returns_List_Of_Correct_Size() {
            //Arrange:
            UnitType type = UnitType.INFANTRY;
            String name = "Peasant";
            int health = 50;
            int attack = 20;
            int armor = 20;
            int expectedSize = 3;
            //Act
            List<Unit> unitList = UnitFactory.getListComplexUnits(type, name, health, attack, armor, 3);
            //Assert
            assertEquals(expectedSize, unitList.size());
        }
    }

}