import org.junit.Before;
import org.junit.Test;

import javax.swing.text.html.parser.Parser;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by abijah on 10/17/16.
 */
public class Parsetest {

    Parse parser;
    String milk = "MlkIgh";
    String milkRx= "[M|m(1|i|I)l|Lk|K]{4}";
    String cookies = "CoOkies";
    String cookiesRx= "[c|C(o|O|0)+k|K(i|I|1)e|E(s|S|5)]{7}";
    String bread = "Bre@Dhey";
    String breadRx= "[b|Br|R(3|e|E)(@|a|A)d|D]{5}";
    String apples = "aPpls1le";
    String applesRx = "[(a|A|@)(p|P)+(l|L|1)e|E(s|S|5)]{6}";
    String dataSample= "naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##rice:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##";
    @Before
    public void setup(){
        parser = new Parse();

    }

    @Test
    public void findMatchTest(){
        boolean actual = parser.findMatch(milkRx, "lmiklek");
        assertTrue("should be true able to find match",actual);
    }
    @Test
    public void wrongWordCatcherForMilk(){
        //Arrange
        String expected = "Milk";
        //Act
        String actual = parser.wrongWordCatcher(milk);
        //Assert
        assertEquals("Should be Milk", actual, expected);
    }
    @Test
    public void wrongWordCatcherForApples(){
        //Arrange
        String expected = "Apples";
        //Act
        String actual = parser.wrongWordCatcher(apples);
        //Assert
        assertEquals("Should be Apples", actual, expected);
    }
    @Test
    public void wrongWordCatcherForBread(){
        //Arrange
        String expected = "Bread";
        //Act
        String actual = parser.wrongWordCatcher(bread);
        //Assert
        assertEquals("Should be Bread", actual, expected);
    }
    @Test
    public void wrongWordCatcherForCookies(){
        //Arrange
        String expected = "Cookies";
        //Act
        String actual = parser.wrongWordCatcher(cookies);
        //Assert
        assertEquals("Should be Cookies", actual, expected);
    }
    @Test
    public  void jsonArrayListTestSize(){
        //Arrange
        int actual= 1;
        //Act
        int expected=parser.jsonDataToArrayList(milkRx, "milk").size();
        //Assert
        assertEquals("Should be 2", actual, expected);
    }

    @Test
    public void jsonArrayListtest(){
        String data = dataSample;
        String actual = "name:Cookies;price:2.25";
        String expected = parser.jsonDataToArrayList("[n|N(a|A|@)m|M(e|E|3)]{4}:([(a-z)|(A-Z)]{4,7}){0,1}[^(a-z)|(A-Z)]{1,2}[p|Pr|Ri|Ic|Ce|E]{5}:(\\d*.\\d{2}){0,1}", data).get(0);

        assertEquals("Should be name:Cookies ; price 2.25", actual, expected);
    }
    @Test
    public void makeItemsTest(){
        //Arrange
        String expected = "Cookies";
        parser.makeItems(dataSample);
        //Act
        String actual = parser.getItems().get(0).getItemName();
        //Assert
        assertEquals("Should be Cookies", actual, expected);
    }

}
