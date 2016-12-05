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
		System.out.println(this.service.addHelp(2, "���г�����", 1, "��ʯ��·���г����ӵ��ˣ��߲����ˣ��ϳ���", 23, "��������ʯ��·", 117.165, 32.051, 30, fileArray));
	}
	
	//@Test
	public void updateHelp(){
		System.out.println(this.service.updateHelp(4, "�ҵ���������", "�Ǻǣ�����", 13, "��ʯ��·�����ֽ���", 117.165, 32.051, 35));
	}
	
	//@Test
	public void addHelpComment(){
		System.out.println(this.service.addHelpComment(2, 2, "�͸�������"));
	}
	
	//@Test
	public void addPeopleSearchHelp(){
		//System.out.println(this.service.addPeopleSearchHelp(2, "С��ѿ�Ҳ�������", 2, "С��ѿ��������ֺͻ���·���������͹�԰�Ҳ����ְ������ˣ�����������ǰͿ˺;��찢�̺ȿ��Ȱ�,������������!", 65, "������������", 117.165, 32.051, 30));
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
