package by.chmut.shapes.action;


import by.chmut.shapes.creator.CubeCreator;
import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.exception.DataException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculateTest {

    private CubeCreator creator;
    private CubeService service;

    @BeforeMethod
    public void setUp() {
        creator = new CubeCreator();
        service = new CubeService();
    }

    @AfterMethod
    public void tearDown() {
        creator = null;
        service = null;
    }

    @DataProvider(name = "forCalculateSquare")
    public static Object[][] forCalculateSquare() {
        double[] numbers1 = {-21.2, -10.7, -18.3, -21.2, 54.3, -18.3, 43.8, 54.3, -18.3, 43.8, -10.7, -18.3, -21.2, -10.7,
                46.7, -21.2, 54.3, 46.7, 43.8, 54.3, 46.7, 43.8, -10.7, 46.7};
        double[] numbers2 = {-5.0, -6.0, 15.0, -5.0, 1.0, 15.0, 2.0, 1.0, 15.0, 2.0, -6.0, 15.0, -5.0,
                -6.0, 22.0, -5.0, 1.0, 22.0, 2.0, 1.0, 22.0, 2.0, -6.0, 22.0};
        double[] numbers3 = {0.0, 0.0, 0.0, 0.0, 37.0, 0.0, 37.0, 37.0, 0.0, 37.0, 0, 0, 0, 0,
                37, 0, 37, 37, 37, 37, 37, 37, 0, 37};
        Object[][] data = new Object[][]{
                {numbers1,25350},
                {numbers2,294},
                {numbers3,8214}};
        return data;
    }

    @DataProvider(name = "forCalculateVolume")
    public static Object[][] forCalculateVolume() {
        double[] numbers1 = {-21.2, -10.7, -18.3, -21.2, 54.3, -18.3, 43.8, 54.3, -18.3, 43.8, -10.7, -18.3, -21.2, -10.7,
                46.7, -21.2, 54.3, 46.7, 43.8, 54.3, 46.7, 43.8, -10.7, 46.7};
        double[] numbers2 = {-5.0, -6.0, 15.0, -5.0, 1.0, 15.0, 2.0, 1.0, 15.0, 2.0, -6.0, 15.0, -5.0,
                -6.0, 22.0, -5.0, 1.0, 22.0, 2.0, 1.0, 22.0, 2.0, -6.0, 22.0};
        double[] numbers3 = {0.0, 0.0, 0.0, 0.0, 37.0, 0.0, 37.0, 37.0, 0.0, 37.0, 0, 0, 0, 0,
                37, 0, 37, 37, 37, 37, 37, 37, 0, 37};
        Object[][] data = new Object[][]{
                {numbers1,274625},
                {numbers2,343},
                {numbers3,50653}};
        return data;
    }
    @DataProvider(name = "forCalculateRatio")
    public static Object[][] forCalculateRatio() {
        double[] numbers1 = {-21.2, -10.7, -18.3, -21.2, 54.3, -18.3, 43.8, 54.3, -18.3, 43.8, -10.7, -18.3, -21.2, -10.7,
                46.7, -21.2, 54.3, 46.7, 43.8, 54.3, 46.7, 43.8, -10.7, 46.7};
        double[] numbers2 = {-5.0, -6.0, 15.0, -5.0, 1.0, 15.0, 2.0, 1.0, 15.0, 2.0, -6.0, 15.0, -5.0,
                -6.0, 22.0, -5.0, 1.0, 22.0, 2.0, 1.0, 22.0, 2.0, -6.0, 22.0};
        double[] numbers3 = {0.0, 0.0, 0.0, 0.0, 37.0, 0.0, 37.0, 37.0, 0.0, 37.0, 0, 0, 0, 0,
                37, 0, 37, 37, 37, 37, 37, 37, 0, 37};
        Object[][] data = new Object[][]{
                {numbers1,0.48401},
                {numbers2,0.4},
                {numbers3,0}};
        return data;
    }

    @Test(dataProvider = "forCalculateSquare",
            description = "Calculation square for many different object")
    public void getSquareTest(double[] numbers, double expected) throws DataException {
        Cube cube = creator.create(numbers);
        double actual = service.getSquare(cube);
        Assert.assertEquals(actual,expected);
    }

    @Test(dataProvider = "forCalculateVolume",
            description = "Calculation volume for many different object")
    public void getVolumeTest(double[] numbers, double expected) throws DataException {
        Cube cube = creator.create(numbers);
        double actual = service.getVolume(cube);
        Assert.assertEquals(actual,expected);
    }

    @Test(dataProvider = "forCalculateRatio",
            description = "Calculation ratio with cartesian plane for many different object")
    public void getRatioWithCartesianPlaneTest(double[] numbers, double expected) throws DataException {
        Cube cube = creator.create(numbers);
        double actual = service.getRatioWithCartesianPlane(cube);
        Assert.assertEquals(actual,expected, 0.00001);
    }
}
