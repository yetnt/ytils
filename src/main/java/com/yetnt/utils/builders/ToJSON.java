package com.yetnt.utils.builders;

public interface ToJSON<T extends SimpleJSON, R extends Exception> {
    T toJson() throws R;
}
