package regExp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextReplacement2 {

    public static final String FILE_PATH = "D:\\Workspace\\WalGreens\\SchedulingService\\app\\src\\test\\java\\com\\walgreens\\h3\\scheduling\\v2\\utils\\EventBuilderTests.java";

    private static String regexp;

    public static void main2(String[] args) throws IOException {
        changePlaces("assertThat(", ").isEqualTo(", ");");
    }

    public static void main(String[] args) {
        replaceInLine("assertThat(10).isEqualTo(scheduledDateTime.getHour());", "assertThat(", ").isEqualTo(", ");");
    }

    private static void changePlaces(final String... regexpParts) throws IOException {
        final List<String> strings = Files.readAllLines(Paths.get(FILE_PATH));
        for (String line : strings) {
            System.out.println(replaceInLine(line, regexpParts));
        }
    }

    private static String replaceInLine(final String text, final String... regexpParts) {
        getRegexpFromList(regexpParts);
        if (text.contains(regexpParts[0])) {
            final String[] textBefore = text.split(regexp);
            Pattern p = Pattern.compile(regexp);
            Matcher m = p.matcher(text);
            while (m.find()) {
                System.out.println(m.group());
            }
            return getTextBefore(textBefore) + text.replace(regexp, regexpParts[0] + "$2" + regexpParts[1] + "$1" + regexpParts[2]);
        }
        return text;
    }

    private static String getTextBefore(final String[] textBefore) {
        return textBefore.length > 0 ? textBefore[0] : "";
    }

    private static void getRegexpFromList(final String[] regexpParts) {
        if (regexp != null) {
            return;
        }

        final StringBuilder regexpBuilder = new StringBuilder();
        for (int i = 0; i < regexpParts.length; i++) {
            regexpBuilder.append(regexpParts[i]
                                    .replaceAll("\\(", "\\\\\\(")
                                    .replaceAll("\\)", "\\\\\\)")
                                    .replaceAll("\\.", "\\\\\\."));
            if (i != regexpParts.length - 1) {
                regexpBuilder.append("(.*?)");
            }
        }
        regexp = regexpBuilder.toString();
    }

}
