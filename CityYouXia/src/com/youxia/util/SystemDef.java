package com.youxia.util;

public class SystemDef {
	
	public static final String APP_REGISTER_MESSAGE_SESSION = "app_register_msg_session";

	public static final String HELPIMAGE_BASEPATH = "/helpImages";
	public static final String USERPHOTO_BASEPATH = "/userImages";
	
	//��������
	public static final byte HELPTYPE_ROADRESCUE   = 1;		//��·��Ԯ
	public static final byte HELPTYPE_PEOPLESEARCH = 2;		//Ѱ��
	
	//���������־
	public static final byte HELP_SOLVED_ALL = 0;	//����	
	public static final byte HELP_SOLVED_NO  = 1;	//�ѽ��
	public static final byte HELP_SOLVED_YES = 2;	//δ���
	
	//�û��˺��Ƿ�����
	public static final byte USER_LOCK_YES = 1;     //������
	public static final byte USER_LOCK_NO  = 2;     //δ������
	
	public static final byte USER_MAXLOGIN_TIMES = 5; //�û�һ��������������
	
	//������Ϣ
	public static final byte OPER_SUCCESS 		 = 1;	//�����ɹ�
	public static final byte OPER_FAIL 			 = 2;	//����ʧ��
	//�û���¼������Ϣ
	public static final byte LOGIN_SUCCESS 		 = 3;	//��¼�ɹ�
	public static final byte LOGIN_NOUSER_ERROR  = 4;   //�û�������
	public static final byte LOGIN_PWD_ERROR 	 = 5;   //�������
	public static final byte LOGIN_ONLINE_ERROR  = 6;   //�û��Ѿ���¼
	public static final byte LOGIN_TIMEOUT_ERROR = 7;   //�û���¼��ʱ
	public static final byte LOGIN_LOCK_ERROR    = 8;   //�û�����
	
	//ע�᷵�ش�����
	public static final byte REGISTE_USER_EXIST = 11;	//�û��Ѿ�����
	
	
	
}
