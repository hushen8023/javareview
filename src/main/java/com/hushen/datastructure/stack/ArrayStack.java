package com.hushen.datastructure.stack;

public class ArrayStack implements Stack {

	private static int DEFAULT_SIZE = 100; 
	private int Top;
	Object array[];
	
	public ArrayStack() {
		Top = 0;
		array = new Object[DEFAULT_SIZE];
	}
	
	public boolean isEmpty() {
		
			return 0 == Top ;
 
	}
	public void expand() {
		Object[] newArray = new Object[2 * array.length];
		for(int i=0; i<array.length; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
	}
	/*
	public void expand() {
		try {
			Object[] newArray = new Object[2*DEFAULT_SIZE];
			for(int i=0; i<array.length; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
		}catch(OutOfMemoryError e) {
			System.out.println("error in expand of Stack class!");
			//e.printStackTrace();
		}
		
		
		DEFAULT_SIZE = 2*DEFAULT_SIZE;
	}
	*/
	public void push(Object obj) {
		if(Top == array.length) {
			expand();
		}	
		array[Top] =obj;
		Top ++;
		
	}
	
	public Object pop() {
		if(0 == Top) throw new IllegalStateException();
		Object val = array[-- Top];
		array[Top] = null;
		return val;
		
	}
	
	public void clear() {
		for(int i=0; i<array.length; i++) {
			array[i] = null;
			Top = 0;
		}
	}
	
	public Object peek() {
		if(0 == Top) throw new IllegalStateException();
		return array[Top - 1];
	}
	
	public int size() {
		return Top;
	}
	
	public String toString() {
		String s = "[";
		for(int i=Top-1; i>=0 ; i--) {
			s = s + array[i];
			s = s + ",  ";
		}
		s = s + "]";
		return s;
	}
}
