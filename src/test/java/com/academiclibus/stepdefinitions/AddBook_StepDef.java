package com.academiclibus.stepdefinitions;

import com.academiclibus.pages.AddBookPage;
import com.academiclibus.pages.LoginPage;
import com.academiclibus.utilities.BrowserUtils;
import com.academiclibus.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class AddBook_StepDef {

    private final AddBookPage addBookPage;
    private final LoginPage loginPage;

    public AddBook_StepDef(AddBookPage addBookPage, LoginPage loginPage){
        this.addBookPage = addBookPage;
        this.loginPage = loginPage;
    }

    //Background
    @Given("user is on Library Application")
    public void user_is_on_Library_Application() {
        System.out.println("user_is_on_Library_Application()");
        Driver.get().get("https://library3.cybertekschool.com/login.html");
    }

    @When("user logs in with {string} and {string} credentials")
    public void user_logs_in_with_and_credentials(String string, String string2) {
        System.out.println("user_logs_in_with_and_credentials()");
        loginPage.signInAsLibrarian();
    }

    @Then("user navigates to {string}")
    public void user_navigates_to(String string) {
        System.out.println("user_navigates_to()");
        BrowserUtils.waitFor(3);
        Driver.get().get("https://library3.cybertekschool.com/#books");
    }

    @Then("user clicks on {string} button")
    public void user_clicks_on_button(String string) {
        System.out.println("user_clicks_on_button()");
        BrowserUtils.waitFor(3);
        Driver.get().findElement(By.xpath("//*[@id=\"books\"]/div[1]/div[1]/span/a")).click();
    }

    //Scenario 23
    @When("user is on Add Book form")
    public void user_is_on_Add_Book_form() {
        System.out.println("user_is_on_Add_Book_form()");
        BrowserUtils.waitFor(3);
        Assert.assertTrue(Driver.get().findElement(By.id("add_book_modal")).isDisplayed());
    }

    @Then("user enters book information:")
    public void user_enters_book_information(List<Map<String, String>> dataTable) {
        System.out.println("user_enters_book_information()");
        dataTable.forEach(book -> {
            System.out.println("user_enters_book_information() book: " + book);
            String bookName = book.get("Book_Name");
            String author = book.get("Author");
            String year = book.get("Year");
            String isbn = book.get("ISBN");
            String bookCategory = book.get("Book_Category");
            String bookDescription = book.get("Book_Description");
            //
        //| Book Name | ISBN | Year | Author | Book Category | Book Description |

            addBookPage.addBook(bookName, author, isbn, year, bookCategory, bookDescription );
        });
    }


    //Scenario 24
    @Then("user should be able to see name, author, description, category, ISBN, year parameters")
    public void user_should_be_able_to_see_name_author_description_category_ISBN_year_parameters() {
        System.out.println("user_should_be_able_to_see_name_author_description_category_ISBN_year_parameters()");
        BrowserUtils.waitFor(3);
        WebDriver driver = Driver.get();
        Assert.assertTrue(driver.findElements(By.xpath("//*[@id=\"add_book_form\"]/div[1]/div/div[1]/div[1]/div/input")).size() > 0);
        Assert.assertTrue(driver.findElements(By.xpath("//*[@id=\"add_book_form\"]/div[1]/div/div[2]/div[1]/div/input")).size() > 0);
        Assert.assertTrue(driver.findElements(By.xpath("//*[@id=\"add_book_form\"]/div[1]/div/div[1]/div[2]/div/input")).size() > 0);
        Assert.assertTrue(driver.findElements(By.xpath("//*[@id=\"add_book_form\"]/div[1]/div/div[1]/div[3]/div/input")).size() > 0);
        Assert.assertTrue(driver.findElements(By.id("book_group_id")).size() > 0);
        Assert.assertTrue(driver.findElements(By.id("description")).size() > 0);
    }

    //Scenario 25
    @Then("user enters {string}, {string},{string},{string}, {string}")
    public void user_enters(String bookName, String author, String year, String isbn, String shouldPass) {
        System.out.println("user_enters()");
        addBookPage.addBook(bookName, author, isbn, year, null,null );
        BrowserUtils.waitFor(1);
        boolean success = Driver.get().findElements(By.xpath("//*[@id=\"toast-container\"]")).size() > 0;
        System.out.println("success " + success);
        if(success && shouldPass.contains("false")){
            Assert.fail("Book Should not be added!");
        }
    }

    //Scenario 26
    @Then("librarian enters {string}, {string},{string},{string},{string}")
    public void librarian_enters(String bookName, String author, String isbn, String year, String shouldPass) {
        System.out.println("librarian_enters");
        addBookPage.addBook(bookName, author, isbn, year, null,null );
        BrowserUtils.waitFor(1);
        boolean success = Driver.get().findElements(By.xpath("//*[@id=\"toast-container\"]")).size() > 0;
        System.out.println("success " + success);
        if(success && shouldPass.contains("false")){
            Assert.fail("Book Should not be added!");
        }
    }

    //Scenario 27
    @Then("user should click {string} dropdown list")
    @Then("user should click Book Category dropdown list")
    public void user_should_click_Book_Category_dropdown_list() {
        System.out.println("user_should_click_Book_Category_dropdown_list");
        BrowserUtils.waitFor(3);
        Driver.get().findElement(By.id("book_group_id")).click();
    }


    @Then("check categories that should be present")
    public void check_categories_that_should_be_present(List<String> dataTable) {
        System.out.println("check_categories_that_should_be_present");
        Select bookCategorySelect = new Select(Driver.get().findElement(By.id("book_group_id")));
        List<WebElement> options = bookCategorySelect.getOptions();
        for (int c = 0; c < dataTable.size(); c++) {
            String category = dataTable.get(c);
            boolean exists = false;
            for (int i = 0; i < options.size(); i++) {
                if (options.get(i).getText().equals(category)){
                    exists = true;
                    break;
                }
            }
            if (exists == false){
                Assert.fail("Category not exist " + category);
            }
        }
    }
}
