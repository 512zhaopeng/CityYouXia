package com.youxia.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import com.opensymphony.xwork2.interceptor.annotations.Allowed;
import com.youxia.util.SystemDef;

@Service("sendShortMsgService")
public class SendShortMsgService {

	@Allowed
	private HttpSession session;
	
	//����ע�����
	public byte sendRegisterMsg(String mobile){
		String randomNumber = String.valueOf(createRandomNumber());
		try {
			String content = createRegisterContent(randomNumber);
			if(sendMSGService(mobile, content)){
				session.setAttribute(SystemDef.APP_REGISTER_MESSAGE_SESSION, randomNumber + "_" + mobile);
				return SystemDef.OPERTYPE_SUCCESS;
			}
			else{
				return SystemDef.OPERTYPE_FAIL;
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return SystemDef.OPERTYPE_FAIL;
		}
	}
	
	//�����ƽ̨���Ͷ���֪ͨ
	public boolean sendMSGService(String mobile, String content){
		String userId = "400114";
		//ʱ���
		String timespan = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String password = "";//MD5Util.encryptStrByMD5("002676" + timespan);
		
		String url = "http://api.shumi365.com:8090/sms/sendData.do";
		//url����
		StringBuffer sendData = new StringBuffer();
		sendData.append("userid=").append(userId)
				.append("&pwd=").append(password)
				.append("&timespan=").append(timespan)
				.append("&mobile=").append(mobile)
				.append("&content=").append(content)
				.append("&msgfmt=").append("UTF-8");
		
		try{
			//���Ͷ���
			String result = httpPost(url, sendData.toString(), "utf-8");
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	//������λ�����֤��
	public int createRandomNumber(){
		int max = 999999, min = 100000;
		Random random = new Random();
		return random.nextInt(max)%(max - min + 1) + min;
	}
	
	public String createRegisterContent(String randomNumber) throws UnsupportedEncodingException{
		StringBuffer sb = new StringBuffer();
		sb.append("�����ֻ���֤��Ϊ��").append(randomNumber).append(",��Ч��Ϊ10���ӡ�");
		String content = new sun.misc.BASE64Encoder().encode(sb.toString().getBytes("UTF-8"));
		//ȥ�������ַ�
		content = content.replaceAll("\\r", "").replaceAll("\\n", "").replaceAll("\\r\\n", "");
		return content;
	}
	
	/**
	 * urlStr:�������ӵ�ַ
	 * data:�������
	 * */
	public static String httpPost(String urlStr, String data, String charset){
		URL url = null;
		
		try {
			url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setConnectTimeout(30*1000);
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			
			OutputStream out = conn.getOutputStream();
			out.write(data.getBytes(charset));
			out.close();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
			StringBuilder response = new StringBuilder();	//�õ���StringBuilder������StringBuffer
			String result;
			while(null != (result = in.readLine())){
				response.append(result).append("\n");
			}
			in.close();
			return response.toString();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	
}
