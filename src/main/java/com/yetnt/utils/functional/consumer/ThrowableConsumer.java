package com.yetnt.utils.functional.consumer;

/**
 * Functional interface representing an operation which takes in an argument and returns no result but may throw an error
 * @param <T> The type of the first  argument
 * @param <U> The type to throw
 * @author Lehlogonolo Poole
 */
@FunctionalInterface
public interface ThrowableConsumer<T, U extends Throwable> {
    void apply(T t) throws U;
}
