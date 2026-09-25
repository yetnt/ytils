package com.yetnt.utils.functional;

/**
 * Represents an operation that accepts three input arguments of the same type and returns no result.
 * This is a specialisation of {@link TriConsumer} where all three input arguments are of the same type.
 * Unlike most other functional interfaces, {@code TrinaryConsumer} is expected to operate via side effects.
 * <p>
 *     From <a href="https://github.com/yetnt/j3engine">J3Engine</a>
 * </p>
 *
 * @param <T> the type of the input arguments to the operation
 *
 * @see TriConsumer
 * @author Lehlogonolo Poole
 */
@FunctionalInterface
public interface TrinaryConsumer<T> extends TriConsumer<T, T, T> {
    @Override
    default TrinaryConsumer<T> andThen(TriConsumer<? super T, ? super T, ? super T> after) {
        return (TrinaryConsumer<T>) TriConsumer.super.andThen(after);
    }
}