package com.wangjun.othersOfJava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/** 
 * hashMap的增删查改
 * 无序
 * key相当于set，不可重复
 * value相当于list，可重复
 * @author wangjun 
 * @email  scuwangjun@hotmail.com
 * @time   2018年4月6日 下午2:30:31 
 */
public class HashMapOperation {

	public static void main(String[] args) {
		//初始化
		HashMap<String,String> map = new HashMap<>();
		//增
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		//删
		map.remove("key2");
		//查
		System.out.println("key1对应的valve为：" + map.get("key1"));
		//改
		map.replace("key3", "value33");
		System.out.println("最终的map是：" + map.toString());
		//遍历1，取出map中所有的key组成一个set
		System.out.println("HashMap遍历1，取出map中所有的key组成一个set:");
		for(String key: map.keySet()) {
			System.out.println("key:" + key + ",value:" + map.get(key));
		}
		//遍历2,取出key组成set后，通过Iterator遍历key
		System.out.println("HashMap遍历2,取出key组成set后，通过Iterator遍历key：");
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println("key:" + key + ",value:" + value);
		}
		//遍历3，取出map中实际存储的数据结构--Map.Entry,在HashMap中使用的是Node静态内部类
		//推荐这种，尤其是数据很大时
		System.out.println("HashMap遍历3，通过Map.Entry：");
		Set<Map.Entry<String, String>> entry = map.entrySet();
		for(Map.Entry<String, String> entryItem: entry) {
			String key = entryItem.getKey();
			String value = entryItem.getValue();
			System.out.println("key:" + key + ",value:" + value);
		}
		//遍历4,只能遍历value，不能遍历key,相当于取出map中左右的value组成一个list
		System.out.println("HashMap遍历4，只遍历value：");
		for(String value: map.values()) {
			System.out.println("value:" + value);
		}
	}

}
