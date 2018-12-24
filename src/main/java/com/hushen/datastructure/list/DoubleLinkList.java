package com.hushen.datastructure.list;
/**
 * 链表的结点
 *
 */
class DlNode{
	Object data;
	DlNode prior, next;
	public DlNode() {
		this(null);
	}
	public DlNode(Object data) {
		this.data = data;	//数据元素
		this.prior = null;	//前驱结点
		this.next = null;	//后驱结点
	}
}
/**
 * 带头结点的双向循环链表,下标从0开始; 
 *
 */
public class DoubleLinkList  implements List {
	DlNode head;	//头结点
	int size;	//链表的大小
	public DoubleLinkList() {
		head = new DlNode();
		head.prior = head;
		head.next = head;
		size = 0;
	}
	public DoubleLinkList(Object[] datas) {
		int n = datas.length;
		head = new DlNode();
		DlNode p = head;
		DlNode p2 = null;
		for(int i=0; i<n; i++) {
			p2 = new DlNode(datas[i]);
			p.next = p2;
			p2.prior = p;
			p = p.next;
		}
		p2.next = head;
		head.prior = p2; 
		size = n;
	}
	public void add(Object e) {
		DlNode p, p2;
		if(0 == size) {
			p = head;
		} else {
			p = index(size-1);
		}
		p2 = new DlNode(e);
		p.next = p2;
		p2.prior = p;
		p2.next = head;
		head.prior = p2;
		size ++;
	}
 
	public void clear() {
		head.prior = head;
		head.next = head;
		size = 0;
	}
 
	public Object get(int i) {
		DlNode p = index(i);
		return p.data;
	}
	
	private DlNode index(int i) {
		DlNode p = null;
		if(i>=0 && i<size){
			p = head;
			for(int j=0; j<=i; j++) {
				p = p.next;
			}
		} 
		return p;
	}
 
	public int indexOf(Object e) {
		DlNode p = head.next;
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
		DlNode p = index(i);
		DlNode p2 = new DlNode(e);
		p2.next = p.next;
		p2.prior = p;
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
		DlNode p = head.prior;
		int i = size-1;
		while(!p.data.equals(e)) {
			p = p.prior;
			i--;
		}
		if(i>=0)
			return i;
		else 
			return -1;
	}
 
	public void remove(int i) {
		if(i>=0 && i<size) {
			DlNode p = null;
			if(i == 0)
				p = head;
			else {
				p = index(i-1);
			}
			DlNode p2 = index(i).next;
			p.next = p2.next;
			p2.next.prior = p;
		}
		size --;
	}
 
	public void set(int i, Object e) {
		DlNode p = index(i);
		p.data = e;
	}
 
	public int size() {
		return size; 
	}
}
