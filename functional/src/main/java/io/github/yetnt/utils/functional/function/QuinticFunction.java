package io.github.yetnt.utils.functional.function;


/**
 * Functional interface representing an operation that accepts FIVE arguments and returns a result.
 *
 * @param <T> the type of the first argument to the operation
 * @param <U> the type of the second argument to the operation
 * @param <V> the type of the third argument to the operation
 * @param <W> the type of the fourth argument
 * @param <X> the type of the fifth argument
 * @param <Y> The type to return
 *
 * @author Lehlogonolo Poole
 */
@FunctionalInterface
public interface QuinticFunction<T, U, V, W, X, Y> {
    Y apply (T t, U u, V v, W w, X x);
}