package main.java.com.pluralsight.advancedjava.examples.example01;

public class AdvancedGenericsExample01 {

    public static void main(String[] args) {
        var three = new LeafNode<Integer>(3);

        var five = new LeafNode<>(5);

        var tree = new InnerNode<>(new LeafNode<>(2), new InnerNode<>(three, five));
        System.out.println(tree);
    }
}
