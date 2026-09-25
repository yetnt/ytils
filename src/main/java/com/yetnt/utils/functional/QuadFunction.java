package com.yetnt.utils.functional;


/**
 * Functional interface representing an operation that accepts FOUR arguments and returns a result.
 * <p>
 *     From <a href="https://github.com/yetnt/j3engine">J3Engine</a>
 * </p>
 *
 * @param <T> the type of the first argument to the operation
 * @param <U> the type of the second argument to the operation
 * @param <V> the type of the third argument to the operation
 * @param <W> the type of the fourth argument
 * @param <X> The type to return
 *
 * @author Lehlogonolo Poole
 */
@FunctionalInterface
public interface QuadFunction<T, U, V, W, X> {
    X apply (T t, U u, V v, W w);
}