import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        List<Integer> integers = initIntegers();
        System.out.println("Llista inicial");
        integers.forEach(x -> System.out.println(integers.get(x - 1)));

        doReverseOrder(integers);
        doIterator(integers);

    }

    private static void doReverseOrder(List<Integer> integers) {
        System.out.println("Llista inicial al revés");
        List<Integer> integersReverse = integers.stream().sorted(Collections.reverseOrder()).toList();
        integers.forEach(x -> System.out.println(integersReverse.get(x - 1)));
    }

    private static void doIterator(List<Integer> integers) {
        System.out.println("Llista iterator");
        ListIterator<Integer> it = integers.listIterator();
        List<Integer> integersIter = new ArrayList<>();
        while (it.hasNext())
            integersIter.add(it.next());

        integersIter.forEach(x -> System.out.println(integersIter.get(x - 1)));

    }

    private static List<Integer> initIntegers() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        integers.add(10);

        return integers;
    }
}