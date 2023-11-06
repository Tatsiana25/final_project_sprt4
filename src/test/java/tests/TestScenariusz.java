package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.MainPage;

public class TestScenariusz {

    WebDriver driver;
    String url = "https://qa-scooter.praktikum-services.ru/";


    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void stop() {
        driver.quit();
    }


    @Test
    public void orderTest() {
        driver.get(url);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderUpButton();

    }

}
