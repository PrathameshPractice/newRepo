package com.practice.javapractice.reflection;
public class Eagle {
	
	Eagle() {
		System.out.println("IN PRIVATE CONSTRUCTOR");
	}
	
	
	
	public String a = "abc";
	private boolean canSwim = false;
	
	public void canSwim(String val) {
		System.out.println("In canSwim Method :: Value is :: "+val);
	}

	private void eat() {
		System.out.println("eat");
	}
}
