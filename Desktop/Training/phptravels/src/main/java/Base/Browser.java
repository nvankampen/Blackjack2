package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class Browser {
    public static WebDriver driver = null;

    public Browser(WebDriver driver){
        Browser.driver = driver;
    }

    public void browserSetup(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        maximizeScreen(driver);
        goTo(url);
    }

    public void goTo (String url){
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        initPageFactory();
    }

    public static void maximizeScreen(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public String isAt(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public void initPageFactory(){
        PageFactory.initElements(driver, this);
    }

}

