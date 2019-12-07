package 数据结构;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		queue.offer("d");
		queue.offer("e");
		for(String q : queue) {
			System.out.println(q);
		}
		System.out.println("-----------------");
		//返回第一个元素，并在队列中删除
		System.out.println("删除"+queue.poll());
		System.out.println("-----------------");
		for(String q : queue) {
			System.out.println(q);
		}
		System.out.println("-----------------");
		System.out.println(queue.element());
		System.out.println("-----------------");
		for(String q : queue) {
			System.out.println(q);
		}
		System.out.println("-----------------");
		System.out.println(queue.peek());
		System.out.println("-----------------");
		for(String q : queue) {
			System.out.println(q);
		}
	}
}
