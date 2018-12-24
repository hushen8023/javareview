package com.hushen.letcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 给定一个整数数组和一个目标整数，该目标整数满足数组中两元素之和，返回数组中两个数字的下标索引，以数组形式表示结果。
 * 例如给定数组int[] nums = [2, 7, 11, 15],目标整数int target = 9,
 * 因为 nums[0] + nums[1] = 2 + 7 = 9,返回包含两数索引的数组[0, 1]。
 * 
 * 每日一题：2017.11.24
 * @author Sonny
 *
 */
public class LetCode04 {
	public static void main(String[] args) {
		int[] nums = { 9, 9, 10, 8 };
		int target = 18;
		Object[] result = test1(nums, target);
		Object[] result1 = test2(nums, target);
		System.out.println("------第一种方式-------");
		System.out.println(result[0]);
		System.out.println(result[1]);
		System.out.println("------第二种方式-------");
		System.out.println(result1[0]);
		System.out.println(result1[1]);
	}

	public static Object[] test1(int[] nums, int target) {
		List<Integer> arr = new ArrayList<Integer>();
		if (nums.length < 2) {
				return null;
		}
			try {
				for (int i = 0; i < nums.length; i++) {
					//这里i+1可以屏蔽掉[0]+[1]与[1]+[0]这种情况，两者相加两次无意义，速度更快。
					for (int j = i + 1; j < nums.length; j++) {
						if (nums[i] + nums[j] == target) {
							arr.add(i);
							arr.add(j);
						}
					}
				}
			} catch(Exception e){
				e.printStackTrace();
				return null;
			}
		return arr.toArray();
	}
	
	
	public static Object[] test2(int[] nums, int target) {
		List<Integer> arr = new ArrayList<Integer>();
		if (nums.length < 2) {
				return null;
		}
		try{
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < nums.length; i++) {
				int num = target - nums[i];//目标整数和每个元素做减法
				//第一次循环不走，因为map中为null
				if (map.containsKey(num)) {
					arr.add(map.get(num));
					arr.add(i);
				}
				//把数组元素作为key，数组下标作为value存入map。
				map.put(nums[i], i);
			}
	}catch(Exception e) {
		e.printStackTrace();
		return null;
	}
	return arr.toArray();
}


}
