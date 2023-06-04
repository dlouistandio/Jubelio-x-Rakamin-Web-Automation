package PageObjects.Login;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name='email']")
    WebElement usernameField;

    @FindBy(css = "[name='password']")
    WebElement passwordField;

    @FindBy(css = ".ladda-button")
    WebElement masukButton;

    @FindBy(xpath = "//div[@class='app-alert alert alert-danger alert-dismissable']/li")
    WebElement alertText;

    @FindBy(xpath = "//h1[.='Login']")
    WebElement loginText;


//    By alertText = By.xpath("//li[.='Password atau email anda salah.']");

    public void inputUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickBtn() {
        masukButton.click();
    }

    public void validateErrMessage(String mess){
        String getAlert = wait.until(ExpectedConditions.visibilityOf(alertText)).getText();
        System.out.println(getAlert);
        Assert.assertEquals(getAlert, mess);
    }

    public void userInLoginPage(String mess){
        String getTxt = wait.until(ExpectedConditions.visibilityOf(loginText)).getText();
        Assert.assertEquals(getTxt, mess);
    }
}
