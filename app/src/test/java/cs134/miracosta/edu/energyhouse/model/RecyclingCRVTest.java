package cs134.miracosta.edu.energyhouse.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * RecyclingCRVTest.java - Tests the RecyclingCRV class
 *
 * @author Dennis La
 * @version 1.0
 */
public class RecyclingCRVTest
{
    private static RecyclingCRV testRecyclingCRV;

    /**
     * Create new RecyclingCRV
     */
    @Before
    public void setUp()
    {
        //instantiate objects used for testing
        testRecyclingCRV = new RecyclingCRV();
    }

    /**
     * Tests getPoundsAluminum
     */
    @Test
    public void testGetPoundsAluminum()
    {
        assertEquals("Testing getPoundsAluminum method", 0, testRecyclingCRV.getPoundsAluminum(), 0);
    }

    /**
     * Tests setPoundsAluminum
     */
    @Test
    public void testSetPoundsAluminum()
    {
        testRecyclingCRV.setPoundsAluminum(50);
        assertEquals("Testing setPoundsAluminum method", 50, testRecyclingCRV.getPoundsAluminum(), 0);
    }

    /**
     * Tests getPoundsPETBottles
     */
    @Test
    public void testGetPoundsPETBottles()
    {
        assertEquals("Testing getPoundsPETBottles method", 0, testRecyclingCRV.getPoundsPETBottles(), 0);
    }

    /**
     * Tests setPoundsPETBottles
     */
    @Test
    public void testSetPoundsPETBottles()
    {
        testRecyclingCRV.setPoundsPETBottles(50);
        assertEquals("Testing setPoundsPETBottles method", 50, testRecyclingCRV.getPoundsPETBottles(), 0);
    }

    /**
     * Tests getPoundsHDPEBottles
     */
    @Test
    public void testGetPoundsHDPEBottles()
    {
        assertEquals("Testing getPoundsHDPEBottles method", 0, testRecyclingCRV.getPoundsHDPEBottles(), 0);
    }

    /**
     * Tests setPoundsHDPEBottles
     */
    @Test
    public void testSetPoundsHDPEBottles()
    {
        testRecyclingCRV.setPoundsHDPEBottles(50);
        assertEquals("Testing setPoundsHDPEBottles method", 50, testRecyclingCRV.getPoundsHDPEBottles(), 0);
    }

    /**
     * Tests getPoundsGlassBottles
     */
    @Test
    public void testGetPoundsGlassBottles()
    {
        assertEquals("Testing getPoundsGlassBottles method", 0, testRecyclingCRV.getPoundsGlassBottles(), 0);
    }

    /**
     * Tests setPoundsGlassBottles
     */
    @Test
    public void testSetPoundsGlassBottles()
    {
        testRecyclingCRV.setPoundsGlassBottles(50);
        assertEquals("Testing setPoundsGlassBottles method", 50, testRecyclingCRV.getPoundsGlassBottles(), 0);
    }

    /**
     * Tests calcCRV
     */
    @Test
    public void testCalcCRV()
    {
        testRecyclingCRV.setPoundsAluminum(10);
        testRecyclingCRV.setPoundsPETBottles(10);
        testRecyclingCRV.setPoundsHDPEBottles(10);
        testRecyclingCRV.setPoundsGlassBottles(10);

        assertEquals("Testing calcCRV method", 35.6, testRecyclingCRV.calcCRV(), 0);
    }


}
