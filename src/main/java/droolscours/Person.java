package droolscours;

import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1396622207289722435L;
	
	private Integer age;
	private String name;
	private String desc;
	
	// 构造函数重载
	public Person() {
		
	}
	
	public Person(Integer age, String name, String desc) {
		this.age = age;
		this.name = name;
		this.desc = desc;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
