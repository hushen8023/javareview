package com.hushen.letcode;

import java.util.Scanner;

/**
 * 字符串碎片的平均长度
 * 
 * 一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。
 * 例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。
 * 牛牛现在给定一个字符串,请你帮助计算这个字符串的所有碎片的平均长度是多少。
 * 
 * 输入描述: 输入包括一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),s只含小写字母('a'-'z')
 * 输出描述: 输出一个整数,表示所有碎片的平均长度,四舍五入保留两位小数。
 * 如样例所示: s = "aaabbaaac"
 * 所有碎片的平均长度 = (3 + 2 + 3 + 1) / 4 = 2.25
 * 输入例子1: aaabbaaac
 * 输出例子1: 2.25
 * 
 * @author Sonny
 *
 */
public class LetCode03 {
	//第一种方式：String类中的charAt()方法
	public static void test () {
		System.out.println("请输入：");
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String s = sc.next();
			float f = 1;
			for (int i = 0; i < s.length() - 1; i++) {
				if (s.charAt(i) != s.charAt(i+1)) {
					f++;
				}
			}
			System.out.println(s.length()/f);
		}	
	}
	//第二种方式：把String转换成数组
	public static void test1() {
		System.out.println("请输入：");
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String s = sc.next();
			float f = 1;
			char[] chars = s.toCharArray();
			for (int i = 0; i < chars.length - 1; i++) {
				if (chars[i] != chars[i+1]) {
					f++;
				}
			}
			System.out.println(s.length()/f);
		}	
	}
	
	public static void main(String[] args) {
		//test();
		test1();
	}
}
