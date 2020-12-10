package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubtractTest {
    private Calculator calculator;
    @DataProvider(name="subtraction")
    public Object[][] TestData() {
        return new Double[][] {
                new Double[] {25.0, 2.0, 23.0},
                new Double[] {50.0, 25.0, 25.0}
        };
    }
    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
    }
    @Test(dataProvider = "subtraction")
    public void subtractTest(double first, double second, double result) {
        Assert.assertEquals(calculator.sub(first, second), result);
    }
    @AfterClass
    public void tearDown() {
        calculator = null;
    }
}
