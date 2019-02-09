package by.chmut.shapes.specification;

import by.chmut.shapes.action.Service;
import by.chmut.shapes.action.ServiceFactory;
import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.entity.Shape;
import by.chmut.shapes.warehouse.MeasurementData;
import by.chmut.shapes.warehouse.Warehouse;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VolumeBetweenValuesSpecificationTest {

    private static final double MIN = 20;
    private static final double MAX = 40;

    private Specification specification;
    private Service service;
    private Shape shape;

    @BeforeMethod
    public void setUp() {
        shape = new Cube();
        service = ServiceFactory.getInstance().getService(shape);
        specification = new VolumeBetweenValuesSpecification(MIN,MAX);
    }

    @AfterMethod
    public void tearDown() {
        shape = null;
        service = null;
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
        Warehouse.getInstance().put(service.getId(shape),new MeasurementData(0,volumeFromMeasurement));
        boolean actual = specification.specify(shape);
        Assert.assertEquals(actual,expected);
    }

}
