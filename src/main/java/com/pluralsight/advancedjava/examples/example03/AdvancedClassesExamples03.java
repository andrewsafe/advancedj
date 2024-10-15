package main.java.com.pluralsight.advancedjava.examples.example03;

public class AdvancedClassesExamples03 {

    private String name = "Joe Smith";

    public void example(int x, int y) {
        int number = 23;

        class Local {
            void method() {
                System.out.println(x + y);
                System.out.println(number);

                System.out.println(name);
            }
        }

        var obj = new Local();
        obj.method();

        // number++
        name = "Susan Jones";
    }
}
