package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmPage {

    private WebDriver driver;
    private final By confirmButton = By.xpath(".//button[text()='Да']");
    private final By header = By.xpath(".//div[text()='Заказ оформлен']");

    public ConfirmPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    public boolean checkOrderFinished() {
        return driver.findElements(this.header).size() > 0;
    }
}
