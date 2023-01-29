import domain.Restaurant;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static String SORTIR = "EXIT";

    public static void main(String[] args) {
        //Utilitzant la classe del programa anterior,
        // crea la implementació necessària perquè els objectes de la classe
        // Restaurant estiguin ordenats per nom i per puntuació en ordre ascendent.

        HashSet<Restaurant> restaurants = new HashSet<>();
        Boolean sortir = true;
        while (sortir) {
            String name = askNameRestaurant();
            if (checkSortir(name)) break;
            Integer puntuacio = askPuntuacioRestaurant();
            restaurants.add(new Restaurant(name, puntuacio));
        }

        List<Restaurant> sortedRestaurant = restaurants.stream().
                sorted(restaurantComparator()).
                collect(Collectors.toList());
        sortedRestaurant.forEach(System.out::println);
    }

    private static Comparator<Restaurant> restaurantComparator() {

        return (r1, r2) -> {
            if (r1.getName() == r2.getName())
                return r1.getName().compareTo(r2.getName());
            else if (r1.getPuntuacio() < r2.getPuntuacio())
                return 1;
            else return -1;
        };
    }
/*
    Comparador inicial. En el párrafo anterior lo substituye por Lambdas
    private static Comparator<Restaurant> restaurantComparator() {

        return new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant r1, Restaurant r2) {
                if (r1.getName() == r2.getName())
                    return r1.getName().compareTo(r2.getName());
                else if (r1.getPuntuacio() < r2.getPuntuacio())
                    return 1;
                else return -1;
            }
        };
    }


 */

    private static Integer askPuntuacioRestaurant() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix la puntuació:");
        return Integer.parseInt(sc.nextLine());
    }

    private static boolean checkSortir(String name) {
        if (name.toUpperCase().equals(SORTIR)) return true;
        return false;
    }

    private static String askNameRestaurant() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix nom del restaurant (exit per sortir):");
        return sc.nextLine().toUpperCase();

    }

}
