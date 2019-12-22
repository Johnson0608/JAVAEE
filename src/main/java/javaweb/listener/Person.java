package javaweb.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Person implements HttpSessionBindingListener {
	private String name;
	private int age;
	private String sex;
	
	public Person(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public Person() {
		super();
	}

	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("把Person对象存放到session中：" + evt.getValue());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("从session中移除Pseron对象：" + evt.getValue());
	}

}
