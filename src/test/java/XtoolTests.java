import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Suite - Проверка функциональности сайта Xtool.ru")
public class XtoolTests extends BaseTest {
    @Test
    @DisplayName("TS-001: Вход пользователя в систему")
    public void testUserLogin() {
        login();
        Assertions.assertTrue(loginPage.isLoggedIn(), "Пользователь не вошел в систему");
    }

    @Test
    @DisplayName("TS-002: Проверка трастовости сайта")
    public void testTrustCheck() {
        analyzePage.navigateToAnalyzePage();
        Assertions.assertTrue(analyzePage.isOnAnalyzePage(),
                "Не удалось перейти на страницу анализа трастовости");

        login();
        analyzePage.analyzeTrust("https://spb.hh.ru/");
        Assertions.assertTrue(analyzePage.isTrustResultsDisplayed(),
                "Результаты анализа трастовости не отобразились");
    }

    @Test
    @DisplayName("TS-003: Анализ обратных ссылок")
    public void testBacklinksAnalysis() {
        backlinksPage.navigateToBacklinks();
        Assertions.assertTrue(backlinksPage.isOnBacklinksPage(),
                "Не удалось перейти на страницу анализа обратных ссылок");

        login();
        backlinksPage.analyzeBacklinks("https://spb.hh.ru/");
        Assertions.assertTrue(backlinksPage.isAnalysisResultsDisplayed(),
                "Результаты анализа не отобразились");
    }

    @Test
    @DisplayName("TS-004: Просмотр моих проверок")
    public void testViewMyChecks() {
        login();

        accountPage.navigateToAccount();
        accountPage.navigateToMyChecks();
        Assertions.assertTrue(accountPage.isOnMyChecksPage(),
                "Не удалось перейти на страницу 'Мои проверки' или контент не отображается");
    }

    @Test
    @DisplayName("TS-005: Просмотр рекомендаций")
    public void testViewRecommendations() {
        accountPage.navigateToRecommendations();
        Assertions.assertTrue(accountPage.isOnRecommendationsPage(),
                "Не удалось перейти на страницу рекомендаций или заголовок не найден");
    }

    @Test
    @DisplayName("TS-006: Проверка дополнительной информации при анализе")
    public void testMoreInfoCheck() {
        analyzePage.navigateToAnalyzePage();
        Assertions.assertTrue(analyzePage.isOnAnalyzePage(),
                "Не удалось перейти на страницу анализа трастовости");

        login();
        analyzePage.analyzeTrust("https://spb.hh.ru/");
        Assertions.assertTrue(analyzePage.isTrustResultsDisplayed(),
                "Результаты анализа трастовости не отобразились");

        analyzePage.togglePageRankSection();
        Assertions.assertTrue(analyzePage.isPageRankContentVisible(),
                "Информация об изменении PageRank не отобразилась");
    }
}
