package com.yetnt.utils.builders;


import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * Simple JSON utility.
 * Damn you im not documenting this or giving an exmaple
 */
public class SimpleJSON {

    protected HashMap<Class<?>, Function<Object, SimpleJSON>> supportedClasses = new HashMap<>();
    protected Map<String, Object> map;

    /**
     * Default Constructor which sets the internal map to a {@link LinkedHashMap}
     * to retain key-value order.
     */
    public SimpleJSON() {
        this.map = new LinkedHashMap<>();
    }

    /**
     * Constructor which allows setting of the internal map to whatever custom map implementation
     * @param map Custom map
     */
    public SimpleJSON(Map<String, Object> map) {
        this.map = map;
    }

    /**
     * Sets this key to map to the given {@link Number}. if the key exists, it's overridden
     * @param key The key to set to
     * @param value The number value
     */
    public void set(String key, @NotNull Number value) {
        objSet(key, value);
    }

    /**
     * Sets this key to map to the given {@link Boolean}. if the key exists, it's overridden
     * @param key The key to set to
     * @param value The boolean value
     */
    public void set(String key, boolean value) {
        objSet(key, value);
    }

    /**
     * Sets this key to map to the given {@link String}. if the key exists, it's overridden
     * @param key The key to set to
     * @param value The string value
     */
    public void set(String key, @NotNull String value) {
        objSet(key, value);
    }

    /**
     * Sets this key to map to the given {@link ToJSON} implementor.
     * if the key exists, it's overridden
     * @implNote The reference to this object is stored, meaning it's {@link ToJSON#toJson()} is called
     * once {@link #toString()} is called.
     * @param key The key to set to
     * @param value The {@link ToJSON} implementor
     */
    public void set(String key, @NotNull ToJSON<?, ?> value) {
        objSet(key, value);
    }

    /**
     * Sets this key to map to the given {@link SimpleJSON}. if the key exists, it's overridden
     * @implNote The reference to this json is stored, meaning it's only fully serialized
     * once {@link #toString()} is called.
     * @param key The key to set to
     * @param value The other {@link SimpleJSON} reference
     */
    public void set(String key, @NotNull SimpleJSON value) {
        objSet(key, value);
    }

    /**
     * Sets this key to map to the given {@link List}. if the key exists, it's overridden.
     * @implNote The reference to this list is stored, meaning it's only fully serialized
     * (to a JSON array) once {@link #toString()} is called.
     * @param key The key to set to
     * @param value The list reference
     */
    public void set(String key, @NotNull List<?> value) {
        objSet(key, value);
    }

    /**
     * Sets this key to map to the given {@link Set}. if the key exists, it's overridden.
     * @implNote The reference to this set is stored, meaning it's only fully serialized
     * (to a JSON array) once {@link #toString()} is called. Also like any Set,
     * order isn't guaranteed. SimpleJSON doesnt bother to suddenly implement order
     * @param key The key to set to
     * @param value The set reference
     */
    public void set(String key, @NotNull Set<?> value) {
        objSet(key, value);
    }

    /**
     * Sets this key to map to the given {@link Map}. if the key exists, it's overridden.
     * @implNote The reference to this map is stored, meaning it's only fully serialized
     * (to a JSON object) once {@link #toString()} is called. Being a {@code <String, ?>} map,
     * the keys of the JSON blob will obviously be the input keys.
     * @param key The key to set to
     * @param value The map reference
     */
    public void setMapString(String key, @NotNull Map<String, ?> value) {
        objSet(key, value);
    }

    /**
     * Sets this key to map to the given {@link Map}. if the key exists, it's overridden.
     * @implNote The reference to this map is stored, meaning it's only fully serialized
     * (to a JSON object) once {@link #toString()} is called. Being a {@code <Enum<?>, ?>} map,
     * the keys of the JSON blob will be the enum keys's result of {@link Enum#name()}
     * @param key The key to set to
     * @param value The map reference
     */
    public void setMapEnum(String key, @NotNull Map<Enum<?>, ?> value) {
        objSet(key, value);
    }

    /**
     * Sets this key to map to the given array. if the key exists, it's overridden.
     * @implNote The reference to this array is stored, meaning it's only fully serialized
     * (to a JSON array) once {@link #toString()} is called.
     * @param key The key to set to
     * @param values The array reference
     */
    public <T> void set(String key, @NotNull T[] values) {
        objSet(key, values);
    }

