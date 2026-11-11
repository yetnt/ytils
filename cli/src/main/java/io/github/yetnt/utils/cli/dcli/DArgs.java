package io.github.yetnt.utils.cli.dcli;

import io.github.yetnt.utils.cli.dcli.args.ArgInterface;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DArgs {
    private ArrayList<ArgumentPath> argumentPaths = new ArrayList<>();

    public DArgs() {
    }

    public DArgs path(@NotNull ArgInterface...args) {
        argumentPaths.add(ArgumentPath.of(args));
        return this;
    }

    public ArrayList< ArgumentPath> getPaths() {
        return argumentPaths;
    }
}
