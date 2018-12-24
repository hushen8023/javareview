package com.hushen.datastructure.queue;

public interface Queue {
	/**
	 * 清空队列
	 */
	public void clear();
	/**
	 * 出队列
	 * @return
	 */
	public Object deQueue();
	/**
	 * 判断是否为空
	 * @return
	 */
	public boolean isEmpty();
	/**
	 * 取对头元素
	 * @return
	 */
	public Object peek();
	/**
	 * 入队列
	 * @param obj
	 */
	public void push(Object obj);
	/**
	 * 元素的个数
	 * @return
	 */
	public int size();
}
