import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


class SignupPageTest extends BasePage {

    private final By usernameLocatorBy = By.xpath("//*[@id=\"user-username\"]");
	private final By passwordLocatorBy = By.xpath("//*[@id=\"user-password\"]");
    private final By passwordRepeatLocatorBy = By.xpath("//*[@id=\"user-password_repeat\"]");
    private final By emailLocatorBy = By.xpath("//*[@id=\"user-email\"]");
	private final By registerLocatorBy = By.xpath("//*[@id=\"w0\"]/button");
    private final By dontHaveAnAccountTextBy = By.xpath("/html/body/header/div[1]/div[3]/div/a[2]");
    
    private final String username = "daemoon3"; // edit this
    private final String email = "badrdinbelkadi3@outlook.com"; // edit this
	private final String password = "Eva2002101@";

    public SignupPageTest(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.tvmaze.com/account/register");
    }

    public DashboardPageTest SignupPageTest(){
        
        try {
            this.waitAndReturnElement(usernameLocatorBy).click();
            Thread.sleep(3000);
            this.waitAndReturnElement(usernameLocatorBy).sendKeys(username);
            Thread.sleep(3000);
            this.waitAndReturnElement(emailLocatorBy).click();
            Thread.sleep(3000);
            this.waitAndReturnElement(emailLocatorBy).sendKeys(email);
            Thread.sleep(3000);
            this.waitAndReturnElement(passwordLocatorBy).click();
            Thread.sleep(3000);
            this.waitAndReturnElement(passwordLocatorBy).sendKeys(password);
            Thread.sleep(3000);
            this.waitAndReturnElement(passwordRepeatLocatorBy).click();
            Thread.sleep(3000);
            this.waitAndReturnElement(passwordRepeatLocatorBy).sendKeys(password);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.waitAndReturnElement(registerLocatorBy).click();

        return new DashboardPageTest(this.driver);
    }

    public boolean pageLoadCheck() {
        WebElement text = wait.until(ExpectedConditions.presenceOfElementLocated(this.dontHaveAnAccountTextBy));
        return text.isDisplayed();
    }
}
