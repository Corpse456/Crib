package regExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Raplacement {

    public static void main (String[] args) {
        String text = "22-2222-22-12 suujghdskjfh sdkj  23-4566-87\n hjg uit tuyg jyuff jy22-555555-22-8 ujhguhh 89-5678-89";
        System.out.println("First: " + text);
        String regexp = "(\\d{2})-(\\d{4})-(\\d{2})";
        // "\\D"; // Нецифровой символ
        // String regexp = "\\d";// Цифровой символ
        // String regexp = "\\w"; //Буквенный или цифровой символ или знак
        // подчёркивания
        // String regexp = "\\s"; // Пробельный символ
        // String regexp = "\\S"; // НЕ gробельный символ
        // String regexp = "^1"; //Начало текста
        System.out.println("Second: " + text.replaceAll(regexp, "$1/$2/$3"));

        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println(m.group());
            text = text.replace(m.group(), func(m.group()));
        }
        System.out.println(text);
    }

    private static CharSequence func (String group) {
        group = group.replace("-", "");
        String regex = "(\\d{3})(\\d{4})(\\d{1})";
        return group.replaceAll(regex, "$1_$2_$3");
    }
}
