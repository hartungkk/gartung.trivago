package web;

import Enums.UserData;
import Pages.MainPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import setUp.Settuper;

import java.util.ResourceBundle;

import static com.codeborne.selenide.Selenide.open;
import static java.util.ResourceBundle.getBundle;

public class TestTaskForTrivagoTest {
    ResourceBundle bundle = getBundle("en");

    @BeforeMethod
    public void setUp() {
        Settuper.setUp();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.getWebDriver().close();
    }


    @Test
    @Description("Test for successful subscribe on newspapers")
    public void testPositiveSubscribeMeToNewsLetters() {
        MainPage mainPage = open("/", MainPage.class);
        mainPage.waitVisible();
        mainPage.footerNewsLetter.scrollTo();
        mainPage.footerNewsLetter.waitUntil(Condition.text(bundle.getString("footer.header")), 10000);
        mainPage.footerEmailInput.setValue(UserData.generateUniqueEmail(UserData.USER_EMAIL.getValue()));
        mainPage.footerInspireMeButton.click();
        mainPage.successfulSubmittedMessage.waitUntil(Condition.visible, 10000);
        mainPage.successfulSubmittedMessage.waitUntil(Condition.text(bundle.getString("footer.succesfullMessage")), 10000);
    }


    @Test
    @Description("Test for check search results")
    public void testSearchInMainPage() {
        MainPage mainPage = open("/", MainPage.class);
        mainPage.waitVisible();
        mainPage.searchButton.click();
        mainPage.waitVisibleSearchLayout();
        mainPage.searchInput.setValue(UserData.USER_SEARCH_DATA.getValue());
        mainPage.searchInput.pressEnter();

        mainPage.searchResults.shouldHaveSize(2); //actually for 06.12.2018
        mainPage.searchResultsTitle.waitUntil(Condition.text(bundle.getString("searchLayoutTitle.expectedSearchResults")), 10000);
        mainPage.searchResults.first().waitUntil(Condition.text(bundle.getString("searchResults.first")), 10000);
        mainPage.searchResults.last().waitUntil(Condition.text(bundle.getString("searchResults.second")), 10000);
    }


    @Test(enabled = false)
    @Description("Test for check view destinations, minor business feature")
    public void testSelectDestinationThroughMenu() {
        MainPage mainPage = open("/", MainPage.class);
        mainPage.waitVisible();
        mainPage.navigationMenuButton.click();

        mainPage.waitVisibleDestinationMenu();

        mainPage.menuCarouselDestinations.shouldHaveSize(5);
    }
}
