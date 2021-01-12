package com.selenium.automated.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

  protected WebDriver driver;

  @BeforeMethod(alwaysRun = true)
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe/");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    driver.quit();
  }
}
