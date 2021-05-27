package com.academiclibus.stepdefinitions;

import com.academiclibus.pages.DashboardPage;
import com.academiclibus.pages.LoginPage;
import com.academiclibus.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Logout {
    private DashboardPage dashboardPage = new DashboardPage();

    @Given("the user is on the dashboard page")
    public void the_user_is_on_the_dashboard_page() {
        Driver.get().get("https://library3.cybertekschool.com/#dashboard");
        new LoginPage().signInAsStudent();
    }
    @When("user navigates to the top corner of the page")
    public void user_navigates_to_the_top_corner_of_the_page()  throws Exception{
        Thread.sleep(2000);
        System.out.println("Navigating to username");
    }
    @When("clicks on the user name item")
    public void clicks_on_the_user_name_item() throws Exception{
        Thread.sleep(2000);
        dashboardPage.userNameDropdown.click();
    }
    @When("the logout button should be clickable")
    public void the_logout_button_should_be_clickable() throws Exception{
        Thread.sleep(2000);
        Assert.assertTrue(dashboardPage.logout.isEnabled());
    }
    @When("user clicks the button")
    public void user_clicks_the_button() throws Exception{
        Thread.sleep(2000);
        dashboardPage.logout.click();
    }
    @Then("user should be in the login page")
    public void user_should_be_in_the_login_page() throws Exception{
        Thread.sleep(2000);
        Assert.assertEquals("https://library3.cybertekschool.com/login.html", Driver.get().getCurrentUrl());
    }
}