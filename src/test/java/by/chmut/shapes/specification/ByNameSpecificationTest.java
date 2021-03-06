package by.chmut.shapes.specification;

import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.entity.Shape;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ByNameSpecificationTest {

    private Specification specification;
    private Shape shape;

    @BeforeMethod
    public void setUp() {
        shape = new Cube();
    }

    @AfterMethod
    public void tearDown() {
        shape = null;
    }

    @Test
    public void testPositive() {
        specification = new ByNameSpecification("Cube");
        boolean actual = specification.specify(shape);
        Assert.assertTrue(actual);
    }

    @Test
    public void testNegative() {
        specification = new ByNameSpecification("SomeAnotherShape");
        boolean actual = specification.specify(shape);
        Assert.assertFalse(actual);
    }


}
