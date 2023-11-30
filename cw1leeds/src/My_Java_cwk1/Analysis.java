package My_Java_cwk1;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Analysis {

    public static void main(String[] args) throws FileNotFoundException {

    	WeatherDataset r = new WeatherDataset();
        r.readFile(args[0]);
        int count = r.size();
        System.out.println(count + " valid records acquired.");
        System.out.println(" ");

        /////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.printf("Highest wind speed: " + "%.1f m/s",r.maxWindSpeed().getWindSpeed());
        System.out.println("");
        String str = r.maxWindSpeed().getTime().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String a = null;
        String b = null;
        try {
        	a = sdf.format(sdf.parse(str));
        	b= str.substring(str.indexOf("T")+1,str.length());
        }catch(ParseException e)
        {
        	e.printStackTrace();
        }
        System.out.println("(measured on " + a + " at " + b + ")");
        System.out.println("");

        //////////////////////////////////////////////////////////////////////////////////////////////

       double rounded1 = Math.round(r.minHumidity().getHumidity() * 10) / 10.0;
       System.out.println("Lowest humidity: " + rounded1  + " %");
       String d = r.minHumidity().getTime().toString();
       try
       {
    	   a = sdf.format(sdf.parse(d));
    	   b= d.substring(d.indexOf("T")+1,d.length());
       }catch(ParseException e)
       {
    	   e.printStackTrace();
       }

       System.out.println("(measured on " + a + " at " + b + ")");
       System.out.println("");

       ///////////////////////////////////////////////////////////////////////////////////////////////

       System.out.printf("Highest temperature: " + "%.1f \u00b0C", r.maxTemperature().getTemperature());
       System.out.println("");
       String z = r.maxTemperature().getTime().toString();
       try
       {
    	   a = sdf.format(sdf.parse(z));
    	   b= z.substring(z.indexOf("T")+1,z.length());
       }catch(ParseException e)
       {
    	   e.printStackTrace();
       }

       System.out.println("(measured on " + a + " at " + b + ")");
       System.out.println("");

       ///////////////////////////////////////////////////////////////////////////////////////////////

       String x = r.maxTemperature().getTime().toString();
       try
       {
    	   a = sdf.format(sdf.parse(x));
    	   LocalDate date = LocalDate.parse(a);
    	   System.out.println("Insolation on " + date + ": " + r.insolation(date) + " J/m2");
       }catch(ParseException e)
       {
    	   e.printStackTrace();
       }
    }
}
