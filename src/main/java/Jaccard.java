import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import static java.util.stream.Collectors.*;

public class Jaccard {
    private Basket basketOne;
    private Basket basketTwo;
    private BigDecimal coefficient;

    public Jaccard(Basket basketOne, Basket basketTwo) {
        this.basketOne = basketOne;
        this.basketTwo = basketTwo;
        this.coefficient = getJaccardCoef();
    }

    private int getUnionListSize() {
        TreeSet<String> union = new TreeSet<String>(basketOne.items);
        union.addAll(basketTwo.items);
        System.out.println("Объединение:" + union);
        return union.size();
    }

    private int getIntersectionListSize() {
        TreeSet<String> intersection = new TreeSet<>(basketOne.items);
        intersection.removeIf(item -> !basketTwo.items.contains(item));
        System.out.println("Пересечение:" + intersection);
        return intersection.size();
    }

    private BigDecimal getJaccardCoef() {
        int unionSize = getUnionListSize();
        int intersectionSize = getIntersectionListSize();
        return BigDecimal.valueOf(intersectionSize).divide(BigDecimal.valueOf(unionSize), 2, RoundingMode.HALF_UP);
    }

    public BigDecimal getCoefficient() {
        return coefficient;
    }
}
