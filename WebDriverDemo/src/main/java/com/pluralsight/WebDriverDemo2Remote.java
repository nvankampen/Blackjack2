package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class WebDriverDemo2Remote {

    public static void main(String[] args) throws Exception {

//the URL comes from setting up the server
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.chrome());
        driver.get("http://www.google.com");

        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.sendKeys("pluralsight");
        searchField.submit();

        //This is an implicit wait
        //driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        //This is an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Images")));


        //Finds the element "Images" from an array at position 0 (could have used "findElement" without an array)
        WebElement imagesLink = driver.findElements(By.linkText("Images")).get(0);
        imagesLink.click();

        WebElement imageLink = driver.findElement(By.name("ZBcDLh9QtUvMIM:"));
        imageLink.click();

        WebElement viewImage = driver.findElement(By.xpath("//*[@id=\"irc_cc\"]/div[2]/div[3]/div[1]/div/table[1]/tbody/tr/td[2]/a/span"));
        viewImage.click();

        //WebElement viewImage = viewImageElement.getAttribute("data-href")
    }
}

