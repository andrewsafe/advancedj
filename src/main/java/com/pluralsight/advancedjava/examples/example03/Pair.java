package main.java.com.pluralsight.advancedjava.examples.example03;

import java.util.function.BiFunction;

public record Pair<T, U>(T first, U second) {

    public static <V, W> Pair<V, W> of(V first, W second) {
        return new Pair<>(first, second);
    }

    public Pair<T, U> withFirst(T newFirst) {
        return Pair.of(newFirst, second);
    }

    public Pair<T, U> withSecond(U newSecond) {
        return Pair.of(first, newSecond);
    }

    public <V, W> Pair<V, W> map(BiFunction<T, U, Pair<V, W>> fn) {
        return fn.apply(first, second);
    }
}
