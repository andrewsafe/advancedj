package main.java.com.pluralsight.advancedjava.examples.example08;

public class RecordsExample08 {
    public static void main(String[] args) {
        var customer1 = new Customer1(500567L, "Andrew", "S", "sham", "andrew@gmail.com");
        System.out.println(customer1);

        var customer2 = new Customer2(500567L, new FullName("Andrew", "S"), new NickName("drew"), new EmailAddress("andrew@gmail.com"));
        System.out.println(customer2);
    }
}
