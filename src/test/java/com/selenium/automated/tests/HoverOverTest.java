package com.selenium.automated.tests;

import com.selenium.automated.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverOverTest extends BaseTest {

  @Test
  public void hoverOverTest() {

    //open the page
    String url = "https://the-internet.herokuapp.com/hovers";
    driver.get(url);
    String actualUrl = driver.getCurrentUrl();
    Assert.assertEquals(actualUrl, url);

    WebElement avatarElement = driver.findElement(By.xpath("//div[@class='figure'][1]"));
    Actions action = new Actions(driver);
    action.moveToElement(avatarElement).build().perform();
    avatarElement.findElement(By.xpath("//a[contains(text(), 'View profile')]")).click();

    String expectedUrl = "https://the-internet.herokuapp.com/users/1";
    String currentUrl = driver.getCurrentUrl();
    Assert.assertEquals(expectedUrl, currentUrl);

  }
}
