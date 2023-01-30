package com.selenium.automated.tests;

import com.selenium.automation.base.BaseTestTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicElementTest extends BaseTestTemplate {

  @Test
  public void dynamicElementTest() {

    //open the page
    String url = "https://the-internet.herokuapp.com/dynamic_controls";
    driver.get(url);

    //click remove button
    WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
    WebDriverWait wait = new WebDriverWait(driver, 10);
    removeButton.click();

    //verifications
    WebElement checkboxElement = driver.findElement(By.id("checkbox"));
    Assert.assertTrue(wait.until(ExpectedConditions.stalenessOf(checkboxElement)));

    //click add button
    WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
    addButton.click();

    //verifications
    WebElement checkBoxElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
    Assert.assertTrue(checkBoxElement2.isDisplayed());

  }
}
