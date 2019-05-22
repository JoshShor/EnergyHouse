package cs134.miracosta.edu.energyhouse.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * RecycleLocationTest.java - Tests the RecycleLocationTest class
 *
 * @author Dennis La
 * @version 1.0
 */
public class RecycleLocationTest
{
    private RecycleLocation testRecycleLocation;

    /**
     * Create new RecycleLocationTest
     */
    @Before
    public void setUp()
    {
        //instantiate objects used for testing
        testRecycleLocation = new RecycleLocation("Place", "123 Place", "Place City",
                "Place State", "12345", "(555)-123-1234", 1234, 1234);
    }

    /**
     * Tests getId
     */
    @Test
    public void testGetId()
    {
        assertEquals("Testing getId method", -1, testRecycleLocation.getId());
    }

    /**
     * Tests setId
     */
    @Test
    public void testSetId()
    {
        testRecycleLocation.setId(321);
        assertEquals("Testing setId method", 321, testRecycleLocation.getId());
    }

    /**
     * Tests getName
     */
    @Test
    public void testGetName()
    {
        assertEquals("Testing getName method", "Place", testRecycleLocation.getName());
    }

    /**
     * Tests setName
     */
    @Test
    public void testSetName()
    {
        testRecycleLocation.setName("New Place");
        assertEquals("Testing setName method", "New Place", testRecycleLocation.getName());
    }

    /**
     * Tests getAddress
     */
    @Test
    public void testGetAddress()
    {
        assertEquals("Testing getAddress method", "123 Place", testRecycleLocation.getAddress());
    }

    /**
     * Tests setAddress
     */
    @Test
    public void testSetAddress()
    {
        testRecycleLocation.setAddress("321 Place");
        assertEquals("Testing setAddress method", "321 Place", testRecycleLocation.getAddress());
    }

    /**
     * Tests getCity
     */
    @Test
    public void testGetCity()
    {
        assertEquals("Testing getCity method", "Place City", testRecycleLocation.getCity());
    }

    /**
     * Tests setCity
     */
    @Test
    public void testSetCity()
    {
        testRecycleLocation.setCity("Place Town");
        assertEquals("Testing setCity method", "Place Town", testRecycleLocation.getCity());
    }

    /**
     * Tests getState
     */
    @Test
    public void testGetState()
    {
        assertEquals("Testing getState method", "Place State", testRecycleLocation.getState());
    }

    /**
     * Tests setState
     */
    @Test
    public void testSetState()
    {
        testRecycleLocation.setState("Somewhere State");
        assertEquals("Testing setState method", "Somewhere State", testRecycleLocation.getState());
    }

    /**
     * Tests getZipCode
     */
    @Test
    public void testGetZipCode()
    {
        assertEquals("Testing getZipCode method", "12345", testRecycleLocation.getZipCode());
    }

    /**
     * Tests setZipCode
     */
    @Test
    public void testSetZipCode()
    {
        testRecycleLocation.setZipCode("54321");
        assertEquals("Testing setZipCode method", "54321", testRecycleLocation.getZipCode());
    }

    /**
     * Tests getPhone
     */
    @Test
    public void testGetPhone()
    {
        assertEquals("Testing getPhone method", "(555)-123-1234", testRecycleLocation.getPhone());
    }

    /**
     * Tests setPhone
     */
    @Test
    public void testSetPhone()
    {
        testRecycleLocation.setPhone("(555)-321-9876");
        assertEquals("Testing setPhone method", "(555)-321-9876", testRecycleLocation.getPhone());
    }

    /**
     * Tests getLatitude
     */
    @Test
    public void testGetLatitude()
    {
        assertEquals("Testing getLatitude method", 1234, testRecycleLocation.getLatitude(), 0);
    }

    /**
     * Tests setLatitude
     */
    @Test
    public void testSetLatitude()
    {
        testRecycleLocation.setLatitude(9876);
        assertEquals("Testing setLatitude method", 9876, testRecycleLocation.getLatitude(), 0);
    }

    /**
     * Tests getLongitude
     */
    @Test
    public void testGetLongitude()
    {
        assertEquals("Testing getLongitude method", 1234, testRecycleLocation.getLongitude(), 0);
    }

    /**
     * Tests setLongitude
     */
    @Test
    public void testSetLongitude()
    {
        testRecycleLocation.setLongitude(9876);
        assertEquals("Testing setLongitude method", 9876, testRecycleLocation.getLongitude(), 0);
    }
}
