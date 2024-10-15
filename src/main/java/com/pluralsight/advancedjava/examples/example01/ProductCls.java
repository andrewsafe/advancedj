package main.java.com.pluralsight.advancedjava.examples.example01;

import java.util.Objects;

public class ProductCls {

    private final long id;
    private final String name;
    private final String description;

    public ProductCls(final long id, final String name, final String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCls that = (ProductCls) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return "ProductCls{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
