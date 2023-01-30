package com.selenium.automated.tests;

import com.selenium.automation.base.BaseTestTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DemoTest extends BaseTestTemplate {

  private String pageUrl = "https://todomvc.com/examples/typescript-angular/#/";

  @Test
  public void shouldCheckItems() throws InterruptedException {
    //given
    List<String> inputs = List.of("shooping", "cooking", "washing");
    driver.get(pageUrl);

    //when
    WebElement todos = driver.findElement(By.xpath("/html/body/section/header/form/input"));
    for (String input : inputs) {
      todos.sendKeys(input);
      todos.sendKeys(Keys.ENTER);
    }

    //then
    Thread.sleep(3000);
    WebElement todosList = driver.findElement(By.className("todo-list"));
    List<WebElement> webElementList = todosList.findElements(By.className("ng-scope"));
    System.out.println("List size is :" + webElementList.size());

    assertEquals(webElementList.size(), 3, "List has a different size than 3");

    for (WebElement elem : webElementList) {
      String itemText = elem.findElement(By.className("ng-binding")).getText();
      System.out.println(itemText);
      assertTrue(inputs.contains(itemText), "Failed to find " + itemText + "in the list of expected inputs" + inputs);
    }
  }
}
