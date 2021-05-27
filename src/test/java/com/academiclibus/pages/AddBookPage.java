package com.academiclibus.pages;

import com.academiclibus.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddBookPage {

    @FindBy(xpath = "//*[@id=\"add_book_form\"]/div[1]/div/div[1]/div[1]/div/input")
    public WebElement bookName;

    @FindBy(xpath = "//*[@id=\"add_book_form\"]/div[1]/div/div[2]/div[1]/div/input")
    public WebElement author;

    @FindBy(xpath = "//*[@id=\"add_book_form\"]/div[1]/div/div[1]/div[2]/div/input")
    public WebElement isbn;

    @FindBy(xpath = "//*[@id=\"add_book_form\"]/div[1]/div/div[1]/div[3]/div/input")
    public WebElement year;

    @FindBy(id = "book_group_id")
    public WebElement bookCategory;

    @FindBy(id = "description")
    public WebElement bookDescription;

    @FindBy(xpath = "//*[@id=\"add_book_form\"]/div[2]/button[2]")
    public WebElement saveChangesBtn;

    public AddBookPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    public void addBook(String bookNameInput, String authorInput, String isbnInput, String yearInput, String bookCategoryInput, String bookDescriptionInput){
        bookName.sendKeys(bookNameInput);
        author.sendKeys(authorInput);
        isbn.sendKeys(isbnInput);
        year.sendKeys(yearInput);
        if(bookCategoryInput != null) {
            Select bookCategorySelect = new Select(bookCategory);
            bookCategorySelect.selectByVisibleText(bookCategoryInput);
        }
        if(bookDescriptionInput != null) {
            bookDescription.sendKeys(bookDescriptionInput);
        }
        saveChangesBtn.click();
    }
}
