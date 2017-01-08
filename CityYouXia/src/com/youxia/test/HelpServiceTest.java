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
//��������webӦ�ò���
//@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-servlet.xml","classpath:spring.xml"})//

public class HelpServiceTest {
	
	@Resource(name="helpService")
	private HelpService service;
	
	//@Test
	public void queryRoadRescueList(){
		System.out.println(this.service.queryRoadRescueList(1, 5));
	}
	
	//@Test
	public void queryHelpDetail(){
		System.out.println(this.service.queryHelpDetail(4));
	}
	
	//@Test
	public void queryHelpImageList(){
		System.out.println(this.service.queryHelpImageList(1, 1, 10));
	}
	
	//@Test
	public void refreshHelpList(){
		System.out.println(this.service.refreshHelpList(1, 2));
	}
	
	
	//@Test
	public void queryHelpCommentList(){
		System.out.println(this.service.queryHelpCommentList(1, 1, 10));
	}
	
	//@Test
	public void addHelp() throws IOException{
		MultipartFile[] fileArray = null;
		System.out.println(this.service.addHelp(2, "���г�����", 1, "��ʯ��·���г����ӵ��ˣ��߲����ˣ��ϳ���", 23, "��������ʯ��·", 117.165, 32.051, 30, fileArray));
	}
	
	//@Test
	public void updateHelp(){
		System.out.println(this.service.updateHelp(4, "�ҵ���������", "�Ǻǣ�����", 13, "��ʯ��·�����ֽ���", 117.165, 32.051, 35));
	}
	
	//@Test
	public void addHelpComment(){
		this.service.addHelpComment(12, 2, "û�£������е���Ǯ��");
	}
	
	//@Test
	public void addPeopleSearchHelp() throws IOException{
		System.out.println(this.service.addPeopleSearchHelp(1, "����̫ʧ����", "һ����һ�߳ԣ�һ㶣���û��!", 65, "ԣ��·ʡ�����ſڰ�", 117.236, 32.135, 30, null));
	}
	
	//@Test
	public void queryPeopleSearchHelpList(){
		System.out.println(this.service.queryPeopleSearchList(-1, -1));
	}
	
	//@Test
	public void queryPeopleSearchDetail(){
		System.out.println(this.service.queryPeopleSearchDetail(7));
	}
	
	//@Test
	public void refreshPeopleSearchList(){
		System.out.println(this.service.refreshPeopleSearchList(7));
	}
	
	//Ѱ��
	//@Test
	public void addFindThingHelp() throws IOException{
		System.out.println(this.service.addFindThingHelp(1, "��˼�����İ����Ƕ���", "æ�ſ���Ů��˼�ϵ��Ǹ��䵽���������ˣ�", 39, "���������Ѱٻ�62·", 114.2301, 35.4512, 30, null));
	}
	
	//@Test
	public void queryFindThingList(){
		System.out.println(this.service.queryFindThingList(-1, -1));
	}
	
	//@Test
	public void refreshFindThingList(){
		System.out.println(this.service.refreshFindThingList(11));
	}
	
	//@Test
	public void queryFindThingDetail(){
		System.out.println(this.service.queryFindThingDetail(12));
	}
	
	
	
}
