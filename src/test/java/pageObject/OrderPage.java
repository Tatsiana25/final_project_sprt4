package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ENTER;

public class OrderPage {

    private WebDriver driver;

    private final By firstName = By.xpath(".//input[@placeholder='* Имя']");

    private final By lastName = By.xpath(".//input[@placeholder='* Фамилия']");

    private final By address = By.xpath(".//input[starts-with(@placeholder,'* Адрес')]");

    private final By metroStation = By.xpath(".//input[@placeholder='* Станция метро']");

    private final By phoneNumber = By.xpath(".//input[starts-with(@placeholder,'* Телефон')]");

    private final By orderDataSendButton = By.xpath(".//button[text()='Далее']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean checkOrderPageShown(String orderpageUrl) {
        return driver.getCurrentUrl().equals(orderpageUrl);
    }

    public void setFirstName(String firstName) {
        driver.findElement(this.firstName).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(this.lastName).sendKeys(lastName);
    }

    public void setMetroStation(String metroStation) {
        driver.findElement(this.metroStation).sendKeys(metroStation + ARROW_DOWN + ENTER);
    }

    public void setAddress(String address) {
        driver.findElement(this.address).sendKeys(address);
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(this.phoneNumber).sendKeys(phoneNumber);
    }


    public void fillOrderForm(String firstName, String lastName, String address, String metroStation, String phoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setMetroStation(metroStation);
        setPhoneNumber(phoneNumber);
    }

    public void orderDataSendButtonClick() {
        driver.findElement(orderDataSendButton).click();

    }
}
