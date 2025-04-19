import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By loginLink = By.id("login");
    private final By emailInput = By.xpath("//input[@id='login' and @name='login']");
    private final By passwordInput = By.id("pass");
    private final By loginButton = By.xpath("//button[@type='submit' and contains(@class, 'btn')]");
    private final By accountButton = By.id("btn-account");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginLink() {
        clickElement(loginLink);
    }

    public void setEmail(String email) {
        typeText(emailInput, email);
    }

    public void setPassword(String password) {
        typeText(passwordInput, password);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public boolean isLoggedIn() {
        try {
            return findVisibleElement(accountButton).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
