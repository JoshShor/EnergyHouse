package cs134.miracosta.edu.energyhouse.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * RecyclingTypesTest.java - Tests the RecyclingTypes class
 *
 * @author Dennis La
 * @version 1.0
 */
public class RecyclingTypesTest
{
    private static RecyclingTypes testRecyclingTypes;

    /**
     * Create new RecyclingTypes
     */
    @Before
    public void setUp()
    {
        //instantiate objects used for testing
        testRecyclingTypes = new RecyclingTypes("Batteries", "Bring to Best Buy");
    }

    /**
     * Tests getRecyclableName
     */
    @Test
    public void testGetRecyclableName()
    {
        assertEquals("Testing getRecyclableName method", "Batteries", testRecyclingTypes.getRecyclableName());
    }

    /**
     * Tests setRecyclableName
     */
    @Test
    public void testSetRecyclableName()
    {
        testRecyclingTypes.setRecyclableName("Paper");
        assertEquals("Testing setRecyclableName method", "Paper", testRecyclingTypes.getRecyclableName());
    }

    /**
     * Tests getHowToDispose
     */
    @Test
    public void testGetHowToDispose()
    {
        assertEquals("Testing getHowToDispose method", "Bring to Best Buy", testRecyclingTypes.getHowToDispose());
    }

    /**
     * Tests setHowToDispose
     */
    @Test
    public void testSetHowToDispose()
    {
        testRecyclingTypes.setHowToDispose("Recycling bin");
        assertEquals("Testing setHowToDispose method", "Recycling bin", testRecyclingTypes.getHowToDispose());
    }
}
