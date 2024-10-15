package main.java.com.pluralsight.advancedjava.examples.example08;

public class InnerNode implements TreeNode {

    private final TreeNode left, right;

    public InnerNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Object getValue() { return null; }

    @Override
    public TreeNode getLeft() { return left; }

    @Override
    public TreeNode getRight() { return right; }

    @Override
    public String toString() { return String.format("{%s, %s}", left, right); }
}
