package com.hushen.datastructure.stack;


/**
 * 链式(堆)栈, 无头结点
 *
 */
public class LinkStack implements Stack {
	private Node top;	//栈顶指针
	private int size;	//栈的大小
	
	public LinkStack() {
		top = null;
		size = 0;
	}
	
	public void clear() {
		top = null;
		size = 0;
	}
 
	public void push(Object obj) {
		Node p = new Node(obj);
		if(top == null) {
			top = p;
		} else {
			p.next = top;
			top = p;
		}
		size ++;
	}
 
	public Object pop() {
		Node p = top;
		top = top.next;
		size --;
		return p.data;
	}
 
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else
			return false;
	}
 
	public int size() {
		return size;
	}
 
	public Object peek() {
		return top.data;
	}
	
 
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node p = top;
		if(p == null) {
			sb.append("");
		} else {
			do{
				sb.append(p.data + ",  ");
			}while((p = p.next) != null);
		}
		sb.append("]");
		return sb.toString();
	}
}

/**
 * 链式(堆)栈的结点
 *
 */
class Node{
	Object data;	//数据元素
	Node next;		//后驱结点
	public Node() {
		this(null);
	}
	public Node(Object data) {
		this.data = data;
		this.next = null;
	}
}