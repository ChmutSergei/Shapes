package by.chmut.shapes.action;

import by.chmut.shapes.creator.CubeCreator;
import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.exception.DataException;
import org.testng.Assert;
import org.testng.annotations.*;

public class CubeServiceTest {

    private CubeService cubeService;
    private CubeCreator creator;

    @BeforeMethod
    public void setUp() {
        cubeService = new CubeService();
        creator = new CubeCreator();
    }

    @AfterMethod
    public void tearDown() {
        cubeService = null;
        creator = null;
    }

    @Test(description = "Expected valid square for correct cube")
    public void getSquareTest() throws DataException {
        Cube cube = creator.create(new double[]{-21.2, -10.7, -18.3, -21.2, 54.3, -18.3, 43.8, 54.3, -18.3, 43.8,
                -10.7, -18.3, -21.2, -10.7, 46.7, -21.2, 54.3, 46.7, 43.8, 54.3, 46.7, 43.8, -10.7, 46.7});
        double actual = cubeService.getSquare(cube);
        double expected = 25350;
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Expected valid volume for correct cube")
    public void getVolumeTest() throws DataException {
        Cube cube = creator.create(new double[]{-5.0, -6.0, 15.0, -5.0, 1.0, 15.0, 2.0, 1.0, 15.0, 2.0, -6.0, 15.0, -5.0,
                -6.0, 22.0, -5.0, 1.0, 22.0, 2.0, 1.0, 22.0, 2.0, -6.0, 22.0});
        double actual = cubeService.getVolume(cube);
        double expected = 343;
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Expected valid ratio with cartesian plane for correct cube")
    public void getRatioWithCartesianPlaneTest() throws DataException {
        Cube cube = creator.create(new double[]{-5.0, -6.0, 15.0, -5.0, 1.0, 15.0, 2.0, 1.0, 15.0, 2.0, -6.0, 15.0, -5.0,
                -6.0, 22.0, -5.0, 1.0, 22.0, 2.0, 1.0, 22.0, 2.0, -6.0, 22.0});
        double actual = cubeService.getRatioWithCartesianPlane(cube);
        double expected = 0.4;
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Expected true for cube on cartesian plane")
    public void isOnCartesianPlaneTest() throws DataException {
        Cube cube = creator.create(new double[]{0.0, 0.0, 0.0, 0.0, 37.0, 0.0, 37.0, 37.0, 0.0, 37.0, 0, 0, 0, 0,
                37, 0, 37, 37, 37, 37, 37, 37, 0, 37});
        boolean actual = cubeService.isOnCartesianPlane(cube);
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Expected true for correct shape - cube")
    public void isShapeTest() throws DataException {
        Cube cube = creator.create(new double[]{0.0, 0.0, 0.0, 0.0, 37.0, 0.0, 37.0, 37.0, 0.0, 37.0, 0, 0, 0, 0,
                37, 0, 37, 37, 37, 37, 37, 37, 0, 37});
        boolean actual = cubeService.isShape(cube, "cube");
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }

}
