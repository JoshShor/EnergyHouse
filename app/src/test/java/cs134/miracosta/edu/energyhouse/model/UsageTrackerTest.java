package cs134.miracosta.edu.energyhouse.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * UsageTrackerTest.java - Tests the UsageTracker class
 *
 * @author Joshua Shor
 * @version 1.0
 */
public class UsageTrackerTest {

    private static UsageTracker testUsageTrackers;
    /**
     * Create new ImpactItem
     */
    @Before
    public void setUp()
    {
        //instantiate objects used for testing
        testUsageTrackers = new UsageTracker("Monday","Ten",1.0);
    }

    /**
     * Tests setId
     */
    @Test
    public void testSetId(){
        testUsageTrackers.setId(321);
        assertEquals("Testing setId method", 321, testUsageTrackers.getId());
    }

    /**
     * Tests setDayStr
     */
    @Test
    public void testSetDayStr(){
        testUsageTrackers.setDayStr("Hello");
        assertEquals("Testing setDayStr method", "Hello", testUsageTrackers.getDayStr());
    }

    /**
     * Tests setTimeStr
     */
    @Test
    public void testSetTimeStr(){
        testUsageTrackers.setTimeStr("a great time");
        assertEquals("Testing getTimeStr method", "a great time", testUsageTrackers.getTimeStr());
    }

    /**
     * Tests setWattsUsed
     */
    @Test
    public void testSetWattsUsed(){
        testUsageTrackers.setWattsUsed(700);
        assertEquals("Testing setWattsUsed method", 700, testUsageTrackers.getWattsUsed(),0);
    }

    /**
     * Tests getId
     */
    @Test
    public void testGetId(){
        assertEquals("Testing getId method", -1, testUsageTrackers.getId());
    }

    /**
     * Tests getDayStr
     */
    @Test
    public void testGetDayStr(){
        assertEquals("Testing setDayStr method", "Hello", testUsageTrackers.getDayStr());
    }

    /**
     * Tests getTimeStr
     */
    @Test
    public void testGetTimeStr(){
        assertEquals("Testing getTimeStr method", "a great time", testUsageTrackers.getTimeStr());
    }

    /**
     * Tests getWattsUsed
     */
    @Test
    public void testGetWattsUsed(){
        assertEquals("Testing getWattsUsed method", 700, testUsageTrackers.getWattsUsed(),0);
    }

}