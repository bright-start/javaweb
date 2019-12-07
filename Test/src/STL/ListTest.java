package STL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		arrayList();
	}
	
	public static void arrayList() {
		List<String> list = new ArrayList<>();
		list.add("111");
		list.add("222");
		list.add("333");
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
