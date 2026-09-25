package com.yetnt.utils.functional;

import java.util.Objects;

/**
 * Functional interface representing an operation that accepts three arguments and returns a valur
 * but can also throw.
 * <p>
 *     From <a href="https://github.com/yetnt/j3engine">J3Engine</a>
 * </p>
 *
 * @param <T> the type of the first argument to the operation
 * @param <U> the type of the second argument to the operation
 * @param <V> the type of the third argument to the operation
 * @param <W> The type to return
 * @param <X> The exception this function could throw
 * @author Lehlogonolo Poole
 */
@FunctionalInterface
public interface ThrowableTriFunction<T, U, V, W, X extends Throwable> {
    /**
     * Applies the function
     * @param t The first argument
     * @param u The second argument
     * @param v The third argument
     * @return Type W
     * @throws X Whatever exception this may throw
     */
    W apply (T t, U u, V v) throws X;
}