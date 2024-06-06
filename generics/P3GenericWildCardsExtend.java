import java.util.*;

// <?>
// wildcards are represented by the `?` symbol and can be used in three ways:
// extends keyword

public class P3GenericWildCardsExtend {

    public static void main(String[] args) {
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();

        age.add(18);
        number.add(314);

        //getUperNumber(name);   // Error 1 ? extends Number
        getUperNumber(age);        // 2
        getUperNumber(number); // 3

    }

    public static void getData(List<?> data) {
        System.out.println("data :" + data.get(0));
    }

    // extends keyword
    public static void getUperNumber(List<? extends Number> data) {
        System.out.println("data :" + data.get(0));
    }
}