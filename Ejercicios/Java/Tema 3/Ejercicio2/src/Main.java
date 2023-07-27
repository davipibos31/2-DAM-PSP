import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Assassin's Creed", "Videogames", 19.95f));
        products.add(new Product("MacBook Air 13\"", "Laptops", 1195));
        products.add(new Product("Lenovo Yoga 14\"", "Laptops", 549.95f));
        products.add(new Product("BQ Curie 8\"", "Tablets", 69.45f));
        products.add(new Product("Samsung Galaxy Tab 3 9.7\"", "Tablets", 210.25f));
        products.add(new Product("iPad Mini 3", "Tablets", 399.95f));
        products.add(new Product("Microsoft Surface 3", "Tablets", 419.75f));
        products.add(new Product("The Lasf of Us", "Videogames", 49.95f));
        products.add(new Product("Fifa 17", "Videogames", 69.95f));

        // Exercise 1

        System.out.println("EXERCISE 1");
        System.out.println("==========");

        Comparator<Product> comp = (p1, p2) ->
        {
            if (p1.getCategory().equals(p2.getCategory()))
                return p1.getName().compareTo(p2.getName());
            else
                return p1.getCategory().compareTo(p2.getCategory());
        };
        Collections.sort(products, comp);
        for (Product p : products) {
            System.out.println(p.getName() + " (" + p.getCategory() + "): " + p.getPrice());
        }
        System.out.println();

        // Exercise 2

        System.out.println("EXERCISE 2");
        System.out.println("==========");

        List<Product> result2 = products.stream()
                .filter(p -> p.getCategory().equals("Tablets"))
                .collect(Collectors.toList());
        for (Product p : result2) {
            System.out.println(p.getName() + " (" + p.getCategory() + "): " + p.getPrice());
        }

        /* Without generating any secondary list:
        products.stream()
                .filter(p -> p.getCategory().equals("Tablets"))
                .forEach(p -> System.out.println(p.getName() + " (" + p.getCategory() + "): " + p.getPrice()));
        */
        System.out.println();

        // Exercise 3

        System.out.println("EXERCISE 3");
        System.out.println("==========");

        OptionalDouble opt = products.stream()
                .filter(p -> p.getCategory().equals("Videogames"))
                .mapToDouble(p -> p.getPrice()).average();
        if (opt.isPresent())
            System.out.printf("Average: %.2f\n", opt.getAsDouble());
        else
            System.out.println("No product matches");

        // Exercise 4

        System.out.println("EXERCISE 4");
        System.out.println("==========");

        BiFunction<List<Product>, Float, String> higher = (list, price) ->
        {
            return list.stream()
                    .filter(p -> p.getPrice() > price)
                    .map(p -> p.getName())
                    .collect(Collectors.joining(",", "Products with price higher than " + price + ": ", ""));
        };
        System.out.println(higher.apply(products, 100f));

        System.out.println("EXERCISE 5");
        System.out.println("==========");

        Map<String, Long> productCount = products.stream()
                .collect(Collectors.groupingBy(p -> p.getCategory(), Collectors.counting()));
        System.out.println(productCount.toString());
    }
}