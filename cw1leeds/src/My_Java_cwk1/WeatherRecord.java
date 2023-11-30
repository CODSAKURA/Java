package My_Java_cwk1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WeatherRecord {
    private LocalDateTime time;
    private double windSpeed;
    private double temperature;
    private double solarIrradiance;
    private double humidity;

    public WeatherRecord(){

    }

    public WeatherRecord(LocalDateTime time,double windSpeed,double temperature,double solarIrradiance,double humidity) {
        this.time = time;
        this.windSpeed = windSpeed;
        this.temperature = temperature;
        this.solarIrradiance = solarIrradiance;
        this.humidity = humidity;
    }


    public LocalDateTime getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        time.format(formatter);
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

    public String toString() {
        return (time + "," + windSpeed + "," + temperature + "," + solarIrradiance + "," + humidity);
    }
}
