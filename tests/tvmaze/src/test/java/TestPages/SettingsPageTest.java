import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;


class SettingsPageTest extends BasePage {

    private final By twitterBy = By.xpath("//*[@id=\"user-twitter\"]");
    private final By websiteBy = By.xpath("//*[@id=\"user-website\"]");
    private final By updateButtonBy = By.xpath("//*[@id=\"w0\"]/button");
    private final By settingsPageBy = By.xpath("/html/body/div[1]/div/header/h1");
    private final By checkBoxBy = By.xpath("//*[@id=\"user-private\"]");
    private final By fileUploadBy = By.xpath("//*[@id=\"user-uploadfile\"]");
    
    // Main Page
    public SettingsPageTest(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.tvmaze.com/dashboard/settings");
    }

    public boolean pageLoadCheck() {
        WebElement settingsElement = wait.until(ExpectedConditions.presenceOfElementLocated(this.settingsPageBy));
        return settingsElement.isDisplayed();
    }

    public void sendFormWhileLoggedIn(){

        WebDriverWait wait = new WebDriverWait(driver, 10); 
        WebElement twitterElement = wait.until(ExpectedConditions.visibilityOfElementLocated(twitterBy));
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(websiteBy));
        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxBy));
        twitterElement.click();
        twitterElement.clear();
        twitterElement.sendKeys("daemoon");
        webElement.click();
        webElement.clear();
        webElement.sendKeys("https://daemoon.com");
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        this.waitAndReturnElement(this.updateButtonBy).click();
    }

    public SettingsPageTest fileUpload(){
        // if (driver instanceof RemoteWebDriver) {
        //     // Cast WebDriver to RemoteWebDriver
        //     RemoteWebDriver remoteDriver = (RemoteWebDriver) driver;
        //     System.out.println("hi");
        //     // Set LocalFileDetector
        //     remoteDriver.setFileDetector(new LocalFileDetector());
        //     remoteDriver.findElement(fileUploadBy).sendKeys("C:\\Users\\L470\\Desktop\\School\\Big-Selenium-Assignment\\tests\\mytests\\image.jpeg");
        //     this.waitAndReturnElement(this.updateButtonBy).click();

        // }
        
        File uploadFile = new File("/home/selenium/tests/tvmaze/src/test/java/TestPages/image.png");
        WebElement fileInput = this.waitAndReturnElement(fileUploadBy);
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        this.waitAndReturnElement(this.updateButtonBy).click();

        // this.waitAndReturnElement(this.fileUploadBy).click();
        // String filePath = "/home/selenium/tests/mytests/image.jpeg";
        // this.waitAndReturnElement(this.fileUploadBy).sendKeys(filePath);
        
        return new SettingsPageTest(this.driver);
    }

}



