package cs134.miracosta.edu.energyhouse.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FuelMileageTest {
    FuelMileage testFuelMileage;

    /**
     * Create new FuelMileage Item
     */
    @Before
    public void setUp()
    {
        //instantiate objects used for testing
        testFuelMileage = new FuelMileage();
    }

    @Test
    public void calculateTotalCost() {
        testFuelMileage.setFuelAmt(2.00);
        testFuelMileage.setPricePerUnitFuel(5.00);
        assertEquals("This test of the calculateTotalCost()", 10.00, testFuelMileage.calculateTotalCost(), 0);
    }
}