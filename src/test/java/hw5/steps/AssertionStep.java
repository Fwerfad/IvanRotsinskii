package hw5.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class AssertionStep extends AbstractStep{
    public AssertionStep(WebDriver driver, String url) {
        super(driver, url);
    }

    @Step("Шаг 1 : Тестовый сайт открыт")
    public void checkTitle() {
        Assert.assertNotEquals(driver.getTitle(),"Page not found · GitHub Pages", "1 is wrong");
    }

    @Step("Шаг 2 : Проверка открытия тестового сайта")
    public void titleEquals(String str) {
        Assert.assertEquals(driver.getTitle(),str, "2 is wrong");
    }

    @Step("Шаг 3 : Авторизация на сайте")
    public void login(String userName) {
        Assert.assertTrue(!userName.equals(""), "3 is wrong");
    }

    @Step("Шаг 4 : Проверка авторизации")
    public void checkLogin(String actualUserName, String expectedUserName) {
        Assert.assertEquals(actualUserName, expectedUserName, "4 is wrong");
    }

    @Step("Шаг 5 : Проверка элементов на сайте")
    public void checkElements(ArrayList<Boolean> flags) {
        Assert.assertTrue(!flags.contains(false), "5 is wrong");
    }

    @Step("Шаг 6 : Проверка картинок на сайте")
    public void checkImages(int actual, int expected) {
        Assert.assertEquals(actual, expected, "6 is wrong");
    }

    @Step("Шаг 7 : Проверка текстов на сайте")
    public void checkTexts(int actual, int expected) {
        Assert.assertEquals(actual, expected, "7 is wrong");
    }

    @Step("Шаг 8 : Проверка фрейма на сайте")
    public void checkFrame(boolean flag) {
        Assert.assertTrue(flag, "8 is wrong");
    }

    @Step("Шаг 9 : Проверка кнопки на фрейме")
    public void checkFrameButton(boolean flag) {
        Assert.assertTrue(flag, "9 is wrong");
    }
    @Step("Шаг 10 : возвращение к предыдущему окну")
    public void checkReturned() {
        Assert.assertEquals(driver.getTitle(),"Home Page", "10 is wrong");
    }

    @Step("Шаг 11 : Проверка элементов левого меню")
    public void checkLeftBarElements(ArrayList<Boolean> flags) {
        Assert.assertTrue(!flags.contains(false), "11 is wrong");
    }

    @Step("Шаг 12 : закрытие браузера")
    public void close() {
        driver.close();
    }

    @Step("Шаг 5 : Переход на страницу с элементами")
    public void checkDifferentElementPage(String str) {
        Assert.assertEquals(driver.getTitle(), str);
    }

    @Step("Шаг 6 : Перекоючить чекбоксы")
    public void switchCheckboxes(ArrayList<Boolean> flags) {
        Assert.assertTrue(!flags.contains(false), "6 is wrong");
    }

    @Step("Шаг 7 : Переключить радио-кнопку")
    public void selectRadio(boolean flag) {
        Assert.assertTrue(flag, "7 is wrong");
    }

    @Step("Шаг 8 : Выбрать предмет в выпадающем списке")
    public void selectInDropdown(boolean flag) {
        Assert.assertTrue(flag, "8 is wrong");
    }

    @Step("Шаг 9 : Проверка логов")
    public void checkLogs(ArrayList<Boolean> flags) {
        Assert.assertTrue(!flags.contains(false), "9 is wrong");
    }

    @Step("Шаг: Специально роняем тест")
    public void fakeAssert() {
        Assert.assertTrue(false);
    }
}
