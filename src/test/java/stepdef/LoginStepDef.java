package stepdef;

import Context.TestContext;
import PageObjects.Home.HomePage;
import PageObjects.Login.LoginPage;
import PageObjects.PageObjectManager;
import PageObjects.Persediaan.PersediaanPage;
import Utils.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class LoginStepDef {
    private final LoginPage loginPage;
    private final HomePage homePage;
    private final TestContext context;

    public LoginStepDef(TestContext context){
        this.context = context;
        loginPage = PageObjectManager.getLoginPage(context.driver);
        homePage = PageObjectManager.getHomePage(context.driver);
    }

    @Given("User already in Jubelio login page")
    public void userAlreadyInJubelioLoginPage() {
       loginPage.userInLoginPage("Login");
    }
    @When("User enter username as {string}")
    public void userEnterUsernameAs(String username) {
        loginPage.inputUsername(username);
    }
    @When("User enter password as {string}")
    public void userEnterPasswordAs(String password){
        loginPage.inputPassword(password);
    }
    @Then("User click Masuk button")
    public void userClickMasukButton(){
        loginPage.clickBtn();
    }

//    @Then("User Select penyesuian barang")
//    public void userSelectPenyesuianBarang() throws InterruptedException {
//        new HomePage(driver).clickMenu("Barang");
//        Thread.sleep(5000);
//        new PersediaanPage(driver).clickPersediaanMenu();
//        Thread.sleep(5000);
//        new PersediaanPage(driver).clickCheckbox("2");
//        Thread.sleep(30000);
//    }

    @Then("User see the error with message {string}")
    public void userSeeTheErrorWithMessage(String mess) {
        loginPage.validateErrMessage(mess);
    }

    @Then("User redirected to Home page")
    public void userRedirectedToHomePage() {
        homePage.validateIsOnPage();
    }
}
