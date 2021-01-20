package hw5.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ActionStep extends AbstractStep{
    private String password;
    private String login;

    public ActionStep(WebDriver driver, String url) {
        super(driver, url);
        driver.manage().window().maximize();
    }

    @Step("Чтение пароля и логина из файла")
    public void getCredos(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        login = scanner.next();
        password = scanner.next();
        scanner.close();
    }

    //@Step("Авторизация на сайте")
    public String login() {
        homePage.login(login, password);
        return homePage.getUserName();
    }

    //@Step("Проверка элементов на сайте")
    public ArrayList<Boolean> checkElements() {
        return homePage.checkNavbarElementsNames(new ArrayList<>(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS")));
    }

    public int getNumberOfBenefitIcons() {
        return homePage.getNumberOfBenefitIcons();
    }

    public int getNumberOfBenefitTexts() {
        return homePage.getNumberOfBenefitTexts();
    }

    public boolean checkFrame() {
        return homePage.checkIsFrameDisplayed();
    }

    public boolean checkFrameButton() {
        return homePage.checkIsFrameButtonIsDisplayed();
    }

    public ArrayList<Boolean> checkSideBarElements(ArrayList<String> elements) {
        return homePage.checkSideBarElements(elements);
    }
}
