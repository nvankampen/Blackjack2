package PageObjects;


import Base.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends Browser {

    @FindBy(xpath="/html/body/nav/div/div[2]/ul[1]/li[1]/a")


    static WebElement headerHome;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderHomeText(){
        return headerHome.getText();
    }

}
