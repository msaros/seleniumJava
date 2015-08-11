import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.PageFormat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by msaros on 8/9/2015.
 */
public class ShopMania {

    @FindBy(xpath="//input[@id='autocomplete_prod']")
    private WebElement searchElement;

    @FindBy(xpath=".//ul/li[1]/div[3]/p[1]/a")
    private WebElement selectElement;


    private WebDriver driver;

    public ShopMania(WebDriver driver)
    {
        this.driver=driver;
        driver.manage().window().maximize();
        driver.get("http://www.shopmania.ro");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }




    public InboxPage search(String element)
    {
        searchElement.sendKeys(element);
        searchElement.submit();
        selectElement.click();



        InboxPage inboxpage= PageFactory.initElements(driver, InboxPage.class);
        return inboxpage;
    }




}
