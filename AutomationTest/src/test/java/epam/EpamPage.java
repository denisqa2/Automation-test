package epam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EpamPage {
    public WebDriver driver;
    public EpamPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//img[@class='header__logo header__logo-light']")
    private WebElement title;

    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div[1]/header/div/div/section/div")
    private WebElement switcher;
    @FindBy(xpath = "//body[@class='fonts-loaded light-mode']")
    private WebElement lightModePage;

    @FindBy(xpath = "//body[@class='fonts-loaded dark-mode']")
    private WebElement darkModePage;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[1]/header/div/div/ul/li[2]/div/div/button/span")
    //"//span[@class='location-selector__button-language']"
    private WebElement selectLanguage;

    @FindBy(xpath = "//a[@href='https://careers.epam.ua'][@class='location-selector__link']")
    private WebElement selectLanguageUa;

    @FindBy(xpath = "//html[@lang='uk-UA']")
    private WebElement validatelanguageUa;

    @FindBy(xpath = "//a[@href='/investors']")
    private WebElement investors;

    @FindBy(xpath = "//a[@href='/cookie-policy']")
    private WebElement cookiePolicy;

    @FindBy(xpath = "//a[@href='/services/engineering/open-source'][@class='fat-links']")
    private WebElement openSourse;

    @FindBy(xpath = "//a[@href='/applicant-privacy-notice']")
    private WebElement privacyNotice;

    @FindBy(xpath = "//a[@href='https://privacy.epam.com/core/interaction/showpolicy?type=CommonPrivacyPolicy']")
    private WebElement privacyPolicy;

    @FindBy(xpath = "//a[@href='/web-accessibility-statement']")
    private WebElement webAccessibilty;

    @FindBy(xpath = "//a[text()='AMERICAS']")
    private WebElement locationAmericas;

    @FindBy(xpath = "//div[@class='tabs-23__title js-tabs-title']/a[text()='EMEA']")
         //   "//a[text()='EMEA']"
    private WebElement locationEmea;


    @FindBy(xpath = "//a[text()='APAC']")
    private WebElement locationApac;

    @FindBy(xpath = "//a[text()='EMEA'][@aria-selected='true']")
    private WebElement verifyLocationEmea;

    @FindBy(xpath = "//span[@class='search-icon dark-iconheader-search__search-icon']")
    private WebElement searchIcon;

    @FindBy(xpath = "//input[@id ='new_form_search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class='custom-button button-text font-900 gradient-border-button large-gradient-button uppercase-text custom-search-button']")
    private WebElement findButton;

    @FindBy(xpath = "//h2[contains(text(), 'results for')]")
    private WebElement findResult;

    @FindBy(xpath = "//input[@id='_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_first_name']")
    private WebElement requiredFirstName;

    @FindBy(xpath = "//input[@id='_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_last_name']")
    private WebElement requiredLastName;

    @FindBy(xpath = "//input[@id='_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_email']")
    private WebElement requiredEmail;

    @FindBy(xpath = "//input[@id='_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_phone']")
    private WebElement requiredPhone;

    @FindBy(xpath = "//button[@class='button-ui'][text()='Submit']")
    private WebElement submitFormButton;

    @FindBy(xpath = "//a[@href='https://www.epam.com/content/dam/epam/free_library/EPAM_Corporate_Overview_Q4_EOY.pdf']")
    private WebElement atGlanceDownload;

    public WebElement getTitle() {
        return title;
    }

    public WebElement getSwitcher() {
        return switcher;
    }

    public WebElement getLightModePage() {
        return lightModePage;
    }

    public WebElement getDarkModePage() {
        return darkModePage;
    }

    public WebElement getSelectLanguage() {
        return selectLanguage;
    }

    public WebElement getSelectLanguageUa() {
        return selectLanguageUa;
    }

    public WebElement getValidatelanguageUa() {
        return validatelanguageUa;
    }

    public WebElement getInvestors() {
        return investors;
    }

    public WebElement getCookiePolicy() {
        return cookiePolicy;
    }

    public WebElement getOpenSourse() {
        return openSourse;
    }

    public WebElement getPrivacyNotice() {
        return privacyNotice;
    }

    public WebElement getPrivacyPolicy() {
        return privacyPolicy;
    }

    public WebElement getWebAccessibilty() {
        return webAccessibilty;
    }

    public WebElement getLocationAmericas() {
        return locationAmericas;
    }

    public WebElement getLocationEmea() {
        return locationEmea;
    }

    public WebElement getLocationApac() {
        return locationApac;
    }

    public WebElement getVerifyLocationEmea() {
        return verifyLocationEmea;
    }

    public WebElement getSearchIcon() {
        return searchIcon;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getFindButton() {
        return findButton;
    }

    public WebElement getFindResult() {
        return findResult;
    }

    public WebElement getRequiredFirstName() {
        return requiredFirstName;
    }

    public WebElement getRequiredLastName() {
        return requiredLastName;
    }

    public WebElement getRequiredEmail() {
        return requiredEmail;
    }

    public WebElement getRequiredPhone() {
        return requiredPhone;
    }

    public WebElement getSubmitFormButton() {
        return submitFormButton;
    }

    public WebElement getAtGlanceDownload() {
        return atGlanceDownload;
    }
}
