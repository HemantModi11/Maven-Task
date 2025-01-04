package com.example.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;

   
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

   
    public void openLoginPage(String url) {
        driver.get(url);
    }

   
    public void setUsername(String username) {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);
    }

    
    public void setPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
    }

    
    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }

    
    public String getSuccessMessage() {
        WebElement messageElement = driver.findElement(By.id("flash"));
        return messageElement.getText();
    }

    

    
    public String getErrorMessage() {
        WebElement errorElement = driver.findElement(By.id("error"));
        return errorElement.getText();
    }
}
