package by.chmut.shapes.util;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IdGeneratorTest {
    private long startId;

    @BeforeMethod
    public void setUp() {
        startId = IdGenerator.getId();
    }

    @AfterMethod
    public void tearDown() {
        startId = 0;
    }

    @Test(priority = 1, description = "Expected return next id")
    public void getIdTest() {
        long actual = IdGenerator.getId();
        long expected = startId + 1;
        Assert.assertEquals(actual,expected);
    }

    @Test(priority = 2, description = "Expected return id after 500_000 iteration")
    public void getIdTest_500_000() {
        for(int i = 0; i<500_000;i++) {
            IdGenerator.getId();
        }
        long actual = IdGenerator.getId();
        long expected = startId + 500_001;
        Assert.assertEquals(actual,expected);
    }

    @Test(priority = 3, description = "Expected return id after overflow: 1_000_000 iteration")
    public void getIdTest_500_001() {
        for(int i = 0; i<500_000;i++) {
            IdGenerator.getId();
        }
        long actual = IdGenerator.getId();
        long expected = startId + 500_001 - 990_000;
        Assert.assertEquals(actual,expected);
    }
}
