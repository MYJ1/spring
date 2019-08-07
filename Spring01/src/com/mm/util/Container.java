package com.mm.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 1、读取myobject.txdt
 * 2。使用反射创建对象
 * 3、使用反射给对象赋值
 *
 */
public class Container {
	//存储对象
	public Map<String,Object> map = new HashMap<>();
	public Container(File file) throws Exception{
		init(file);
	}
	//冲map中获取对象
	public Object getBeanObject(String name){
		Object result = null;
		if(map.containsKey(name)){
			result = map.get(name);
		}
		return result;
	}
	//读取文件创建对象
	private void init(File file) throws Exception{
		//使用io读取文件
		FileReader reader = new FileReader(file);
		
		//创建缓冲流
		BufferedReader br = new BufferedReader(reader);
		//
		String line = null;
		while((line= br.readLine())!=null){
			String[] array = line.split("=");
			String left = array[0];
			String right = array[1];
			
			if(left.indexOf(".")>0){
				//给属性赋值
				String[] leftArray = left.split("[.]");
				//从Map中获取对象
				Object beanObject = map.get(leftArray[0]);
				//设置属性
				Class clazz = beanObject.getClass();
				
				//获取成员对象
				Field field = clazz.getDeclaredField(leftArray[1]);
				
				//设置私有属性可访问
				field.setAccessible(true);
				//给属性赋值
				field.set(beanObject, map.get(right));
				
				 
			}else{
				//使用反射机制创建对象
				Object object = makeObject(right);
				//把创建的对象存起来
				map.put(left, object);
			}
		}
	}
	/**
	 * 利用反射生成对象
	 * @param className
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	private Object makeObject(String className)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Object object = null;
		
		object = Class.forName(className).newInstance();
		
		return object;
	
	}
}
