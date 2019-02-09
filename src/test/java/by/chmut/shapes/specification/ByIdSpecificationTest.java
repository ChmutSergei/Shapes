package by.chmut.shapes.specification;

import by.chmut.shapes.action.Service;
import by.chmut.shapes.action.ServiceFactory;
import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.entity.Shape;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ByIdSpecificationTest {

    private Specification specification;
    private Service service;
    private Shape shape;

    @BeforeMethod
    public void setUp() {
        shape = new Cube();
        service = ServiceFactory.getInstance().getService(shape);
    }

    @AfterMethod
    public void tearDown() {
        shape = null;
        service = null;
    }

    @Test
    public void testPositive() {
        specification = new ByIdSpecification(service.getId(shape));
        boolean actual = specification.specify(shape);
        Assert.assertTrue(actual);
    }

    @Test
    public void testNegative() {
        specification = new ByIdSpecification(-1);
        boolean actual = specification.specify(shape);
        Assert.assertFalse(actual);
    }
}
