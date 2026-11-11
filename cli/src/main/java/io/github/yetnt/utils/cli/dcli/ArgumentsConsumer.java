package io.github.yetnt.utils.cli.dcli;

import io.github.yetnt.utils.cli.dcli.args.ArgInterface;
import io.github.yetnt.utils.cli.dcli.args.tag.ArgumentType;
import io.github.yetnt.utils.cli.types.ArgumentConstant;
import io.github.yetnt.utils.tuple.Pair;
import io.github.yetnt.utils.tuple.SamePair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ArgumentsConsumer {
    private final DArgs dArgsDefiniton;
    private final String[] originalArgs;
    private final ArrayDeque<String> args;

    private ArrayList<ArgumentPath> paths = new ArrayList<>();
    private ArgumentConstant  argumentConstant;
    private ArrayList<ArgumentType> list = new ArrayList<>();
    private int pos = 0;

    public ArgumentsConsumer(@NotNull DArgs dArgsDefinition, String[] originalArgs) {
        this.dArgsDefiniton = dArgsDefinition;
        this.originalArgs = originalArgs;
        this.args = new ArrayDeque<>(List.of(originalArgs));
        this.paths.addAll(dArgsDefinition.getPaths());
    }

    @Nullable
    private String consumeNext() {
        if (args.isEmpty()) return null;
        return args.removeFirst();
    }

    @Nullable
    private String peekNext() {
        if (args.isEmpty()) return null;
        return args.getFirst();
    }

    public boolean expect(ArgumentType argumentType) {
        boolean result = true;
        list.add(argumentType);
        pos++;
        ArrayList<ArgumentPath> oldPaths = new ArrayList<>(paths);
        filterAndMatch();
        if (args.isEmpty()) result = false;
        String arg = args.removeFirst();
        if (result) {
            result = switch (argumentType) {
                case ANON, SUBCOMMAND -> {
                    argumentConstant = new ArgumentConstant(argumentType, arg);
                    yield true;
                }
                case FLAG, FLAG_MVALUES -> {
                    if (!(arg.startsWith("-"))) yield false;
                    if ((arg.contains("=") || arg.contains(":")) || argumentType == ArgumentType.FLAG) {
                        String[] parts = arg.split(Pattern.quote("="));
                        String[] parts2 = arg.split(Pattern.quote(":"));
                        if (parts.length == 2) {
                            argumentConstant = new ArgumentConstant(argumentType, parts[0], parts[1]);
                            yield true;
                        } else if (parts2.length == 2) {
                            argumentConstant = new ArgumentConstant(argumentType, parts2[0], parts2[1]);
                            yield true;
                        } else {
                            String peek = peekNext();
                            if (peek == null || peek.startsWith("-") || peek.startsWith("--")) {
                                argumentConstant = new ArgumentConstant(argumentType, arg, arg);
                            } else {
                                String consume = consumeNext();
                                argumentConstant = new ArgumentConstant(argumentType, arg, consume);
                            }
                            yield true;
                        }
                    } else {
                        // take the name and keep consuming until an arg starts with -- or -
                        StringBuilder sb = new StringBuilder();
                        String next = "";
                        while (true) {
                            String peek = peekNext();
                            if (peek != null && (peek.startsWith("--") || peek.startsWith("-")))
                                yield false;
                            next = consumeNext();
                            if (next == null) break;
                            sb.append(next);
                        }
                        argumentConstant = new ArgumentConstant(argumentType, arg, sb.toString());
                        yield true;
                    }
                }
            };
        }

        if (!result) {
            paths = oldPaths;
            pos--;
            args.addFirst(arg);
            list.removeLast();
            return false;
        } else {
            return true;
        }

    }

    public ArgumentConstant getArgumentConstant() {
        return argumentConstant;
    }

    private void filterAndMatch() {
        paths = paths.stream().filter(p -> {
            List<ArgumentType> ls = new ArrayList<>(p.getArguments().subList(0, list.size())).stream().map(ArgInterface::getType).toList();
            Pair<Boolean, ArrayList<SamePair<ArgumentType>>> pairable = SamePair.pairable(ls, list);
            return pairable.getFirst();
        }).collect(Collectors.toCollection(ArrayList::new));
    }
}
