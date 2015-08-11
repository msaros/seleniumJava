import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by msaros on 8/9/2015.
 */
public class TemaJava {

    ShopMania page;
    WebDriver driver;


    @Before
    public void before()
    {
        driver= new FirefoxDriver();
        page= PageFactory.initElements(driver,ShopMania.class);

    }

    @Test
    public void test()
    {

        InboxPage inbox=page.search("samsung galaxy s5");
        inbox.sort();
        inbox.countStores();
        inbox.getMaxPriceFromList();







    }

    @After
    public void after()
    {
        driver.close();
    }



}
