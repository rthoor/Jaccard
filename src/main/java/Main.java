import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
        private HashMap<String, Basket> baskets = new HashMap<>();


    public static void main(String[] args) {
        Main main = new Main();
        main.readFromCsv("transactions.csv");

//        main.baskets.forEach((key, value) -> System.out.println(main.baskets.get(key)));

        System.out.println(main.baskets.get("994106500003936"));
        System.out.println("Comparing with kids");
        Jaccard jaccard = new Jaccard(main.baskets.get("994106500003936"), kids);
        System.out.println("Jaccard coefficient: " + jaccard.getCoefficient());
        System.out.println();
        System.out.println("Comparing with youths");
        jaccard = new Jaccard(main.baskets.get("994106500003936"), youths);
        System.out.println("Jaccard coefficient: " + jaccard.getCoefficient());
        System.out.println();
        System.out.println("Comparing with matures");
        jaccard = new Jaccard(main.baskets.get("994106500003936"), mature);
        System.out.println("Jaccard coefficient: " + jaccard.getCoefficient());
        System.out.println();
        System.out.println("Comparing with elders");
        jaccard = new Jaccard(main.baskets.get("994106500003936"), elders);
        System.out.println("Jaccard coefficient: " + jaccard.getCoefficient());
        System.out.println();
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

    private static List<String> kids = Arrays.asList("PRD0900725", "PRD0901527", "PRD0901977", "PRD0902163", "PRD0902394", "PRD0902411",
            "PRD0903336", "PRD0903389", "PRD0903395", "PRD0901369", "PRD0902129", "PRD0901168", "PRD0902479", "PRD0903788", "PRD0903819",
            "PRD0904184", "PRD0900280", "PRD0901441", "PRD0903199", "PRD0904358", "PRD0904780", "PRD0904888", "PRD0900454", "PRD0900700",
            "PRD0902405", "PRD0903127", "PRD0903463", "PRD0904363", "PRD0900384", "PRD0900400", "PRD0900830", "PRD0901133", "PRD0901194",
            "PRD0901860", "PRD0901965", "PRD0902008", "PRD0902265", "PRD0902767", "PRD0902801", "PRD0902969", "PRD0902970", "PRD0903523");

    private static List<String> youths = Arrays.asList("PRD0903925", "PRD0903940", "PRD0903993", "PRD0904434", "PRD0904511",
            "PRD0904615", "PRD0903639", "PRD0901499", "PRD0903270", "PRD0904663", "PRD0904917", "PRD0902817", "PRD0900218",
            "PRD0902968", "PRD0903229", "PRD0903787", "PRD0904469", "PRD0904945", "PRD0901348", "PRD0903678", "PRD0901802",
            "PRD0903988", "PRD0904857", "PRD0904881", "PRD0901338", "PRD0904248", "PRD0900254", "PRD0901007", "PRD0902118",
            "PRD0901506", "PRD0901219", "PRD0901809", "PRD0903211", "PRD0904441", "PRD0904444", "PRD0900162");


    private static List<String> mature = Arrays.asList("PRD0903437", "PRD0904366", "PRD0903703", "PRD0904797", "PRD0900173",
            "PRD0901003", "PRD0900332", "PRD0902140", "PRD0900296", "PRD0900302", "PRD0900407", "PRD0902069", "PRD0902540",
            "PRD0903053", "PRD0903093", "PRD0903214", "PRD0904679", "PRD0904878", "PRD0900745", "PRD0900465", "PRD0900907",
            "PRD0904209", "PRD0900034", "PRD0900078", "PRD0900713", "PRD0900761", "PRD0900997", "PRD0901837", "PRD0902099",
            "PRD0902603", "PRD0902852", "PRD0903007", "PRD0903078", "PRD0903228", "PRD0903560", "PRD0903835");

    private static List<String> elders = Arrays.asList("PRD0904391", "PRD0900168", "PRD0901228", "PRD0902840", "PRD0903750", "PRD0901877",
            "PRD0900027", "PRD0900463", "PRD0900676", "PRD0900899", "PRD0901083", "PRD0901265", "PRD0901584", "PRD0902019",
            "PRD0902365", "PRD0902390", "PRD0902408", "PRD0902897", "PRD0902907", "PRD0903052", "PRD0903529", "PRD0904092",
            "PRD0904340", "PRD0901070", "PRD0901316", "PRD0901699", "PRD0901983", "PRD0903571", "PRD0903612", "PRD0904371",
            "PRD0904418", "PRD0904817", "PRD0902679", "PRD0903487", "PRD0900265", "PRD0900838");
}
