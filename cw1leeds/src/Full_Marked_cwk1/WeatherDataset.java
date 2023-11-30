package Full_Marked_cwk1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class WeatherDataset {

	// Private fields to represent components of a WeatherDataset
	
    private LinkedList<WeatherRecord> weathers;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
    // Constructors that initialize a WeatherDataset object two different ways
    
    public WeatherDataset() 
    {
        weathers= new LinkedList<>();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public WeatherDataset(String filename) throws FileNotFoundException 
    {
        weathers = new LinkedList<>();
        readFile(filename);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////    
    
    public void readFile(String filename) throws FileNotFoundException 
    {
        Scanner input = new Scanner(new File(filename));       
        while (input.hasNext()) 
        {
            try 
            {
                String[] str = input.nextLine().trim().split(",");
                
                if (str.length != 8) 
                {
                    continue;
                }
                //put value into its certain location on a list
                
                String[] a = str[0].split("\\s+");
                String[] b = a[0].split("/");
                int day = Integer.valueOf(b[0]);
                int month = Integer.valueOf(b[1]);
                int year = Integer.valueOf(b[2]);                

                String[] c = a[1].split(":");
                int hours = Integer.valueOf(c[0]);
                int minutes = Integer.valueOf(c[1]);
                
                LocalDateTime time = LocalDateTime.of(year, month, day, hours, minutes);
                
                double windSpeed = Double.valueOf(str[2]);
                double temperature = Double.valueOf(str[4]);
                double solarIrradiance = Double.valueOf(str[6]);	
                double humidity = Double.valueOf(str[7]);
                
                WeatherRecord d = new WeatherRecord(time, windSpeed, temperature, solarIrradiance, humidity);
                
                boolean e = false;
                for (WeatherRecord r : weathers) 
                {
                    if (r.equals(d)) 
                    {
                        e = true;
                        break;
                    }
                }
                
                if (!e)
                {
                    weathers.add(d);
                }
                
            } catch (NumberFormatException e) 
            {
            }
        }
        input.close();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////    
    
    
    public WeatherRecord get(int index) 
    {
        return weathers.get(index);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////    
    
    public int size() 
    {
        return weathers.size();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////  
    
    public void add(WeatherRecord record) 
    {
        weathers.add(record);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////    
    
    
    // Method that return the max and min value from list
    
    public WeatherRecord maxWindSpeed() 
    {
        if (weathers.isEmpty()) 
        {
            throw new WeatherException("Not Valid");
        }
        
        double max = Double.MIN_VALUE;	// assignment only happens if there is no exception
        WeatherRecord a = null;
        for (WeatherRecord r: weathers) 
        {
            if (r.getWindSpeed() > max) 
            {
                max = r.getWindSpeed();
                a = r;
            }
        }
        return a;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    
    public WeatherRecord maxTemperature() {
        if (weathers.isEmpty()) 
        {
            throw new WeatherException("Not Valid");
        }
        
        double max = Double.MIN_VALUE;
        WeatherRecord a = null;
        for (WeatherRecord r: weathers) 
        {
            if (r.getTemperature() > max) 
            {
                max = r.getTemperature();
                a = r;
            }
        }
        return a;
    }

    
    //////////////////////////////////////////////////////////////////////////////////////////////    
    
    public WeatherRecord minHumidity() 
    {
        if (weathers.isEmpty()) 
        {
            throw new WeatherException("Not Valid");
        }
        
        double min = Double.MAX_VALUE;
        WeatherRecord a = null;
        for (WeatherRecord r: weathers) 
        {
            if (r.getHumidity() < min) 
            {
                min = r.getHumidity();
                a = r;
            }
        }
        return a;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////    
    
    public double insolation(LocalDate date) 
    {
        boolean c = false;
        double sum = 0;
        for (WeatherRecord r: weathers) 
        {
            if (r.getTime().getYear() == date.getYear() && r.getTime().getMonthValue() == date.getMonthValue() && r.getTime().getDayOfMonth() == date.getDayOfMonth()) 
            {
                c = true;
                sum += r.getSolarIrradiance();
            }
        }
        if (!c) 
        {
            throw new WeatherException("Not Valid");
        }
        return sum * 3600;
    }
}