package com.hushen.datastructure.set;

public class ArraySet implements Set {
	/**
	 * 集合默认的初始大小
	 */
	public static final int defLen = 10;
	private int maxLen;	//数组的大小
	private int size;	//元素的大小
	private Object[] e;	
	
	public ArraySet() {
		maxLen = defLen;
		e = new Object[maxLen];
		size = 0;
	}
	/**
	 * 构造函数
	 * @param len 数组的大小
	 */
	public ArraySet(int len) {
		this.maxLen = len;
		e = new Object[maxLen];
		size = 0;
	}
	
	public ArraySet(Set set) {
		size = maxLen = set.size();
		for(int i=0; i<size; i++) {
			e[i] = set.get(i);
		}
	}
	
	/*public boolean valid(Object o) {
		return 
	}*/
	
	private void clear() {
		size = 0;
	}
	
	private void expand() {
		maxLen = 2*maxLen;
		Object newArray[] = new Object[maxLen];
		for(int i=0; i<size; i++) {
			newArray[i] = e[i];
		}
		e = newArray;
	}
 
	public int size() {
		return size;
	}
 
	public void add(Object o) {
		if(!contain(o)) {
			if(size >= maxLen) {
				expand();
			}
			e[size] = o;
			size ++;
		}
	}
 
	public void remove(Object o) {
		if(!contain(o))
			throw new IllegalArgumentException("this set is not contain o element!");
		else {
			int k = index(o);
			for(int i=k; i<size-1; i++) {
				e[i] = e[i+1];
			}
			size --;
		}
	}
	
	private int index(Object o) {
		int i=0;
		while(i<size) {
			if(e[i] == o)
				return i;
			i++;
		}
		return -1;
	}
 
	public boolean contain(Object o) {
		int i = 0;
		while(i<size) {
			if(e[i] == o)
				return true;
			i++;
		}
		return false;
	}
 
	public boolean include(Set set) {
		if(set.size() > size)
			return false;
		else if(set.size() == 0)
			return true;
		else {
			boolean b = true;
			for(int i=0; i<set.size(); i++) {
				b = b && contain(set.get(i));
				if(!b)
					return false;
			}
			return b;
		}
	}
 
	public Set unionSet(Set set) {
		int len = size + set.size();
		Set rSet = new ArraySet(len);
		//int i=0; 
		for(int i=0; i<size; i++) {
			rSet.add(e[i]);
		}
		for(int i=0; i<set.size(); i++) {
			Object obj = set.get(i);
			if(!contain(obj))
				rSet.add(obj);
		}
		return rSet;
	}
 
	public Set intersection(Set set) {
		int len = size<set.size() ? size : set.size();
		Set rSet = new ArraySet(len);
		for(int i=0; i<set.size(); i++) {
			Object obj = set.get(i);
			if(contain(obj))
				rSet.add(obj);
		}
		return rSet;
	}
 
	public boolean isEmpty() {
		return size == 0;
	}
 
	public Object get(int i) {
		if(i<0 && i>= size) {
			throw new ArrayIndexOutOfBoundsException(i);
		}else  {
			return e[i];
		}
	}
	public Set differenceSet(Set set) {
		Set rSet = new ArraySet(size);
		for(int i=0; i<size; i++) {
			if(!set.contain(e[i]))
				rSet.add(e[i]);
		}
		return rSet;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(int i=0; i<size; i++) {
			if(i == size-1)
				sb.append(e[i]);
			else
				sb.append(e[i] + ", ");
		}
		sb.append("}");
		return sb.toString();
	}
}
