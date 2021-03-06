package com.wangjun.arithmetic;
/** 
 * @author wangjun 
 * @email  scuwangjun@hotmail.com
 * @time   2018年4月4日 下午11:14:43 
 */
public class Factorial {

	public static void main(String[] args) {
		System.out.println(factorial1(11));
	}
	
	/*
	 * 计算X!
	 * 使用递归
	 */
	public static int factorial(int n) {
		if( 1 == n) {
			return 1;
		}else {
			return factorial(n -1) * n;
		}
	}
	
	/*
	 * 计算X!
	 * 使用循环
	 */
	public static int factorial1(int n) {
		int result = 1;
		for (int i = n; i > 0; i--) {
			result *= i;
		}
		return result;
	}

}
