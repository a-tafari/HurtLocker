import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by abijah on 10/17/16.
 */
public class Parse {
    PrintOut print =new PrintOut();
    private ArrayList<Items> items= new ArrayList<>();
    //Items newItems = new Items();
    int error = 0;
    //public Display display = new Display();


    public String wrongWordCatcher(String word){
        String newWord = "";
        if(findMatch("[M|m(1|i|I)l|Lk|K]{4}", word)){//matches any four letter word with these characters
            newWord = "Milk";//if word matches the new word is Milk
        }else if(findMatch("[(a|A|@)(p|P)+(l|L|1)e|E(s|S|5)]{6}", word)){
            newWord = "Apples";
        }else if(findMatch("[c|C(o|O|0)+k|K(i|I|1)e|E(s|S|5)]{7}", word)){//matches any 7 letter words
            newWord = "Cookies";// if word matches the new word is Cookies
        }else if(findMatch("[b|Br|R(3|e|E)(@|a|A)d|D]{5}", word)){
            newWord = "Bread";
        }
        return newWord;
    }

    public boolean findMatch (String regex, String name) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);

        return matcher.find();
    }
    public ArrayList<String>jsonDataToArrayList(String regex,String name){
        ArrayList<String>dataMatches = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        if(matcher.find()){
            dataMatches.add(matcher.group());
        }
        return dataMatches;
    }
    public void makeItems(String data) {
        ArrayList<String> jsonData = jsonDataToArrayList("[n|N(a|A|@)m|M(e|E|3)]{4}:([(a-z)|(A-Z)]{4,7}){0,1}[^(a-z)|(A-Z)]{1,2}[p|Pr|Ri|Ic|Ce|E]{5}:(\\d*.\\d{2}){0,1}", data);
        for (String jdata : jsonData) {
            try {
                String nameValue = jsonDataToArrayList(":([(a-z)|(A-Z)]{4,7}){0,1}", jdata).get(0).substring(1);
                double price = Double.parseDouble(jsonDataToArrayList(":(\\d*.\\d{2})", jdata).get(0).substring(1));
                items.add(new Items(wrongWordCatcher(nameValue), price));
            } catch (IndexOutOfBoundsException e) {
                error++;
            }
        }
    }

    public ArrayList<Items> getItems () {
        return items;
        }
    public void addItem(Items item){
        getItems().add(item);
    }


    public void myParser(String data){
        makeItems(data);
        print.printOutput(items, error);
    }
}
