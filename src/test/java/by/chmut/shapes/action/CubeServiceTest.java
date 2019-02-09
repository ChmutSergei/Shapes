package by.chmut.shapes.action;

import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.entity.Point;
import by.chmut.shapes.exception.DataException;
import org.testng.Assert;
import org.testng.annotations.*;

public class CubeServiceTest {

    private CubeService service;

    @BeforeMethod
    public void setUp() {
        service = new CubeService();
    }

    @AfterMethod
    public void tearDown() {
        service = null;
    }

    @DataProvider(name = "forCalculateSquare")
    public static Object[][] forCalculateSquare() {
        Point[] points1 = {new Point(-21.2, -10.7, -18.3), new Point(-21.2, 54.3, -18.3),
                new Point(43.8, 54.3, -18.3), new Point(43.8, -10.7, -18.30),
                new Point(-21.2, -10.7,46.7),new Point(-21.2, 54.3, 46.7),
                new Point(43.8, 54.3, 46.7), new Point(43.8, -10.7, 46.7)};
        Point[] points2 = {new Point(-5.0, -6.0, 15.0), new Point(-5.0, 1.0, 15.0),
                new Point(2.0, 1.0, 15.0), new Point(2.0, -6.0, 15.0),
                new Point(-5.0,-6.0, 22.0),new Point(-5.0, 1.0, 22.0),
                new Point(2.0, 1.0, 22.0), new Point(2.0, -6.0, 22.0)};
        Point[] points3 = {new Point(0.0, 0.0, 0.0), new Point(0.0, 37.0, 0.0),
                new Point(37.0, 37.0, 0.0), new Point(37.0, 0, 0),
                new Point(0, 0,37),new Point(0, 37, 37),
                new Point(37, 37, 37), new Point(37, 0, 37)};
        Object[][] data = new Object[][]{
                {points1,25350},
                {points2,294},
                {points3,8214}};
        return data;
    }

    @DataProvider(name = "forCalculateVolume")
    public static Object[][] forCalculateVolume() {
        Point[] points1 = {new Point(-21.2, -10.7, -18.3), new Point(-21.2, 54.3, -18.3),
                new Point(43.8, 54.3, -18.3), new Point(43.8, -10.7, -18.30),
                new Point(-21.2, -10.7,46.7),new Point(-21.2, 54.3, 46.7),
                new Point(43.8, 54.3, 46.7), new Point(43.8, -10.7, 46.7)};
        Point[] points2 = {new Point(-5.0, -6.0, 15.0), new Point(-5.0, 1.0, 15.0),
                new Point(2.0, 1.0, 15.0), new Point(2.0, -6.0, 15.0),
                new Point(-5.0,-6.0, 22.0),new Point(-5.0, 1.0, 22.0),
                new Point(2.0, 1.0, 22.0), new Point(2.0, -6.0, 22.0)};
        Point[] points3 = {new Point(0.0, 0.0, 0.0), new Point(0.0, 37.0, 0.0),
                new Point(37.0, 37.0, 0.0), new Point(37.0, 0, 0),
                new Point(0, 0,37),new Point(0, 37, 37),
                new Point(37, 37, 37), new Point(37, 0, 37)};
        Object[][] data = new Object[][]{
                {points1,274625},
                {points2,343},
                {points3,50653}};
        return data;
    }
    @DataProvider(name = "forCalculateRatio")
    public static Object[][] forCalculateRatio() {
        Point[] points1 = {new Point(-21.2, -10.7, -18.3), new Point(-21.2, 54.3, -18.3),
                new Point(43.8, 54.3, -18.3), new Point(43.8, -10.7, -18.30),
                new Point(-21.2, -10.7,46.7),new Point(-21.2, 54.3, 46.7),
                new Point(43.8, 54.3, 46.7), new Point(43.8, -10.7, 46.7)};
        Point[] points2 = {new Point(-5.0, -6.0, 15.0), new Point(-5.0, 1.0, 15.0),
                new Point(2.0, 1.0, 15.0), new Point(2.0, -6.0, 15.0),
                new Point(-5.0,-6.0, 22.0),new Point(-5.0, 1.0, 22.0),
                new Point(2.0, 1.0, 22.0), new Point(2.0, -6.0, 22.0)};
        Point[] points3 = {new Point(0.0, 0.0, 0.0), new Point(0.0, 37.0, 0.0),
                new Point(37.0, 37.0, 0.0), new Point(37.0, 0, 0),
                new Point(0, 0,37),new Point(0, 37, 37),
                new Point(37, 37, 37), new Point(37, 0, 37)};
        Object[][] data = new Object[][]{
                {points1,0.48401},
                {points2,0.4},
                {points3,0}};
        return data;
    }

