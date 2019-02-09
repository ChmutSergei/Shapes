package by.chmut.shapes.reader;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;

public class DataReaderTest {
    private DataReader reader;
    private String pathFile;

    @BeforeMethod
    public void setUp() {
        reader = new DataReader();
        pathFile = "/readerTest.txt";
    }

    @AfterMethod
    public void tearDown() {
        reader = null;
        pathFile = null;
    }

    @Test(description = "Read 3 String lines from correct file: expected List with 3 String line")
    public void pathTestPositive() {
        List<String> actual = reader.read(pathFile);
        List<String> expected = Arrays.asList("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24",
                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0","cs");
        Assert.assertEquals(actual,expected);
    }


    @Parameters ({"WrongName"})
    @Test(expectedExceptions = RuntimeException.class,
            description = "Attempt to read data without a file: expected RuntimeException")
    public void pathTestNegative(@Optional String pathFile) {
        reader.read(pathFile);
    }

}
