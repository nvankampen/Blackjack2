package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by User on 1/10/2018.
 */
public class WebDriverTables {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("C:\\Users\\User\\Desktop\\Training\\Pluralsight\\IntelliJIDEA\\WebDriverDemo\\src\\main\\resources\\TableTest.html");
//Using brute force to find the value within nested tables
        WebElement outerTable = driver.findElement(By.tagName("table"));
        WebElement innerTable = outerTable.findElement(By.tagName("table"));
        WebElement row = innerTable.findElements(By.tagName("td")).get(1);
        System.out.println(row.getText());

//Using Xpath to find value in tables
        WebElement tableValue = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/table/tbody/tr[2]/td"));
        System.out.println(tableValue.getText());
    }
}
