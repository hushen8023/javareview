package com.hushen.algorithm;

import java.util.Arrays;

/**
 * 算法工具类
 * @author Sonny
 *
 */
public class AlgorithmUtil {
	//打印排序后的数组
	public static void printArr(int[] numbers){
	    for(int i = 0 ; i < numbers.length ; i ++ ){
	    	System.out.print(numbers[i] + ",");
	    }
	    System.out.println("");
    }
	
	public static void main(String[] args) {
		int []numbers = new int[10];
        for(int i=1;i<numbers.length;i++){
            //a[i]=(int)(new Random().nextInt(100));
        	numbers[i]=(int)(Math.random()*100);
        }
        System.out.println("排序前的数组为："+Arrays.toString(numbers));
		System.out.print("冒泡排序：");
		BubbleSort.bubbleSort(numbers);
		AlgorithmUtil.printArr(numbers);
		System.out.print("快速排序Method1：");
		QuickSort.sortFirst(numbers, 0, numbers.length-1);
		AlgorithmUtil.printArr(numbers);
		System.out.print("快速排序Method2：");
		QuickSort.sortSecond(numbers, 0, numbers.length-1);
		AlgorithmUtil.printArr(numbers);
		System.out.print("选择排序Method1：");
		SelectSort.selectSortFirst(numbers);
		AlgorithmUtil.printArr(numbers);
		System.out.print("选择排序Method2：");
		SelectSort.selectSortSecond(numbers);
		AlgorithmUtil.printArr(numbers);
		System.out.print("插入排序Method1：");
		InsertSort.insertSortFirst(numbers);
		AlgorithmUtil.printArr(numbers);
		System.out.print("插入排序Method2：");
		InsertSort.insertSortSecond(numbers);
		AlgorithmUtil.printArr(numbers);
		System.out.print("希尔排序Method1：");
		SheelSort.sheelSortFirst(numbers);
		AlgorithmUtil.printArr(numbers);
		System.out.print("希尔排序Method2：");
		SheelSort.shellSortSecond(numbers);
		AlgorithmUtil.printArr(numbers);
	}
}
