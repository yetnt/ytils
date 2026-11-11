package io.github.yetnt.utils.cli.types;

import io.github.yetnt.utils.cli.dcli.args.tag.ArgumentType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class ArgumentConstant {
    private final String name;
    private ArrayList<String> values;
    private final String value;
    private final ArgumentType argumentType;
    public ArgumentConstant(ArgumentType t, String value) {
        this.name = null;
        this.value = value;
        this.argumentType = t;
    }

    public ArgumentConstant(ArgumentType t, String name, String value) {
        this.name = name;
        this.value = value;
        this.argumentType = t;
    }

    public ArrayList<String> getValues() {
        return values;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public String getValue() {
        return values.getFirst();
    }

    @Override
    public String toString() {
        return "ArgumentConstant{" +
                "name='" + name + '\'' +
                ", type=" + argumentType +
                ", values=" + values +
                ", value='" + value + '\'' +
                '}';
    }
}
