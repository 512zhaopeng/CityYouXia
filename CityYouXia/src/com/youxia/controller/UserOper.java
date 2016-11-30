package com.youxia.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.youxia.service.SendShortMsgService;


@Controller
@RequestMapping("/uesrOper")		//�༶��,���Բ���Ҫ,���Ҫ��,�������е�����·��ǰ����Ҫ���� 
public class UserOper {
	
	@Resource(name="sendShortMsgService")
	private SendShortMsgService msgService;
	
	@RequestMapping("/sendRegisterMsg")	//��������,������,����������������ĸ�����,������༶�� /aaa/bbb
	public void sendRegisterMsg(@RequestParam(value="mobile", required=true) String mobile, 
								HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		
		byte result = msgService.sendRegisterMsg(mobile);
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	
}
