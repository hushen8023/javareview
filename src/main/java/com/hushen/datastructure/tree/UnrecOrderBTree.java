package com.hushen.datastructure.tree;
import com.hushen.datastructure.stack.ArrayStack;
import com.hushen.datastructure.stack.Stack;
import com.hushen.datastructure.tree.btree.BTree;

public class UnrecOrderBTree implements Visit {

	private Stack stack = new ArrayStack();
	private BTree bt;
	
	public void visit(BTree btree) {
		System.out.print("\t" + btree.getRootData());
	}
	
	public void inOrder(BTree boot) {
		stack.clear();
		stack.push(boot);
		while(!stack.isEmpty()) {
			//左孩子结点进栈
			while((bt = ((BTree)(stack.peek())).getLeftChild()) != null) {
				stack.push(bt);
			}
			//如果该结点没有右孩子，则逐级往上出栈
			while(!stack.isEmpty() &&!( (BTree)stack.peek() ).hasRightTree()) {
				bt = (BTree)stack.pop();
				visit(bt);
			}
			//如果该结点有右孩子，则右孩子进栈
			if(!stack.isEmpty() && ( (BTree)stack.peek() ).hasRightTree()){
				bt = (BTree)stack.pop();
				visit(bt);
				stack.push(bt.getRightChild());
			}
		}
	}
}
