package Full_Marked_cwk1;
//Class to get weather record
import java.time.LocalDateTime;
import java.util.Objects;


public class WeatherRecord {
	// Constants used by methods of WeatherRecord
	// (static means they are shared by all instances)
	
    private LocalDateTime time;
    private double windSpeed;
    private double temperature;
    private double solarIrradiance;
    private double humidity;
    
    // Private fields to represent components of a WeatherRecord

    public WeatherRecord(LocalDateTime time,double windSpeed,double temperature,double solarIrradiance,double humidity) 
    {
        this.time = time;
        this.windSpeed = windSpeed;
        this.temperature = temperature;
        this.solarIrradiance = solarIrradiance;
        this.humidity = humidity;
    }
    // calls the five-parameter constructor

    // Getters for the fields
    public LocalDateTime getTime() {
        return time;
    }

    public double getWindSpeed() {
        return this.windSpeed;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getSolarIrradiance() {
        return solarIrradiance;
    }

    public double getHumidity() {
        return humidity;
    }
    
    public boolean equals(Object o) {
        if (this == o) 
        {
        	return true;
        }
        if (o == null || getClass() != o.getClass()) 
        {
        	return false;
        }
        
        WeatherRecord that = (WeatherRecord) o;
        
        return Double.compare(that.windSpeed, windSpeed) == 0 && Double.compare(that.temperature, temperature) == 0 && Double.compare(that.solarIrradiance, solarIrradiance) == 0 && Double.compare(that.humidity, humidity) == 0 && Objects.equals(time, that.time);
    }

    // A method to return a specific type of string
    public String toString() 
    {
        String a = "";
        
        if (time.getDayOfMonth() < 10) 
        {
            a += "0";
        }
        
        a += time.getDayOfMonth() + "/";
        
        if (time.getMonthValue() < 10) 
        {
            a += "0";
        }
        
        a += time.getMonthValue() + "/" + time.getYear() + " ";
        
        if (time.getHour() < 10) 
        {
            a += "0";
        }
        
        a += time.getHour() + ":";
        
        if (time.getMinute() < 10) 
        {
            a += "0";
        }
        
        a += time.getMinute();
        a += "," + windSpeed;
        a += "," + temperature;
        a += "," + solarIrradiance;
        a += "," + humidity;
        
        return a;
    }
}