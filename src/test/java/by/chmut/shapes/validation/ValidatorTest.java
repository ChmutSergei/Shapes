package by.chmut.shapes.validation;

import by.chmut.shapes.entity.Point;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidatorTest {

    @DataProvider(name = "forIsCorrectCube")
    public static Object[][] forIsCorrectCube() {
        Point[] points1 = {new Point(-21.2, -10.7, -18.3), new Point(-21.2, 54.3, -18.3),
                new Point(43.8, 54.3, -18.3), new Point(43.8, -10.7, -18.30),
                new Point(-21.2, -10.7,46.7),new Point(-21.2, 54.3, 46.7),
                new Point(43.8, 54.3, 46.7), new Point(43.8, -10.7, 46.7)};
        Point[] points2 = {new Point(-5.0, -6.0, 15.0), new Point(-5.0, 1.0, 15.0),
                new Point(2.0, 1.0, 15.0), new Point(2.0, -6.0, 15.0),
                new Point(-5.0,-6.0, 22.0),new Point(-5.0, 1.0, 22.0),
                new Point(2.0, 1.0, 22.0), new Point(2.0, -6.0, 22.0)};
        Point[] points3 = {};
        Point[] points4 = {new Point(1,2,3)};
        Point[] points5 = {new Point(1,2,3), new Point(4,5,6),
                new Point(2.0, 1.0, 15.0), new Point(2.0, -6.0, 15.0),
                new Point(-5.0,-6.0, 22.0),new Point(-5.0, 1.0, 22.0),
                new Point(2.0, 1.0, 22.0), new Point(2.0, -6.0, 22.0)};
        Point[] points6 = {new Point(1,2,3), new Point(4,5,6),
                new Point(2.0, 1.0, 15.0), new Point(2.0, -6.0, 15.0),
                new Point(-5.0,-6.0, 22.0),new Point(-5.0, 1.0, 22.0),
                new Point(2.0, 1.0, 22.0), new Point(2.0, -6.0, 22.0), new Point(0,0,0)};
        Object[][] data = new Object[][]{
                {points1,true},
                {points2,true},
                {points3,false},
                {points4,false},
                {points5,false},
                {points6,false},
        };
        return data;
    }

    @Test(description = "Validate some arrays of points on the possibility of creating a correct cube ",
            dataProvider = "forIsCorrectCube")
    public void isCorrectCubeTest(Point[] points, boolean expected) {
        boolean actual = Validator.isCorrectCube(points);
        Assert.assertEquals(actual,expected);
    }
}
