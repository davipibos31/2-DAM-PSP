import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        HashMap<String,Integer> hash = new HashMap<>();
        hash.put("asdasda",3003);

        hash.get("asdasda")    ;


        List<String> array = new ArrayList<>();
        array.add("J");
        array.add("M");
        array.add("S");
        array.add(10, "J");


        for (int i = 0; i < array.size(); i++) {
            String valor = array.get(i);
            i=0
        }



        for(String valor : array){
            System.out.println(valor);
        }




        ListIterator<String> iterator = array.listIterator();
        while (iterator.hasNext()) {
            String valor = iterator.next();
            if valeor = ={
                    break
            }
        }

    }
}