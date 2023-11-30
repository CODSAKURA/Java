package Full_Marked_cwk1;

/**
 * Class to represent errors in handling weather data.
 *
 * <p>Created for use in COMP1721 Coursework 1.</p>
 *
 * @author Nick Efford
 */
public class WeatherException extends RuntimeException {
  /**
	 * 
	 */
	private static final long serialVersionUID = -6676836496415424164L;

public WeatherException(String message) {
    super(message);
  }
}
