package com.hushen.datastructure.stack;

public class Test {
	
	/**
	 * 测试堆栈
	 * @param args
	 */
	public static void main(String[] args) {
		//Stack stack = new ArrayStack();
		Stack stack = new LinkStack();
		for(int i=0; i<10; i++) {
			stack.push(i);
		}
		System.out.println(stack.toString());
		Object a = stack.pop();
		System.out.println(a + stack.toString());
		stack.push(20);
		Object b = stack.peek();
		System.out.println( b + stack.toString());
		stack.clear();
		System.out.println( "数据数量：" + stack.size()
				+ "  isEmpty? " + stack.isEmpty() + "  数据为：" + stack.toString());

	}

}
