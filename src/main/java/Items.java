import java.util.ArrayList;

/**
 * Created by abijah on 10/17/16.
 */
public class Items {

    private ArrayList<Price> myPrices = new ArrayList<Price>();
    private String itemName;

    public Items(String itemName, double price){//creates a new item consisting of a name and price
        this.itemName = itemName;
        addPrice(price);//adds price to arraylist
       // getPrices().add(new Price(price));//adds price to arraylist
    }

    public void addPrice(double price){
        myPrices.add(new Price(price));
    }

    public ArrayList<Price> getPrices() {
        return myPrices;
    }

    public String getItemName(){
        return  itemName;
    }

    public void createGroceryList(){

    }

    public int totalItems(){
        int totalItems = 0;
        for(Price price : myPrices){
            totalItems += price.getNumberOfPriceElements();
        }
        return totalItems;
    }
}
