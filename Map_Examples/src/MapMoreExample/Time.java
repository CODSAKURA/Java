package MapMoreExample;

/**
 * A representation of time on a 24-hour clock.
 *
 * <p>This is based on a similar class from Lectures 5-6, but with
 * the addition of hashCode and equals methods.  It also implements
 * Comparable, and therefore has a compareTo method.</p>
 *
 * <p>This version is also immutable, allowing the class to be used
 * safely as a key in associative collections.</p>
 *
 * @author Nick Efford
 * @version 2.0
 */
public class Time implements Comparable<Time> {
  // Constants used by methods of Time
  // (static means they are shared by all instances)

  private static final int SEC_IN_A_MINUTE = 60;
  private static final int MIN_IN_AN_HOUR = 60;
  private static final int SEC_IN_AN_HOUR = SEC_IN_A_MINUTE * MIN_IN_AN_HOUR;
  private static final int HOURS_IN_A_DAY = 24;

  private static final int MAX_HOURS = HOURS_IN_A_DAY - 1;
  private static final int MAX_MINUTES = MIN_IN_AN_HOUR - 1;
  private static final int MAX_SECONDS = SEC_IN_A_MINUTE - 1;

  // Private fields used to represent times

  private int hours;
  private int minutes;
  private int seconds;

  /**
   * Creates a time in hours and minutes (seconds default to 0).
   *
   * @param h Value for hours
   * @param m Value for minutes
   */
  public Time(int h, int m) {
    this(h, m, 0);
  }

  /**
   * Creates a time in hours, minutes and seconds.
   *
   * @param h Value for hours
   * @param m Value for minutes
   * @param s Value for seconds
   */
  public Time(int h, int m, int s) {
    setHours(h);     // initialisation is delegated to private setters
    setMinutes(m);
    setSeconds(s);
  }

  /**
   * @return Hours component of this time
   */
  public int getHours() {
    return hours;
  }

  /**
   * @return Minutes component of this time
   */
  public int getMinutes() {
    return minutes;
  }

  /**
   * @return Seconds component of this time
   */
  public int getSeconds() {
    return seconds;
  }

  /**
   * Generates a string representation of this time, following ISO 8601.
   *
   * <p>The format is HH:MM:SS - i.e., two digits for hours, minutes
   * and seconds, with colons as separators.</p>
   *
   * @return Time as an ISO 8601 string
   */
  @Override
  public String toString() {
    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
  }

  /**
   * Generates a hashcode for this time.
   *
   * <p>The hashcode is an integer that characterises a Time object and,
   * in this case, is guaranteed to be unique for each object.  It is
   * needed when using Time objects as keys in hash-based collections.</p>
   *
   * @return Hashcode
   */
  @Override
  public int hashCode() {
    return secondsSinceMidnight();
  }

  /**
   * Indicates whether this time is equal to another object.
   *
   * <p>In this context, 'equal' means 'also a Time object with the same
   * values for hours, minutes and seconds.</p>
   *
   * @param other Object being compared with this time
   * @return true if this time is equal to the other, false otherwise
   */
  @Override
  public boolean equals(Object other) {
    if (other == this) {
      // Same object, so must be equal!
      return true;
    }
    else if (!(other instanceof Time)) {
      // Other object is not a Time instance, so cannot be equal
      return false;
    }
    else {
      // Other object is a Time instance, so compare fields
      Time otherTime = (Time) other;
      return hours == otherTime.hours &&
             minutes == otherTime.minutes &&
             seconds == otherTime.seconds;
    }
  }

  /**
   * Compares this time with another.
   *
   * <p>This is required by the Comparable interface and allows times
   * to be sorted in lists and used with TreeMap and TreeSet.</p>
   *
   * @param other The other time being compared with this one
   * @return -1 if this time comes before the other, 0 if they are
   *   the same, +1 if this time comes after the other
   */
  @Override
  public int compareTo(Time other) {
    int comp = Integer.compare(hours, other.hours);

    if (comp == 0) {
      comp = Integer.compare(minutes, other.minutes);
      if (comp == 0) {
        comp = Integer.compare(seconds, other.seconds);
      }
    }

    return comp;

    // Shorter alternative implementation:
    //
    // return secondsSinceMidnight() - other.secondsSinceMidnight();
  }

  /**
   * Indicates whether this time is in the morning.
   *
   * @return true if this time is before 12:00, false otherwise
   */
  public boolean isMorning() {
    return hours < 12;
  }

  /**
   * Indicates whether this time is in the afternoon.
   *
   * @return true if this time is 12:00 or later, false otherwise
   */
  public boolean isAfternoon() {
    return !isMorning();
  }

  /**
   * Indicates whether this time is earlier than another.
   *
   * @param other Other time being compared with this one
   * @return true if this time is earlier, false otherwise
   */
  public boolean earlierThan(Time other) {
    return secondsSinceMidnight() < other.secondsSinceMidnight();
  }

  /**
   * Indicates whether this time is later than another.
   *
   * @param other Other time being compared with this one
   * @return true if this time is later, false otherwise
   */
  public boolean laterThan(Time other) {
    return secondsSinceMidnight() > other.secondsSinceMidnight();
  }

  // Private helper methods

  private void setHours(int h) {
    if (h < 0 || h > MAX_HOURS) {
      throw new IllegalArgumentException("Invalid hours");
    }

    hours = h;   // assignment only happens if there is no exception
  }

  private void setMinutes(int m) {
    if (m < 0 || m > MAX_MINUTES) {
      throw new IllegalArgumentException("Invalid minutes");
    }

    minutes = m;
  }

  private void setSeconds(int s) {
    if (s < 0 || s > MAX_SECONDS) {
      throw new IllegalArgumentException("Invalid seconds");
    }

    seconds = s;
  }

  private int secondsSinceMidnight() {
    return seconds + SEC_IN_A_MINUTE * minutes + SEC_IN_AN_HOUR * hours;
  }
}
