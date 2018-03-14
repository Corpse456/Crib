package parsing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    public static void main (String[] args) {
        int i = 130;
        double d = 130;
        System.out.println(d != i);
        System.out.println(i);

        System.out.println(Double.parseDouble("0."));

        String s = "05 09 2013";
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
        Date docDate;
        try {
            docDate = format.parse(s);
        } catch (ParseException e) {
            docDate = new Date();
        }

        System.out.println(docDate);
    }
}
