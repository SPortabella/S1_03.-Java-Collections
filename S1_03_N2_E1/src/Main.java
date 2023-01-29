import domain.Restaurant;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static String SORTIR = "EXIT";

    public static void main(String[] args) {
        //Crea una classe anomenada Restaurant amb dos atributs: nom(String) i puntuació(int).
        // Implementa els mètodes necessaris perquè no es puguin introduir objectes Restaurant
        // amb el mateix nom i la mateixa puntuació en un HashSet creat en el main() de l’aplicació.
        //Important
        //Pot haver-hi restaurants amb el mateix nom amb diferent puntuació,
        //però no pot haver-hi restaurants amb el mateix nom i la mateixa puntuació.

        HashSet<Restaurant> restaurants = new HashSet<>();
        Boolean sortir = true;
        while (sortir) {
            String name = askNameRestaurant();
            if (checkSortir(name)) break;
            Integer puntuacio = askPuntuacioRestaurant();
            restaurants.add(new Restaurant(name,puntuacio));
        }

        List<Restaurant> sortedRestaurant = restaurants.stream().
                sorted(Comparator.comparingInt(Restaurant::getPuntuacio)).
                collect(Collectors.toList());
        sortedRestaurant.forEach(System.out::println);
    }

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
