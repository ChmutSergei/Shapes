package by.chmut.shapes.action;

import by.chmut.shapes.creator.CubeCreator;
import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.exception.DataException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckCubeTest {
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

    @DataProvider(name = "forCheckOnCartesianPlane")
    public static Object[][] forCheckOnCartesianPlane() {
        double[] numbers1 = {-21.2, -10.7, -18.3, -21.2, 54.3, -18.3, 43.8, 54.3, -18.3, 43.8, -10.7, -18.3, -21.2, -10.7,
                46.7, -21.2, 54.3, 46.7, 43.8, 54.3, 46.7, 43.8, -10.7, 46.7};
        double[] numbers2 = {-5.0, -6.0, 15.0, -5.0, 1.0, 15.0, 2.0, 1.0, 15.0, 2.0, -6.0, 15.0, -5.0,
                -6.0, 22.0, -5.0, 1.0, 22.0, 2.0, 1.0, 22.0, 2.0, -6.0, 22.0};
        double[] numbers3 = {0.0, 0.0, 0.0, 0.0, 37.0, 0.0, 37.0, 37.0, 0.0, 37.0, 0, 0, 0, 0,
                37, 0, 37, 37, 37, 37, 37, 37, 0, 37};
        Object[][] data = new Object[][]{
                {numbers1,false},
                {numbers2,false},
                {numbers3,true}};
        return data;
    }

    @Test(dataProvider = "forCheckOnCartesianPlane",
            description = "Check is cube on cartesian plane for many different object")
    public void isOnCartesianPlaneTest(double[] numbers, boolean expected) throws DataException {
        Cube cube = creator.create(numbers);
        boolean actual = service.isOnCartesianPlane(cube);
        Assert.assertEquals(actual,expected);
    }

}
