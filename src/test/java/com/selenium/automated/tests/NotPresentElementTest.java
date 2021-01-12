package com.selenium.automated.tests;

import com.selenium.automated.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotPresentElementTest  extends BaseTest {

  @Test
  public void notPresentElementTest() {

    //open the page
    String url = "http://the-internet.herokuapp.com/dynamic_loading/2";
    driver.get(url);

    //click start button
    WebElement startButton = driver.findElement(By.xpath("//div[@id ='start']/button"));
    startButton.click();

    //verifications
    String expectedMessage = "Hello World!";
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement actualMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
    String messageText = actualMessage.getText();
    Assert.assertTrue(messageText.contains(expectedMessage));

  }
}
