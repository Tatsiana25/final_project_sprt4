package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ENTER;

public class RentPage {
    private WebDriver driver;
    private final By header = By.xpath(".//div[text()='Про аренду']");

    // локатор дата
    private final By dateStart = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    private final By numberOfDays = By.cssSelector(".Dropdown-arrow");

    private final By color = By.xpath(".//div[text()='Цвет самоката'");

    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    private final By rentDataSendButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkRentPageShown() {
        return driver.findElements(this.header).size() > 0;
    }


    public void setDateStart(String dateStart) {
        WebElement st = driver.findElement(this.dateStart);
        st.sendKeys(dateStart);
        st.sendKeys(ENTER);
    }

    public void setDateEnd(String numberOfDays) {
        driver.findElement(this.numberOfDays).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-option' and text()='" + numberOfDays + "']")).click();
    }

    public void setColor(String color) {//driver.findElement(this.color).sendKeys(color);
        driver.findElement(By.cssSelector("#" + color)).click();
    }

    public void setComment(String comment) {
        driver.findElement(this.comment).sendKeys(comment);
    }

    public void fillRentForm(String dateStart, String numberOfDays, String color, String comment) {
        setDateStart(dateStart);
        setDateEnd(numberOfDays);
        setColor(color);
        setComment(comment);

    }

    public void rentDataSendButtonClick() {
        driver.findElement(rentDataSendButton).click();

    }
}