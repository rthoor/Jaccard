import java.util.ArrayList;
import java.util.Objects;

public class Basket {
    String id;
    ArrayList<String> items = new ArrayList<>();

    public Basket(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        Basket b = (Basket) o;
        return Objects.equals(id, b.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id='" + id + '\'' +
                ", items=" + items +
                '}';
    }
}
