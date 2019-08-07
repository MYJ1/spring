package com.mm.test;

import java.io.File;

import com.mm.service.UserService;
import com.mm.util.Container;

public class MyTest {
	public static void main(String[] args) throws Exception {
		/*UserService userService = new UserServiceImpl();
		
		userService.addUser();*/
		String path = MyTest.class.getResource("/").getPath();
		
		String fileName = path + "myobject.txt";
		
		File file = new File(fileName);
		
		Container container = new Container(file);
		
		UserService userService = (UserService) container.getBeanObject("userService");
		
		userService.addUser();
		
		
	}
}
