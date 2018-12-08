package setUp;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settuper {

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://room5.trivago.com";
        Configuration.browserSize = "1280x1024";
    }
}
