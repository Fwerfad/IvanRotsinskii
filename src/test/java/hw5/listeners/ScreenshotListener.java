package hw5.listeners;

import hw5.utils.AttachmentUtils;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("EEE: onTestFailure.enter " + result.getName());
        Object driver = result.getTestContext().getAttribute("driver");
        if (driver != null) {
            AttachmentUtils.makeStringAttachment(Arrays.asList("test context contains driver:", driver.toString()));
            // in the same way WebDriver can be cast to Screenshot taker
            // ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            attachScreenShot((WebDriver) driver);
        }
        System.out.println("EEE: onTestFailure.exit");
    }

    @Attachment(type = "image/png", fileExtension = "png")
    private byte[] attachScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

