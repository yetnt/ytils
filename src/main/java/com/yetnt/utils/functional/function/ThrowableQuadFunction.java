package com.yetnt.utils.functional.function;

/**
 * Functional interface representing an operation that accepts FOUR arguments and returns a result
 * but may also throw.
 *
 * @param <T> the type of the first argument to the operation
 * @param <U> the type of the second argument to the operation
 * @param <V> the type of the third argument to the operation
 * @param <W> The type to return
 * @param <X> The type this may throw
 *
 * @author Lehlogonolo Poole
 */
@FunctionalInterface
public interface ThrowableQuadFunction<S, T, U, V, W, X extends Throwable> {
    W apply (S s, T t, U u, V v) throws X;
}