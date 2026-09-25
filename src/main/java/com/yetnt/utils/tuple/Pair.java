package com.yetnt.utils.tuple;

import java.util.Objects;

/**
 * A generic Pair class that holds two related objects.
 * <p>
 *     From <a href="https://github.com/yetnt/jaiva">Jaiva!</a>
 * </p>
 *
 * @param <T> The type of the first object.
 * @param <U> The type of the second object.
 *
 * @author Lehlogonolo Poole
 * @see MutablePair
 * @see SamePair
 * @see Triple
 */
public class Pair<T, U> {
    /** The first object in the pair. */
    protected final T first;
    /** The second object in the pair. */
    protected final U second;

    /**
     * Constructs a Pair with the specified objects.
     *
     * @param first  The first object.
     * @param second The second object.
     */
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Returns the first object
     * @return The first object
     */
    public T getFirst() {
        return first;
    }

    /**
     * Returns the second object
     * @return The second object
     */
    public U getSecond() {
        return second;
    }

    /**
     * Creates an immutable {@link Pair} from a {@link MutablePair} instance by fetching it's values.
     * @param pair The mutable pair
     */
    public Pair(MutablePair<T, U> pair) {
        this.first = pair.getFirst();
        this.second = pair.getSecond();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public String toString() {
        return "Pair{" + "first=" + first + ", second=" + second + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}