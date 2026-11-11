package io.github.yetnt.utils.cli.dcli.args.tag;

public class ArgumentList<T> extends Argument<T> {
    private final ListSeparator listSeparator;
    public ArgumentList(Class<T> expected, ArgName tagName, TaggedSeparator separator, ListSeparator listSeparator) {
        super(expected, tagName, separator);
        this.listSeparator = listSeparator;
    }
}
