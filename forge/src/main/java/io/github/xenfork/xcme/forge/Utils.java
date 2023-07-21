package io.github.xenfork.xcme.forge;

import java.text.MessageFormat;

public class Utils {
    public static String convert(Class<?> clazz) {
        return MessageFormat.format("L{0};", clazz.getName().replace(".", "/"));
    }
}
