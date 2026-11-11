package io.github.yetnt.utils.builders;

import java.util.List;

public interface ToJSONList<T extends SimpleJSON, R extends Exception> {
    List<T> toJson() throws R;
}
