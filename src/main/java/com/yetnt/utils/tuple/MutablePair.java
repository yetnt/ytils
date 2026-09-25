package com.yetnt.utils.tuple;

/**
 * A mutable version of {@link Pair}
 * <p>
 *     From <a href="https://github.com/yetnt/j3engine">J3Engine</a>
 * </p>
 * @param <T> The type of the first element
 * @param <U> The type of the second element
 * @author Lehlogonolo Poole
 */
public class MutablePair<T, U> {
    private T first;
    private U second;

    /**
     * Constructs a new MutablePair
     * @param first The first value
     * @param second The second value
     */
    public MutablePair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Gets the first value
     * @return The first value
     */
    public T getFirst() {
        return first;
    }

    /**
     * Gets the second value
     * @return The second value
     */
    public U getSecond() {
        return second;
    }

    /**
     * Sets the first value
     * @param first The new value
     */
    public void setFirst(T first) {
        this.first = first;
    }

    /**
     * Sets the second value
     * @param second The new value
     */
    public void setSecond(U second) {
        this.second = second;
    }

    /**
     * Creates a pair of the first and second value, effectively "freezing" them.
     * <p>
     *     This is similar to calling
     *     <pre>{@code
     *     MutablePair<T, U> mut = ...;
     *     Pair<T, U> pair1 = new Pair<>(mut);                              // using constructor
     *     Pair<T, U> pair2 = new Pair<>(mut.getFirst(), mut.getSecond());  // using values directly
     *     }</pre>
     * </p>
     * @return A new pair
     */
    public Pair<T, U> freeze() {
        return new Pair<>(this);
    }
}