package by.chmut.shapes.creator;

import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.exception.DataException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CubeCreatorTest {

    private CubeCreator creator;

    @BeforeMethod
    public void setUp() {
        creator = new CubeCreator();
    }

    @AfterMethod
    public void tearDown() {
        creator = null;
    }

    @DataProvider(name = "forCreateCubePositive")
    public static Object[][] forCreateCubePositive() {
        double[] numbers1 = {-21.2, -10.7, -18.3, -21.2, 54.3, -18.3, 43.8, 54.3, -18.3, 43.8, -10.7, -18.3, -21.2, -10.7,
                46.7, -21.2, 54.3, 46.7, 43.8, 54.3, 46.7, 43.8, -10.7, 46.7};
        double[] numbers2 = {-5.0, -6.0, 15.0, -5.0, 1.0, 15.0, 2.0, 1.0, 15.0, 2.0, -6.0, 15.0, -5.0,
                -6.0, 22.0, -5.0, 1.0, 22.0, 2.0, 1.0, 22.0, 2.0, -6.0, 22.0};
        double[] numbers3 = {0.0, 0.0, 0.0, 0.0, 37.0, 0.0, 37.0, 37.0, 0.0, 37.0, 0, 0, 0, 0,
                37, 0, 37, 37, 37, 37, 37, 37, 0, 37};
        Object[][] data = new Object[][]{
                {numbers1, Cube.class},
                {numbers2, Cube.class},
                {numbers3, Cube.class}};
        return data;
    }

    @DataProvider(name = "forCreateCubeNegative")
    public static Object[][] forCreateCubeNegative() {
        double[] numbers1 = {0, -10.7, -18.3, -21.2, 54.3, -18.3, 43.8, 54.3, -18.3, 43.8, -10.7, -18.3, -21.2, -10.7,
                46.7, -21.2, 54.3, 46.7, 43.8, 54.3, 46.7, 43.8, -10.7, 46.7};
        double[] numbers2 = {0, -6.0, 15.0, -5.0, 1.0, 15.0, 2.0, 1.0, 15.0, 2.0, -6.0, 15.0, -5.0,
                -6.0, 22.0, -5.0, 1.0, 22.0, 2.0, 1.0, 22.0, 2.0, -6.0, 22.0};
        double[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
        double[] numbers4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        double[] numbers5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        double[] numbers6 = {1};
        double[] numbers7 = {};
        Object[][] data = new Object[][]{
                {numbers1},
                {numbers2},
                {numbers3},
                {numbers3},
                {numbers4},
                {numbers5},
                {numbers6},
                {numbers7}};
        return data;
    }

    @Test(dataProvider = "forCreateCubePositive",
            description = "Create Cube object on source data")
    public void createPositiveTest(double[] numbers, Class expected) throws DataException {
        Cube cube = creator.create(numbers);
        Class actual = cube.getClass();
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "forCreateCubeNegative", expectedExceptions = DataException.class,
            description = "Expected Exception when attempt create Cube with invalid Data")
    public void createNegativeTest(double[] numbers) throws DataException {
        Cube cube = creator.create(numbers);
    }
}
