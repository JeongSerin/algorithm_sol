package com.ssafy.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueAPITest {

	 
	public static void main(String[] args) {
//		Queue<String> queue = new LinkedList<String>();
//		Queue<String> queue = new PriorityQueue<String>();
		Queue<String> queue = new PriorityQueue<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		System.out.println(queue.isEmpty()+"//"+queue.size());
		queue.offer("김재환");
		queue.offer("이지아");
		queue.offer("이동욱");
		System.out.println(queue.isEmpty()+"//"+queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.isEmpty()+"//"+queue.size());
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty()+"//"+queue.size());
		
	}

}











