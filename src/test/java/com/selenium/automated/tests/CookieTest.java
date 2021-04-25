package com.selenium.automated.tests;

import com.selenium.automated.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CookieTest extends BaseTest {

  @Test
  public void cookieTest() {

    //open the page
    String url = "https://the-internet.herokuapp.com/login";
    driver.get(url);
    // set cookie
    Cookie ck = new Cookie("userCk", "tom", "/", null);
    setCookie(ck);
    //enter username
    WebElement username = driver.findElement(By.id("username"));
    username.sendKeys("tomsmith");
    //enter password
    WebElement password = driver.findElement(By.id("password"));
    password.sendKeys("SuperSecretPassword!");
    //click login button
    WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
    submit.click();
    // get cookies values
    String userCookie = getCookie("userCk");
    System.out.println("User cookie: " +userCookie);
    String sessionCookie = getCookie("rack.session");
    System.out.println("Session cookie:" + sessionCookie);
    //verifications
    String expectedUrl = "https://the-internet.herokuapp.com/secure";
    String actualUrl = driver.getCurrentUrl();
    Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

    WebElement logoutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
    Assert.assertTrue(logoutButton.isDisplayed(), "Logout button is not displayed");

    String expectedMessage = "You logged into a secure area!";
    WebElement actualMessage = driver.findElement(By.xpath("//div[@id='flash']"));
    String messageText = actualMessage.getText();
    Assert.assertTrue(messageText.contains(expectedMessage));

  }
}
