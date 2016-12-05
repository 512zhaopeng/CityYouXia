package com.youxia.util;

public class SystemDef {
	
	public static final String APP_REGISTER_MESSAGE_SESSION = "app_register_msg_session";

	public static final String HELPIMAGE_BASEPATH = "/helpImages";
	public static final String USERPHOTO_BASEPATH = "/userImages";
	
	//帮助类型
	public static final byte HELPTYPE_ROADRESCUE   = 1;		//道路救援
	public static final byte HELPTYPE_PEOPLESEARCH = 2;		//寻人
	
	//帮助解决标志
	public static final byte HELP_SOLVED_ALL = 0;	//所有	
	public static final byte HELP_SOLVED_NO  = 1;	//已解决
	public static final byte HELP_SOLVED_YES = 2;	//未解决
	
	//用户账号是否被锁定
	public static final byte USER_LOCK_YES = 1;     //被锁定
	public static final byte USER_LOCK_NO  = 2;     //未被锁定
	
	public static final byte USER_MAXLOGIN_TIMES = 5; //用户一天内密码输错次数
	
	//错误信息
	public static final byte OPER_SUCCESS 		 = 1;	//操作成功
	public static final byte OPER_FAIL 			 = 2;	//操作失败
	//用户登录返回信息
	public static final byte LOGIN_SUCCESS 		 = 3;	//登录成功
	public static final byte LOGIN_NOUSER_ERROR  = 4;   //用户不存在
	public static final byte LOGIN_PWD_ERROR 	 = 5;   //密码错误
	public static final byte LOGIN_ONLINE_ERROR  = 6;   //用户已经登录
	public static final byte LOGIN_TIMEOUT_ERROR = 7;   //用户登录超时
	public static final byte LOGIN_LOCK_ERROR    = 8;   //用户锁定
	
	//注册返回错误码
	public static final byte REGISTE_USER_EXIST = 11;	//用户已经存在
	
	
	
}
