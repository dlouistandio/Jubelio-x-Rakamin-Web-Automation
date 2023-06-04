package PageObjects.Home;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[.='Selamat Datang']")
    WebElement welcomeText;

    @FindBy(css = ".navbar-minimalize")
    WebElement navbarButton;

    @FindBy(xpath = "//ul[@class='metismenu-container']/li//span")
    List<WebElement> menuContainer;


    public void validateIsOnPage(){
      String text = wait.until(ExpectedConditions.visibilityOf(welcomeText)).getText();
      Assert.assertEquals(text, "Selamat Datang");
    }

    public void clickMenuButton(){
        wait.until(ExpectedConditions.visibilityOf(navbarButton)).click();
    }

//    public void clickMenuList(String name){
//        String[] menuList = name.split(",");
//        WebElement selectedMenu;
//        for (String menuName:
//                menuList) {
//            String xPathSelectedProduct =  "//a[.='"+ menuName +"']";
//            selectedMenu = menuContainer.findElement(By.xpath(xPathSelectedProduct));
//            wait.until(ExpectedConditions.visibilityOf(selectedMenu)).click();
//        }
//    }

    public List<WebElement> getMenuList(){
        return menuContainer;
    }

    public WebElement getMenu(String name){
        WebElement list = getMenuList().stream().filter(persediaanNavbar -> persediaanNavbar.getText().equals(name)).findFirst().orElse(null);
        return list;
    }

    public void clickMenu(String name){
        wait.until(ExpectedConditions.elementToBeClickable(getMenu(name))).click();
    }
}
