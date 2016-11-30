package com.youxia.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.youxia.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
//来标明是web应用测试
//@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-servlet.xml","classpath:spring.xml"})//
public class UserDaoTest {
	
	@Resource(name="userDao")
	private UserDao dao;

	@Test
	public void queryUserByName(){
		System.out.println(dao.queryUserByName("张三三"));
	}


}
