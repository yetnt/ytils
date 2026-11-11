package io.github.yetnt.utils.cli;

import io.github.yetnt.utils.cli.dcli.ArgumentsConsumer;
import io.github.yetnt.utils.cli.dcli.DArgs;
import io.github.yetnt.utils.functional.consumer.ThrowableConsumer;
import org.jetbrains.annotations.NotNull;

public class DeclarativeCli {
    private DArgs argPaths;

    public DeclarativeCli(DArgs argPaths) {
        this.argPaths = argPaths;
    }

    public <T extends Exception> void read(String[] args, @NotNull ThrowableConsumer<ArgumentsConsumer, T> consumer) throws T {
        consumer.apply(new ArgumentsConsumer(argPaths, args));
    }
}
