package com.youxia.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommFunc {
	/**
	 * ��������
	 * */
	public static String formatDate(Timestamp time, byte type){
        if(time == null)
            return "";

        String formatType = "";
        switch(type){
            case 1:
                formatType = "yyyy-MM-dd HH:mm:ss";
                break;
            case 2:
                formatType = "yyyy-MM-dd";
                break;    
            case 3:
                formatType = "HH:mm:ss";
                break;
            case 4:
                formatType = "yyyy��MM��dd��";
                break;
            case 5:
                formatType = "yyyyMMdd";
                break;
            default:
                formatType = "yyyy-MM-dd";
                break;    
        }

        SimpleDateFormat df = new SimpleDateFormat(formatType); 
        return df.format(time);
    }

    //Dateת��Ϊ��׼��ʽ
    public static String formatDate(Date time, byte type){
        if(time == null)
            return "";

        String formatType = "";
        switch(type){
            case 1:
                formatType = "yyyy-MM-dd HH:mm:ss";
                break;
            case 2:
                formatType = "yyyy-MM-dd";
                break;    
            case 3:
                formatType = "HH:mm:ss";
                break;
            case 4:
                formatType = "yyyy��MM��dd��";
                break;
            case 5:
                formatType = "yyyyMMdd";
                break;
            default:
                formatType = "yyyy-MM-dd";
                break;    
        }

        SimpleDateFormat df = new SimpleDateFormat(formatType); 
        return df.format(time);
    }
    
    //Timestamp-->Date
    
    //TimeStamp-->Calendar
    
    
    
    //��ȡ��ǰʱ���Timestamp
    public static Timestamp getNowTimestamp(){
    	return Timestamp.valueOf(formatDate(new Date(), (byte)1));
    }

    //��ȡ�ڽ������differDay�������(differDay<0:֮ǰ�ģ�differDay>0֮���)
    public static Calendar getCalendarByDay(Calendar calendar, int differDay){
        Calendar aim =  Calendar.getInstance();
        aim.setTime(calendar.getTime());
        aim.add(Calendar.DATE, differDay);
        return aim;
    }

    //�ж����������Ƿ�Ϊͬһ�·�
    public static boolean isSameMonth(Calendar calendar1, Calendar calendar2){
        int month1 = calendar1.get(Calendar.MONTH);
        int month2 = calendar2.get(Calendar.MONTH);        
        return month1 == month2;
    }

    //��������
    public static long diffDate(Timestamp time1, Timestamp time2){
        return time1.getTime() - time2.getTime();
    }
    
    //�ж�����Timestamp�Ƿ�Ϊͬһ��
    public static boolean isTimestampSameDay(Timestamp time1, Timestamp time2){

    	return true;
    }
    
    
    //����TimeStamp�����ڲ�
    public static double diffDateByDay(Timestamp time1, Timestamp time2){
        return round(((time1.getTime() - time2.getTime())/(1000*60*60*24.0)),0);
    }
    
    /**��ʽ��������֮��Ĳ�ֵ(���㵥λΪ��)
     * diff<1000*60==��   
     * 1000*60<diff<1000*60*60 ==����
     * 1000*60*60<diff<1000*60*60*24 == Сʱ
     * 1000*60*60*24 < diff < 1000*60*60*24*30 == ��
     * 1000*60*60*24*30 < diff == ��
     * */
    public static String formatDiff(Timestamp time1, Timestamp time2){
    	long diff = Math.abs(diffDate(time1, time2));
    	if(diff<=1000*60l){ 
    		return roundtostr(diff*1.0/1000,0) + "��ǰ";
    	}
    	else if(diff<=1000*60*60l){
    		return roundtostr(diff*1.0/(1000*60),0) + "����ǰ";
    	}
    	else if(diff<=1000*60*60*24l){
    		return roundtostr(diff*1.0/(1000*60*60),0) + "Сʱǰ";
    	}
    	else if(diff<=1000*60*60*24*30l){
    		return roundtostr(diff*1.0/(1000*60*60*24l),0) + "��ǰ";
    	}
    	else{
    		return roundtostr(diff*1.0/(1000*60*60*24*30l),0) + "��ǰ";
    	}
    }
    
    
    

    // ��������
    // scale:С�������λ��
    public static BigDecimal roundBase(Double d, int scale) {
        if (d == null) {
            return null;
        }
        if (scale < 0) {
            scale = Math.abs(scale);
        }
        BigDecimal b1 = new BigDecimal(Double.toString(d));
        BigDecimal b2 = new BigDecimal("1");
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
    }

    // �������뷵��double����
    public static double round(Double d, int scale) {
        BigDecimal b = roundBase(d, scale);
        if (b == null)
            return 0;
        else
            return b.doubleValue();
    }

    // �������뷵��string����
    public static String roundtostr(Double d, int scale) {
        BigDecimal b = roundBase(d, scale);
        if (b == null)
            return "";
        else
            return b.toString();
    }
	
    /**
     * ����ת��Ϊ����
     * */
    public static byte ObjectToByte(Object object){
		if(object == null) return 0;
		else 			   return Byte.parseByte(object.toString());	
	}
    
    public static short ObjectToShort(Object object){
		if(object == null) return 0;
		else 			   return Short.parseShort(object.toString());	
	}
    
    public static int ObjectToInt(Object object){
		if(object == null) return 0;
		else 			   return Integer.parseInt(object.toString());	
	}
	
    public static long ObjectToLong(Object object){
		if(object == null) return 0;
		else 			   return Long.parseLong(object.toString());	
	}
	
    public static double ObjectToDouble(Object object){
		if(object == null) return 0;
		else 			   return Double.parseDouble(object.toString());	
	}
	
	
	
	
	
}
