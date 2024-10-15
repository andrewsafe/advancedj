package main.java.com.pluralsight.advancedjava.examples.example08;

public class AdvancedGenericsExample08 {

    public static void main(String[] args) {
        // Type erasure simple removes arguments, as if the code was written without generics.
        var three = new LeafNode(3);
        var five = new LeafNode(5);

        var tree = new InnerNode(new LeafNode(2), new InnerNode(three, five));
        System.out.println(tree);
    }
}
