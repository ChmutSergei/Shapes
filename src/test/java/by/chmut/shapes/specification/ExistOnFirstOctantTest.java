package by.chmut.shapes.specification;

import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.entity.Point;
import by.chmut.shapes.entity.Shape;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExistOnFirstOctantTest {

    private Specification specification;
    private Shape shape;

    @BeforeMethod
    public void setUp() {
        shape = new Cube();
        specification = new ExistInFirstOctantSpecification();
    }

    @AfterMethod
    public void tearDown() {
        shape = null;
        specification = null;
    }

    @DataProvider(name = "forSpecify")
    public static Object[][] forSpecify() {
        return new Object[][]{
                {new Point[]{new Point(-21.2, -10.7, -18.3), new Point(-21.2, 54.3, -18.3),
                        new Point(43.8, 54.3, -18.3), new Point(43.8, -10.7, -18.30),
                        new Point(-21.2, -10.7,46.7),new Point(-21.2, 54.3, 46.7),
                        new Point(43.8, 54.3, 46.7), new Point(43.8, -10.7, 46.7)}, false},
                {new Point[]{new Point(0.0, 0.0, 0.0), new Point(0.0, 37.0, 0.0),
                        new Point(37.0, 37.0, 0.0), new Point(37.0, 0, 0),
                        new Point(0, 0,37),new Point(0, 37, 37),
                        new Point(37, 37, 37), new Point(37, 0, 37)}, true}
        };
    }

    @Test(dataProvider = "forSpecify",
            description = "Check condition - if shape exist in the first octant")
    public void specifyTest(Point[] points, boolean expected) {
        ((Cube)shape).setPoints(points);
        boolean actual = specification.specify(shape);
        Assert.assertEquals(actual,expected);
    }


}
