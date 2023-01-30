package com.selenium.automated.tests;

import com.selenium.automation.base.BaseTestTemplate;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTestTemplate {

  @BeforeMethod
  public void navigateToPageWithAlerts() {
    //open the main page
    String url = "https://the-internet.herokuapp.com/";
    driver.get(url);

    //navigate to alerts subpage
    driver.findElement(By.linkText("JavaScript Alerts")).click();
    String expectedUrl = "https://the-internet.herokuapp.com/javascript_alerts";
    String actualUrl = driver.getCurrentUrl();
    Assert.assertEquals(actualUrl, expectedUrl);
  }

  @Test(priority = 1)
  public void jsAlertTest() {

    //click js alert
    driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    String expectedAlertText = "I am a JS Alert";
    String alertText = alert.getText();
    Assert.assertEquals(alertText, expectedAlertText);
    alert.accept();

    //verification
    WebElement result = driver.findElement(By.id("result"));
    String presentedText = result.getText();
    Assert.assertTrue(presentedText.contains("You successfuly clicked an alert"));
  }

  @Test(priority = 2)
  public void jsConfirmTest() {

    //click js confirm
    driver.findElement(By.xpath("//button[text() ='Click for JS Confirm']")).click();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    String expectedAlertText = "I am a JS Confirm";
    String alertText = alert.getText();
    Assert.assertEquals(alertText, expectedAlertText);
    alert.dismiss();

    //verification
    WebElement result = driver.findElement(By.id("result"));
    String presentedText = result.getText();
    Assert.assertTrue(presentedText.contains("You clicked: Cancel"));
  }

  @Test(priority = 3)
  public void jsPromptTest() {

    //click js prompt
    driver.findElement(By.xpath("//button[text() ='Click for JS Prompt']")).click();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    alert.sendKeys("Monika Bacinska");
    alert.accept();

    //verification
    WebElement result = driver.findElement(By.id("result"));
    String presentedText = result.getText();
    Assert.assertTrue(presentedText.contains("Monika Bacinska"));
  }

}
