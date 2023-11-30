package MapExample;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		map.put("apple", 42);
		map.put("orange", 34);
		map.put("mango", 100);
		for (String key: map.keySet()) {
		 int value = map.get(key);
		 System.out.printf("%s: %d%n", key, value);
		}
	}
}
