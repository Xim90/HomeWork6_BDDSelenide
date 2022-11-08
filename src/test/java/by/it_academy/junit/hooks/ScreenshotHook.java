package by.it_academy.junit.hooks;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;

public class ScreenshotHook {

    public static final String IMAGE_PNG = "image/png";

    @After
    public static void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = Selenide.screenshot(OutputType.BYTES);
            scenario.attach(screenshot, IMAGE_PNG,scenario.getName());
        }
    }
}

