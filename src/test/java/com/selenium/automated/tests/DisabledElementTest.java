package com.selenium.automated.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElementTest {

  @Test
  public void disabledElementTest() throws InterruptedException {

    //setUp
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe/");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    //open the page
    String url = "https://the-internet.herokuapp.com/dynamic_controls";
    driver.get(url);

    //click enable button
    WebElement textField = driver.findElement(By.xpath("(//input)[2]"));
    WebElement enableButton = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));

    enableButton.click();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(textField));

    //write text
    textField.sendKeys("Bla bla bla");

    //verification
    Assert.assertEquals(textField.getAttribute("value"), "Bla bla bla");

    //close browser
    driver.quit();
  }
}
