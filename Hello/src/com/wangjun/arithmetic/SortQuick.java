package com.wangjun.arithmetic;

import java.util.Arrays;

/*
 * 快速排序
 */
public class SortQuick {

	public static void main(String[] args) {
		int[] arr = {2,3,7,5,43,8,9,0,3,1};
		SortQuick ss = new SortQuick();
		ss.sortQuick(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 快速排序，与冒泡排序类似
1，首先设定一个分界值，通过该分解将数组分为左右两部分
2，将大于等于分界值的数值集中到数组右边，小于等于分界值的数值集中到数组左边，
   此时，左边的数据都小于等于分界值，右边的数据都大于等于分界值
3，然后左边和右边的数据可以独立排序，对于左边的数据也可以取一个分界值将数据分为左右两部分，
   左边的数据小于等于分界值，右边的数据大于等于分界值。右边的数据也可以这样做
4，重复上述过程，可以看出这是一个递归定义。通过递归将左侧数据排序好后，在递归排好右侧部分的顺序。
   当左、右两部分数据排序完成后，整个数组的排序也就完成了。
	 */
	public void sortQuick(int[] arr) {
		sortHelper(arr, 0, arr.length - 1);
	}
	
	public void sortHelper(int[] arr, int start, int end) {
		int lstart = start;
		int rend = end;
		
		int middle = arr[(start + end)/2]; //分解值
		
		while(start < end) {
			while(arr[start] < middle) {
				start++;
			}
			while(arr[end] > middle) {
				end--;
			}
			if(start < end) {
				int tem = arr[start];
				arr[start] = arr[end];
				arr[end] = tem;
				start++;
				end--;
			}
		}
		if(start == end) {
			start++;
		}
		
		if(lstart < end) {
			sortHelper(arr, lstart, start - 1);
		}
		if(rend > start) {
			sortHelper(arr, end + 1, rend);
		}
		
	}

}