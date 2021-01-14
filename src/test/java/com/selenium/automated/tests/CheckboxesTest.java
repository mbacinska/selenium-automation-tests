package com.selenium.automated.tests;

import com.selenium.automated.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest extends BaseTest {

  @Test
  public void checkboxesTest() {

    //open main page
    String url = "https://the-internet.herokuapp.com/";
    driver.get(url);

    //navigate to chekboxes subpage
    driver.findElement(By.linkText("Checkboxes")).click();
    String expectedUrl = "https://the-internet.herokuapp.com/checkboxes";
    String actualUrl = driver.getCurrentUrl();
    Assert.assertEquals(actualUrl, expectedUrl);

    //click checkbox
    WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(checkbox1));
    checkbox1.click();

    Assert.assertTrue(checkbox1.isSelected());

  }
}
