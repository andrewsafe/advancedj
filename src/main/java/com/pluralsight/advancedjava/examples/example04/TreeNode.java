package main.java.com.pluralsight.advancedjava.examples.example04;

public interface TreeNode<T> extends Comparable<T> {

    T getValue();

    TreeNode<T> getLeft();

    TreeNode<T> getRight();
}
