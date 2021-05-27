package com.academiclibus.pages;

import com.academiclibus.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@id='menu_item']/li[1]")
    public WebElement dashboardButton;

    @FindBy(xpath = "//*[@id='menu_item']/li[2]")
    public WebElement usersButton;

    @FindBy(xpath = "//*[@id='menu_item']/li[3]")
    public WebElement librarianBooksButton;

    @FindBy(xpath = "//*[@id='menu_item']/li[1]")
    public WebElement studentBooksButton;

    @FindBy(xpath = "//*[@id='menu_item']/li[2]")
    public WebElement borrowingBooksButton;

}