import java.util.List;
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

class ProfilePageTest extends BasePage {

    private final By logoutButtonBy = By.xpath("//*[@id=\"personal\"]/ul/li[6]/a");
    private final By settingsButtonBy = By.xpath("/html/body/div[1]/div/header/nav/ul/li[7]/a");
    private final By profileBy = By.xpath("//*[@id=\"profile-options\"]/ul/li[1]/div/strong");
    private final By pageTitleBy = By.xpath("/html/body/div[1]/div/header/h1");
    
    public ProfilePageTest(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.tvmaze.com/dashboard");
    }

    public String pageLoadCheck() {
        return this.waitAndReturnElement(this.profileBy).getText();
    }   

    public String readPageTitle(){
        return driver.getTitle();
    }

    public SettingsPageTest settings(){
        WebElement settingsButton = this.waitAndReturnElement(this.settingsButtonBy);
        settingsButton.click();
        return new SettingsPageTest(this.driver);
    }

}
