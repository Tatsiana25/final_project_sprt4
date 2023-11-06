package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    // локатор "Верхняя кнопка 'Заказать'"
    private final By orderUpButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    // локатор "Нижняя кнопка 'Заказать'"
    private final By orderDownButton = By.className("Button_Middle__1CSJM");

    //локатор "Раздел 'Вопросы о важном'"
    private final By listOfFAQ = By.className("Home_FAQ__3uVm4");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickOrderUpButton() {
        driver.findElement(orderUpButton).click();
    }


    public void scrollToOrderDownButton() {
        WebElement element = driver.findElement(orderDownButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickOrderLowerButton() {
        driver.findElement(orderDownButton).click();
    }


    public void scrollToListOfFAQ() {
        WebElement element = driver.findElement(listOfFAQ);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public String findAnswerByQuestion(String questionText) {
        By question = By.xpath(".//div[@class='accordion__button' and text()='" + questionText + "']");
        driver.findElement(question).click();
        String attrib = driver.findElement(question).getAttribute("id");
        int idNum = attrib.lastIndexOf("-");
        String idNumStr = attrib.substring(idNum + 1);
        String attribAnswer = "accordion__panel-" + idNumStr;
        String answerXPath = ".//div[@id='" + attribAnswer + "']/p";

        By answer = By.xpath(answerXPath);

        return driver.findElement(answer).getText();
    }
}
