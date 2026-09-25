package com.yetnt.utils.collection.buckets;

/**
 * A utility class that acts as a container for a set of {@code Class} objects.
 * It provides a method to check if a given object is an instance of the
 * classes held within the bucket.
 * <p>
 *     From <a href="https://github.com/yetnt/jaiva">Jaiva!</a>
 * </p>
 * @see Buckets
 * @author Lehlogonolo Poole
 */
public class Bucket {
    private Class<?>[] cls;

    /**
     * Default Constructor to create a bucket with multiple {@link Class} stuff
     * @param classes Classes
     */
    public Bucket(Class<?> ...classes) {
        cls = classes;
    }

    /**
     * Whether the object {@code t} is a type of the classes this bucket holds.
     * @param t The object to check against
     * @return true if {@code clazz.isInstance(t)} of any which of the classes in this
     * bucket holds passes, or false otherwise
     */
    public boolean shouldHold(Object t) {
        for (Class<?> c : cls) {
            if (c.isInstance(t)) return true;
        }
        return false;
    }
}