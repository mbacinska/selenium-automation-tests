package com.selenium.automation.pages;

import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage {
  private String welcomePageUrl = "";

  public WelcomePage(WebDriver driver) {
    super(driver);
  }

  public void openPage() {
    openUrl(welcomePageUrl);
  }
}
