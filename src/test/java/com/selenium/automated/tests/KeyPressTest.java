package com.selenium.automated.tests;

import com.selenium.automated.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressTest extends BaseTest {


  @Test
  public void keyPressTest(){

    //open the page
    String url = "https://the-internet.herokuapp.com/key_presses";
    driver.get(url);
    String actualUrl = driver.getCurrentUrl();
    Assert.assertEquals(actualUrl,url);

    //press TAB key
    WebElement pageBody = driver.findElement(By.xpath("//body"));
    pageBody.sendKeys(Keys.TAB);

    //verification
    WebElement result = driver.findElement(By.id("result"));
    String expectedMessage = "You entered: TAB";
    String actualMessage = result.getText();
    Assert.assertTrue(actualMessage.contains(expectedMessage));

  }
}
