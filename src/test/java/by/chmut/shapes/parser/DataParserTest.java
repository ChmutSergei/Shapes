package by.chmut.shapes.parser;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class DataParserTest {

    DataParser parser;

    @BeforeMethod
    public void setUp() {
        parser = new DataParser();
    }

    @AfterMethod
    public void tearDown() {
        parser = null;
    }

    @DataProvider(name = "PositiveProvider")
    public static Object[][] setData() {
        double[] expected1 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0,
                17.0, 18.0, 19.0, 20.0, 21.0, 22.0, 23.0, 24.0};
        double[] expected2 = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        double[] expected3 = {-22.8, -20.0, -21.5, -22.8, 11.0, -21.5, 8.2, 11.0, -21.5, 8.2, -20.0, -21.5,
                -22.8, -20.0, 9.5, -22.8, 11.0, 9.5, 8.2, -15.0, 9.5, 8.2, 6.0, 9.5};
        Object[][] data = new Object[][]{
                {"1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24",expected1},
                {"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0",expected2},
                {"-22.8 -20.0 -21.5 -22.8 11.0 -21.5 8.2 11.0 -21.5 8.2 -20.0 -21.5 -22.8" +
                        " -20.0 9.5 -22.8 11.0 9.5 8.2 -15.0 9.5 8.2 6.0 9.5",expected3}};
        return data;
    }

    @DataProvider(name = "NegativeProvider")
    public static Object[][] setWrongData() {
        Object[][] data = new Object[][]{
                {""},
                {"cs"},
                {"-2/2.8 -20.0 -21.5 -22.8 11.0 -21.5 8.2 11.0 -21.5 8.2 -20.0 -21.5 -22.8"},
                {" -20..0 9.5 -22.8 11.0 9.5 8.2 -15.0 9.5 8.2 6.0 9.5"},
                {"0000.."},
                {"5,5"}};
        return data;
    }

    @Test(dataProvider = "PositiveProvider")
    public void parseTestPositive(String source, double[] expected) {
        double[][] result = parser.parse(Arrays.asList(source));
        double[] actual = result[0];
        Assert.assertEquals(actual,expected);
    }

    @Test(dataProvider = "NegativeProvider")
    public void parseTestNegative(String source) {
        double[][] actual = parser.parse(Arrays.asList(source));
        double[][] expected = new double[0][0];
        Assert.assertEquals(actual,expected);
    }
}
