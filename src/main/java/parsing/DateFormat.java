package parsing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormat {
    public static void main (String[] args) {
        int i = 130;
        double d = 130;
        System.out.println(d != i);
        System.out.println(i);
        
        System.out.println(Double.parseDouble("0."));

        String s = "21 декабря 2000";
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        Date docDate;
        try {
            docDate = format.parse(s);
        } catch (ParseException e) {
            docDate = new Date();
        }
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        System.out.println(format2.format(docDate));
    }
}
