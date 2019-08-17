package com.mm.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mm.service.SomeService;

//从spring容器中获取java对象，调用对象的业务方法
public class MyTest {


	public static void main(String[] args) { 
		//指定容器的配置文件
		String resources = "application.xml";
		//创建spring容器对象】
		ApplicationContext ac = new ClassPathXmlApplicationContext(resources);
		//从容器中获取对象
		SomeService bean = (SomeService) ac.getBean("someService");
		//调用对象的方法
		bean.dosome();
		
	}

}
