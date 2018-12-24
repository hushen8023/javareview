package com.hushen.datastructure.list;
/**
 * 链表的结点
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
/**
 * 带头结点的链式链表,下标从0开始; 
 *
 */
public class LinkList implements List {
	Node head;	//头结点
	int size;	//链表的大小
	public LinkList() {
		head = new Node();
		size = 0;
	}
	public LinkList(Object[] datas) {
		int n = datas.length;
		head = new Node();
		Node p = head;
		for(int i=0; i<n; i++) {
			p.next = new Node(datas[i]);
			p = p.next;
		}
		size = n;
	}
	public void add(Object e) {
		Node p;
		if(0 == size) {
			p = head;
		} else {
			p = index(size-1);
		}
		p.next = new Node(e);
		size ++;
	}
 
	public void clear() {
		head.next = null;
		size = 0;
	}
 
	public Object get(int i) {
		Node p = index(i);
		return p.data;
	}
	
	private Node index(int i) {
		Node p = null;
		if(i>=0 && i<size){
			p = head;
			for(int j=0; j<=i; j++) {
				p = p.next;
			}
		} 
		return p;
	}
 
	public int indexOf(Object e) {
		Node p = head.next;
		int i = 0;
		while(!p.data.equals(e)) {
			p = p.next;
			i++;
		}
		if(i<size)
			return i;
		else 
			return -1;
	}
 
	public void insert(int i, Object e) {
		Node p = index(i);
		Node p2 = new Node(e);
		p2.next = p.next;
		p.next = p2;
		size ++;
	}
 
	public boolean isEmpty() {
		if(size ==0)
			return true;
		else
			return false;
	}
 
	public int lastIndexOf(Object e) {
		int i = size-1;
		while(!get(i).equals(e)) {
			i--;
		}
		if(i>=0)
			return i;
		else 
			return -1;
	}
 
	public void remove(int i) {
		if(i>=0 && i<size) {
			Node p = null;
			if(i == 0)
				p = head;
			else {
				p = index(i-1);
			}
			p.next = index(i).next;
		}
		size --;
	}
 
	public void set(int i, Object e) {
		Node p = index(i);
		p.data = e;
	}
 
	public int size() {
		return size; 
	}
}
