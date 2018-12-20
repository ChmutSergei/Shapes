package by.chmut.shapes.specification;

import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.entity.Shape;
import by.chmut.shapes.warehouse.MeasurementData;
import by.chmut.shapes.warehouse.Warehouse;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VolumeBetweenMinMaxTest {

    private static final double MIN = 20;
    private static final double MAX = 40;

    private Specification specification;
    private Shape shape;

    @BeforeMethod
    public void setUp() {
        shape = new Cube();
        specification = new VolumeBetweenMinMax(MIN,MAX);
    }

    @AfterMethod
    public void tearDown() {
        shape = null;
    }

    @DataProvider(name = "forSpecify")
    public static Object[][] forSpecify() {
        return new Object[][]{
                {20, true},
                {30, true},
                {40, true},
                {19, false},
                {41, false},
                {-10, false}
        };
    }

    @Test(dataProvider = "forSpecify",
            description = "Check whether the volume of the shape is between MIN and MAX")
    public void testPositive(double volumeFromMeasurement, boolean expected) {
        Warehouse.getInstance().updateData(shape.getId(),new MeasurementData(0,volumeFromMeasurement));
        boolean actual = specification.specify(shape);
        Assert.assertEquals(actual,expected);
    }

}
