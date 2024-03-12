package epam;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class EpamTest {

    static EpamPage epamPage;
    static WebDriver driver;

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    public void setUp(String browser){
        driver = DriverSingleton.getDriver(browser);
        epamPage = new EpamPage(driver);
        driver.get("https://www.epam.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
        Assertions.assertEquals("EPAM", epamPage.getTitle().getAttribute("alt"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    public void languageTest(String browser) {
        driver = DriverSingleton.getDriver(browser);
        epamPage = new EpamPage(driver);
        driver.get("https://www.epam.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        epamPage.getSelectLanguage().click();
        epamPage.getSelectLanguageUa().click();
        Assertions.assertEquals("uk-UA", epamPage.getValidatelanguageUa().getAttribute("lang"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    public void policyTest(String browser) {
        driver = DriverSingleton.getDriver(browser);
        epamPage = new EpamPage(driver);
        driver.get("https://www.epam.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        Assertions.assertEquals("INVESTORS", epamPage.getInvestors().getText());
        Assertions.assertEquals("OPEN SOURCE", epamPage.getOpenSourse().getText());
        Assertions.assertEquals("PRIVACY POLICY", epamPage.getPrivacyPolicy().getText());
        Assertions.assertEquals("COOKIE POLICY", epamPage.getCookiePolicy().getText());
        Assertions.assertEquals("APPLICANT PRIVACY NOTICE", epamPage.getPrivacyNotice().getText());
        Assertions.assertEquals("WEB ACCESSIBILITY", epamPage.getWebAccessibilty().getText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    public void searchTest(String browser) {
        driver = DriverSingleton.getDriver(browser);
        epamPage = new EpamPage(driver);
        driver.get("https://www.epam.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        epamPage.getSearchIcon().click();
        epamPage.getSearchField().sendKeys("AI");
        epamPage.getFindButton().click();
        Assertions.assertTrue(epamPage.getFindResult().getText().contains("RESULTS FOR \"AI\""));
    }

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    public void formFieldsTest(String browser) {
        driver = DriverSingleton.getDriver(browser);
        epamPage = new EpamPage(driver);
        driver.get("https://www.epam.com/about/who-we-are/contact");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        epamPage.getSubmitFormButton().submit();
//        epamPage.getRequiredLastName().sendKeys("a");
//        epamPage.getRequiredEmail().sendKeys("a");
//        epamPage.getRequiredPhone().sendKeys("a");
        Assertions.assertEquals("This is a required field", epamPage.getRequiredFirstName().getText());

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
        //driver = null;
    }
}