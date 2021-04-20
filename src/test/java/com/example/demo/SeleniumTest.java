package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest
public class SeleniumTest {


    public static void main(String[] args) throws InterruptedException {

        // setup Webdriver and open a Chrome browser at localhost:8080/animal
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/animal");
        WebElement inputAnimal = driver.findElement(By.name("animalName"));
        inputAnimal.sendKeys("dogs");
        WebElement inputAdjective = driver.findElement(By.name("adjective"));
        inputAdjective.sendKeys("funny");
        inputAnimal.submit();
        inputAdjective.submit();

        Thread.sleep(5000);
        driver.quit();
        // close the browser after 5 seconds
    }
}