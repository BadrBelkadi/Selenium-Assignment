import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.support.ui.*;
import okhttp3.internal.http2.Settings;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class TvmazeTest {
    private WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException{
        ChromeOptions options = new ChromeOptions();
        this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        this.driver.manage().window().maximize();

        int timeoutSeconds = 30; 
        driver.manage().timeouts().implicitlyWait(timeoutSeconds, TimeUnit.SECONDS);

        options.addArguments("--user-agent=IST6WP");
        options.addArguments("--disable-extensions");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        
    }

    @Test
    public void TvmazeTest() {
        try{

            LoginPageTest loginPage = new LoginPageTest(this.driver);
            MainPageTest mainPage = new MainPageTest(this.driver);
        
            Thread.sleep(2000);

            driver.navigate().to("https://theuselessweb.com/");
            Thread.sleep(1000);
            driver.navigate().back();

            loginPage = mainPage.clickLoginToRedirect();
            Assert.assertTrue(loginPage.pageLoadCheck());        
            DashboardPageTest dashboardPage = loginPage.loginIn();
            

            Assert.assertTrue(dashboardPage.pageLoadCheck());
            System.out.println(dashboardPage.getBodyText());


            ProfilePageTest profilePage = dashboardPage.clickDashboardToRedirect();
            Assert.assertEquals("Profile: daemoon", profilePage.pageLoadCheck());


            Assert.assertEquals("User dashboard", profilePage.readPageTitle());


            SettingsPageTest settingspage = profilePage.settings();
            Assert.assertTrue(settingspage.pageLoadCheck());
            settingspage.sendFormWhileLoggedIn();

            // file upload not working
            // settingspage = settingspage.fileUpload();

            LoginPageTest loginPage2 = dashboardPage.logout();
            Assert.assertTrue(loginPage2.pageLoadCheck());

            // ----------------------------------------

            // SignupPageTest signupPage = new SignupPageTest(this.driver);
            // signupPage = mainPage.clickLoginToRedirect();
            // Thread.sleep(3000);

            // Signing Up Test

            // DashboardPageTest dashboardPage1 = signupPage.SignupPageTest();
            // Assert.assertTrue(signupPage.pageLoadCheck()); // not working

            // ----------------------------------------
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }   

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }   
}