    /**
     * Sets this key to map to {@code null}. if the key exists, it's overridden.
     * @implNote This is a specialisation of calling {@link #set(String, Object)}
     * where the object is null. The output JSON will have the literal null value.
     * @param key The key to set to
     */
    public void set(String key) {
        objSet(key, null);
    }

    /**
     * Sets this key to map to the given {@link Object}. if the key exists, it's overridden.
     * @implNote The behaviour of this depends on what the object is.
     * If it is either of these: {@code null}, {@link Number}, {@link Boolean}, {@link ArrayList},
     * {@link Set}, {@link String}, {@link Map}, an implementor of {@link ToJSON} or a raw array,
     * the value gets sets accordingly. If however none of those pass
     * and this happens to be some other class which is not within {@link #getSupportedClasses()},
     * then this will throw.
     * @param key The key to set to
     * @param value The list reference
     * @throws UnsupportedOperationException If the given value is not supported.
     */
    public void set(String key, @Nullable Object value) {
        switch (value) {
            case null -> set(key);
            case Number n -> set(key, n);
            case Boolean b -> set(key, b.booleanValue());
            case ArrayList<?> a -> set(key, a);
            case Set<?> s -> set(key, s);
            case String s -> set(key, s);
            // later validation will validate the map anyways.
            case Map<?, ?> m -> objSet(key, m);
            case ToJSON<?, ?> toj -> set(key, toj);
            case SimpleJSON sj -> set(key, sj);
            default -> {
                if (value.getClass().isArray()) {
                    set(key, (Object[]) value);
                    break;
                }
                if (supportedClasses.containsKey(value.getClass())) {
                    objSet(key, value);
                    break;
                }

                throw new UnsupportedOperationException("Unsupported type: " + value.getClass());
            }
        }
    }

    /**
     * Adds support for converting this class to a {@link SimpleJSON} object by providing
     * the class and the converter function.
     * @implNote You could also just implement {@link ToJSON} and skip this extra step entirely.
     * @param clazz The given class
     * @param converter The converter which helps with converting this to a {@link SimpleJSON} object
     * @param <T> The type of the class.
     */
    public <T> void addSupportFor(@NotNull Class<T> clazz, @NotNull Function<T, SimpleJSON> converter) {
        //noinspection unchecked
        supportedClasses.put(clazz, (Function<Object, SimpleJSON>) converter);
    }

    /**
     * Sets the object.
     * @implSpec You gotta really knwo what you're doing to override or call this.
     * @param key The key
     * @param value The value.
     */
    protected void objSet(String key, @Nullable Object value) {
        map.put(key, value);
    }

    /**
     * Retrieves the map which will effectively be converted to it's JSON representation
     * @return The map
     */
    @NotNull
    public Map<String, Object> getMap() {
        return map;
    }

    /**
     * Retrieves the supported classes map.
     * @return The map again.
     */
    @NotNull
    public HashMap<Class<?>, Function<Object, SimpleJSON>> getSupportedClasses() {
        return supportedClasses;
    }

    /**
     * Allows implementors to perform special escaping of string input. The default implementation
     * returns the input unchanged.
     * @implSpec This is called first within {@link #escape(String)} before it performs any
     * backslash escaping.
     * @param s The input string
     * @return The output string
     */
    @NotNull
    protected String escapeBefore(String s) {
        return s;
    }

