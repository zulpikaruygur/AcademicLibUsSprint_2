package com.academiclibus.pages;


import com.academiclibus.utilities.Driver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }
}
