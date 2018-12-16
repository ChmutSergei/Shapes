package by.chmut.shapes.util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IdGeneratorTest {

    @Test(priority = 1, description = "Expected return first id = 10_000")
    public void getIdTest() {
        long actual = IdGenerator.getId();
        long expected = 10_000;
        Assert.assertEquals(actual,expected);
    }

    @Test(priority = 2, description = "Expected return id = 510_001 after 500_000 iteration")
    public void getIdTest_500_000() {
        for(int i = 0; i<500_000;i++) {
            IdGenerator.getId();
        }
        long actual = IdGenerator.getId();
        long expected = 510_001;
        Assert.assertEquals(actual,expected);
    }

    @Test(priority = 3, description = "Expected return id = 20_002 after overflow: 1_010_002 iteration")
    public void getIdTest_500_001() {
        for(int i = 0; i<500_000;i++) {
            IdGenerator.getId();
        }
        long actual = IdGenerator.getId();
        long expected = 20_002;
        Assert.assertEquals(actual,expected);
    }
}
