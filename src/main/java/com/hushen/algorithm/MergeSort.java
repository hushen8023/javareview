package com.hushen.algorithm;

import java.util.Arrays;

/**
 * 	归并排序
 * 
 *  设r[i…n]由两个有序子表r[i…m]和r[m+1…n]组成，两个子表长度分别为n-i +1、n-m。
	j=m+1；k=i；i=i; //置两个子表的起始下标及辅助数组的起始下标
	若i>m 或j>n，转⑷ //其中一个子表已合并完，比较选取结束
	//选取r[i]和r[j]较小的存入辅助数组rf
	如果r[i]<r[j]，rf[k]=r[i]； i++； k++； 转⑵
	否则，rf[k]=r[j]； j++； k++； 转⑵
	//将尚未处理完的子表中元素存入rf
	如果i<=m，将r[i…m]存入rf[k…n] //前一子表非空
	如果j<=n ,  将r[j…n] 存入rf[k…n] //后一子表非空
	合并结束。
 * @author Sonny
 *
 */
public class MergeSort {
	
     public static void sort(int []arr){
         int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
         sort(arr,0,arr.length-1,temp);
     }
     private static void sort(int[] arr,int left,int right,int []temp){
         if(left<right){
             int mid = (left+right)/2;
             sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
             sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
             merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
         }
     }
     private static void merge(int[] arr,int left,int mid,int right,int[] temp){
         int i = left;//左序列指针
         int j = mid+1;//右序列指针
         int t = 0;//临时数组指针
         while (i<=mid && j<=right){
             if(arr[i]<=arr[j]){
                 temp[t++] = arr[i++];
             }else {
                 temp[t++] = arr[j++];
             }
         }
         while(i<=mid){//将左边剩余元素填充进temp中
             temp[t++] = arr[i++];
         }
         while(j<=right){//将右序列剩余元素填充进temp中
             temp[t++] = arr[j++];
         }
         t = 0;
         //将temp中的元素全部拷贝到原数组中
         while(left <= right){
             arr[left++] = temp[t++];
         }
     }

     
     
	public static void main(String[] args) {
	 int []numbers = new int[10];
     for(int i=1;i<numbers.length;i++){
         //a[i]=(int)(new Random().nextInt(100));
     	numbers[i]=(int)(Math.random()*100);
     }
     System.out.println("排序前的数组为："+Arrays.toString(numbers));
     sort(numbers);
     System.out.println("排序后的数组为："+Arrays.toString(numbers));
	} 
}
