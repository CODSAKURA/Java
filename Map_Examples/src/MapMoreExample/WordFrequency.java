package MapMoreExample;

// An example application for Java maps: word frequencies

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class WordFrequency {
  public static void main(String[] args) throws FileNotFoundException {
    if (args.length == 0) {
      System.out.println("Usage: java WordFrequency <filename>");
      System.exit(1);
    }

    // Create a map of words onto word frequencies
    // (Use a TreeMap, because we want words to be sorted)

    Map<String,Integer> frequencies = new TreeMap<>();

    try (Scanner input = new Scanner(new File(args[0]))) {
      while (input.hasNext()) {
        // Read a word and normalise it by converting to lowercase
        // and removing anything that isn't a letter

        String word = input.next().toLowerCase().replaceAll("[^a-zA-Z]", "");

        if (word.length() == 0) {
          continue;   // no letters remain, so fetch another word
        }

        // Update frequency of occurrence for the word

        int freq = frequencies.getOrDefault(word, 0);
        frequencies.put(word, freq+1);
      }
    }

    // Display each word and its frequency of ocurrence

    for (String word: frequencies.keySet()) {
      int freq = frequencies.get(word);
      System.out.printf("%5d %s\n", freq, word);
    }

    // Can do this in Java 8 onwards:
    // frequencies.forEach((word, freq) -> {
    //   System.out.printf("%4d %s\n", freq, word);
    // });
  }
}
