package com.academiclibus.stepdefinitions;

import com.academiclibus.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {

    @After
    public void tearDown(){
        Driver.closeDriver();
    }
}
