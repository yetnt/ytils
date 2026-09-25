package com.yetnt.utils.builders;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * A helper class which applies ANSI escape codes to strings for lovely terminal output.
 * <p>
 *     Example usage:
 *     <pre>{@code
 *     String out = AnsiColour.print(
 *              "Oh my Glob",
 *              AnsiColour.FONT.BOLD,
 *              AnsiColour.FORE.BRIGHT_PURPLE,
 *              AnsiColour.BACK.WHITE
 *     );
 *     System.out.println(out);
 *     }</pre>
 * </p>
 * <p>
 *     From <a href="https://github.com/yetnt/jaiva">Jaiva!</a>
 * </p>
 * @author Lehlogonolo Poole
 */
public final class AnsiColour {

    /**
     * Applies ANSI escape codes to a given string to style its output in a console.
     * The styling can include text color, background color, and font styles (e.g., bold, italic).
     *
     * @param input  The string to be styled.
     * @param styles An array of {@link Style} enums (e.g., {@link FORE}, {@link BACK}, {@link FONT})
     *               to apply to the input string. If no styles are provided, the input string
     *               is returned as is.
     * @return The styled string with ANSI escape codes, followed by a reset code to ensure
     * subsequent console output is not affected.
     */
    public static String print(String input, Style... styles) {
        if (styles.length == 0) return input;
        String prefix = Arrays.stream(styles)
                .map(Style::getCode)
                .collect(Collectors.joining());
        return prefix + input + FORE.RESET.getCode();
    }

    /**
     * Applies ANSI escape codes to a given string to style its output in a console.
     * Unlike {@link #print(String, Style...)}, this method does not append a reset code,
     * allowing subsequent output to inherit the applied styles.
     * @param input The string to be styled.
     * @param styles An array of {@link Style} enums to apply.
     * @return The styled string with ANSI escape codes.
     */
    public static String printInline(String input, Style... styles) {
        if (styles.length == 0) return input;
        String prefix = Arrays.stream(styles)
                .map(Style::getCode)
                .collect(Collectors.joining());
        return prefix + input;
    }

    /**
     * Removes all ANSI colour codes froma  given string
     * @param withANSI Input with ANSI escape codes
     * @return input without ANSI escape codes
     */
    public static String remove(String withANSI) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < withANSI.length(); i++) {
            if (withANSI.charAt(i) == '\u001B'
                    && i + 1 < withANSI.length()
                    && withANSI.charAt(i + 1) == '[') {

                i += 2;

                // Skip until the terminating 'm'
                while (i < withANSI.length() && withANSI.charAt(i) != 'm') {
                    i++;
                }

                continue;
            }

            result.append(withANSI.charAt(i));
        }

        return result.toString();
    }

    /**
     * An interface representing a style that can be applied to console output.
     * Implementations of this interface provide the specific ANSI escape code for a style.
     */
    public interface Style {
        String getCode();
    }

    /**
     * Font styles
     */
    public enum FONT implements Style {
        BOLD("\033[1m"),
        UNDERLINE("\u001B[4m"),
        ITALIC("\033[3m");

        private final String code;

        FONT(String code) {
            this.code = code;
        }

        @Override
        public String getCode() {
            return code;
        }
    }

    /**
     * Foreground colours
     */
    public enum FORE implements Style {
        RESET("\u001B[0m"),
        RED("\u001B[31m"),
        BLACK("\u001B[30m"),
        GREEN("\u001B[32m"),
        YELLOW("\u001B[33m"),
        BLUE("\u001B[34m"),
        PURPLE("\u001B[35m"),
        CYAN("\u001B[36m"),
        WHITE("\u001B[37m"),

        // Bright/High-Intensity
        BRIGHT_BLACK("\u001B[90m"),
        BRIGHT_RED("\u001B[91m"),
        BRIGHT_GREEN("\u001B[92m"),
        BRIGHT_YELLOW("\u001B[93m"),
        BRIGHT_BLUE("\u001B[94m"),
        BRIGHT_PURPLE("\u001B[95m"),
        BRIGHT_CYAN("\u001B[96m"),
        BRIGHT_WHITE("\u001B[97m");

        private final String code;

        FORE(String code) {
            this.code = code;
        }

        @Override
        public String getCode() {
            return code;
        }
    }

    /**
     * Background colours
     */
    public enum BACK implements Style {
        BLACK("\u001B[40m"),
        RED("\u001B[41m"),
        GREEN("\u001B[42m"),
        YELLOW("\u001B[43m"),
        BLUE("\u001B[44m"),
        PURPLE("\u001B[45m"),
        CYAN("\u001B[46m"),
        WHITE("\u001B[47m"),

        // Bright/High-Intensity
        BRIGHT_BLACK("\u001B[100m"),
        BRIGHT_RED("\u001B[101m"),
        BRIGHT_GREEN("\u001B[102m"),
        BRIGHT_YELLOW("\u001B[103m"),
        BRIGHT_BLUE("\u001B[104m"),
        BRIGHT_PURPLE("\u001B[105m"),
        BRIGHT_CYAN("\u001B[106m"),
        BRIGHT_WHITE("\u001B[107m");

        private final String code;

        BACK(String code) {
            this.code = code;
        }

        @Override
        public String getCode() {
            return code;
        }
    }
}
