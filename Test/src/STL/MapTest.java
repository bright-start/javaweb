package STL;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {
	public static void main(String[] args) {
		hashMap();
	}
	
	public static void hashMap() {
		Map<String,Object> map = new HashMap<>();
		map.put("one", "this is one");
		map.put("two", "this is two");
		map.put("three", "this is three");
		map.put("four", "this is four");
		map.put("five", "this is five");
		map.put("six", "this is six");
		for (Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
	}
}
