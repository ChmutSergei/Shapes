package by.chmut.shapes.observer;

import by.chmut.shapes.entity.Cube;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShapeObserverTest {

    ShapeEvent event;

    @BeforeMethod
    public void setUp() {

    }

    @AfterMethod
    public void tearDown() {

    }

    @DataProvider(name = "forHandleEvent")
    public static Object[][] forHandleEvent() {
        double[] numbers1 = {0, -10.7, -18.3, -21.2, 54.3, -18.3, 43.8, 54.3, -18.3, 43.8, -10.7, -18.3, -21.2, -10.7,
                46.7, -21.2, 54.3, 46.7, 43.8, 54.3, 46.7, 43.8, -10.7, 46.7};
        double[] numbers2 = {0, -6.0, 15.0, -5.0, 1.0, 15.0, 2.0, 1.0, 15.0, 2.0, -6.0, 15.0, -5.0,
                -6.0, 22.0, -5.0, 1.0, 22.0, 2.0, 1.0, 22.0, 2.0, -6.0, 22.0};
        Object[][] data = new Object[][]{
                {numbers1, Cube.class},
                {numbers2, Cube.class}};
        return data;
    }

    @Test
    public void handleEvenTest() {

    }
}
