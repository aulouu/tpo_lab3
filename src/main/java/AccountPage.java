import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {
    private final By accountButton = By.cssSelector("a#btn-account.btn-warning");
    private final By myChecksLink = By.cssSelector("a.list-group-item.menu-links[href*='/account/check/']");
    private final By mainContent = By.id("main-col");
    private final By recommendationsLink = By.xpath("//a[@class='nav-link d-md-none d-lg-block' and contains(@href,'/recomend/')]");
    private final By recommendationsTitle = By.xpath("//h1[@class='p-4' and contains(text(),'Рекомендации оптимизаторам')]");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToAccount() {
        clickElement(accountButton);
        wait.until(ExpectedConditions.urlContains("/account"));
    }

    public void navigateToMyChecks() {
        clickElement(myChecksLink);
        wait.until(ExpectedConditions.urlContains("/account/check"));
    }

    public boolean isOnMyChecksPage() {
        return driver.getCurrentUrl().contains("/account/check") &&
                findVisibleElement(mainContent).isDisplayed();
    }

    public void navigateToRecommendations() {
        clickElement(recommendationsLink);
        wait.until(ExpectedConditions.urlContains("/recomend"));
    }

    public boolean isOnRecommendationsPage() {
        return driver.getCurrentUrl().contains("/recomend") &&
                findVisibleElement(recommendationsTitle).isDisplayed();
    }
}
