package com.hushen.algorithm;

/**
 * 选择排序
 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 * @author Sonny
 *
 */
public class SelectSort {
	/**
     * 选择排序算法
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置  
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。 
     * 以此类推，直到所有元素均排序完毕。 
     * @param numbers
     */
    public static void selectSortFirst(int[] numbers){
	    int size = numbers.length; //数组长度
	    int temp = 0 ; //中间变量
	    
	    for(int i = 0 ; i < size ; i++){
	        int k = i;   //待确定的位置
	        //选择出应该在第i个位置的数
	        for(int j = size -1 ; j > i ; j--){
		        if(numbers[j] < numbers[k]){
		            k = j;
		        }
		    }
	        //交换两个数
	        temp = numbers[i];
	        numbers[i] = numbers[k];
	        numbers[k] = temp;
	    }
    }
    
    /**
     * 第二种方式
     * @param a
     */
    public static void selectSortSecond(int[]a){
        int len=a.length;
        for(int i=0;i<len;i++){//循环次数
            int value=a[i];
            int position=i;
            for(int j=i+1;j<len;j++){//找到最小的值和位置
                if(a[j]<value){
                    value=a[j];
                    position=j;
                }
            }
            a[position]=a[i];//进行交换
            a[i]=value;
        }
    }
    
	public static void main(String[] args) {
		int[] numbers = {10,20,15,0,6,7,2,1,-5,55};
		//selectSortFirst(numbers);
		SelectSort selectSort = new SelectSort();
		selectSort.selectSortSecond(numbers);
		AlgorithmUtil.printArr(numbers);
	}

}
