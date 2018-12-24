package com.hushen.letcode;

/**
 * 题目：给定32位有符号整数，然后将其反转输出。例如：
 * 	输入： 123
 * 	输出： 321
 * 	输入： -123
 * 	输出： -321
 * 	输入： 120
 * 	输出： 21
 * 	给定反转整数范围: [-2^31, 2^31 - 1]，即在int的最小值、最大值之间，如果反转整数超过此范围，则返回0
 * 
 * 每日一题：2018.11.25
 * @author Sonny
 *
 */
public class LetCode05 {
	//第一种方法：使用StringBuilder类中的reverse()方法
	public static int reverse1 (int x) {
		if (0 == x) {
			return 0;
		}
		String flag = "";
		if (x < 0) {
			flag = "-";
		}
		//Math.abs()方法是用于取整数类型的绝对值
		String str = String.valueOf(Math.abs(x));
		StringBuilder sb = new StringBuilder(str);
		str = sb.reverse().toString();
		if (str.length() > 10) {
			return 0;
		}
		long value = Long.parseLong(flag + str);
		if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
			return 0;
		}
		return (int)value;
	}
	//第二种方法：通过%和/来拿出整数的个位和其他位
	public static int reverse2(int x) {
		if (x == 0){
			return 0;
		}
		Boolean flag = false;
		if (x < 0) {
			flag = true;
		}
		int b = 0;
		int a = Math.abs(x);
		while(a > 0){
			b = b*10 + a%10;
			a/=10;
		}
		if (flag) {
			b = 0 - b;
		}
		if (b < Integer.MIN_VALUE || b > Integer.MAX_VALUE) {
			return 0;
		}
		return b;
	}
	
	public static void main(String[] args) {
		int x = 123;
		int a = reverse2(x);
		int b = reverse1(x);
		System.out.println(a);
		System.out.println(b);
	}
}
