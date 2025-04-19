import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AnalyzePage extends BasePage {
    private final By analyzeLink = By.xpath("//a[@class='nav-link' and contains(@href,'/analyze/')]");
    private final By urlInput = By.cssSelector("input#url.form-control");
    private final By submitButton = By.cssSelector("button.btn.mcb.ms-3");
    private final By resultsBlock = By.id("_trust-dannye");
    private final By pageRankToggle = By.xpath("//h2[@class='panel-title h4 collapsed' and contains(text(),'Изменение PageRank')]");
    private final By pageRankContent = By.id("_history-pr");

    public AnalyzePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToAnalyzePage() {
        clickElement(analyzeLink);
        wait.until(ExpectedConditions.urlContains("/analyze"));
    }

    public void analyzeTrust(String url) {
        typeText(urlInput, url);
        clickElement(submitButton);
    }

    public void togglePageRankSection() {
        clickElement(pageRankToggle);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageRankContent));
    }

    public boolean isTrustResultsDisplayed() {
        try {
            return findVisibleElement(resultsBlock).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPageRankContentVisible() {
        try {
            return findVisibleElement(pageRankContent).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isOnAnalyzePage() {
        return driver.getCurrentUrl().contains("/analyze");
    }
}
