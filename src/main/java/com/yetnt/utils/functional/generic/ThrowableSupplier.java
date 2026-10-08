package com.yetnt.utils.functional.generic;

/**
 * Functional interface describing a function which takes in
 * no arguments, produces an output but may throw.
 * @param <T> The type returned
 * @param <U> The type that can be thrown
 */
@FunctionalInterface
public interface ThrowableSupplier<T, U extends Throwable> {
    T get() throws U;
}
