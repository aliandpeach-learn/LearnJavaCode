package com.wangjun.othersOfJava;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/** 
 * LinkedList的增删查改和遍历
 * @author wangjun 
 * @email  scuwangjun@hotmail.com
 * @time   2018年4月7日 下午4:50:44 
 */
public class LinkedListOperation {

	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		//增
		list.add("str1");
		list.add("str2");
		list.add("str3");
		//删
		list.remove(1);
		//查
		System.out.println("list的第二个元素是：" + list.get(1));
		//改
		list.set(1, "str33");
		System.out.println("最终的list：" + list.toString());
	}

}
