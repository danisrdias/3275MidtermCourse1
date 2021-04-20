package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnimalPage {
    @FindBy(id = "animalText")
    private WebElement animal;

    @FindBy(id = "adjective")
    private WebElement adjectvie;

    public AnimalPage(WebDriver driver){
        PageFactory.initElements(driver, this);}

}
