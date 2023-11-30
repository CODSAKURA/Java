package ArrayListExample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Class that benchmarks an implementation of List by
 * performing successive insertions at its front.
 *
 * @author Nick Efford
 */

//这个是用来证明insertion在linkedlist的话用的速度比arraylist快
public class ListBenchmark {

  private List<Integer> list;
  private int numberofInsertionstimes;
  private long howlongittake;

  /**
   * Creates a ListBenchmark object that will test the given
   * List using the given number of insertions.
   *
   * @param list List of objects into which data will be inserted
   * @param numInsertions Number of insertions to be performed
   */
  public ListBenchmark(List<Integer> list, int numInsertions) {
    this.list = list;
    this.numberofInsertionstimes = numInsertions;
  }

  /**
   * Runs the benchmark, recording total time taken for all insertions.
   */
  public void run() {
    int value = 1;
    long startTime = System.currentTimeMillis();

    for (int i = 0; i < numberofInsertionstimes; ++i)
      list.add(0, value);

    howlongittake = System.currentTimeMillis() - startTime;
  }

  /**
   * Reports on time taken to perform insertions.
   */
  public void report() {
    System.out.printf("%s: %d ms\n", list.getClass(), howlongittake);
  }

  /**
   * Example of benchmarking ArrayList and LinkedList.
   *
   * Running as
   * <pre>
   *   java ListBenchmark 5000
   * </pre>
   * will benchmark these two classes using 5000 insertions.
   *
   * @param args Command-line arguments; the first is the number of
   *   insertions required.
   */
  public static void main(String[] args) {
    if (args.length > 0) {
      int size = Integer.parseInt(args[0]);

      LinkedList<Integer> linkedList = new LinkedList<Integer>();
      ListBenchmark linkedTest = new ListBenchmark(linkedList, size);

      ArrayList<Integer> arrayList = new ArrayList<Integer>();
      ListBenchmark arrayTest = new ListBenchmark(arrayList, size);

      linkedTest.run();
      linkedTest.report();

      arrayTest.run();
      arrayTest.report();

      System.exit(0);
    }
    else {
      System.err.println("Usage: java ListBenchmark <numInsertions>");
      System.exit(1);
    }
  }
}
