package hw5.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class AssertionStep extends AbstractStep{
    SoftAssert softAssert;
    public AssertionStep(WebDriver driver, String url) {
        super(driver, url);
        softAssert = new SoftAssert();
    }

    @Step("Шаг 1 : Тестовый сайт открыт")
    public void checkTitle() {
        softAssert.assertNotEquals(driver.getTitle(),"Page not found · GitHub Pages", "1 is wrong");
    }

    @Step("Шаг 2 : Проверка открытия тестового сайта")
    public void titleEquals(String str) {
        softAssert.assertEquals(driver.getTitle(),str, "2 is wrong");
    }

    @Step("Шаг 3 : Авторизация на сайте")
    public void login(String userName) {
        softAssert.assertTrue(!userName.equals(""), "3 is wrong");
    }

    @Step("Шаг 4 : Проверка авторизации")
    public void checkLogin(String actualUserName, String expectedUserName) {
        softAssert.assertEquals(actualUserName, expectedUserName, "4 is wrong");
    }

    @Step("Шаг 5 : Проверка элементов на сайте")
    public void checkElements(ArrayList<Boolean> flags) {
        softAssert.assertTrue(!flags.contains(false), "5 is wrong");
    }

    @Step("Шаг 6 : Проверка картинок на сайте")
    public void checkImages(int actual, int expected) {
        softAssert.assertEquals(actual, expected, "6 is wrong");
    }

    @Step("Шаг 7 : Проверка текстов на сайте")
    public void checkTexts(int actual, int expected) {
        softAssert.assertEquals(actual, expected, "7 is wrong");
    }

    @Step("Шаг 8 : Проверка фрейма на сайте")
    public void checkFrame(boolean flag) {
        softAssert.assertTrue(flag, "8 is wrong");
    }

    @Step("Шаг 9 : Проверка кнопки на фрейме")
    public void checkFrameButton(boolean flag) {
        softAssert.assertTrue(flag, "9 is wrong");
    }
    @Step("Шаг 10 : возвращение к предыдущему окну")
    public void checkReturned() {
        softAssert.assertEquals(driver.getTitle(),"Home Page", "10 is wrong");
    }

    @Step("Шаг 11 : Проверка элементов левого меню")
    public void checkLeftBarElements(ArrayList<Boolean> flags) {
        softAssert.assertTrue(!flags.contains(false), "11 is wrong");
    }

    @Step("Шаг 12 : закрытие браузера")
    public void close() {
        softAssert.assertAll();
        driver.close();
    }
}
