package cs134.miracosta.edu.energyhouse.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * SolarPanelsTest.java - Tests the SolarPanelsTest class
 *
 * @author Joshua Shor
 * @version 1.0
 */
public class SolarPanelsTest {
    private static SolarPanels testSolarPanels;

    /**
     * Create new SolarPanels
     */
    @Before
    public void setUp(){
        //instantiate objects used for testing
        testSolarPanels = new SolarPanels("Panels", 0,0,0);
    }


    /**
     * Tests setPanel
     */
    @Test
    public void testSetPanel(){
        testSolarPanels.setPanel("panel");
        assertEquals("Testing setPanel method", "panel", testSolarPanels.getPanel());
    }

    /**
     * Tests setCosts
     */
    @Test
    public void testSetCosts(){
        testSolarPanels.setCosts(0.0);
        assertEquals("Testing setCosts method", 0.0, testSolarPanels.getCosts(),0);
    }

    /**
     * Tests setWatts
     */
    @Test
    public void testSetWatts(){
        testSolarPanels.setWatts(2.0);
        assertEquals("Testing setWatts method", 2.0, testSolarPanels.getWatts(),0);
    }

    /**
     * Tests setSqft
     */
    @Test
    public void testSetSqft(){
        testSolarPanels.setSqft(-1.0);
        assertEquals("Testing setSqft method", -1.0, testSolarPanels.getSqft(),0);
    }

    /**
     * Tests setNumberOfPanels
     */
    @Test
    public void testSetNumberOfPanels(){
        testSolarPanels.setNumberOfPanels(25.0);
        assertEquals("testing getNumberOfPanels method", 25.0, testSolarPanels.getNumberOfPanels(),0);
    }

    /**
     * Tests setTotalArea
     */
    @Test
    public void testSetTotalArea(){
        testSolarPanels.setTotalArea(0.0);
        assertEquals("testing getNumberOfPanels method", 12.1, testSolarPanels.getTotalArea(),0);
    }

    /**
     * Tests setTotalCosts
     */
    @Test
    public void testSetTotalCosts(){
        testSolarPanels.setTotalCosts(8.1);
        assertEquals("testing getNumberOfPanels method", 8.1, testSolarPanels.getTotalCosts(),0);
    }
    /**
     * Tests getPanel
     */
    @Test
    public void testGetPanel(){
        assertEquals("testing getPanel method", "panel", testSolarPanels.getPanel());
    }

    /**
     * Tests getCosts
     */
    @Test
    public void testGetCosts(){
        assertEquals("testing getCost method", 0, testSolarPanels.getCosts(),0);
    }

    /**
     * Tests getWatts
     */
    @Test
    public void testGetWatts(){
        assertEquals("Testing setWatts method", 2.0, testSolarPanels.getWatts(),0);
    }

    /**
     * Tests getSqft
     */
    @Test
    public void testGetSqft(){
        assertEquals("Testing setSqft method", -1.0, testSolarPanels.getSqft(),0);
    }

    /**
     * Tests getNumberOfPanels
     */
    @Test
    public void testGetNumberOfPanels(){
        assertEquals("testing getNumberOfPanels method", 25.0, testSolarPanels.getNumberOfPanels(),0);
    }

    /**
     * Tests getTotalArea
     */
    @Test
    public void testGetTotalArea(){
        assertEquals("testing getNumberOfPanels method", 12.1, testSolarPanels.getTotalArea(),0);
    }

    /**
     * Tests getTotalCosts
     */
    @Test
    public void testGetTotalCosts(){
        assertEquals("testing getNumberOfPanels method", 8.1, testSolarPanels.getTotalCosts(),0);
    }

}
