import com.google.common.collect.Iterables;
import com.sun.javafx.scene.layout.region.Margins;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.jboss.netty.util.internal.SystemPropertyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by msaros on 8/9/2015.
 */
public  class InboxPage  {

    @FindBy(xpath = ".//div[@class='menu-select']//select[@id='offers_sort']//option[@value='price']")
    private WebElement sortByPrice;

    @FindBy(xpath = ".//ul[1]/li/div[2]/div[3]/p[1]/a")
    private WebElement minimPrice;

    @FindBy(xpath = ".//ul[1]/li/div[2]/div[2]/p[1]/a/img")
    private WebElement storeWithMinPrice;

    @FindBy(xpath = ".//span[@itemprop='offerCount']")
    private WebElement countOffers;

    @FindBy(xpath = ".//*[@itemprop='offerCount']")
    private WebElement offersDispayed;

    @FindBy(xpath = ".//span[2][@class='text-price-xl price']")
    private WebElement maximPrice;

    @FindBy(xpath = "//p[@itemtype='http://schema.org/AggregateOffer']/span[2]")
    private WebElement maxValuePriceTitle;

    @FindBy(xpath = ".//ul[58]/li[2]/div[2]/div[2]/p[1]/a/img")
    private WebElement storeNameWithMaximumPrice;





    WebDriver driver;

    public InboxPage(WebDriver driver) {
        this.driver = driver;
    }


    public void sort() {
        sortByPrice.click();
        String pret = minimPrice.getText();
        String magazin = storeWithMinPrice.getAttribute("alt");
        System.out.println("Pretul cel mai mic este: " + pret + " disponibil in magazinul " + magazin);

    }

    public void countStores() {
        int count = 0;
        List<WebElement> listOffers = driver.findElements(By.xpath(".//*[@itemprop='offers']"));
        Iterator<WebElement> itr = listOffers.iterator();
        while (itr.hasNext()) {


            count++;
            itr.next();
        }


        System.out.println("Numarul de magazine gasit este: " + count);

        //assertEquals(count, Integer.parseInt(countOffers.getText()));


    }



    public void getMaxPriceFromList() {
        int count = 0;
        List<WebElement> listOffers = driver.findElements(By.xpath(".//*[@id='product_offers_container']/ul/li/div[2]/div[3]/meta[1][@itemprop='price']"));
        List<Double> lista=new ArrayList<Double>();
        for (WebElement elem : listOffers) {
            String aux=(elem.getAttribute("content"));
            Double result=Double.parseDouble(aux.replace(".","").replace(",","."));
            count++;

            //System.out.println(result);

            lista.add(result);


        }
        Collections.sort(lista);
        System.out.println(lista);
        Double maxim =lista.get(count - 1);
        System.out.println(maxim);
        double maxPrice=Double.parseDouble(maxValuePriceTitle.getText().replace(".", "").replace(",", ".").replace("RON", ""));
        String maxStore =storeNameWithMaximumPrice.getAttribute("alt");
        System.out.println(maxPrice);
        //System.out.println(maxStore);
        //double nr=2723.9;
        //assertTrue(maxim==maxPrice);



        /*List<WebElement> listOffers2 = driver.findElements(By.xpath(".//*[@itemprop='offers']"));
        for (WebElement elem : listOffers2)
        {

            String aux = (elem.findElement(By.xpath(".//div[2]/div[3]/p[1]/a")).getAttribute("content"));
            Double aux1 = Double.parseDouble(aux.replace(".", "").replace(",", "."));

            if(aux1==maxim)
            {
               /System.out.println(elem.findElement(By.xpath(".//p/a/img")).getAttribute("alt"));
            }

        }
        */




    }











}










