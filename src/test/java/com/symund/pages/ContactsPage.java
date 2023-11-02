package com.symund.pages;

import com.github.javafaker.Faker;
import com.symund.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactsPage {

    private Faker faker;

    public ContactsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
        this.faker = new Faker();
    }

    public void fillContactForm(){

        newContactName.clear();
        newContactName.sendKeys(faker.name().fullName());
        newContactCompany.sendKeys(faker.company().name());
        newContactTitle.sendKeys(faker.job().title());
        newContactPhoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        newContactEmail.sendKeys(faker.internet().emailAddress());
        newContactPostOfficeBox.sendKeys("P.O. Box: "+faker.number().numberBetween(1000,9999));
        newContactAddress.sendKeys(faker.address().streetAddress());
        newContactPostalCode.sendKeys(faker.address().zipCode());
        newContactCity.sendKeys(faker.address().city());
        newContactState.sendKeys(faker.address().state());
        newContactCountry.sendKeys(faker.address().country());


    }

    public void listOfAvailableGroups(List<String> groupList){
        List<WebElement> listOfGroups = newGroup.findElements(By.tagName("li"));
        for (WebElement eachElement : listOfGroups) {
            if (eachElement.getText().replace(" ","").contains(groupList.toString())){

            }
        }
    }

    @FindBy(xpath = "//a[normalize-space(.)='Contacts'][1]")
    public WebElement contactsModule;

    @FindBy(xpath = "//span[@title='+ New group']")
    public WebElement newGroup;

    @FindBy(xpath = "//input[@class='action-input__input focusable']")
    public WebElement newGroupName;

    @FindBy(xpath = "//button[@id='new-contact-button']")
    public WebElement newContact;

    @FindBy(id = "contact-fullname")
    public WebElement newContactName;

    @FindBy(id = "contact-title")
    public WebElement newContactTitle;

    @FindBy(id = "contact-org")
    public WebElement newContactCompany;

    @FindBy(xpath = "//input[@inputmode='tel']")
    public WebElement newContactPhoneNumber;

    @FindBy(xpath = "//input[@inputmode='email']")
    public WebElement newContactEmail;

    @FindBy(xpath = "//div[@class='property__row' and normalize-space(.)='Post office box']//input")
    public WebElement newContactPostOfficeBox;

    @FindBy(xpath = "//div[@class='property__row' and normalize-space(.)='Address']//input")
        public WebElement newContactAddress;

    @FindBy(xpath = "//div[@class='property__row' and normalize-space(.)='Postal code']//input")
    public WebElement newContactPostalCode;

    @FindBy(xpath = "//div[@class='property__row' and normalize-space(.)='City']//input")
    public WebElement newContactCity;

    @FindBy(xpath = "//div[@class='property__row' and normalize-space(.)='State or province']//input")
    public WebElement newContactState;

    @FindBy(xpath = "//div[@class='property__row' and normalize-space(.)='Country']//input")
    public WebElement newContactCountry;

    @FindBy(xpath = "//input[@placeholder='Choose property type']")
    public WebElement newContactPropertySelection;

    @FindBy(xpath = "//div[contains(@prop-name,'anniversary')]")
    public WebElement newContactAnniversaryBlock;

    @FindBy(xpath = "//div[@title='Anniversary']")
    public WebElement anniversaryOption;

    @FindBy(xpath = "//div[@class='app-navigation-entry__counter']")
    public WebElement numberOfContactsInNewGroup;



























}
