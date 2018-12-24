package com.hushen.datastructure.queue;

public class Test {

	public static void main(String[] args) {
		//Queue queue = new LinkQueue();
		Queue queue = new ArrayQueue();
		for(int i=0; i<10; i++) {
			queue.push(i);
		}
		System.out.println(queue);
		Object obj1 = queue.deQueue();
		Object obj2 = queue.deQueue();
		System.out.println("count:" + queue.size() + "  obj1:" + obj1 + "  obj2:" + obj2);
		System.out.println(queue);
		System.out.println("peek:" + queue.peek());
		//System.out.println(test.toString());
		
		for(int i=0; i<12; i++) {
			queue.push(i+10);
		}
	}

}
