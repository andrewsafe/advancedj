package main.java.com.pluralsight.advancedjava.examples.example05;

import java.util.Comparator;
import java.util.List;

public class AdvancedGenericsExample05 {

    public static void main(String[] args) {
        var products = List.of(
                new Product(100346L, "link", "swordsman"),
                new Product(200201L, "andrew", "king"),
                new Product(500000L, "shamx", "new version"));

        var names = sortByIdAndExtractNames(products);
        System.out.println(names);
    }

    static <T extends HasId & HasName> List<String> sortByIdAndExtractNames(List<T> list) {
        return list.stream().sorted(Comparator.comparing(HasId::id)).map(HasName::name).toList();
    }
}
