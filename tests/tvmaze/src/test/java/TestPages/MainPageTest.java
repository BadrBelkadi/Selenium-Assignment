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

class MainPageTest extends BasePage {

    private By footerBy = By.xpath("//*[@id=\"copyright\"]/span");
    private By loginRedirectorBy = By.xpath("//*[@id=\"user-tools\"]/div/a[1]");
    
    public MainPageTest(WebDriver driver) {
        super(driver);
        this.driver.get(ConfigReader.getProperty("dashboardPage"));
    }

    public String getFooterText() {
        return this.waitAndReturnElement(this.footerBy).getText();
    }

    public LoginPageTest clickLoginToRedirect() {
        this.waitAndReturnElement(this.loginRedirectorBy).click();
        return new LoginPageTest(this.driver);
    }

    // public SignupPageTest clickSignUpToRedirect() {
    //     this.waitAndReturnElement(this.signupRedirectorBy).click();
    //     return new SignupPageTest(this.driver);
    // }
    
}
