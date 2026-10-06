package com.yetnt.utils.functional.function;

/**
 * Functional interface representing an operation which takes in two arguments and returns a result but may throw an error
 * @param <T> The type of the first  argument
 * @param <U> The type of the second argument
 * @param <V> The type of the result
 * @param <W> The type to throw
 * @author Lehlogonolo Poole
 */
@FunctionalInterface
public interface ThrowableBiFunction<T, U, V, W extends Throwable> {
    V apply(T t, U u) throws W;
}
