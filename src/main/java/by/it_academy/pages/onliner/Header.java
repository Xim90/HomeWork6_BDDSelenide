package by.it_academy.pages.onliner;

import by.it_academy.pages.BasePage;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class Header extends BasePage {
    public static final String MAIN_MENU_ITEM_LINK_PATTERN =
            "//span[contains(@class,'main') and contains(text(),'%s')]";
    public static final String ACTIVE_SUB_MENU_LINK =
            "//div[contains(@class,'dropdown_visible')]//span[contains(@class,'sign')]";

    public void hoverOnHeaderMenuItem(String category) {
        $x(format(MAIN_MENU_ITEM_LINK_PATTERN, category)).hover();
    }

    public ElementsCollection getElementsOfActiveSubMenu() {
        return $$x(ACTIVE_SUB_MENU_LINK);
    }
}
