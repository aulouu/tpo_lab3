import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BacklinksPage extends BasePage {
    private final By backlinksLink = By.xpath("//a[@class='nav-link' and contains(@href,'/backlinks/')]");
    private final By urlInput = By.cssSelector("input#url.form-control");
    private final By submitButton = By.cssSelector("button#check-submit.btn.mcb");
    private final By resultsBlock = By.id("_analiz");

    public BacklinksPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToBacklinks() {
        clickElement(backlinksLink);
        wait.until(ExpectedConditions.urlContains("/backlinks"));
    }

    public void analyzeBacklinks(String url) {
        typeText(urlInput, url);
        clickElement(submitButton);
    }

    public boolean isAnalysisResultsDisplayed() {
        try {
            return findVisibleElement(resultsBlock).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isOnBacklinksPage() {
        return driver.getCurrentUrl().contains("/backlinks");
    }
}
