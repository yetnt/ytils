package io.github.yetnt.utils.tuple;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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
     * Represents the result of {@link #zip(List, List)}
     * @param isSuccessful Whether the zip was even successful or not
     * @param zippedList The list itself
     * @param <T> The type held by each SamePair within the list.
     */
    public static record ZipResult<T>(
            boolean isSuccessful,
            @Nullable List<SamePair<T>> zippedList
    ) {
        // Methods for implementors which still expect the Pair naming scheme

        /**
         * Identical to {@link #isSuccessful()}
         * @return Whether the zip was successful or not.
         */
        public boolean getFirst() {
            return isSuccessful;
        }

        /**
         * Identical to {@link #zippedList()}
         * @return The list itself
         */
        @Nullable
        public List<SamePair<T>> getSecond() {
            return zippedList;
        }

        /**
         * Converts the given generic List to a more specific collection. This is identical to calling
         * {@code zippedList().stream().collect(...)}
         * <pre>{@code
         * ZippedResult<Integer> result = zip(List.of(1, 2), List.of(3, 4));
         * if (result.isSuccessful()) {
         *     ArrayList<SamePair<Integer>> list = result.zippedListAs(ArrayList::new)
         * }
         * }</pre>
         * @param supplier Da supplier providing a new empty Collection into which the results will be inserted
         * @return A new collection
         * @param <R> The type of the resulting collection
         */
        @Nullable
        public <R extends Collection<SamePair<T>>> Collection<SamePair<T>> zippedListAs(@NotNull Supplier<R> supplier) {
            if (zippedList == null) return null;
            return zippedList.stream()
                    .collect(Collectors.toCollection(
                            supplier
                    ));
        }
    }

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
    @NotNull
    @Contract("_ -> new")
    public static <T> SamePair<T> from(@NotNull Pair<T, T> samePair) {
        return new SamePair<>(samePair.getFirst(), samePair.getSecond());
    }

    /**
     * Attempts to zip 2 lists of the same type T to a single list of zips where each element yada yada bruv
     * essentially:
     * <pre>{@code
     * List<Integer> A = List.of(1, 2, 3);
     * List<Integer> B = List.of(4, 5, 6);
     *
     * ZipResult result = zip(A, B);
     * ArrayList<SamePair<Integer>> pairs;
     * if (result.isSuccessful())
     *      pairs = result.getSecond();
     *
     * // pairs holds:
     * // SamePair(1, 4)
     * // SamePair(2, 5)
     * // SamePair(3, 6)
     * }</pre>
     * @param ls The first list
     * @param list The second list
     * @return A new ZipResult
     * @param <T> The type everything finna hold
     * @implSpec You might want to check whether the zip was even successful before fetching the
     * list. Otherwise null baby!
     */
    @NotNull
    @Contract("_, _ -> new")
    public static <T> ZipResult<T> zip(@NotNull List<T> ls, @NotNull List<T> list) {
        if (ls.size() != list.size())
            return new ZipResult<>(false, null);
        ArrayList<SamePair<T>> pairs = new ArrayList<>();
        for (int i = 0; i < ls.size(); i++) {
            pairs.add(
                    new SamePair<>(ls.get(i), list.get(i))
            );
        }
        return new ZipResult<>(true, pairs);
    }

    /**
     * Applies a given mapping function to each element of this SamePair,
     * returning a new SamePair with the transformed elements.
     *
     * @param <U> The type of the elements in the new SamePair after mapping.
     * @param function The function to apply to each element.
     * @return A new {@link SamePair} containing the results of applying the mapper function to each element.
     */
    @NotNull
    @Contract(pure = true)
    public <U> SamePair<U> map(@NotNull Function<T, U> function) {
        return new SamePair<U>(function.apply(first), function.apply(second));
    }

    /**
     * Applies the given function to the SamePair to return a single value.
     * @param function The mapper function
     * @return A single value
     * @param <U> The type of the single value to return
     */
    @NotNull
    @Contract(pure = true)
    public <U> U zip(@NotNull BiFunction<T, T, U> function) {
        return function.apply(first, second);
    }

    /**
     * Applies the given function to the SamePair to return a single value.
     * @param function The mapper function
     * @return A single value
     * @param <U> The type of the single value to return
     * @deprecated Use {@link #zip(List, List)} instead.
     */
    @NotNull
    @Contract(pure = true)
    @Deprecated(since = "2.0.0", forRemoval = true)
    public <U> U mapTo(@NotNull BiFunction<T, T, U> function) {
        return zip(function);
    }

    public <R> Triple<R> expand(@NotNull BiFunction<T, T, Triple<R>> function) {
        return function.apply(first, second);
    }
}