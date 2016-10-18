import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by abijah on 10/17/16.
 */
public class ItemsTest {
    private Items items;
    private Price myPrice;
    private String name= "Milk";
    private String type = "Food";
    private String expiration = "1/25/2016";
    private double price =3.23;
    private double delta = .00001;

    @Before
    public void setup(){
        items = new Items(name, price);
        myPrice= new Price(price);
    }

    @Test
    public void addPriceTest(){
        //Arrange
        int expected = 2;
        items.addPrice(10.00);
        //Act
        int actual = items.getPrices().size();
        //Assert
        Assert.assertEquals("Should be two elements in the array", actual,expected);
    }
    @Test
    public  void getPriceTest(){
        //Arrange
        double expected = 3.23;
        items.addPrice(10.00);
        Price price = items.getPrices().get(0);
        //Act
        double actual =price.getPrice();
        //Assert
        assertEquals("Should be the price of the first item", actual,expected);
    }
    @Test
    public void totalItemsTest(){
        //Arrange
        int expected = 3;
        items.addPrice(price);
        items.addPrice(10.00);
        //Act
        int actual = items.totalItems();
        //Assert
        assertEquals("Should be 3", actual,expected);
    }
    @Test
    public void getItemNameTest(){
        //Arrange
        String expected = "Milk";
        //Act
        String actual = items.getItemName();
        //Assert
        assertEquals("Should be milk", actual,expected);
    }

}
