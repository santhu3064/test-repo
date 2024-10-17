package support;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public static String browser_headless;

    public static String browser_required;
    public static String browser_type;

    public static String platform_url;

    public static String yopMail_url;

    public static String NewRegisterUserEmail;

    public static String NewRegisterMobileNumber;

    public static String Password;

    public static String NewPassword;

    public static String CompanyNameTest;

    public static String CompanyPhoneTest;

    public static String CompanyEmailTest;

    public static String CompanyAddressTest;

    public static String CompanyStateTest;

    public static String CompanyGSTIN;


    public void loadProperties() throws IOException {
        Properties settings = new Properties();
        Properties data = new Properties();

        settings.load(new FileInputStream("config/settings.properties"));
        data.load(new FileInputStream("data/commonData.properties"));

        browser_required = settings.getProperty("browser.required");
        browser_type = settings.getProperty("browser.type");
        browser_headless = settings.getProperty("browser.headless");
        platform_url = settings.getProperty("platform_url");
        yopMail_url = settings.getProperty("yopMail_url");
        NewRegisterUserEmail = data.getProperty("NewRegisterUserEmail");
        NewRegisterMobileNumber = data.getProperty("NewRegisterMobileNumber");
        Password = data.getProperty("Password");
        NewPassword = data.getProperty("NewPassword");
        CompanyNameTest = data.getProperty("CompanyNameTest");
        CompanyPhoneTest = data.getProperty("CompanyPhoneTest");
        CompanyEmailTest = data.getProperty("CompanyEmailTest");
        CompanyGSTIN = data.getProperty("CompanyGSTIN");
        CompanyAddressTest = data.getProperty("CompanyAddressTest");
        CompanyStateTest = data.getProperty("CompanyStateTest");

        // Override browser_headless with the system property if it exists
        browser_headless = System.getProperty("browser.headless",
                              settings.getProperty("browser.headless", "false"));
    }

}