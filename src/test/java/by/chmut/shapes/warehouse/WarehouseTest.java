package by.chmut.shapes.warehouse;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WarehouseTest {

    Warehouse warehouse = Warehouse.getInstance();

    @DataProvider(name = "forUpdateDataNotExist")
    public static Object[][] forUpdateDataNotExist() {
        return new Object[][]{
                {1, new MeasurementData()},
                {2, new MeasurementData()}
        };
    }
    @DataProvider(name = "forUpdateDataExist")
    public static Object[][] forUpdateDataExist() {
        return new Object[][]{
                {1, new MeasurementData()},
                {2, new MeasurementData()}
        };
    }

    @Test(priority = 0, dataProvider = "forUpdateDataNotExist")
    public void updateNotExistDataTest(long id, MeasurementData expected) {
        warehouse.updateData(id,expected);
        MeasurementData actual = warehouse.getMeasurements(id);
        Assert.assertEquals(actual,expected);
    }

    @Test(priority = 1, dataProvider = "forUpdateDataExist")
    public void updateExistDataTest(long id, MeasurementData expected) {
        warehouse.updateData(id,expected);
        MeasurementData actual = warehouse.getMeasurements(id);
        Assert.assertEquals(actual,expected);
    }


}

