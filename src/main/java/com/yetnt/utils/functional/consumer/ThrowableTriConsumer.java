package com.yetnt.utils.functional.consumer;

import java.util.Objects;

/**
 * Functional interface representing an operation that accepts three arguments and returns no result but may thwo
 *
 * @param <T> the type of the first argument to the operation
 * @param <U> the type of the second argument to the operation
 * @param <V> the type of the third argument to the operation
 * @param <W> the type to throw
 *
 * @author Lehlogonolo Poole
 */
@FunctionalInterface
public interface ThrowableTriConsumer<T, U, V, W extends Throwable> {
    /**
     * Consumes the given 3 arguments
     * @param t The first argument
     * @param u The second argument
     * @param v The third argument
     */
    void accept(T t, U u, V v) throws W;
}
