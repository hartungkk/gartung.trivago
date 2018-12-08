package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;//h3[@class='section-title']
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    public SelenideElement header = $(byClassName("fixed-header"));
    public SelenideElement navigationMenuButton = $(byClassName("nav-icon"));
    public SelenideElement searchButton = $(byClassName("search-icon"));
    public SelenideElement contentContainer = $(byXpath("//div[contains(@class,'home-container')]"));
    public SelenideElement footerNewsLetter = $(byXpath("//div[contains(@class,'newsletter-title')]"));
    public SelenideElement footerEmailInput = $(byXpath("//div[contains(@class,'newsletter-inputs')]//input"));
    public SelenideElement footerInspireMeButton = $(byXpath("//div[contains(@class,'newsletter-inputs')]//button"));
    public SelenideElement menuContainer = $(byId("menu"));
    public ElementsCollection menuCarouselDestinations = $$(byXpath("//div[@class='destination-menu']"));
    public SelenideElement successfulSubmittedMessage = $(byXpath("//p[contains(@class,'submitted')]"));
    public SelenideElement searchLayer = $(byId("search"));
    public SelenideElement searchInput = $(byXpath("//div[contains(@class,'search-input-wrapper')]//input"));
    public ElementsCollection filterTags = $$(byXpath("//div[@id='search']//div[@class='filter-tag']"));
    public SelenideElement searchResultsTitle = $(byXpath("//h3[@class='section-title']"));
    public ElementsCollection searchResults = $$(byXpath("//div[@class='search-results']//section[@class='posts-section']//div[contains(@class,'article-card')]"));

    public void waitVisible() {
        header.waitUntil(Condition.visible, 10000);
        navigationMenuButton.waitUntil(Condition.visible, 10000);
        searchButton.waitUntil(Condition.visible, 10000);
        contentContainer.waitUntil(Condition.visible, 10000);

    }

    public void waitVisibleSearchLayout() {
        searchLayer.waitUntil(Condition.visible, 10000);
        searchInput.waitUntil(Condition.visible, 10000);
        filterTags.first().waitUntil(Condition.visible, 10000);
    }

    public void waitVisibleDestinationMenu() {
        menuContainer.waitUntil(Condition.visible, 10000);
        menuCarouselDestinations.first().waitUntil(Condition.visible, 10000);
    }

}
