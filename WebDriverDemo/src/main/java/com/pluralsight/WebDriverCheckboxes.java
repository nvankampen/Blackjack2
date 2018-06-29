package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by User on 1/9/2018.
 */
public class WebDriverCheckboxes {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("C:\\Users\\User\\Desktop\\Training\\Pluralsight\\IntelliJIDEA\\WebDriverDemo\\target\\classes\\CheckboxTest.html");

        WebElement checkbox = driver.findElement(By.id("lettuceCheckbox"));
        checkbox.click();
    }
}
