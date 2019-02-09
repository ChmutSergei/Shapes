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

public class SquareBetweenValuesSpecificationTest {

    private static final double MIN = 12;
    private static final double MAX = 20;

    private Specification specification;
    private Service service;
    private Shape shape;

    @BeforeMethod
    public void setUp() {
        shape = new Cube();
        service = ServiceFactory.getInstance().getService(shape);
        specification = new SquareBetweenValuesSpecification(MIN,MAX);
    }

    @AfterMethod
    public void tearDown() {
        shape = null;
        service = null;
    }

    @DataProvider(name = "forSpecify")
    public static Object[][] forSpecify() {
        return new Object[][]{
                {12, true},
                {15, true},
                {20, true},
                {11, false},
                {21, false},
                {-1, false}
        };
    }

    @Test(dataProvider = "forSpecify",
            description = "Check whether the square of the shape is between MIN and MAX")
    public void testPositive(double squareFromMeasurement, boolean expected) {
        Warehouse.getInstance().put(service.getId(shape),new MeasurementData(squareFromMeasurement,0));
        boolean actual = specification.specify(shape);
        Assert.assertEquals(actual,expected);
    }
}