    /**
     * Escapes the given string input so json doesnt die.
     * @param i The input string
     * @return The output string with (some) stuff escaped. Being:
     * {@code \}, {@code "}, {@code \b}, {@code \f}, {@code \n},
     * {@code \r}, {@code \t}
     */
    @NotNull
    private String escape(String i) {
        return escapeBefore(i)
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\b", "\\b")
                .replace("\f", "\\f")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    /**
     * Converts the given object to it's JSON string
     * @param input The input object
     * @return The output string
     * @throws Exception If someting throws lol.
     */
    private String objToStr(@Nullable Object input) throws Exception {
        return switch (input) {
            case String s ->  "\"" + escape(s) + "\"";
            case Set<?> set -> collectionToString(set);
            case List<?> arr -> collectionToString(arr);
            case ToJSON<?, ?> conv -> conv.toJson().toString();
            case SimpleJSON json -> json.toString();
            case Map<?, ?> m -> mapToStr(m);
            case null -> "null";
            default ->
                    input.getClass().isArray() ?
                            collectionToString(Arrays.asList((Object[]) input))
                            : (supportedClasses.containsKey(input.getClass())) ?
                            supportedClasses.get(input.getClass()).apply(input).toString()
                            : input.toString();
        };
    }

    /**
     * Converts an anonymous collection, ({@link ArrayList} or {@link Set} or whatever else)
     * of Objects into a JSON String array.
     * @implNote The objects within the collection have to comply with the valid types listed in
     * {@link #set(String, Object)}
     * @param collection The collection
     * @return A JSON String Array
     * @throws Exception If something throws lol
     */
    public final String collectionToString(@NotNull Collection<?> collection) throws Exception {
        if (collection.isEmpty()) return "[]";
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (Object o : collection) {
            result.append(objToStr(o)).append(",");
        }
        result.deleteCharAt(result.length() - 1); // remove last comma
        result.append("]");
        return result.toString();
    }

    /**
     * Copies the JSON
     * @implNote The internal map of the returned JSON is of its own instance.
     * @return A new {@link SimpleJSON}
     */
    @Contract(pure = true)
    public SimpleJSON copy() {
        return new SimpleJSON(map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    /**
     * Converts the given map to a JSON string of key/value pairs
     * @implSpec Note that, the map should either have {@link String} keys or
     * {@link Enum} keys. Otherwise, it's rejected.
     * @param map The map input
     * @return The JSON Object String
     * @throws Exception If the given map doesn't have only String keys or only Enum keys.
     */
    public String mapToString(Map<?, ?> map) throws Exception {
        return mapToStr(map);
    }

    /**
     * Converts the given map to a string and does checking and shi
     * @param map The map
     * @return The JSON string
     * @throws Exception im tired.
     */
    @SuppressWarnings("unchecked")
    @NotNull
    private String mapToStr(@NotNull Map<?, ?> map) throws Exception {
        if (map.isEmpty()) return "{}";
        ArrayList<Map.Entry<?, ?>> entries = new ArrayList<>(map.entrySet());
        Class<? extends Enum<?>> enumClass = null;
        boolean mixedTypes = false;
        boolean isStr = false;
        ArrayList<Map.Entry<String, ?>> newEntries;

        for (Map.Entry<?, ?> e : entries) {
            Object o = e.getKey();
            try {
                if (o.getClass().isEnum() && !isStr) {
                    Class<? extends Enum<?>> oClass = (Class<? extends Enum<?>>) o.getClass();
                    if (enumClass == null) {
                        enumClass = oClass;
                    } else if (enumClass != oClass) {
                        mixedTypes = true;
                        break;
                    }
                } else if (o instanceof String && enumClass == null) {
                    isStr = true;
                } else {
                    mixedTypes = true;
                    break;
                }
            } catch (NullPointerException ex) {
                // o is null.
                mixedTypes = true;
                break;
            }
        }

        if (mixedTypes)
            throw new UnsupportedOperationException("Input map should only contain string or enum keys!: " + map);
        else if (enumClass != null)
            newEntries = entries.stream().map(s -> (Map.Entry<Enum<?>, ?>) s)
                    .map(s -> new AbstractMap.SimpleEntry<>(s.getKey().name(), s.getValue()))
                    .collect(Collectors.toCollection(ArrayList::new));
        else
            newEntries = entries.stream().map(s -> (Map.Entry<String, ?>) s)
                    .collect(Collectors.toCollection(ArrayList::new));

        StringBuilder result = new StringBuilder();
        result.append("{");
        for (int i = 0; i < entries.size(); i++) {
            Map.Entry<String, ?> entry = newEntries.get(i);
            boolean addComma = i != entries.size() - 1;
            String key = entry.getKey();
            Object value = entry.getValue();

            result.append(objToStr(key));
            result.append(" : ");
            result.append(objToStr(value));
            if (addComma) result.append(", ");
        }
        result.append("}");
        return result.toString();
    }

    /**
     * Converts the inner map into a JSON String. This is effectively the same as doing the following:
     * <pre>{@code
     * String json = simpleJson.mapToString(simpleJson.getMap());
     * }</pre>
     * @return The JSON String
     */
    @Override
    public String toString() {
        try {
            return mapToStr(map);
        } catch (Throwable e) {
            throw new RuntimeException("Input could not be converted to JSON! " + e);
        }
    }
}