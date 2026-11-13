package io.github.yetnt.utils.functional.function;

/**
 * Functional interface representing an operation that accepts FIVE arguments and returns a result
 * but may also throw.
 *
 * @param <S> the type of the first argument to the operation
 * @param <T> the type of the second argument to the operation
 * @param <U> the type of the third argument to the operation
 * @param <V> the type of the fourth argument to the operation
 * @param <W> The type of the fifth argument to the operation
 * @param <X> The type to return
 * @param <Y> The type this may throw
 *
 * @author Lehlogonolo Poole
 */
@FunctionalInterface
public interface ThrowableQuinticFunction<S, T, U, V, W, X, Y extends Throwable> {
    X apply (S s, T t, U u, V v, W w) throws Y;
}