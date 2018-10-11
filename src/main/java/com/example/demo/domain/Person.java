package com.example.demo.domain;

public class Person {
	
    private Long id;
    
    private String userName;
    
    private String password;
    
    private Integer age;
    
	public Person(Long id, String userName, String password, Integer age) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.age = age;
	}
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

}
