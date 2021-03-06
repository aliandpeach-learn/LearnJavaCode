package com.wangjun.leetcode;

/*
请编写一个函数，其功能是将输入的字符串反转过来。

示例：

输入：s = "hello"
返回："olleh"
 */
public class LeetCode8 {

	public static void main(String[] args) {
		LeetCode8 lc = new LeetCode8();
		System.out.println(lc.reverseString("hello"));
	}

	// 解法1 用时：3ms
	public String reverseString(String s) {
		char[] arr = s.toCharArray();
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			char tem = arr[i];
			arr[i] = arr[j];
			arr[j] = tem;
			i++;
			j--;
		}
		return String.valueOf(arr);
	}
	// 解法2，使用StringBuilder，线程不安全，性能好  用时：3ms
	public String reverseString2(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		return sb.toString();
	}

}
