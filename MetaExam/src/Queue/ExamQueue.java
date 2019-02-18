package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class ExamQueue {
	public static void main(String[] args) {
		Queue que = new LinkedList();

		que.offer("A");
		que.offer("B");
		que.offer("C");
		que.offer("D");

		System.out.println(que);

	}
}
