package main.java.com.pluralsight.advancedjava.examples.example01;

public interface TreeNode<T> {

    T getValue();

    TreeNode<T> getLeft();

    TreeNode<T> getRight();
}
