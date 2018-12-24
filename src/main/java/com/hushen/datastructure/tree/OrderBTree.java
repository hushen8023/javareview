package com.hushen.datastructure.tree;

import com.hushen.datastructure.tree.btree.BTree;

public class OrderBTree implements Visit{
	/**
	 * 前序遍历
	 * @param root 根结点
	 */
	public void preOrder(BTree root) {
		visit(root);
		if(root.getLeftChild() != null) {
			preOrder(root.getLeftChild());
		}
		if(root.getRightChild() != null) {
			preOrder(root.getRightChild());
		}
	}
	/**
	 * 中序遍历
	 * @param root 根结点
	 */
	public void inOrder(BTree root) {
		if(root.getLeftChild() != null)
			inOrder(root.getLeftChild());
		visit(root);
		if(root.getRightChild() != null) {
			//System.out.println("true");
			inOrder(root.getRightChild());
		}
	}
	/**
	 * 后序遍历
	 * @param root 根结点
	 */
	public void postOrder(BTree root) {
		if(root.getLeftChild() != null)
			postOrder(root.getLeftChild());
		if(root.getRightChild() != null)
			postOrder(root.getRightChild());
		visit(root);
	}
 
	public void visit(BTree btree) {
		System.out.print(btree.getRootData() + "\t");
	}
}
