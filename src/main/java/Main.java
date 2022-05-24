import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
        private HashMap<String, Basket> baskets = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.readFromCsv("transactions.csv");

//        main.baskets.forEach((key, value) -> System.out.println(main.baskets.get(key)));
        System.out.println("Сравним две корзины: 994106500591944 и 994106500480160");
        System.out.println(main.baskets.get("994106500157906"));
        System.out.println(main.baskets.get("994106500059708"));
        Jaccard jaccard = new Jaccard(main.baskets.get("994106500157906"), main.baskets.get("994106500059708"));
        System.out.println(jaccard.getCoefficient());
    }

    void readFromCsv(String fileName){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/" + fileName));
            String s;
            while((s = br.readLine())!=null){
                String[] rows = s.split(";");
                String id = rows[1];
                String value = rows[0];
                if(baskets.containsKey(id)){
                    baskets.get(id).items.add(value);
                }else{
                    Basket basket = new Basket(id);
                    basket.items.add(value);
                    baskets.put(id, basket);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
