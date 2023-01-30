package com.selenium.automation.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTestTemplate {

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

  public void implicitWait(){
    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

  }

}
