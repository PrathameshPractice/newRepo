package com.practice.javapractice.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionEg1 {

	public static void main(String[] args) {
		try {
		Class eagle = Eagle.class;
		Method[] method = eagle.getMethods();
		
		/*
		for (Method methods:method) {
			
			System.out.println("Method Name : "+methods.getName());
			System.out.println("Return Type : "+methods.getReturnType());
			System.out.println("Class Name : "+methods.getDeclaringClass());

			
		}
		*/
		
		System.out.println(eagle.getName());
		System.out.println(eagle.getFields().toString());
		
		
		//To invoke(Call Method) using reflection
		
		Object eagleObj = eagle.newInstance();
		
		Method swim = eagle.getMethod("canSwim",String.class);
		swim.invoke(eagleObj, "Hello");
		
		
		
		//To change value of any variable which having access modifies as public
		Eagle egpublic = new Eagle();
		Field field = eagle.getDeclaredField("a");
		field.set(egpublic, "pqr");
		System.out.println(egpublic.a);
		
		
		
		//To change value of any variable which having access modifies as private

		Eagle egprivate = new Eagle();
		Field fieldpri = eagle.getDeclaredField("canSwim");
		fieldpri.setAccessible(true);
		fieldpri.set(egprivate,true);
		
		
		System.out.println("Private Variable Value :"+fieldpri.getBoolean(egprivate));
		
		// Acceing Constructor which is declared as private
		
		Class re = ReflectionConstructorExample.class;
		
		Constructor[] newConList = re.getDeclaredConstructors();
		for(Constructor sampleCond : newConList) {
			sampleCond.setAccessible(true);
			
			
			ReflectionConstructorExample ref = (ReflectionConstructorExample) sampleCond.newInstance();
			
		}
		
		}catch(Exception e) {
			
		}

		}

}
