package com.youxia.test;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.youxia.bean.HelpBean;
import com.youxia.bean.HelpCommentBean;
import com.youxia.bean.HelpImageBean;
import com.youxia.dao.HelpDao;

@RunWith(SpringJUnit4ClassRunner.class)
//来标明是web应用测试
//@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-servlet.xml","classpath:spring.xml"})
public class HelpDaoTest {
	
	@Resource(name="helpDao")
	private HelpDao dao;
	
	//@Test
	public void addHelp(){
		HelpBean bean = new HelpBean();
		bean.setUserId(2);
		bean.setCategoryId(1);
		bean.setName("测试2");
		bean.setContent("第二个测试");
		bean.setArea(1);
		bean.setSite("友谊大街");
		bean.setRewardPoints(45);
		System.out.println(this.dao.addHelp(bean));
	}
	
	//@Test
	public void updateHelp(){
		HelpBean bean = new HelpBean();
		bean.setHelpId(2);
		bean.setName("我的第二个测试");
		bean.setRewardPoints(20);
		System.out.println(this.dao.updateHelp(bean));
	}
	
	//@Test
	public void queryHelpList(){
		System.out.println(this.dao.queryHelpList(1, (byte)0, -1, -1));
	}
	
	//@Test
	public void queryHelpDetail(){
		System.out.println(this.dao.queryHelpDetail(1));
	}
	
	//@Test
	public void addHelpImage(){
		HelpImageBean bean = new HelpImageBean();
		bean.setHelpId(3);
		bean.setImageUrl("/images/pic3.jpg");
		bean.setName("pic3");
		bean.setOrders(3);
		System.out.println(this.dao.addHelpImage(bean));		
	}
	
	//@Test
	public void queryHelpImageList(){
		System.out.println(this.dao.queryHelpImageList(1, 0, 10));
	}
	
	//@Test
	public void addHelpComment(){
		HelpCommentBean bean = new HelpCommentBean();
		bean.setContent("让你逆行，碰了活该！");
		bean.setHelpId(1);
		bean.setUserId(3);
		System.out.println(this.dao.addHelpComment(bean));
	}
	
	//@Test
	public void queryHelpCommentList(){
		System.out.println(this.dao.queryHelpCommentList(1, 0, 10));
	}
	
	
}
