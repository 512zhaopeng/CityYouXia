package com.youxia.test;

import java.io.IOException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import com.youxia.service.HelpService;

@RunWith(SpringJUnit4ClassRunner.class)
//来标明是web应用测试
//@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-servlet.xml","classpath:spring.xml"})//

public class HelpServiceTest {
	
	@Resource(name="helpService")
	private HelpService service;
	
	@Test
	public void queryHelpList(){
		System.out.println(this.service.queryRoadRescueList(1, 5));
	}
	
	//@Test
	public void queryHelpDetail(){
		System.out.println(this.service.queryHelpDetail(1));
	}
	
	//@Test
	public void queryHelpImageList(){
		System.out.println(this.service.queryHelpImageList(1, 1, 10));
	}
	
	//@Test
	public void queryHelpCommentList(){
		System.out.println(this.service.queryHelpCommentList(1, 1, 10));
	}
	
	//@Test
	public void addHelp() throws IOException{
		MultipartFile[] fileArray = null;
		System.out.println(this.service.addHelp(2, "自行车坏了", 1, "新石中路自行车链子掉了，走不了了，拖车！", 23, "红旗大街新石中路", 117.165, 32.051, 30, fileArray));
	}
	
	//@Test
	public void updateHelp(){
		System.out.println(this.service.updateHelp(4, "我的汽车挂了", "呵呵，无语", 13, "新石中路红旗大街交口", 117.165, 32.051, 35));
	}
	
	//@Test
	public void addHelpComment(){
		System.out.println(this.service.addHelpComment(2, 2, "就该这样！"));
	}
	
	//@Test
	public void addPeopleSearchHelp(){
		//System.out.println(this.service.addPeopleSearchHelp(2, "小豆芽找不到家了", 2, "小豆芽在体育大街和槐安路附近的世纪公园找不到爸爸妈妈了，现在在万达星巴克和警察阿姨喝咖啡吧,爹妈速来认领!", 65, "红旗大街南三环", 117.165, 32.051, 30));
	}
	
	//@Test
	public void queryPeopleSearchHelpList(){
		System.out.println(this.service.queryPeopleSearchList(-1, -1));
	}
	
	//@Test
	public void queryPeopleSearchDetail(){
		System.out.println(this.service.queryPeopleSearchDetail(7));
	}
	
	
	
}
