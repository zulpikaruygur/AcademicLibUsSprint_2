package com.academiclibus.pages;

import com.academiclibus.utilities.ConfigurationReader;
import com.academiclibus.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;


    @FindBy(css = "[type='submit']")
    public WebElement signIn;


    public void signInAsLibrarian(){

        String email = ConfigurationReader.get("libUsername");
        String password = ConfigurationReader.get("libPassword");

        signIn(email,password);
    }


    public void signIn(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signIn.click();
    }
}