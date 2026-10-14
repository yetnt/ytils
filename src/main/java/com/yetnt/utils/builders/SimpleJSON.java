package com.yetnt.utils.builders;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * simple JSON utility.
 */
public class SimpleJSON {
    protected LinkedHashMap<String, Object> map = new LinkedHashMap<>();

    public SimpleJSON() {

    }

    public SimpleJSON(LinkedHashMap<String, Object> map) {
        this.map = new LinkedHashMap<>(map);
    }

    public void set(String name, Number value) {
        objSet(name, value);
    }

    public void set(String name, boolean value) {
        objSet(name, value);
    }

    public void set(String name, String value) {
        objSet(name, value);
    }

    public void set(String name, ArrayList<Object> value) {
        objSet(name, value);
    }

    public void set(String name, SimpleJSON value) {
        objSet(name, value);
    }

    public void set(String name) {
        objSet(name, null);
    }

    public <T> void set(String name, T[] v) {
        objSet(name, List.of(v));
    }

    protected void objSet(String name, Object value) {
        map.put(name, value);
    }

    public LinkedHashMap<String, Object> getMap() {
        return map;
    }

    @NotNull
    public String escapeBefore(String s) {
        return s;
    }

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

    private String objToStr(@Nullable Object input) {
        return switch (input) {
            case String s ->  "\"" + escape(s) + "\"";
            case List<?> arr -> {
                StringBuilder result = new StringBuilder();
                result.append("[");
                for (int i = 0; i < arr.size(); i++) {
                    Object o = arr.get(i);
                    boolean addComma = i != arr.size() - 1;
                    result.append(objToStr(o));
                    if (addComma) result.append(", ");
                }
                result.append("]");
                yield result.toString();
            }
            case SimpleJSON json -> json.toString();
            case null -> "null";
            default -> input.toString();
        };
    }

    public static String jsonArr(@NotNull List<SimpleJSON> jsons) {
        return  jsons.toString();
    }

    public SimpleJSON copy() {
        return new SimpleJSON(map);
    }

    @Override
    public String toString() {
        ArrayList<Map.Entry<String, Object>> entries = new ArrayList<>(map.entrySet());
        StringBuilder result = new StringBuilder();
        result.append("{");
        for (int i = 0; i < entries.size(); i++) {
            Map.Entry<String, Object> entry = entries.get(i);
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
}
