import java.util.ArrayList;

/**
 * Created by abijah on 10/17/16.
 */
public class PrintOut {

    public void printOutput(ArrayList<Items> items, int errors){
        StringBuilder output = new StringBuilder();
        for(Items item : items){
            output.append("name:    ").append(item.getItemName()).append(" \t\t seen:").append(item.totalItems()).append(" times\n");
            System.out.println("============= \t \t =============");
            for(Price price : item.getPrices()) {
                output.append("Price: \t ").append(price.getPrice()).append("\t\t seen: ").append(price.getNumberOfPriceElements()).append(" times");
                System.out.println("-------------\t\t -------------");
            }
            System.out.println("\n");
        }
        System.out.println("Errors         \t \t seen: "+errors+" times\n");
    }
}
