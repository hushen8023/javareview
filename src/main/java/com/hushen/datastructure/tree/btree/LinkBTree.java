package com.hushen.datastructure.tree.btree;

public class LinkBTree implements BTree{
	private Object data;
	private BTree lChild;
	private BTree rChild;
	
	public LinkBTree() {
		this.clearTree();
	}
	public LinkBTree(Object data) {
		this.data = data;
		this.lChild = null;
		this.rChild = null;
	}
	public void addLeftTree(BTree lChild) {
		this.lChild = lChild;
	}
 
	public void addRightTree(BTree rChild) {
		this.rChild = rChild;
	}
 
	public void clearTree() {
		this.data = null;
		this.lChild = null;
		this.rChild = null;
	}
 
	public int dept() {
		return dept(this);
	}
	
	private int dept(BTree btree) {
		if(btree.isEmpty()) {
			return 0;
		}else if(btree.isLeaf()) {
			return 1;
		} else {
			if(btree.getLeftChild() == null) {
				return dept(btree.getRightChild()) + 1;
			} else if(btree.getRightChild() == null) {
				return dept(btree.getLeftChild()) + 1;
			} else {
				return Math.max(dept(btree.getLeftChild()), dept(btree.getRightChild()))+1;
			}
		}
	}
 
	public BTree getLeftChild() {
		return lChild;
	}
 
 
	public BTree getRightChild() {
		return rChild;
	}
 
	public Object getRootData() {
		return data;
	}
 
	public boolean hasLeftTree() {
		if(lChild != null)
			return true;
		return false;
	}
 
	public boolean hasRightTree() {
		if(rChild != null)
			return true;
		return false;
	}
 
	public boolean isEmpty() {
		if((lChild == null && rChild == null && data == null) || this == null) {
			return true;
		}
		return false;
	}
	
	public boolean isLeaf() {
		if(lChild == null && rChild == null) {
			return true;
		}
		return false;
	}
 
	public void removeLeftChild() {
		lChild = null;
	}
 
	public void removeRightChild() {
		rChild = null;
	}
	public BTree root() {
		return this;
	}
	public void setRootData(Object data) {
		this.data = data;
	}
	public int size() {
		return size(this);
	}
	private int size(BTree btree) {
		if(btree == null) 
			return 0;
		else if(btree.isLeaf()) 
			return 1;
		else {
			if(btree.getLeftChild() == null) {
				return size(btree.getRightChild()) + 1;
			} else if(btree.getRightChild() == null) {
				return size(btree.getLeftChild()) + 1;
			} else {
				return size(btree.getLeftChild()) + size(btree.getRightChild()) + 1;
			}
		} 
	}
}
