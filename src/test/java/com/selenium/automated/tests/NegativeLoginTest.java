package com.selenium.automated.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest {

  @Test
  public void negativeUsernameTest() throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe/");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    //open the page
    String url = "https://the-internet.herokuapp.com/login";
    driver.get(url);
    //enter username
    WebElement username = driver.findElement(By.id("username"));
    username.sendKeys("wrong");
    //enter password
    WebElement password = driver.findElement(By.id("password"));
    password.sendKeys("SuperSecretPassword!");
    //click login button
    WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
    submit.click();
    //verifications
    String actualUrl = driver.getCurrentUrl();
    Assert.assertEquals(actualUrl, url, "Actual page url is not the same as expected");

    String expectedMessage = "Your username is invalid!";
    WebElement actualMessage = driver.findElement(By.xpath("//div[@id='flash']"));
    String messageText = actualMessage.getText();
    Assert.assertTrue(messageText.contains(expectedMessage));

    driver.quit();
  }

  @Test
  public void negativePasswordTest() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe/");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    //open the page
    String url = "https://the-internet.herokuapp.com/login";
    driver.get(url);
    //enter username
    WebElement username = driver.findElement(By.id("username"));
    username.sendKeys("tomsmith");
    //enter password
    WebElement password = driver.findElement(By.id("password"));
    password.sendKeys("WrongPassword!");
    //click login button
    WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
    submit.click();
    //verifications
    String actualUrl = driver.getCurrentUrl();
    Assert.assertEquals(actualUrl, url, "Actual page url is not the same as expected");

    String expectedMessage = "Your password is invalid!";
    WebElement actualMessage = driver.findElement(By.xpath("//div[@id='flash']"));
    String messageText = actualMessage.getText();
    Assert.assertTrue(messageText.contains(expectedMessage));

    driver.quit();
  }
}
