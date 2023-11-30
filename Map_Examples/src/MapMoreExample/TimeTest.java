package MapMoreExample;

// Test program for hashCode, equals & compareTo methods of Time

import static java.lang.System.out;

public class TimeTest {
  public static void main(String[] args) {
    Time t1 = new Time(8, 30, 5);
    Time t2 = new Time(13, 26);
    Time t3 = new Time(8, 30, 5);

    out.printf("t1 is %s\n", t1);
    out.printf("t2 is %s\n", t2);
    out.printf("t3 is %s\n\n", t3);

    out.printf("t1 hashes to %d\n", t1.hashCode());
    out.printf("t2 hashes to %d\n", t2.hashCode());
    out.printf("t3 hashes to %d\n\n", t3.hashCode());

    out.printf("t1 == t1? %s\n", t1 == t1);
    out.printf("t1 == t2? %s\n", t1 == t2);
    out.printf("t1 == t3? %s\n\n", t1 == t3);

    out.printf("t1.equals(t1)? %s\n", t1.equals(t1));
    out.printf("t1.equals(t2)? %s\n", t1.equals(t2));
    out.printf("t1.equals(t3)? %s\n\n", t1.equals(t3));

    out.printf("t1.compareTo(t1) = %d\n", t1.compareTo(t1));
    out.printf("t1.compareTo(t2) = %d\n", t1.compareTo(t2));
    out.printf("t1.compareTo(t3) = %d\n", t1.compareTo(t3));
    out.printf("t2.compareTo(t1) = %d\n\n", t2.compareTo(t1));
  }
}
