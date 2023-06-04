package stepdef;

import Context.TestContext;
import PageObjects.Home.HomePage;
import PageObjects.Login.LoginPage;
import PageObjects.PageObjectManager;
import PageObjects.Persediaan.PersediaanPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bouncycastle.util.test.TestResult;

public class PersediaanStepDef {
    private final HomePage homePage;
    private final TestContext context;
    private final PersediaanPage persediaanPage;
    private final LoginPage loginPage;

    public PersediaanStepDef(TestContext context){
        this.context = context;
        persediaanPage = PageObjectManager.getPersediaanPage(context.driver);
        homePage = PageObjectManager.getHomePage(context.driver);
        loginPage = PageObjectManager.getLoginPage(context.driver);
    }

    @Given("User already login")
    public void userAlreadyLogin() {
        loginPage.inputUsername("qa.rakamin.jubelio@gmail.com");
        loginPage.inputPassword("Jubelio123!");
        loginPage.clickBtn();
    }

    @And("User already in Persediaan page")
    public void userAlreadyInPersediaanPage() {
        homePage.validateIsOnPage();
        homePage.clickMenu("Barang");
        persediaanPage.clickPersediaanMenu();
    }

    @When("User click on item checkbox")
    public void userClickOnItemCheckbox() {
        persediaanPage.validateIsOnPersediaanPage();
        persediaanPage.clickCheckbox("1");
    }

    @And("User click penyesuaian persediaan button")
    public void userClickPenyesuaianPersediaanButton(){
        persediaanPage.clickPenyesuaianPersediaan();
    }

    @And("User fill the penyesuaian persediaan form with valid data")
    public void userFillThePenyesuaianPersediaanFormWithValidData(){
        persediaanPage.validateIsOnPenyesuaianPersediaan();
        persediaanPage.adjustStock("3");
        persediaanPage.inputKeteranganField("Ini buat testing sihhh");
    }

    @Then("User click simpan button")
    public void userClickSimpanButton() {
        persediaanPage.clickSimpanButton();
    }

    @And("User will see success message")
    public void userWillSeeSuccessMessage() {
        persediaanPage.validateAlertMessage("Sukses merubah stok");
    }

    @And("User will see error message {string}")
    public void userWillSeeErrorMessage(String err) {
        persediaanPage.validateAlertMessage(err);
    }

    @And("User fill the penyesuaian persediaan form with invalid data")
    public void userFillThePenyesuaianPersediaanFormWithInvalidData() {
        persediaanPage.validateIsOnPenyesuaianPersediaan();
        persediaanPage.adjustStock("");
        persediaanPage.inputKeteranganField("Ini buat testing sihhh");
    }
}
