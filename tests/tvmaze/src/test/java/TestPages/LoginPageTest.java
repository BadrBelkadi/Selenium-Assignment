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


class LoginPageTest extends BasePage {

    private final String username = ConfigReader.getProperty("username");
	private final String password = ConfigReader.getProperty("password");

    
    private final By usernameLocatorbBy = By.id("loginform-username");
	private final By passwordLocatorBy = By.id("loginform-password");
	private final By loginLocatorBy = By.xpath("//button[contains(text(),'Login')]");
    private final By registerLocatorBy = By.xpath("//*[@id=\"login\"]/h1");
    

    public LoginPageTest(WebDriver driver) {
        super(driver);
        this.driver.get(ConfigReader.getProperty("loginPage"));

    }

    public DashboardPageTest loginIn(){
        
        try {
            this.waitAndReturnElement(usernameLocatorbBy).click();
            Thread.sleep(3000);
            this.waitAndReturnElement(usernameLocatorbBy).sendKeys(username);
            Thread.sleep(3000);
            this.waitAndReturnElement(passwordLocatorBy).click();
            Thread.sleep(3000);
            this.waitAndReturnElement(passwordLocatorBy).sendKeys(password);
            Thread.sleep(3000);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.waitAndReturnElement(loginLocatorBy).click();

        return new DashboardPageTest(this.driver);
    }

    public boolean pageLoadCheck() {
        WebElement text = wait.until(ExpectedConditions.presenceOfElementLocated(this.registerLocatorBy));
        return text.isDisplayed();
    }
}
