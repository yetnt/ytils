package io.github.yetnt.utils.functional.consumer;

import java.util.function.Consumer;
import java.util.Objects;

/**
 * Represents an operation that accepts five input arguments and returns no result.
 *
 * @param <T> the type of the first argument to the operation
 * @param <U> the type of the second argument to the operation
 * @param <V> the type of the third argument to the operation.
 * @param <W> the type of the fourth argument to the operation.
 * @param <X> the type of the fifth argument to the operation.
 * @see Consumer
 * @author Lehlogonolo Poole
 */
@FunctionalInterface
public interface QuinticConsumer<T, U, V, W, X> {
    /**
     * Performs this operation on the given arguments.
     *
     * @param t the first input argument
     * @param u the second input argument
     * @param v the third input argument
     * @param w the fourth input argument
     * @param x the fifth input argument
     */
    void accept(T t, U u, V v, W w, X x);

    /**
     * Returns a composed {@code QuinticConsumer} that performs, in sequence, this
     * operation followed by the {@code after} operation.
     *
     * @param after the operation to perform after this operation
     * @return a composed {@code QuinticConsumer} that performs in sequence this
     *         operation followed by the {@code after} operation
     * @throws NullPointerException if {@code after} is null
     */
    default QuinticConsumer<T, U, V, W, X> andThen(QuinticConsumer<? super T, ? super U, ? super V, ? super W, ? super X> after) {
        Objects.requireNonNull(after);
        return (t, u, v, w, x) -> {
            this.accept(t, u, v, w, x);
            after.accept(t, u, v, w, x);
        };
    }
}