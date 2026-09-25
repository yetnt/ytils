package com.yetnt.utils.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * basically a String except this has a {@link #readAs(Class, Function)} and {@link #read(Class, Consumer)} methods such as to
 * allow {@link Class#getResourceAsStream(String)} reading via an anonymous function.
 * <p>
 *     From <a href="https://github.com/yetnt/j3engine">J3Engine</a>
 * </p>
 * @implNote The stream is wrapped ina  try-with-resources so you need not close it.
 * @param path The path in the resources folder to this file.
 */
public record JarPath(String path) {
    /**
     * Reads the file with the given function and returns a result
     * @param relative The class whose project resources should be read
     * @param func The function to read the file and return a result.
     * @return The result returned by the reader func
     * @param <T> The type of the result returned by the reader func
     * @throws IOException if any Io shit happens
     */
    public <T> T readAs(Class<?> relative, Function<InputStream, T> func) throws IOException {
        try (InputStream s = relative.getResourceAsStream(path)) {
            return func.apply(s);
        }
    }
    /**
     * Reads the file with the given function
     * @param relative The class whose project resources should be read
     * @param func The function to read the file.
     * @throws IOException if any Io shit happens
     */
    public void read(Class<?> relative, Consumer<InputStream> func) throws IOException {
        try (InputStream s = relative.getResourceAsStream(path)) {
            func.accept(s);
        }
    }
}