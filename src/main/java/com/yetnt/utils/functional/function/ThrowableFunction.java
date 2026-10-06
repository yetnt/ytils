package com.yetnt.utils.functional.function;

/**
 * Functional interface representing an operation which takes in an argument and returns a result but may throw an error
 * @param <T> The type of the first  argument
 * @param <U> The type to return
 * @param <V> The type to throw
 * @author Lehlogonolo Poole
 */
@FunctionalInterface
public interface ThrowableFunction<T, U, V extends Throwable> {
    U apply(T t) throws V;
}
