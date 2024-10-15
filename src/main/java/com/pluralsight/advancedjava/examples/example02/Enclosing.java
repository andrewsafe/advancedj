package main.java.com.pluralsight.advancedjava.examples.example02;

public class Enclosing {

    private String name = "Joe Smith";

    public void createInner() {
        var inner = new Inner();
    }

    class Inner {
        private String name = "Susan Jones";

        void run() {
            System.out.println(name);
            System.out.println(Enclosing.this.name);
        }
    }
}
