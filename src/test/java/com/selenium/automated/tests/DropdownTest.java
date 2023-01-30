package com.selenium.automated.tests;

import com.selenium.automation.base.BaseTestTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTestTemplate {

  @Test
  public void dropdownTest() {

    //open the main page
    String url = "https://the-internet.herokuapp.com/";
    driver.get(url);

    //navigate to the dropdown link
    driver.findElement(By.linkText("Dropdown")).click();
    String expectedUrl = "https://the-internet.herokuapp.com/dropdown";
    String actualUrl = driver.getCurrentUrl();
    Assert.assertEquals(actualUrl, expectedUrl);

    //select option2
    Select dropdown = new Select(driver.findElement(By.id("dropdown")));
    //dropdown.selectByVisibleText("Option 2");
    //dropdown.selectByIndex(2);
    dropdown.selectByValue("2");

    String selectedOption = dropdown.getFirstSelectedOption().getText();
    Assert.assertEquals(selectedOption, "Option 2");

  }
}
