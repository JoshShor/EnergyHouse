package cs134.miracosta.edu.energyhouse.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * ImpactItemTest.java - Tests the ImpactItem class
 *
 * @author Dennis La
 * @version 1.0
 */
public class ImpactItemTest
{
    private static ImpactItem testImpactItem;

    /**
     * Create new ImpactItem
     */
    @Before
    public void setUp()
    {
        //instantiate objects used for testing
        testImpactItem = new ImpactItem();
    }

    /**
     * Tests getPoundsOfPaper
     */
    @Test
    public void testGetPoundsPaper()
    {
        assertEquals("Testing getPoundsOfPaper method", 0.0,
                testImpactItem.getPoundsOfPaper(), 0);
    }

    /**
     * Tests setPoundsOfPaper
     */
    @Test
    public void testSetPoundsPaper()
    {
        testImpactItem.setPoundsOfPaper(1.0);
        assertEquals("Testing setPoundsOfPaper method", 1.0,
                testImpactItem.getPoundsOfPaper(), 0);
    }

    /**
     * Tests getPoundsOfMixedRecyclables
     */
    @Test
    public void testGetPoundsMixedRecyclables()
    {
        assertEquals("Testing getPoundsOfMixedRecyclables method", 0.0,
                testImpactItem.getPoundsOfMixedRecyclables(), 0);
    }

    /**
     * Tests setPoundsOfMixedRecyclables
     */
    @Test
    public void testSetPoundsMixedRecyclables()
    {
        testImpactItem.setPoundsOfMixedRecyclables(1.0);
        assertEquals("Testing setPoundsOfMixedRecyclables method", 1.0,
                testImpactItem.getPoundsOfMixedRecyclables(), 0);
    }

    /**
     * Tests getId
     */
    @Test
    public void testGetId()
    {
        assertEquals("Testing getId method", -1, testImpactItem.getId());
    }

    /**
     * Tests setId
     */
    @Test
    public void testSetId()
    {
        testImpactItem.setId(321);
        assertEquals("Testing setId method", 321, testImpactItem.getId());
    }

    /**
     * Tests calcNumTreesSaved
     */
    @Test
    public void testCalcNumTreesSaved()
    {
        testImpactItem.setPoundsOfPaper(50);
        testImpactItem.setPoundsOfMixedRecyclables(50);

        int numTrees = (int) Math.round(testImpactItem.calcNumTreesSaved());

        assertEquals("Testing calcNumTreesSaved method", 7, numTrees);

    }

    /**
     * Tests calcNumGallonsOfOilSaved
     */
    @Test
    public void testCalcNumGallonsOfOilSaved()
    {
        testImpactItem.setPoundsOfPaper(50);
        testImpactItem.setPoundsOfMixedRecyclables(50);

        int numOil = (int) Math.round(testImpactItem.calcNumGallonsOfOilSaved());

        assertEquals("Testing calcNumGallonsOfOilSaved method", 163, numOil);

    }

    /**
     * Tests calcHoursOfElectricitySaved
     */
    @Test
    public void testCalcHoursOfElectricitySaved()
    {
        testImpactItem.setPoundsOfPaper(50);
        testImpactItem.setPoundsOfMixedRecyclables(50);

        int numElec = (int) Math.round(testImpactItem.calcHoursOfElectricitySaved());

        assertEquals("Testing calcHoursOfElectricitySaved method", 1307, numElec);

    }

    /**
     * Tests calcNumGallonsOfWaterSaved
     */
    @Test
    public void calcNumGallonsOfWaterSaved()
    {
        testImpactItem.setPoundsOfPaper(50);
        testImpactItem.setPoundsOfMixedRecyclables(50);

        int numWater = (int) Math.round(testImpactItem.calcNumGallonsOfWaterSaved());

        assertEquals("Testing calcNumGallonsOfWaterSaved method", 2080, numWater);

    }

}
