package com.hushen.datastructure.stack;

public interface Stack {
	/**
	 * 清空堆栈
	 */
	public void clear();
	/**
	 * 入栈
	 * @param obj 入栈的元素
	 */
	public void push(Object obj);
	/**
	 * 出栈
	 * @return 出栈的结果
	 */
	public Object pop();
	/**
	 * 判断是否为空
	 * @return
	 */
	public boolean isEmpty();
	/**
	 * 求元素的个数
	 * @return 元素的个数
	 */
	public int size();
	/**
	 * 取栈顶元素
	 * @return 栈顶元素
	 */
	public Object peek();
}
