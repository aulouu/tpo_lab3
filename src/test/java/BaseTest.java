import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {
    protected WebDriver driver;
    protected AnalyzePage analyzePage;
    protected LoginPage loginPage;
    protected BacklinksPage backlinksPage;
    protected AccountPage accountPage;

    @BeforeEach
    public void setUp() {
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://xtool.ru/");

        analyzePage = new AnalyzePage(driver);
        loginPage = new LoginPage(driver);
        backlinksPage = new BacklinksPage(driver);
        accountPage = new AccountPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void login() {
        loginPage.clickLoginLink();
        loginPage.setEmail(Config.getEmail());
        loginPage.setPassword(Config.getPassword());
        loginPage.clickLoginButton();
    }
}
