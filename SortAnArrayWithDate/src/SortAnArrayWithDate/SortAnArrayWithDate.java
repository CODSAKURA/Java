package SortAnArrayWithDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;

public class SortAnArrayWithDate {

    public static void main(String[] args) {
        String dates[] = {"05-11-2014-apple", "23-08-2014-pig","05-02-2013-pear"};
        Arrays.sort(dates, new Comparator<String>() {
            private SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
            @Override
            public int compare(String o1, String o2) {
                int result = -1;

                try {
                    result = sdf.parse(o1).compareTo(sdf.parse(o2));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                return result;
            }
        });

        for (String date : dates) {
            System.out.println(date);
        }
    }

}
