package com.hushen.letcode;

import java.util.Scanner;

/**
 * 求“相反数”问题
 * 
 * 为了得到一个数的"相反数",我们将这个数的数字顺序颠倒,然后再加上原先的数得到"相反数"。
 * 例如,为了得到1325的"相反数",首先我们将该数的数字顺序颠倒,我们得到5231,之后再加上原先的数,我们得到5231+1325=6556.
 * 如果颠倒之后的数字有前缀零,前缀零将会被忽略。例如n = 100, 颠倒之后是1.
 * 
 * 输入描述: 输入包括一个整数n,(1 ≤ n ≤ 10^5)
 * 输出描述: 输出一个整数,表示n的相反数
 * 输入例子1: 1325
 * 输出例子1: 6556
 * 
 * 每日一题：2018.11.27
 * @author Sonny
 *
 */
public class LetCode02 {
	public static void main(String[] args) {
		int a = reverseAdd();
	}
	public static int reverseAdd() {
		System.out.println("请输入一个整数：");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		//将字符串转成数字
		int i = Integer.parseInt(s);
		//注意这边StringBuilder反转之后要用toString()一下
		int y = Integer.parseInt(new StringBuilder(s).reverse().toString());
		System.out.println(i+y);	
		return i+y;
	}
}