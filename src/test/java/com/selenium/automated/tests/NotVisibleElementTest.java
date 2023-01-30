package com.selenium.automated.tests;

import com.selenium.automation.base.BaseTestTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotVisibleElementTest extends BaseTestTemplate {

  @Test
  public void notVisibleElementTest()  {

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

  }
}
