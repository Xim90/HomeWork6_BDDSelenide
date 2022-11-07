package by.it_academy.pages.onliner;

import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    public static final String ONLINER_URL = "https://www.onliner.by/";
    private final Header header = new Header();

    public Header getHeader() {
        return header;
    }

    public void navigateToMainPage() {
        open(ONLINER_URL);
    }

}
