package com.wangjun.othersOfJava;
/** 
 * @author wangjun 
 * @email  scuwangjun@hotmail.com
 * @time   2018年4月2日 下午11:37:09 
 */
public class UMLExample {

}

class Person {
	
	private String name = "personName";
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

class Teacher extends Person implements test{
	
	private int teacherNum;
	
	public String teach() {
		
		return "teaching";
		
	}
}

interface test {
	int a = 0;
	
	
}

