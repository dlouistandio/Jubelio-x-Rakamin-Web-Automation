package PageObjects.Persediaan;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class PersediaanPage extends BasePage {

    public PersediaanPage(WebDriver driver) {
        super(driver);
    }

    Actions act = new Actions(driver);

    @FindBy(xpath = "//a[@href='/home/inventory']")
    WebElement persediaanMenu;

    @FindBy(xpath = "//ul[@class='nav nav-tabs']/li/a")
    List<WebElement> persediaanNavbarList;

    @FindBy(css = "[placeholder='Nama, SKU, Merek Lain']")
    WebElement searchBarangField;

    @FindBy(css = "//button[@class='btn btn-primary']")
    WebElement searchBarangBtn;

    @FindBy(xpath = "//div[@class='react-grid-checkbox-container']")
    WebElement checkboxButtonList;

    @FindBy(xpath = "//button[@class='btn-link']")
    WebElement skuNameList;

    @FindBy(xpath = "//button[@class='ladda-button btn btn-primary m-l-xs']")
    WebElement penyesuaianButton;

    @FindBy(xpath = "//h1[.='Persediaan']")
    WebElement persediaanPageText;

    @FindBy(xpath = "//h2[@class='editor-title']")
    WebElement penyesuaianPersediaanText;

    @FindBy(xpath = "//div[@class='react-grid-Row react-grid-Row--even']/div[2]/div[@class='react-grid-Cell__value']")
    WebElement kurangTambahStokField;
    @FindBy(xpath = "//input[@class=' editor-main']")
    WebElement kurangTambahStokInput;

    @FindBy(xpath = "//textarea[@name='note']")
    WebElement keteranganField;

    @FindBy(xpath = "//button[.='Simpan']")
    WebElement simpanButton;

    @FindBy(css = ".app-alert > li")
    WebElement alertMessage;

    public void clickPersediaanMenu() {
        persediaanMenu.click();
    }

    public List<WebElement> getNavbarList() {
        return persediaanNavbarList;
    }

    public WebElement getPersediaanNavbar(String name) {
        WebElement list = getNavbarList().stream().filter(persediaanNavbar -> persediaanNavbar.getText().equals(name)).findFirst().orElse(null);
        return list;
    }

    public void clickPersediaanNavbar(String name) {
        getPersediaanNavbar(name).click();
    }

    public void clickCheckbox(String number) {
        String[] checkboxList = number.split(",");
        WebElement selectedButton;
        for (String checkbox :
                checkboxList) {
            String xPathSelectedCheckbox = "//label[@for='checkbox" + checkbox + "']";
            selectedButton = checkboxButtonList.findElement(By.xpath(xPathSelectedCheckbox));
            wait.until(ExpectedConditions.visibilityOf(selectedButton)).click();
        }
    }

    public void clickItemSKU(String name) {
        String[] skuList = name.split(",");
        WebElement selectedSKU;
        for (String skuName :
                skuList) {
            String xPathSelectedCheckbox = "//button[.='" + skuName + "']";
            selectedSKU = skuNameList.findElement(By.xpath(xPathSelectedCheckbox));
            wait.until(ExpectedConditions.visibilityOf(selectedSKU)).click();
        }
    }

    public void inputSearchField(String name){
        searchBarangField.sendKeys(name);
        searchBarangBtn.click();
    }

    public void clickPenyesuaianPersediaan(){
        penyesuaianButton.click();
    }

    public void validateIsOnPersediaanPage(){
        String text = wait.until(ExpectedConditions.visibilityOf(persediaanPageText)).getText();
        Assert.assertEquals(text, "Persediaan");
    }

    public void validateIsOnPenyesuaianPersediaan(){
        String text = wait.until(ExpectedConditions.visibilityOf(penyesuaianPersediaanText)).getText();
        Assert.assertEquals(text, "Penyesuaian Persediaan");
    }

    public void inputKeteranganField(String text) {
        keteranganField.sendKeys(text);
    }

    public void adjustStock(String qty){
        wait.until(ExpectedConditions.elementToBeClickable(kurangTambahStokField));
        act.doubleClick(kurangTambahStokField).perform();
        wait.until(ExpectedConditions.visibilityOf(kurangTambahStokInput)).sendKeys(qty);
        keteranganField.click();
    }

    public void clickSimpanButton(){
        act.scrollByAmount(900,900).perform();
        simpanButton.click();
    }

    public void validateAlertMessage(String mess){
        String getAlert = wait.until(ExpectedConditions.visibilityOf(alertMessage)).getText();
        System.out.println(getAlert);
        Assert.assertEquals(getAlert, mess);
    }
}
