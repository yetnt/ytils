package io.github.yetnt.utils.tuple;

import io.github.yetnt.utils.functional.function.TriFunction;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

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
 * @param first The first value
 * @param second The second value
 * @param third The third value
 * @param <T> The type of the elements in the triple.
 * @author Lehlogonolo Poole
 */
public record Triple<T>(T first, T second, T third) {

    // for old APIS

    @Deprecated(since = "2.0.0")
    public T v1() {return first;}
    @Deprecated(since = "2.0.0")
    public T v2() {return second;}
    @Deprecated(since = "2.0.0")
    public T v3() {return third;}

    /**
     * Creates a new {@link Triple} record from a given list
     * @param list The list. Should have at least 3 elements
     * @return A new Triple with the 3 elements
     * @param <T> The type held by the list
     * @throws IllegalArgumentException If the list is empty or the list has less than 3 elements.
     */
    @NotNull
    @Contract("_ -> new")
    public static <T> Triple<T> from(@NotNull List<T> list) throws IllegalArgumentException {
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
    public <K> K mapTo(@NotNull TriFunction<T, T, T, K> map)  {
        return map.apply(first, second, third);
    }

    /**
     * Converts this Triple into an {@link ArrayList} containing its three elements.
     * The order of elements in the list will be v1, v2, v3.
     *
     * @return An {@link ArrayList} containing the elements of this Triple.
     */
    @NotNull
    @Contract(" -> new")
    public ArrayList<T> toArrayList() {
        return new ArrayList<>(List.of(first, second, third));
    }
    /**
     * Converts this Triple into an array containing its three elements.
     * The order of elements in the list will be v1, v2, v3.
     *
     * @return An array containing the elements of this Triple.
     */
    @NotNull
    @Contract(" -> new")
    public Object[] toArray() {
        return new Object[]{first, second, third};
    }

    /**
     * Applies a given mapping function to each element of this Triple,
     * returning a new Triple with the transformed elements.
     *
     * @param <T2> The type of the elements in the new Triple after mapping.
     * @param mapper The function to apply to each element.
     * @return A new {@link Triple} containing the results of applying the mapper function to each element.
     */
    @NotNull
    @Contract("_ -> new")
    public <T2> Triple<T2> map(@NotNull Function<T, T2> mapper) {
        return new Triple<>(
                mapper.apply(first),
                mapper.apply(second),
                mapper.apply(third)
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
    @NotNull
    @Contract(pure = true)
    public Stream<T> stream() {
        return Stream.of(first, second, third);
    }

    @Contract(pure = true, value = "_ -> new")
    public <R> R reduce(@NotNull TriFunction<T, T, T, R> reducer) {
        return reducer.apply(first, second, third);
    }


    /**
     * Applies the given consumer to each positional pair of the two input triples.
     * <p>
     *     This is if, you were to take {@code v1} of each Triple, and consume them with a {@link BiConsumer},
     *     applied to each argument in one call.
     * </p>
     * @implNote This means the {@link BiConsumer} will be called 3 different types for {{@link #first()}}, {@link #second()}
     *          and {@link #third()} of each triple
     * @param t1 The first triple
     * @param t2 The second triple
     * @param forEachConsumer The consumer to apply to each positional argument
     * @param <T> The type the first triple holds
     * @param <V> The type the second triple holds
     */
    public static <T, V> void forEachZip(@NotNull Triple<T> t1, @NotNull Triple<V> t2, @NotNull BiConsumer<T, V> forEachConsumer) {
        forEachConsumer.accept(t1.first, t2.first);
        forEachConsumer.accept(t1.second, t2.second);
        forEachConsumer.accept(t1.third, t2.third);
    }

    /**
     * Applies the given consumer to each positional pair of the two input triples.
     * <p>
     *     This is if, you were to take {@code v1} of each Triple, and consume them with a {@link BiConsumer},
     *     applied to each argument in one call.
     * </p>
     * @implNote This means the {@link BiConsumer} will be called 3 different types for {{@link #first()}}, {@link #second()}
     *          and {@link #third()} of each triple
     * @param t1 The first triple
     * @param t2 The second triple
     * @param forEachConsumer The consumer to apply to each positional argument
     * @param <T> The type the first triple holds
     * @param <V> The type the second triple holds
     * @deprecated Use {@link #forEachZip(Triple, Triple, BiConsumer)} instead
     */
    @Deprecated(forRemoval = true, since = "2.0.0")
    public static <T, V> void forEachPair(@NotNull Triple<T> t1, @NotNull Triple<V> t2, @NotNull BiConsumer<T, V> forEachConsumer) {
        forEachZip(t1, t2, forEachConsumer);
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
     * @deprecated Use {@link #zip(Triple, Triple, BiFunction)} instead
     */
    @Deprecated(forRemoval = true, since = "2.0.0")
    @NotNull
    @Contract("_, _, _ -> new")
    public static <T, U, V> Triple<V> mapPair(@NotNull Triple<T> t1, @NotNull Triple<U> t2, @NotNull BiFunction<T, U, V> mapper) {
        return zip(t1, t2, mapper);
    }

    /**
     * Zips each positional pair of the two input triples back into the same position of a new triple.
     * <p>
     *     This is if you were to take {@code v1} of each Triple, apply the map then save that as {@code v1} of
     *     a new triple, applied to each argument in one call.
     * </p>
     * <pre>{@code
     * Triple<Integer> a = new Triple<>(1, 2, 3);
     * Triple<Integer> b = new Triple<>(10, 20, 30);
     *
     * Triple<Integer> result =
     *     TripleUtils.zip(a, b, Integer::sum);
     *
     * // (11, 22, 33)
     * }</pre>
     * @param triple1 The first triple
     * @param triple2 The second triple
     * @param zipper The map to apply to each positional element of the triple
     * @return A new triple
     * @param <T> The type held by the first triple
     * @param <U> The type held by the second triple
     * @param <V> The type held by the new returned triple
     */
    @NotNull
    @Contract("_, _, _ -> new")
    public static <T, U, V> Triple<V> zip(@NotNull Triple<T> triple1, @NotNull Triple<U> triple2, @NotNull BiFunction<T, U, V> zipper) {
        return new Triple<>(
                zipper.apply(triple1.first, triple2.first),
                zipper.apply(triple1.second, triple2.second),
                zipper.apply(triple1.third, triple2.third)
        );
    }
}