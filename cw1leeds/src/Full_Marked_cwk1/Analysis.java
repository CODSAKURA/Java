package Full_Marked_cwk1;

import java.io.FileNotFoundException;
import java.time.LocalDate;

//Program to formally test the WeatherDataset class

public class Analysis {

    public static void main(String[] args) {
        
    	String filename = args[0];
        WeatherDataset w = null; //create a new object of the class WeatherDataset
        
        try 
        {
            w = new WeatherDataset(filename); 
        } catch (FileNotFoundException e) 
        {
            System.out.println("File does not existed");
            System.exit(1);
        }

        System.out.println(w.size() + " valid records acquired.");
        System.out.println("");
        
        WeatherRecord a = w.maxWindSpeed();
        System.out.println("Highest wind speed: " + String.format("%.1f", a.getWindSpeed()) + " m/s");
        System.out.println(String.format("(measured on %d-%02d-%02d at %02d:%02d)", a.getTime().getYear(), a.getTime().getMonthValue(), a.getTime().getDayOfMonth(), a.getTime().getHour(), a.getTime().getMinute()));
        System.out.println("");
        
        a = w.minHumidity();
        System.out.println("Lowest humidity: " + String.format("%.1f", a.getHumidity()) + "%");
        System.out.println(String.format("(measured on %d-%02d-%02d at %02d:%02d)", a.getTime().getYear(), a.getTime().getMonthValue(), a.getTime().getDayOfMonth(), a.getTime().getHour(), a.getTime().getMinute()));
        System.out.println("");
        
        a = w.maxTemperature();
        System.out.println("Highest temperature: " + String.format("%.1f", a.getTemperature()) + "\u00b0C");
        System.out.println(String.format("(measured on %d-%02d-%02d at %02d:%02d)", a.getTime().getYear(), a.getTime().getMonthValue(), a.getTime().getDayOfMonth(), a.getTime().getHour(), a.getTime().getMinute()));
        System.out.println("");
        
        LocalDate t = LocalDate.of(2016, 7, 19);
        System.out.println("Insolation on 2016-07-19: " + String.format("%.3e", w.insolation(t)) + " J/m2");
        System.out.println("");
        
    }
}