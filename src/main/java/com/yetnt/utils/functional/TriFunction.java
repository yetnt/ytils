package com.yetnt.utils.functional;

import java.util.Objects;

/**
 * Functional interface representing an operation that accepts three arguments and returns a result.
 * <p>
 *     From <a href="https://github.com/yetnt/j3engine">J3Engine</a>
 * </p>
 *
 * @param <T> the type of the first argument to the operation
 * @param <U> the type of the second argument to the operation
 * @param <V> the type of the third argument to the operation
 * @param <W> The type to return
 *
 * @author Lehlogonolo Poole
 */
@FunctionalInterface
public interface TriFunction<T, U, V, W> {
    /**
     * Applies the function with the 3 arguments
     * @param t The first argument
     * @param u The second argument
     * @param v The third argument
     * @return The type W
     */
    W apply (T t, U u, V v);
}