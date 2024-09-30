package support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;


public class DeviceCreation {
    private static final DesiredCapabilities capabilities = new DesiredCapabilities();
    public static WebDriver driver;
    public static Scenario scenario;
    static Logger log = LoggerFactory.getLogger(DeviceCreation.class);
    final PropertiesReader propertiesReader = new PropertiesReader();

    final ChromeOptions options = new ChromeOptions();
    LoggingPreferences logPrefs = new LoggingPreferences();



    @Before("@Portal")
    public void setUp(Scenario scenario) throws IOException {
        propertiesReader.loadProperties();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        chromePrefs.put("autofill.profile_enabled","false");
        options.setExperimentalOption("prefs", chromePrefs);
        log.info("Currently executing Scenario -->" + scenario.getName());
        DeviceCreation.scenario = scenario;
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        if (PropertiesReader.browser_headless.equals("true")) {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--start-maximized");
            options.addArguments("--no-sandbox");
            options.addArguments("--allow-insecure-localhost");
            options.addArguments("window-size=1600,900");
            options.addArguments("disable-notifications");
            options.addArguments("test-type");
            options.addArguments("autofill.profile_disable");
            options.addArguments("--disable-popup-blocking");
            options.setAcceptInsecureCerts(true);
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
        }
        if (PropertiesReader.browser_required.equals("true")) {
            if (PropertiesReader.browser_type.equals("chrome")) {
                options.addArguments("start-maximized");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--silent");
                options.addArguments("--log-level=3");
                options.addArguments("--disable-extensions");
                options.addArguments("--test-type");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--start-maximized");
                options.setPageLoadStrategy(PageLoadStrategy.NONE);
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
            } else if (PropertiesReader.browser_type.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        new World().driverClass();
    }
    @After("@Portal")
    public void embedScreenshot(Scenario scenario) {
        driver.quit();
    }

    public WebDriver getBrowserDriver() {
        return driver;
    }
}
