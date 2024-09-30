package support;
import org.openqa.selenium.WebDriver;
import pages.*;

public class World {

    public static WebDriverHelper webDriverHelper;

    public static loginPage objLoginPage;

    public static logoutPage objLogoutPage;

    public static passwordReset objPasswordReset;

    public static mailinatorPage objMailinatorPage;

    public static registrationPage objRegistrationPage;

    public static profilePage objProfilePage;

    final WebDriver driver = new DeviceCreation().getBrowserDriver();

    public void driverClass() {
        World.webDriverHelper = new WebDriverHelper(driver);
        World.objLoginPage = new loginPage(driver);
        World.objMailinatorPage = new mailinatorPage(driver);
        World.objRegistrationPage = new registrationPage(driver);
        World.objLogoutPage = new logoutPage(driver);
        World.objPasswordReset = new passwordReset(driver);
        World.objProfilePage = new profilePage(driver);
    }
}

