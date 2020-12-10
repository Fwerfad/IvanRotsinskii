package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivTest {
    private Calculator calculator;
    @DataProvider(name="division")
    public Object[][] TestData() {
        return new Double[][] {
                new Double[] {25.0, 2.0, 12.5},
                new Double[] {50.0, 25.0, 2.0}
        };
    }
    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "division")
    public void divTest(double first, double second, double result) {
        Assert.assertEquals(calculator.div(first, second), result);
    }
    @AfterClass
    public void tearDown() {
        calculator = null;
    }
}
