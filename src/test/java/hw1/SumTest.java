package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest {
    private Calculator calculator;
    @DataProvider(name="sum")
    public Object[][] TestData() {
        return new Double[][] {
                new Double[] {25.0, 2.0, 27.0},
                new Double[] {50.0, 25.0, 75.0}
        };
    }
    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
    }
    @Test(dataProvider = "sum")
    public void sumTest(double first, double second, double result) {
        Assert.assertEquals(calculator.sum(first, second), result);
    }
    @AfterClass
    public void tearDown() {
        calculator = null;
    }
}
