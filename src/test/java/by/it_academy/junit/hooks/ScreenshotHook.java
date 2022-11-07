package by.it_academy.junit.hooks;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ScreenshotHook {

    public static final String IMAGE_PNG = "image/png";

    @After
    public static void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((RemoteWebDriver) Selenide.webdriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, IMAGE_PNG,scenario.getName());
        }
    }
}

