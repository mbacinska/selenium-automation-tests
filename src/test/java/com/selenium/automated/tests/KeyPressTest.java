package com.selenium.automated.tests;

import com.selenium.automation.base.BaseTestTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressTest extends BaseTestTemplate {

  @Test
  public void keyPressTest() {

    //open the page
    String url = "https://the-internet.herokuapp.com/key_presses";
    driver.get(url);
    String actualUrl = driver.getCurrentUrl();
    Assert.assertEquals(actualUrl, url);

    //press TAB key
//    WebElement pageBody = driver.findElement(By.xpath("//body"));
//    pageBody.sendKeys(Keys.TAB);

    Actions action = new Actions(driver);
    action.sendKeys(Keys.TAB).build().perform();

    //verification
    WebElement result = driver.findElement(By.id("result"));
    String expectedMessage = "You entered: TAB";
    String actualMessage = result.getText();
    Assert.assertTrue(actualMessage.contains(expectedMessage));

  }
}
