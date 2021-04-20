package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.Assert.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeleniumJUnitTest {
    @LocalServerPort
    private Integer port;
    private static WebDriver driver;
    private AnimalPage animalPage;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void beforeEach() {
        driver.get("http://localhost:" + port + "/animal");
        animalPage = new AnimalPage(driver);
    }

    @Test
    public void maintest () {
        // perform an automated test with
            // animal: dog
            // adjective: funny
        WebElement inputAnimal = driver.findElement(By.name("animalName"));
        inputAnimal.sendKeys("dogs");
        WebElement inputAdjective = driver.findElement(By.name("adjective"));
        inputAdjective.sendKeys("funny");
        inputAnimal.submit();
        inputAdjective.submit();
        WebElement display = driver.findElement(By.className("trainingMessage"));

        assertEquals("We love funny dogs.", display);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
