package com.yetnt.utils.builders;

interface ToJSON<T extends SimpleJSON, R extends Exception> {
    T toJson() throws R;
}
