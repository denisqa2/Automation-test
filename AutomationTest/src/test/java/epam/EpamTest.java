package epam;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        Assertions.assertTrue(epamPage.getRequiredFirstName().getAttribute("aria-invalid").contains("true"));
        Assertions.assertTrue(epamPage.getRequiredLastName().getAttribute("aria-invalid").contains("true"));
        Assertions.assertTrue(epamPage.getRequiredPhone().getAttribute("aria-invalid").contains("true"));
        Assertions.assertTrue(epamPage.getRequiredEmail().getAttribute("aria-invalid").contains("true"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    public void logoTest(String browser) {
        driver = DriverSingleton.getDriver(browser);
        epamPage = new EpamPage(driver);
        driver.get("https://www.epam.com/about");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        epamPage.getTitle().click();
        Assertions.assertEquals("https://www.epam.com/", driver.getCurrentUrl());
    }

//    @ParameterizedTest
//    @ValueSource(strings = {"chrome", "firefox"})
//    public void modeTest(String browser) {
//        driver = DriverSingleton.getDriver(browser);
//        epamPage = new EpamPage(driver);
//        driver.get("https://www.epam.com");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
//        epamPage.getSwitcher().click();
//        WebElement currentState = epamPage.getDarkModePage();
//        if (currentState == epamPage.getDarkModePage()) {
//            Assertions.assertTrue(epamPage.getLightModePage().isDisplayed());
//        } else {
//            Assertions.assertTrue(epamPage.getDarkModePage().isDisplayed());
//        }
//    }

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    public void locationTest(String browser) {
        driver = DriverSingleton.getDriver(browser);
        epamPage = new EpamPage(driver);
        driver.get("https://www.epam.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        Assertions.assertNotNull(epamPage.getLocationAmericas().getAttribute("aria-selected"));
        Assertions.assertNotNull(epamPage.getLocationEmea().getAttribute("aria-selected"));
        Assertions.assertNotNull(epamPage.getLocationApac().getAttribute("aria-selected"));
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}