package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by User on 1/9/2018.
 */
public class WebDriverRadioButtons {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("C:\\Users\\User\\Desktop\\Training\\Pluralsight\\IntelliJIDEA\\WebDriverDemo\\target\\classes\\RadioButtonTest.html");

        List<WebElement> radioButtons = driver.findElements(By.name("color"));
        radioButtons.get(1).click();

        for (WebElement buttonTemp : radioButtons) {
            if (buttonTemp.isSelected()){
                System.out.print(buttonTemp.getAttribute("value"));
            }
        }
    }
}
