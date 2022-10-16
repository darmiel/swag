package io.d2a.ahpe;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class AhpeFile {

    private static final Set<Class<?>> acceptedParseTypes = new HashSet<>(Arrays.asList(
            int.class, Integer.class,
            double.class, Double.class,
            float.class, Float.class,
            boolean.class, Boolean.class,
            String.class
    ));

    /**
     * Write the text to the file.
     * All other contents will be truncated.
     *
     * @param file The file to write to
     * @param text The text to write
     */
    public static void write(final File file, final String text) {
        Ahpe.yolo(() -> Files.writeString(file.toPath(), text,
                StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE));
    }

    /**
     * Appends the text to the file.
     * If the file doesn't already exist, the file is newly created.
     *
     * @param file The file to write to
     * @param text The text to write
     */
    public static void append(final File file, final String text) {
        Ahpe.yolo(() -> Files.writeString(file.toPath(), text,
                StandardOpenOption.WRITE, StandardOpenOption.APPEND, StandardOpenOption.CREATE));
    }

    /**
     * Appends the text to the file and adds a new-line.
     * If the file doesn't already exist, the file is newly created.
     *
     * @param file The file to write to
     * @param text The text to write
     */
    public static void appendLine(final File file, final String text) {
        AhpeFile.append(file, text + "\n");
    }

    /**
     * Appends the text to the file with new line.
     * If there are already more than {maxHowMany} lines in the file,
     * the first lines are removed so that in the end there are only {maxHowMany} lines in the file.
     *
     * <pre>
     *      appendLineMax(file, "hello1", 2)
     *      appendLineMax(file, "hello2", 2)
     *      appendLineMax(file, "hello3", 2)
     * </pre>
     * outputs:
     * <pre>
     *     hello2
     *     hello3
     * </pre>
     *
     * @param file       The file to write to
     * @param text       The text to write
     * @param maxHowMany Max amount of lines in file
     */
    public static void appendLineMax(final File file, final String text, final int maxHowMany) {
        final List<String> lines = Ahpe.yolo(() -> Files.readAllLines(file.toPath(), StandardCharsets.UTF_8)).orElse(new ArrayList<>());
        lines.add(text);
        while (lines.size() > maxHowMany) {
            lines.remove(0);
        }
        Ahpe.yolo(() -> Files.write(file.toPath(), lines,
                StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE));
    }

    ///

    /**
     * Reads all contents of the file in a single string
     *
     * @param file The file to read from
     * @return File contents
     */
    public static String read(final File file) {
        return Ahpe.yolo(() -> Files.readString(file.toPath())).nil();
    }

    /**
     * Reads all lines in the file.
     *
     * @param file The file to read from
     * @return Lines of file
     */
    public static List<String> readLines(final File file) {
        return Ahpe.yolo(() -> Files.readAllLines(file.toPath())).nil();
    }

    /**
     * Reads out all lines in the file, but returns only the first {howMany} lines.
     *
     * @param file    The file to read from
     * @param howMany How many lines to read
     * @return First {howMany} lines
     */
    public static List<String> readFirstLines(final File file, final int howMany) {
        final List<String> lines = Ahpe.yolo(() -> Files.readAllLines(file.toPath())).nil();
        while (lines.size() > howMany) {
            lines.remove(lines.size() - 1);
        }
        return lines;
    }

    /**
     * Reads out all lines in the file, but returns only the last {howMany} lines.
     *
     * @param file    The file to read from
     * @param howMany How many lines to read
     * @return Last {howMany} lines
     */
    public static List<String> readLastLines(final File file, final int howMany) {
        final List<String> lines = Ahpe.yolo(() -> Files.readAllLines(file.toPath())).orElse(new ArrayList<>());
        while (lines.size() > howMany) {
            lines.remove(0);
        }
        return lines;
    }

    ///

    /**
     * Parses a class from a given CSV- (or separator-separated) String.
     * Make sure the target class has a constructor with exactly the same count of data
     *
     * <h2>Data</h2>
     * <code>peter, 12, true</code>
     * <br />
     *
     * <h2>Target Class</h2>
     * <pre>
     *     public class Person {
     *         public Person(final String name, final int age, final boolean cool) {
     *             // ...
     *         }
     *     }
     * </pre>
     * <p>
     * <hr />
     *
     * <pre>
     *     final Person person = AhpeFile.parseSeparated("peter,12,true", ", ", Person.class);
     * </pre>
     *
     * @param data                separated data as string
     * @param separatorExpression separator (e. g. ',')
     * @param clazz               Type Class
     * @param <T>                 Type
     * @return Object of type {Type}
     */
    private static <T> T parseSeparatedExplicit(final String data, final String separatorExpression, final Class<T> clazz)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final String[] split = data.split(separatorExpression);

        Constructor<T> constructor = null;
        uwu:
        for (final Constructor<?> c : clazz.getConstructors()) {
            if (c.getParameterCount() != split.length) {
                continue;
            }
            if (!Modifier.isPublic(c.getModifiers())) {
                continue;
            }
            // check if only primitive types in parameters
            for (Class<?> type : c.getParameterTypes()) {
                if (!acceptedParseTypes.contains(type)) {
                    continue uwu;
                }
            }
            constructor = clazz.getDeclaredConstructor(c.getParameterTypes());
        }
        // no constructor found
        if (constructor == null) {
            throw new IllegalArgumentException("no suitable constructor found");
        }

        // create class
        int i = 0;
        final List<Object> parameters = new ArrayList<>();
        for (Class<?> type : constructor.getParameterTypes()) {
            if (int.class.equals(type) || Integer.class.equals(type)) {
                parameters.add(Integer.parseInt(split[i++]));
            } else if (double.class.equals(type) || Double.class.equals(type)) {
                parameters.add(Double.parseDouble(split[i++]));
            } else if (float.class.equals(type) || Float.class.equals(type)) {
                parameters.add(Float.parseFloat(split[i++]));
            } else if (boolean.class.equals(type) || Boolean.class.equals(type)) {
                parameters.add(split[i++].equalsIgnoreCase("true"));
            } else if (String.class.equals(type)) {
                parameters.add(split[i++]);
            } else {
                throw new IllegalArgumentException("invalid type: " + type);
            }
        }

        return constructor.newInstance(parameters.toArray());
    }

    /* See above */
    public static <T> T parseSeparated(final String data, final String separatorExpression, final Class<T> clazz) {
        return Ahpe.yolo(() -> parseSeparatedExplicit(data, separatorExpression, clazz)).orElse(null);
    }

    /* See above */
    public static <T> List<T> parseSeparatedFile(final File file, final String separatorExpression, final Class<T> clazz) {
        return parseSeparatedFile(file, separatorExpression, clazz, false);
    }

    /* See above */
    public static <T> List<T> parseSeparatedFile(final File file, final String separatorExpression, final Class<T> clazz, final boolean ignoreHeader) {
        final List<T> result = new ArrayList<>();
        final List<String> lines = readLines(file);
        boolean header = false;
        for (final String line : lines) {
            if (!header) {
                header = true;
                if (ignoreHeader) {
                    continue;
                }
            }
            if (line.isBlank()) {
                continue;
            }
            final T res = parseSeparated(line, separatorExpression, clazz);
            if (res == null) {
                System.out.println("[AHPE] Warning: found null row");
                continue;
            }
            result.add(res);
        }
        return result;
    }

}
