package com.yetnt.utils.tuple;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * A specialized {@link Pair} where both elements are of the same type.
 * <p>
 *     From <a href="https://github.com/yetnt/jaiva">Jaiva!</a>
 * </p>
 *
 * @param <T> The type of both elements in the pair.
 *
 * @author Lehlogonolo Poole
 * @see Pair
 * @see MutablePair
 */
public class SamePair<T> extends Pair<T, T> {
    /**
     * Constructs a new {@code SamePair} with the given first and second elements.
     *
     * @param first The first element of the pair.
     * @param second The second element of the pair.
     */
    public SamePair(T first, T second) {
        super(first, second);
    }

    /**
     * Creates a new {@link SamePair} from a {@link Pair} who's already defined as having the same types.
     * @param samePair The pair
     * @return A new same pair
     * @param <T> The type the original pair has in both fields.
     */
    public static <T> SamePair<T> from(Pair<T, T> samePair) {
        return new SamePair<>(samePair.getFirst(), samePair.getSecond());
    }

    /**
     * Applies a given mapping function to each element of this SamePair,
     * returning a new SamePair with the transformed elements.
     *
     * @param <U> The type of the elements in the new SamePair after mapping.
     * @param function The function to apply to each element.
     * @return A new {@link SamePair} containing the results of applying the mapper function to each element.
     */
    public <U> SamePair<U> map(Function<T, U> function) {
        return new SamePair<U>(function.apply(first), function.apply(second));
    }

    /**
     * Applies the given function to the SamePair to return a single value.
     * @param function The mapper function
     * @return A single value
     * @param <U> The type of the single value to return
     */
    public <U> U mapTo(BiFunction<T, T, U> function) {
        return function.apply(first, second);
    }
}