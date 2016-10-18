import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by abijah on 10/17/16.
 */
public class PriceTest {

    Price myPrice;
    double price = 10.50;


    @Before
    public void setup(){
        myPrice = new Price(price);
    }

    @Test
    public void addToNumberOfElementsTest(){
        //Arrange
        int expected =2;
        myPrice.addToNumber();
        //Act
        int actual = myPrice.getNumberOfPriceElements();
        //Assert
        assertEquals("Should be 2",expected,actual);
    }
    @Test
    public void getPriceTest(){
        //Arrange
        double expected = 10.50;
        //Act
        double actual = myPrice.getPrice();
        //Assert
        assertEquals("Should be 10.50",expected,actual);
    }

}
