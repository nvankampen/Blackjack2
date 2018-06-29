package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AutoEdgeTest1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");

        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.sendKeys("pluralsight");
        searchField.submit();


        WebElement username = driver.findElement(By.id("lst-ib"));
        username.sendKeys("hello");


    }

}
