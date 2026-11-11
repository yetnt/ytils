package io.github.yetnt.utils.cli.dcli.args.tag;

import io.github.yetnt.utils.cli.dcli.args.ArgInterface;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Argument<T> implements ArgInterface {
    Class<T> expected;
    private final ArgName tagName;
    private final TaggedSeparator separator;
    private final ArgumentType type;

    public Argument(Class<T> expected, ArgName tagName, TaggedSeparator separator) {
        this.expected = expected;
        this.tagName = tagName;
        this.separator = separator;
        this.type = ArgumentType.FLAG;
    }

    protected Argument(Class<T> expected, ArgName tagName, TaggedSeparator separator, ArgumentType type) {
        this.expected = expected;
        this.tagName = tagName;
        this.separator = separator;
        this.type = type;
    }

    @NotNull
    @Contract("_ -> new")
    public static Argument<String> subcmd(String title) {
        return new Argument<>(String.class, ArgName.of(title), null);
    }

    @NotNull
    @Contract("_ -> new")
    public static Argument<?> anon(Class<?> expected) {
        return new Argument<>(expected, null, null, ArgumentType.ANON);
    }

    @Override
    public ArgumentType getType() {
        return type;
    }
}
