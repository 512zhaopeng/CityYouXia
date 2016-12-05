package com.youxia.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.youxia.bean.UserBean;
import com.youxia.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
//来标明是web应用测试
//@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-servlet.xml","classpath:spring.xml"})//
public class UserDaoTest {
	
	@Resource(name="userDao")
	private UserDao dao;

	//@Test
	public void queryUserByName(){
		System.out.println(dao.queryUserByName("zhangsan"));
	}
	
	@Test
	public void queryUserByMobile(){
		System.out.println(dao.queryUserByMobile("18931111605"));
	}
	
	
	//@Test
	public void addUserBean(){
		UserBean bean = new UserBean(); 
		//bean.setUserName("zhangsan");
		//bean.setNickName("张三三");
		bean.setPassword("123456");
		//bean.setArea(15);
		bean.setMobile("18931111605");
		System.out.println(dao.addUserBean(bean));
	}
	


}
