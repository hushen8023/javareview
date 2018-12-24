package com.hushen.datastructure.set;

public interface Set {
	/**
	 * 求元素的个数
	 * @return
	 */
	public  int size();
	/**添加元素
	 * 
	 * @param o
	 */
	public void add(Object o);
	/**
	 * 返回第i个元素
	 * @param i
	 * @return
	 */
	public Object get(int i);
	/**
	 * 删除元素
	 * @param o
	 */
	public void remove(Object o);
	/**
	 * 判断是否包含元素 o
	 * @param o
	 * @return
	 */
	public boolean contain(Object o);
	/**
	 * 是否包含集set
	 * @param set
	 * @return
	 */
	public boolean include(Set set);
	/**
	 * 求并集
	 * @param set
	 * @return
	 */
	public Set unionSet(Set set);
	/**
	 * 求交集
	 * @param set
	 * @return
	 */
	public Set intersection(Set set);
	/**
	 * 求差集
	 * @param set
	 * @return
	 */
	public Set differenceSet(Set set);
	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty();
}
