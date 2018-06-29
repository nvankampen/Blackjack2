package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by User on 1/12/2018.
 */
public class WebDriverGetLinks {

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.pluralsight.com");

        //Gets all links on the page that have "a" anchor tag, then prints them all out
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links are: "+links.size());
        for(int i=0; i<links.size(); i++) {
            System.out.println(links.get(i).getAttribute("href"));
        }

    }
}
