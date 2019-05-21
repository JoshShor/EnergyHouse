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
    public void testGetId()
    {
        assertEquals("Testing getId method", -1, testImpactItem.getId());
    }

    @Test
    public void testSetId()
    {
        testImpactItem.setId(321);
        assertEquals("Testing setId method", 321, testImpactItem.getId());
    }

    @Test
    public void testCalcNumTreesSaved()
    {
        testImpactItem.setPoundsOfPaper(50);
        testImpactItem.setPoundsOfMixedRecyclables(50);
        
        int numTrees = (int) Math.round(testImpactItem.calcNumTreesSaved());

        assertEquals("Testing calcNumTreesSaved method", 7, numTrees);

    }

    @Test
    public void testCalcNumGallonsOfOilSaved()
    {
        testImpactItem.setPoundsOfPaper(50);
        testImpactItem.setPoundsOfMixedRecyclables(50);

        int numOil = (int) Math.round(testImpactItem.calcNumGallonsOfOilSaved());

        assertEquals("Testing calcNumGallonsOfOilSaved method", 163, numOil);

    }

    @Test
    public void testCalcHoursOfElectricitySaved()
    {
        testImpactItem.setPoundsOfPaper(50);
        testImpactItem.setPoundsOfMixedRecyclables(50);

        int numElec = (int) Math.round(testImpactItem.calcHoursOfElectricitySaved());

        assertEquals("Testing calcHoursOfElectricitySaved method", 1307, numElec);

    }

    @Test
    public void calcNumGallonsOfWaterSaved()
    {
        testImpactItem.setPoundsOfPaper(50);
        testImpactItem.setPoundsOfMixedRecyclables(50);

        int numWater = (int) Math.round(testImpactItem.calcNumGallonsOfWaterSaved());

        assertEquals("Testing calcNumGallonsOfWaterSaved method", 2080, numWater);

    }

}
