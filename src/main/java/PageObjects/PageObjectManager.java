package PageObjects;

import PageObjects.Home.HomePage;
import PageObjects.Login.LoginPage;
import PageObjects.Persediaan.PersediaanPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private static LoginPage loginPage;
    private static HomePage homePage;
    private static PersediaanPage persediaanPage;

    public static LoginPage getLoginPage(WebDriver driver){
        return loginPage == null ? new LoginPage(driver) : loginPage;
    }

    public static HomePage getHomePage(WebDriver driver){
        return homePage == null ? new HomePage(driver) : homePage;
    }

    public static PersediaanPage getPersediaanPage(WebDriver driver){
        return persediaanPage == null ? new PersediaanPage(driver) : persediaanPage;
    }
}
