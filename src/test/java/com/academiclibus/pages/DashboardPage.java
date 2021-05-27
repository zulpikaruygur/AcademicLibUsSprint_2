package com.academiclibus.pages;

import com.academiclibus.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage{

    //no need to explicitly write constructor, because it will use its parents constructor
    public DashboardPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(id="navbarDropdown")
    public WebElement userNameDropdown;
    @FindBy(xpath = "//a[@class='dropdown-item']")
    public WebElement logout;

    public void logOut(){
        userNameDropdown.click();
        logout.click();
    }
}