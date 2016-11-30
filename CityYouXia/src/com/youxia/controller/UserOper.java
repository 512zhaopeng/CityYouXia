package com.youxia.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.youxia.service.SendShortMsgService;


@Controller
@RequestMapping("/uesrOper")		//类级别,可以不需要,如果要了,下面所有的请求路径前都需要加入 
public class UserOper {
	
	@Resource(name="sendShortMsgService")
	private SendShortMsgService msgService;
	
	@RequestMapping("/sendRegisterMsg")	//方法级别,必须有,决定这个方法处理哪个请求,如果有类级别 /aaa/bbb
	public void sendRegisterMsg(@RequestParam(value="mobile", required=true) String mobile, 
								HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		
		byte result = msgService.sendRegisterMsg(mobile);
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	
}
