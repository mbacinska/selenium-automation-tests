package com.selenium.automated.tests;

import com.selenium.automated.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFileTest extends BaseTest {

  @Test
  public void uploadFileTest() {

    //open the page
    String url = "https://the-internet.herokuapp.com/upload";
    driver.get(url);
    String actualUrl = driver.getCurrentUrl();
    Assert.assertEquals(actualUrl, url);

    //select the file
    String filePath = System.getProperty("user.dir") + "//src//main//resources//files//selenium.png";
    WebElement chooseFileElement = driver.findElement(By.id("file-upload"));
    chooseFileElement.sendKeys(filePath);

    //click upload
    WebElement uploadElement = driver.findElement(By.id("file-submit"));
    uploadElement.click();

    //verification - page message
    String expectedMessage = "File Uploaded!";
    WebElement messageElement = driver.findElement(By.tagName("h3"));
    String actualMessage = messageElement.getText();
    Assert.assertTrue(actualMessage.contains(expectedMessage));
    //verification - file name
    String expectedFileName = "selenium.png";
    WebElement uploadedFileName = driver.findElement(By.id("uploaded-files"));
    String actualUploadedFile = uploadedFileName.getText();
    Assert.assertTrue(actualUploadedFile.contains(expectedFileName));

  }
}
