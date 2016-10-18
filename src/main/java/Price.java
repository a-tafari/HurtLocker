/**
 * Created by abijah on 10/17/16.
 */
public class Price {

    private double price;

    private int numberOfPriceElements;

    public Price(double amount){
        this.price = amount;
        addToNumber();
    }

    public int getNumberOfPriceElements() {
        return numberOfPriceElements;
    }
    public double getPrice() {
        return price;
    }

    public void addToNumber(){
        this.numberOfPriceElements++;
    }


}
