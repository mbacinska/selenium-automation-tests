package com.selenium.automated.base;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

  protected WebDriver driver;

  @BeforeMethod(alwaysRun = true)
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/files/chromedriver.exe/");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    driver.quit();
  }

  // add cookie
  public void setCookie(Cookie ck) {
    driver.manage().addCookie(ck);
  }

  // get cookie value using cookie name
  public String getCookie(String name) {
    return driver.manage().getCookieNamed(name).getValue();
  }
}
