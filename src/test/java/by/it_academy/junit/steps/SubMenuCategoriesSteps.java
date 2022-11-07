package by.it_academy.junit.steps;

import by.it_academy.junit.constants.TestFailMessage;
import by.it_academy.pages.onliner.MainPage;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;

public class SubMenuCategoriesSteps {
    public static final String ROOMS = "комнатные";
    public static final String DOLLAR = "$";
    public static final String RUBLE = "р.";
    private final List<String> cities = Arrays.asList("Минск", "Гомель", "Могилев", "Гродно", "Витебск", "Брест");
    private final List<String> carBrands = Arrays.asList("Audi", "BMW", "Ford", "Renault", "Volkswagen");
    private static MainPage mainPage;

    @BeforeAll
    public static void before_all() {
        mainPage = new MainPage();
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
    }

    @Given("the user opens Onliner website")
    public void theUserOpensOnlinerWebsite() {
        mainPage.navigateToMainPage();
    }

    @When("the user hover on the {string} section")
    public void theUserHoverOnTheSection(String string) {
        mainPage.getHeader().hoverOnHeaderMenuItem(string);
    }

    @Then("submenu is displayed and I see division by prices, cities and brands")
    public void submenuIsDisplayed() {
        mainPage.getHeader().getElementsOfActiveSubMenu()
                .shouldHave(noneMatch(TestFailMessage.SUBMENU_HAVE_EMPTY_ITEM, el -> el.getText().isEmpty())
                        .because(TestFailMessage.SUBMENU_HAVE_EMPTY_ITEM))
                .shouldHave(containExactTextsCaseSensitive(cities)
                        .because(TestFailMessage.SUBMENU_HAVEN_NOT_DIVISION_BY_CITIES))
                .shouldHave(containExactTextsCaseSensitive(carBrands)
                        .because(TestFailMessage.SUBMENU_HAVE_NOT_DIVISION_BY_BRANDS))
                .shouldHave(anyMatch("", el -> el.getText().contains(RUBLE))
                        .because(TestFailMessage.SUBMENU_HAVE_NOT_DIVISION_BY_PRICES));
    }


    @Then("submenu is displayed and I see division by prices, cities and number of rooms")
    public void submenuIsDisplayedAndISeeDivisionByPricesCitiesAndNumberOfRooms() {
        mainPage.getHeader().getElementsOfActiveSubMenu()
                .shouldHave(noneMatch("", el -> el.getText().isEmpty()))
                .shouldHave(containExactTextsCaseSensitive(cities)
                        .because(TestFailMessage.SUBMENU_HAVEN_NOT_DIVISION_BY_CITIES))
                .shouldHave(anyMatch("", el -> el.getText().contains(DOLLAR))
                        .because(TestFailMessage.SUBMENU_HAVE_NOT_DIVISION_BY_PRICES))
                .shouldHave(allMatch("", el -> el.getText().contains(ROOMS))
                        .because(TestFailMessage.SUBMENU_HAVE_NOT_DIVISION_BY_NUMBER_OF_ROOMS));
    }
}
