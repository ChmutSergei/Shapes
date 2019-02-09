package by.chmut.shapes.observer;

import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.entity.Point;
import by.chmut.shapes.warehouse.Warehouse;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShapeObserverTest {

    ShapeObserver observer;

    @BeforeMethod
    public void setUp() {
        observer = new ShapeObserver();
    }

    @AfterMethod
    public void tearDown() {
        observer = null;
    }

    @DataProvider(name = "forHandleEvent")
    public static Object[][] forHandleEvent() {
        Point[] points1 = {new Point(-21.2, -10.7, -18.3), new Point(-21.2, 54.3, -18.3),
                new Point(43.8, 54.3, -18.3), new Point(43.8, -10.7, -18.30),
                new Point(-21.2, -10.7,46.7),new Point(-21.2, 54.3, 46.7),
                new Point(43.8, 54.3, 46.7), new Point(43.8, -10.7, 46.7)};
        Point[] points2 = {new Point(-5.0, -6.0, 15.0), new Point(-5.0, 1.0, 15.0),
                new Point(2.0, 1.0, 15.0), new Point(2.0, -6.0, 15.0),
                new Point(-5.0,-6.0, 22.0),new Point(-5.0, 1.0, 22.0),
                new Point(2.0, 1.0, 22.0), new Point(2.0, -6.0, 22.0)};
        Object[][] data = new Object[][]{
                {points1, 25350},
                {points2, 294}};
        return data;
    }

    @Test(dataProvider = "forHandleEvent")
    public void handleEvenTest(Point[] points, double expected) {
        Cube cube = new Cube();
        cube.setObserver(observer);
        cube.setPoints(points);
        double actual = Warehouse.getInstance().getMeasurements(cube.getId()).getSquare();
        Assert.assertEquals(actual,expected);
    }
}
