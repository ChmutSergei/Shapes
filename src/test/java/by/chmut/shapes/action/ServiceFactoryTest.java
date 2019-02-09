package by.chmut.shapes.action;

import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.entity.Point;
import by.chmut.shapes.entity.Shape;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ServiceFactoryTest {

    private Shape shape;
    private ServiceFactory factory;

    @BeforeMethod
    public void setUp() {
        shape = new Cube();
        factory = ServiceFactory.getInstance();
    }

    @AfterMethod
    public void tearDown() {
        shape = null;
        factory = null;
    }

    @Test(description = "Expected return object of CubeService.class when transferring the correct Shape object")
    public void getServicePositiveTest() {
        ((Cube)shape).setPoints(new Point[]{new Point(-5.0, -6.0, 15.0), new Point(-5.0, 1.0, 15.0),
                new Point(2.0, 1.0, 15.0), new Point(2.0, -6.0, 15.0),
                new Point(-5.0,-6.0, 22.0),new Point(-5.0, 1.0, 22.0),
                new Point(2.0, 1.0, 22.0), new Point(2.0, -6.0, 22.0)});
        Service service = factory.getService(shape);
        Class actual = service.getClass();
        Class expected = CubeService.class;
        Assert.assertEquals(actual,expected);
    }


    @Test(expectedExceptions = RuntimeException.class,
            description = "Expected RuntimeException when transferring incorrect object")
    public void getServiceNegativeTest() {
        shape = null;
        factory.getService(shape);
    }
}
