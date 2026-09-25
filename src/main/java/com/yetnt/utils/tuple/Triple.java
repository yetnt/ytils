package com.yetnt.utils.tuple;


import com.yetnt.utils.functional.TriFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * An immutable record representing a tuple of three elements of the same type.
 * <p>
 *     From <a href="https://github.com/yetnt/j3engine">J3Engine</a>
 * </p>
 *
 * @param v1 The first value
 * @param v2 The second value
 * @param v3 The third value
 * @param <T> The type of the elements in the triple.
 * @author Lehlogonolo Poole
 */
public record Triple<T>(T v1, T v2, T v3) {

    /**
     * Creates a new {@link Triple} record from a given list
     * @param list The list. Should have at least 3 elements
     * @return A new Triple with the 3 elements
     * @param <T> The type held by the list
     * @throws IllegalArgumentException If the list is empty or the list has less than 3 elements.
     */
    public static <T> Triple<T> from(List<T> list) throws IllegalArgumentException {
        if (list.isEmpty()) throw new IllegalArgumentException("List input must not be empty");
        if (list.size() < 3) throw new IllegalArgumentException("List input must have at least 3 elements");
        return new Triple<>(list.get(0), list.get(1), list.get(2));
    }

    /**
     * Applies the given function to the triple to return a single value.
     * @param map The mapper function
     * @return A single value
     * @param <K> The type of the single value to return
     */
    public <K> K mapTo(TriFunction<T, T, T, K> map)  {
        return map.apply(v1, v2, v3);
    }

    /**
     * Converts this Triple into an {@link ArrayList} containing its three elements.
     * The order of elements in the list will be v1, v2, v3.
     *
     * @return An {@link ArrayList} containing the elements of this Triple.
     */
    public ArrayList<T> toArrayList() {
        return new ArrayList<>(List.of(v1, v2, v3));
    }

    /**
     * Applies a given mapping function to each element of this Triple,
     * returning a new Triple with the transformed elements.
     *
     * @param <T2> The type of the elements in the new Triple after mapping.
     * @param mapper The function to apply to each element.
     * @return A new {@link Triple} containing the results of applying the mapper function to each element.
     */
    public <T2> Triple<T2> map(Function<T, T2> mapper) {
        return new Triple<>(
                mapper.apply(v1),
                mapper.apply(v2),
                mapper.apply(v3)
        );
    }

    /**
     * Creates a stream of the 3 elements
     * <p>
     *     This is functionally identical to calling
     *     <pre>{@code
     *     Triple<String> triple = new Triple("hello", "world", "!");
     *     Stream<String> str = Stream.of(triple.v1(), triple.v2(), triple.v3());
     *     }</pre>
     * </p>
     * @return A stream of the input stuff
     */
    public Stream<T> stream() {
        return Stream.of(v1, v2, v3);
    }


    /**
     * Applies the given consumer to each positional pair of the two input triples.
     * <p>
     *     This is if, you were to take {@code v1} of each Triple, and consume them with a {@link BiConsumer},
     *     applied to each argument in one call.
     * </p>
     * @implNote This means the {@link BiConsumer} will be called 3 different types for {{@link #v1()}}, {@link #v2()}
     *          and {@link #v3()} of each triple
     * @param t1 The first triple
     * @param t2 The second triple
     * @param forEachConsumer The consumer to apply to each positional argument
     * @param <T> The type the first triple holds
     * @param <V> The type the second triple holds
     */
    public static <T, V> void forEachPair(Triple<T> t1, Triple<V> t2, BiConsumer<T, V> forEachConsumer) {
        forEachConsumer.accept(t1.v1, t2.v1);
        forEachConsumer.accept(t1.v2, t2.v2);
        forEachConsumer.accept(t1.v3, t2.v3);
    }

    /**
     * Maps each positional pair of the two input triples back into the same position of a new triple.
     * <p>
     *     This is if you were to take {@code v1} of each Triple, apply the map then save that as {@code v1} of
     *     a new triple, applied to each argument in one call.
     * </p>
     * <pre>{@code
     * Triple<Integer> a = new Triple<>(1, 2, 3);
     * Triple<Integer> b = new Triple<>(10, 20, 30);
     *
     * Triple<Integer> result =
     *     TripleUtils.mapPair(a, b, Integer::sum);
     *
     * // (11, 22, 33)
     * }</pre>
     * @param t1 The first triple
     * @param t2 The second triple
     * @param mapper The map to apply to each positional element of the triple
     * @return A new triple
     * @param <T> The type held by the first triple
     * @param <U> The type held by the second triple
     * @param <V> The type held by the new returned triple
     */
    public static <T, U, V> Triple<V> mapPair(Triple<T> t1, Triple<U> t2, BiFunction<T, U, V> mapper) {
        return new Triple<>(
                mapper.apply(t1.v1, t2.v1),
                mapper.apply(t1.v2, t2.v2),
                mapper.apply(t1.v3, t2.v3)
        );
    }
}