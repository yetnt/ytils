package io.github.yetnt.utils.cli.dcli;

import io.github.yetnt.utils.cli.dcli.args.ArgInterface;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class ArgumentPath {
    private ArrayList<ArgInterface> arguments = new ArrayList<>();

    private ArgumentPath(ArrayList<ArgInterface> arguments) {
        this.arguments = arguments;
    }

    @NotNull
    @Contract("_ -> new")
    public static ArgumentPath of(ArgInterface... arguments) {
        return new ArgumentPath(new ArrayList<>(Arrays.asList(arguments)));
    }

    public ArrayList<ArgInterface> getArguments() {
        return arguments;
    }
}
