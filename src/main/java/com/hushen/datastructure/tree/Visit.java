package com.hushen.datastructure.tree;

import com.hushen.datastructure.tree.btree.BTree;

public interface Visit {
	/**
	 * 对结点进行某种操作
	 * @param btree 树的结点
	 */
	public void visit(BTree btree);

}
