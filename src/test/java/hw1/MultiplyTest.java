package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplyTest {
    private Calculator calculator;
    @DataProvider(name="multiplication")
    public Object[][] TestData() {
        return new Double[][] {
                new Double[] {25.0, 2.0, 50.0},
                new Double[] {50.0, 2.0, 100.0}
        };
    }
    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
    }
    @Test(dataProvider = "multiplication")
    public void multiplyDoubleTest(double first, double second, double result) {
        Assert.assertEquals(calculator.mult(first, second), result);
    }
    @AfterClass
    public void tearDown() {
        calculator = null;
    }
}
