package io.d2a.ahpe;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class AhpeFile {

    public static void append(final File file, final String text) {
        Ahpe.yolo(() -> Files.writeString(file.toPath(), text, StandardOpenOption.APPEND, StandardOpenOption.CREATE));
    }

    public static void appendLine(final File file, final String text) {
        Ahpe.yolo(() -> Files.writeString(file.toPath(), text + "\n", StandardOpenOption.APPEND, StandardOpenOption.CREATE));
    }

    public static void appendLineMax(final File file, final String text, final int maxHowMany) {
        final List<String> lines = Ahpe.yolo(() -> Files.readAllLines(file.toPath(), StandardCharsets.UTF_8)).orElse(new ArrayList<>());
        lines.add(text);
        while (lines.size() > maxHowMany) {
            lines.remove(0);
        }
        Ahpe.yolo(() -> Files.write(file.toPath(), lines, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING));
    }

    public static List<String> readLines(final File file) {
        return Ahpe.yolo(() -> Files.readAllLines(file.toPath())).orElse(new ArrayList<>());
    }

    public static List<String> readFirstLines(final File file, final int howMany) {
        final List<String> lines = Ahpe.yolo(() -> Files.readAllLines(file.toPath())).orElse(new ArrayList<>());
        while (lines.size() > howMany) {
            lines.remove(lines.size() - 1);
        }
        return lines;
    }

    public static List<String> readLastLines(final File file, final int howMany) {
        final List<String> lines = Ahpe.yolo(() -> Files.readAllLines(file.toPath())).orElse(new ArrayList<>());
        while (lines.size() > howMany) {
            lines.remove(0);
        }
        return lines;
    }

}
