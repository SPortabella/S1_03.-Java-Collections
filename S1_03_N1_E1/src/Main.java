import domain.Month;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Month> months = initMonths();
        System.out.println("Impressió 1: " + months);

        Integer position = 8;
        String name = "AGOST";
        insertMonthInArrayList(months, position, name);
        System.out.println("Impressió 2: " + months);


        HashSet<Month> hmonths = new HashSet(months);
        System.out.println("Impressió 1 amb hashSet: " + hmonths);
        name = "NOVEMBRE";
        insertMonthInHash(hmonths, new Month(name));
        System.out.println("Impressió 2 amb hashSet: " + hmonths);


        System.out.println("Recorro la llista amb un for");
        for (Month month : months) {
            System.out.println(month);
        }

        System.out.println("Recorro la llista amb un iterador");
        Iterator<Month> it = months.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

    private static void insertMonthInHash(HashSet<Month> hmonths, Month month) {

        if (!hmonths.stream().filter(x -> x.getName().equals(month.getName())).findFirst().isPresent()) {
            hmonths.add(month);
        }

    }

    private static void insertMonthInArrayList(List<Month> months, Integer position, String name) {
        months.add(position - 1, new Month(name));
    }

    private static ArrayList<Month> initMonths() {
        ArrayList<Month> months = new ArrayList<>();
        months.add(new Month("GENER"));
        months.add(new Month("FEBRER"));
        months.add(new Month("MARÇ"));
        months.add(new Month("ABRIL"));
        months.add(new Month("MAIG"));
        months.add(new Month("JUNY"));
        months.add(new Month("JULIOL"));
        months.add(new Month("SETEMBRE"));
        months.add(new Month("OCTUBRE"));
        months.add(new Month("NOVEMBRE"));
        months.add(new Month("DESEMBRE"));

        return months;
    }
}