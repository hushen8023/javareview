package com.hushen.algorithm;

/**
 * 快速排序
 * 
 * 一个方法两种写法，第二种更好理解一点。
 * 先选择第一位数为中轴，遍历把比他大的放右边，比他小的放左边。这样以中轴为中心分成了两个数组
 * 再每个数组再走一遍第一步，迭代循环即可
 * @author Sonny
 *
 */
public class QuickSort {
	/**
	 * 第一种方式：
	 * 
	 * 要求时间最快时。
	 * 选择第一个数为p，小于p的数放在左边，大于p的数放在右边。
	 * 递归的将p左边和右边的数都按照第一步进行，直到不能递归。
	 * @param a 待排序数组
	 * @param start 开始位置
	 * @param end 结束位置
	 */
	public static void sortFirst(int[]a,int start,int end){
        if(start<end){
            int baseNum=a[start];//选基准值
            int midNum;//记录中间值
            int i=start;
            int j=end;
            do{
                while((a[i]<baseNum)&&i<end){
                    i++;
                }
                while((a[j]>baseNum)&&j>start){
                    j--;
                }
                if(i<=j){
                    midNum=a[i];
                    a[i]=a[j];
                    a[j]=midNum;
                    i++;
                    j--;
                }
            }while(i<=j);
             if(start<j){
            	 sortFirst(a,start,j);
             }       
             if(end>i){
            	 sortFirst(a,i,end);
             }
        }
    }
	/**
	 * 第二种方法:
	 * 把整个序列看做一个数组，把第零个位置看做中轴，和最后一个比，如果比它小交换，比它大不做任何处理；
	 * 交换了以后再和小的那端比，比它小不交换，比他大交换。
	 * 这样循环往复，一趟排序完成，左边就是比中轴小的，右边就是比中轴大的，然后再用分治法，分别对这两个独立的数组进行排序。
	 */
	
	/**
     * 递归形式的分治排序算法
     * @param numbers 带排序数组
     * @param low  开始位置
     * @param high 结束位置
     */
    public static void sortSecond(int[] numbers,int low,int high){
        if(low < high){
        	int middle = getMiddle(numbers,low,high); //将numbers数组进行一分为二
        	sortSecond(numbers, low, middle-1);   //对低字段表进行递归排序
        	sortSecond(numbers, middle+1, high); //对高字段表进行递归排序
        }
    }
	/**
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     * @param numbers 带查找数组
     * @param low   开始位置
     * @param high  结束位置
     * @return  中轴所在位置
     */
    public static int getMiddle(int[] numbers, int low,int high){
        int temp = numbers[low]; //数组的第一个作为中轴
        while(low < high){
	        while(low < high && numbers[high] >= temp){//如果数组种出现两个数相等的，要么在比中轴小处理=，要么在下面比中轴大处理=
	            high--;
	        }
	        numbers[low] = numbers[high];//比中轴小的记录移到低端
	        while(low < high && numbers[low] < temp){
	            low++;
	        }
	        numbers[high] = numbers[low] ; //比中轴大的记录移到高端
        }
        numbers[low] = temp ; //中轴记录到尾
        return low ; // 返回中轴的位置
    }
    
	
	public static void main(String[] args) {
		int[] a = new int[]{2,2,-1,3,9,6};
		QuickSort quickSort = new QuickSort();
//		quickSort.sortFirst(a, 0, a.length-1);
		sortSecond(a, 0, a.length-1);
		AlgorithmUtil.printArr(a);
	}
}
