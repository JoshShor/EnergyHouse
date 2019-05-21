package cs134.miracosta.edu.energyhouse.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImpactItemTest
{
    private ImpactItem testImpactItem;

    @Before
    public void setUp() throws Exception
    {
        //instantiate objects used for testing
        testImpactItem = new ImpactItem();
    }

    @Test
    public void testGetPoundsPaper()
    {
        assertEquals("Testing getPoundsOfPaper method", 0.0,
                testImpactItem.getPoundsOfPaper(), 0);
    }

    @Test
    public void testSetPoundsPaper()
    {
        testImpactItem.setPoundsOfPaper(1.0);
        assertEquals("Testing setPoundsOfPaper method", 1.0,
                testImpactItem.getPoundsOfPaper(), 0);
    }

    @Test
    public void testGetPoundsMixedRecyclables()
    {
        assertEquals("Testing getPoundsOfMixedRecyclables method", 0.0,
                testImpactItem.getPoundsOfMixedRecyclables(), 0);
    }

    @Test
    public void testSetPoundsMixedRecyclables()
    {
        testImpactItem.setPoundsOfMixedRecyclables(1.0);
        assertEquals("Testing setPoundsOfMixedRecyclables method", 1.0,
                testImpactItem.getPoundsOfMixedRecyclables(), 0);
    }

    @Test
    public void getId()
    {
        assertEquals("Testing getId method", -1, testImpactItem.getId());
    }

    @Test
    public void setId()
    {
        testImpactItem.setId(321);
        assertEquals("Testing setId method", 321, testImpactItem.getId());
    }

}