    @DataProvider(name = "forCheckOnCartesianPlane")
    public static Object[][] forCheckOnCartesianPlane() {
        Point[] points1 = {new Point(-21.2, -10.7, -18.3), new Point(-21.2, 54.3, -18.3),
                new Point(43.8, 54.3, -18.3), new Point(43.8, -10.7, -18.30),
                new Point(-21.2, -10.7,46.7),new Point(-21.2, 54.3, 46.7),
                new Point(43.8, 54.3, 46.7), new Point(43.8, -10.7, 46.7)};
        Point[] points2 = {new Point(-5.0, -6.0, 15.0), new Point(-5.0, 1.0, 15.0),
                new Point(2.0, 1.0, 15.0), new Point(2.0, -6.0, 15.0),
                new Point(-5.0,-6.0, 22.0),new Point(-5.0, 1.0, 22.0),
                new Point(2.0, 1.0, 22.0), new Point(2.0, -6.0, 22.0)};
        Point[] points3 = {new Point(0.0, 0.0, 0.0), new Point(0.0, 37.0, 0.0),
                new Point(37.0, 37.0, 0.0), new Point(37.0, 0, 0),
                new Point(0, 0,37),new Point(0, 37, 37),
                new Point(37, 37, 37), new Point(37, 0, 37)};
        Object[][] data = new Object[][]{
                {points1,false},
                {points2,false},
                {points3,true}};
        return data;
    }

    @Test(dataProvider = "forCalculateSquare",
            description = "Calculation square for many different object")
    public void getSquareTest(Point[] points, double expected) throws DataException {
        Cube cube = new Cube();
        cube.setPoints(points);
        double actual = service.calculateSquare(cube);
        Assert.assertEquals(actual,expected);
    }

    @Test(dataProvider = "forCalculateVolume",
            description = "Calculation volume for many different object")
    public void getVolumeTest(Point[] points, double expected) throws DataException {
        Cube cube = new Cube();
        cube.setPoints(points);
        double actual = service.calculateVolume(cube);
        Assert.assertEquals(actual,expected);
    }

    @Test(dataProvider = "forCalculateRatio",
            description = "Calculation ratio with cartesian plane for many different object")
    public void getRatioWithCartesianPlaneTest(Point[] points, double expected) throws DataException {
        Cube cube = new Cube();
        cube.setPoints(points);
        double actual = service.calculateRatioWithCartesianPlane(cube);
        Assert.assertEquals(actual,expected, 0.00001);
    }

    @Test(dataProvider = "forCheckOnCartesianPlane",
            description = "Check is cube on cartesian plane for many different object")
    public void isOnCartesianPlaneTest(Point[] points, boolean expected) throws DataException {
        Cube cube = new Cube();
        cube.setPoints(points);
        boolean actual = service.isOnCartesianPlane(cube);
        Assert.assertEquals(actual,expected);
    }

    @Test(description = "Expected true for correct shape - cube")
    public void isShapeTest() throws DataException {
        Cube cube = new Cube();
        cube.setPoints(new Point[]{new Point(0.0, 0.0, 0.0), new Point(0.0, 37.0, 0.0),
                new Point(37.0, 37.0, 0.0), new Point(37.0, 0, 0),
                new Point(0, 0,37),new Point(0, 37, 37),
                new Point(37, 37, 37), new Point(37, 0, 37)});
        boolean actual = service.isShape(cube, "cube");
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }

}
