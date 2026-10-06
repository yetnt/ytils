package com.yetnt.utils.functional.consumer;

/**
 * Functional interface representing an operation which takes in two arguments and returns no result but may throw an error
 * @param <T> The type of the first  argument
 * @param <U> The type of the second argument
 * @param <V> The type to throw
 * @author Lehlogonolo Poole
 */
@FunctionalInterface
public interface ThrowableBiConsumer<T, U, V extends Throwable> {
    void apply(T t, U u) throws V;
}
