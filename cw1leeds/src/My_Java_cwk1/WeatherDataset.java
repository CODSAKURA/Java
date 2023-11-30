package My_Java_cwk1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class WeatherDataset {
    private ArrayList<WeatherRecord> weathers;

    public WeatherDataset() {weathers = new ArrayList<WeatherRecord>();}

    public WeatherDataset(String filename) {}

    public void readFile (String filename) throws FileNotFoundException
    {
        weathers.removeAll(weathers);
        File inFile = new File(filename);
        String inString = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            int index = 0;
            while ((inString = reader.readLine()) != null)
            {
                String[] str = inString.split(",");
                String[] newStr = new String[8];
                if (str.length < 8)
                {
                    for (int i = 0; i < 8; i++)
                    {
                        if (i < str.length)
                        {
                            newStr[i] = str[i];
                        }
                        else
                        {
                            newStr[i] = "";
                        }
                    }
                }
                else
                {
                    newStr = str;
                }

                if (index != 0)
                {
                	Double s = 0d;
                	if (newStr[2].length() > 0){
                        s = Double.parseDouble(newStr[2]);
                    }
                	Double f = 0d;
                    if (newStr[4].length() > 0){
                        f = Double.parseDouble(newStr[4]);
                    }
                	Double d = 0d;
                    if (newStr[6].length() > 0){
                        d = Double.parseDouble(newStr[6]);
                    }
                	Double q = 0d;
                    if (newStr[7].length() > 0){
                        q = Double.parseDouble(newStr[7]);
                    }

                	DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                	LocalDateTime localDateTime = LocalDateTime.parse(newStr[0], df);
                	WeatherRecord a = new WeatherRecord(localDateTime, s, f, d, q);
                    weathers.add(a);

                }
                index++;
            }
            reader.close();
        } catch (FileNotFoundException note) {
            note.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////

    public void add(WeatherRecord record) {weathers.add(record);}

    /////////////////////////////////////////////////////////////////////////////////////////////////////

    public int size() {
        return weathers.size();
    }

    public WeatherRecord get(int index) {
        return weathers.get(index);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////

    public WeatherRecord maxWindSpeed() {
    	WeatherRecord weatherRecord = new WeatherRecord();
    	try
        {
        	double max = weathers.get(0).getWindSpeed();
        	for(int i = 1; i < weathers.size(); i++ )
        	{
        		WeatherRecord w = weathers.get(i);
        		if( w.getWindSpeed() > max && w.getWindSpeed() != 0 ){
        			max = weatherRecord.getWindSpeed();
        			weatherRecord = w;
        		}
        	}
        }
        catch(WeatherException e)
        {
        	e.printStackTrace();
        }
        return weatherRecord;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////

    public WeatherRecord maxTemperature() {
    	WeatherRecord weatherRecord = new WeatherRecord();
    	try
    	{
    		double max = 0;
        if(weathers.size() > 0)
        {
          max = weathers.get(0).getTemperature();
          weatherRecord = weathers.get(0);
        }
    		for(int i = 1; i < weathers.size(); i++ )
    		{
    			WeatherRecord w = weathers.get(i);
    			if( w.getTemperature() > max && w.getTemperature() != 0){
    				max = w.getTemperature();
    				weatherRecord = w;
    			}
    		}
    	}
    	catch(WeatherException d)
    	{
    		d.printStackTrace();
    	}
    	return weatherRecord;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    public WeatherRecord minHumidity() {
    	WeatherRecord weatherRecord = new WeatherRecord();
    	try
    	{
    		double min = weathers.get(0).getHumidity();
    		for(int i = 1; i < weathers.size(); i++ )
    		{
    			WeatherRecord w = weathers.get(i);
    			if( w.getHumidity() < min && w.getHumidity() != 0 ){
    				min = w.getHumidity();
    				weatherRecord = w;
    			}
    		}
    	}
    	catch(WeatherException q)
    	{
    		q.printStackTrace();
    	}
    	return weatherRecord;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////

    public double insolation(LocalDate date) {
		double sum = 0;
    	try
    	{

    		for(int i = 0; i < weathers.size();i++ )
    		{
    			WeatherRecord w = weathers.get(i);
    			LocalDateTime t = w.getTime();
    			LocalDate d = t.toLocalDate();
    			if( date.equals(d))
    			{
    				sum += w.getSolarIrradiance()*3600;
    			}
    		}
    	}
    	catch(WeatherException e)
    	{
    		e.printStackTrace();
    	}
    	return sum;
    }


}
