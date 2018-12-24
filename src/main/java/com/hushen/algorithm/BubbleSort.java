package com.hushen.algorithm;

/**
 * 冒泡排序
 * 
 * 将序列中所有元素两两比较，将最大的放在最后面。
 * 将剩余序列中所有元素两两比较，将最大的放在最后面。
 * 重复第二步，直到只剩下一个数。
 * @author Sonny
 *
 */
public class BubbleSort {
	
	/**
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。  
     * 第一轮i，会把最大的排在最后面
     * @param numbers 需要排序的整型数组
     */
    public static void bubbleSort(int[] numbers){
        int temp = 0;
        int size = numbers.length;
        for(int i = 0 ; i < size-1; i ++){
            for(int j = 0 ;j < size-1-i ; j++){
                if(numbers[j] > numbers[j+1]){
                    //交换两数位置
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }
}
