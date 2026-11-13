package io.github.yetnt.utils.functional.consumer;

import java.util.function.Consumer;

/**
 * Represents an operation that accepts five input arguments and returns no result but may throw
 *
 * @param <T> the type of the first argument to the operation
 * @param <U> the type of the second argument to the operation
 * @param <V> the type of the third argument to the operation.
 * @param <W> the type of the fourth argument to the operation.
 * @param <X> the type of the fifth argument to the operation
 * @param <Y> the type to throw
 * @see Consumer
 * @author Lehlogonolo Poole
 */
@FunctionalInterface
public interface ThrowableQuinticConsumer<T, U, V, W, X, Y extends Throwable> {
    /**
     * Performs this operation on the given arguments.
     *
     * @param t the first input argument
     * @param u the second input argument
     * @param v the third input argument
     * @param w the fourth input argument
     * @param x the fifth input argument
     */
    void accept(T t, U u, V v, W w, X x) throws Y;
}