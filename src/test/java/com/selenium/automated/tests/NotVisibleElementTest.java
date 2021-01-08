package com.selenium.automated.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotVisibleElementTest {

  @Test
  public void notVisibleElementTest()  {

    //setUp
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe/");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    //open the page
    String url = "http://the-internet.herokuapp.com/dynamic_loading/1";
    driver.get(url);

    //click start button
    WebElement startButton = driver.findElement(By.xpath("//div[@id ='start']/button"));
    startButton.click();

    //verifications
    String expectedMessage = "Hello World!";
    WebElement actualMessage = driver.findElement(By.xpath("//div[@id='finish']"));

    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOf(actualMessage));
    String messageText = actualMessage.getText();
    Assert.assertTrue(messageText.contains(expectedMessage));

    //close browser
    driver.quit();

  }
}
