package com.youxia.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.youxia.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
//��������webӦ�ò���
//@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-servlet.xml","classpath:spring.xml"})//
public class UserServiceTest {

	@Resource(name="userService")
	private UserService service;
	
	@Test
	public void loginCheckUser(){
		System.out.println(service.loginCheckUser("������", "12345"));
	}
	
	
}
