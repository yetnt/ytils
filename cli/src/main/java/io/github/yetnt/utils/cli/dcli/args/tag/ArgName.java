package io.github.yetnt.utils.cli.dcli.args.tag;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class ArgName {

    public enum ArgNameType {
        DEFAULT, SINGULAR
    }

    private final String fullName;
    private final String shortName;
    private final ArgNameType type;

    private ArgName(
            String fullName,
            String shortName,
            ArgNameType type
    ) {
        this.fullName = fullName;
        this.shortName = shortName;
        this.type = type;
    }

    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    public static ArgName of(String fullName, String shortName) {
        return new ArgName(fullName, shortName,  ArgNameType.DEFAULT);
    }

    @NotNull
    @Contract(value = "_ -> new", pure = true)
    public static ArgName of(String fullName) {
        return new ArgName(fullName, fullName, ArgNameType.SINGULAR);
    }

    public String fullName() {
        return fullName;
    }

    public String shortName() {
        return shortName;
    }

    public ArgNameType getType() {
        return type;
    }
}
