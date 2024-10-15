package main.java.com.pluralsight.advancedjava.examples.example08;

public class LeafNode implements TreeNode {

    private final Object value;

    public LeafNode(Object value) { this.value = value; }

    @Override
    public Object getValue() { return value; }

    @Override
    public TreeNode getLeft() { return null; }

    @Override
    public TreeNode getRight() { return null; }

    @Override
    public String toString() { return String.format("[%s]", value); }
}
