package com.yetnt.utils.functional.generic;

/**
 * Functional interface describing a function which
 * takes no args and produces side effects but may throw
 * @param <T> The type of the exception thrown
 */
@FunctionalInterface
public interface ThrowableRunnable<T extends Throwable> {
    void run() throws T;
}
