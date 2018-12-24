package com.hushen.letcode;

/**
 * 题目：给定一个整数，判断其是否为回文整数，即向前读和向后读的整数一样。
 * 如：
 * 	输入： 121
 * 	输出： true
 * 	输入： -121
 * 	输出： false
 * 	说明：从左到右读为-121。从右到左读为121-。因此它不是回文。
 * 	输入： 10
 * 	输出： false
 * 	说明：从左到右读为10。从右到左读为01。因此它不是回文。
 * 
 * 每日一题：2018.11.26
 * @author Sonny
 *
 */
public class LetCode06 {
	public static Boolean isReverseData(int x) {
		Boolean flag = false;
		if (x == 0) {
			return false;
		}
		if (x < 0 || x%10 == 0) {
			return false;
		}
		int a = 0;	
		//这块有点绕
		while(x>a){
			a = a*10 + x%10;
			x/=10;
		}
		if (a == x || x == a/10) {
			flag = true;
		}
		return flag;
	}
	
	public static void main(String[] args) {
		int x = 1223;
		System.out.println(isReverseData(x));
	}

}
