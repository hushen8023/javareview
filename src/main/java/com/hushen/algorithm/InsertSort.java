package com.hushen.algorithm;

public class InsertSort {
	/**  
     * 插入排序
     * 
     * 从第一个元素开始，该元素可以认为已经被排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描 
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置  
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置  
     * 将新元素插入到该位置中  
     * 重复步骤2  
     * @param numbers  待排序数组
     */  
    public static void insertSortFirst(int[] numbers){
	    int size = numbers.length;
	    int temp = 0 ;
	    int j =  0;
    
	    for(int i = 0 ; i < size ; i++){
	        temp = numbers[i];
	        //假如temp比前面的值小，则将前面的值后移
	        for(j = i ; j > 0 && temp < numbers[j-1] ; j --){
	        	numbers[j] = numbers[j-1];
	        }
	        numbers[j] = temp;
	    }
    }
    
    public static void insertSortSecond(int[] numbers){
        int len=numbers.length;//单独把数组长度拿出来，提高效率
        int insertNum;//要插入的数
        for(int i=1;i<len;i++){//因为第一次不用，所以从1开始
            insertNum=numbers[i];
            int j=i-1;//序列元素个数
            while(j>=0&&numbers[j]>insertNum){//从后往前循环，将大于insertNum的数向后移动
            	numbers[j+1]=numbers[j];//元素向后移动
                j--;
            }
            numbers[j+1]=insertNum;//找到位置，插入当前元素
        }
    }
}
