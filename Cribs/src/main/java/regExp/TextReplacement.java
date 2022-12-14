package regExp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextReplacement {

    public static final String FILE_PATH = "D:\\Workspace\\WalGreens\\SchedulingService\\app\\src\\test\\java\\com\\walgreens\\h3\\scheduling\\v2\\utils\\EventBuilderTests.java";

    private static String regexp;

    public static void main(String[] args) throws IOException {
        changePlaces("assertThat(", ").isEqualTo(", ");");
    }

    public static void main2(String[] args) {
        System.out.println(replaceInLine("assertThat(10).isEqualTo(scheduledDateTime.getHour());", "assertThat(", ").isEqualTo(", ");"));
    }

    private static void changePlaces(final String... regexpParts) throws IOException {
        final List<String> strings = Files.readAllLines(Paths.get(FILE_PATH));
        for (String line : strings) {
            System.out.println(replaceInLine(line, regexpParts));
        }
    }

    private static String replaceInLine(final String text, final String... regexpParts) {
        getRegexpFromList(regexpParts);
        return text.replaceAll(regexp, regexpParts[0] + "$2" + regexpParts[1] + "$1" + regexpParts[2]);
    }

    private static void getRegexpFromList(final String[] regexpParts) {
        if (regexp != null) {
            return;
        }
        for (int i = 0; i < regexpParts.length; i++) {
            regexpParts[i] = regexpParts[i]
                    .replaceAll("\\(", "\\\\\\(")
                    .replaceAll("\\)", "\\\\\\)")
                    .replaceAll("\\.", "\\\\\\.");
        }
        regexp = regexpParts[0] + "(.*?)" + regexpParts[1] + "(.*?)" + regexpParts[2];
    }

}
