package exercises;

import java.util.*;
import java.util.stream.Collectors;

public class Java8AndCollectionsExercises {
    public static void main(String[] args) {

        List<Product> productsList = new ArrayList<>();
        productsList.add(new Product(1, "HP Laptop", 25000f));
        productsList.add(new Product(2, "Dell Laptop", 30000f));
        productsList.add(new Product(3, "Apple Laptop", 90000f));

        List<Float> priceList = productsList.stream()
                .filter(p -> p.price < 30000) //filtering data
                .map(p -> p.price) //fetching price
                .collect(Collectors.toList());
        System.out.println(priceList);

        productsList.stream()
                .filter(product -> product.price == 30000)
                .forEach(product -> System.out.println(product.name));

        double sum = productsList.stream()
                .collect(Collectors.summingDouble(product -> product.price));
        System.out.println(sum);

        Product product = productsList.stream().max((product1, product2) -> product1.price > product2.price ? 1 : -1).get();
        System.out.println(product.price);

        Product productB = productsList.stream().min((product1, product2) -> product1.price > product2.price ? 1 : -1).get();
        System.out.println(product.price);

        long count = productsList.stream()
                .filter(product1 -> product1.price < 30000)
                .count();
        System.out.println(count);

        //Converting product List into Set
        Set<Float> productPriceList =
                productsList.stream()
                        .filter(product2 -> product2.price < 30000)   // filter product on the base of price
                        .map(product3 -> product3.price)
                        .collect(Collectors.toSet());   // collect it as Set(remove duplicate elements)
        System.out.println(productPriceList);

        //Converting Product List into a Map
        Map<Integer, String> productPriceMap =
                productsList.stream()
                        .collect(Collectors.toMap(p -> p.id, p -> p.name));
        System.out.println(productPriceMap);

        //_______________________________________
        List<String> cоlleсtion = List.of("AA", "BB", "CC"); //immutable!!! java 9
        for (String еlement : cоlleсtion) {
            if (еlement.equals("AA")) {
                cоlleсtion.remove(еlement); //ImmutableCollections exception
            }
        }

        //_______________________________________
        Map m = new HashMap();
        m.put(null, "Test");
        m.put(null, "Fest");
        System.out.println(m); //{null=Fest}

        //_______________________________________


    }
}

class Product {
    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

//    public Product(byte var){
//        this(4); //compilation error;
//    }
}
