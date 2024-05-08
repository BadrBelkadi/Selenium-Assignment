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

class DashboardPageTest extends BasePage {

    private final By profileButtonBy = By.xpath("//*[@id=\"notifications\"]/i");
    private final By settingsButtonBy = By.xpath("/html/body/header/div[1]/div[3]/div/div[2]/div/article[1]/ul/li[4]/a");
    private final By pageTitleBy = By.xpath("/html/body/div[2]/div/section/section[1]/section[1]/header/h1");;
    private final By dashboardButtonBy = By.xpath("//*[@id=\"personal\"]/ul/li[3]/a");
    private final By logoutButtonBy = By.xpath("//*[@id=\"personal\"]/ul/li[6]/a");
    private final By dropdownToggleBy = By.xpath("//*[@id=\"user-menu\"]");
   
    public DashboardPageTest(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.tvmaze.com");
    }

    public boolean pageLoadCheck() {
        WebElement avatarElement = wait.until(ExpectedConditions.presenceOfElementLocated(this.profileButtonBy));
        return avatarElement.isDisplayed();
    }

    public ProfilePageTest clickDashboardToRedirect() {
        WebElement dropdownToggle = this.waitAndReturnElement(this.dropdownToggleBy);
        dropdownToggle.click();
        WebElement dashboardButton = this.waitAndReturnElement(this.dashboardButtonBy);
        dashboardButton.click();
        return new ProfilePageTest(this.driver);
    }

    public SettingsPageTest settings(){
        WebElement logoutButton = this.waitAndReturnElement(this.settingsButtonBy);
        logoutButton.click();
        return new SettingsPageTest(this.driver);
    }

    public LoginPageTest logout() {
        WebElement dropdownToggle = this.waitAndReturnElement(this.dropdownToggleBy);
        dropdownToggle.click();
        WebElement logoutButton = this.waitAndReturnElement(this.logoutButtonBy);
        logoutButton.click();
        return new LoginPageTest(this.driver);
    }

    public String readPageTitle(){
        return this.waitAndReturnElement(this.pageTitleBy).getText();
    }

}
