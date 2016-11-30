package com.youxia.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommFunc {
	/**
	 * 公共函数
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
                formatType = "yyyy年MM月dd日";
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

    //Date转换为标准格式
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
                formatType = "yyyy年MM月dd日";
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
    
    
    
    //获取当前时间的Timestamp
    public static Timestamp getNowTimestamp(){
    	return Timestamp.valueOf(formatDate(new Date(), (byte)1));
    }

    //获取于今天相差differDay天的日期(differDay<0:之前的，differDay>0之后的)
    public static Calendar getCalendarByDay(Calendar calendar, int differDay){
        Calendar aim =  Calendar.getInstance();
        aim.setTime(calendar.getTime());
        aim.add(Calendar.DATE, differDay);
        return aim;
    }

    //判断两个日期是否为同一月份
    public static boolean isSameMonth(Calendar calendar1, Calendar calendar2){
        int month1 = calendar1.get(Calendar.MONTH);
        int month2 = calendar2.get(Calendar.MONTH);        
        return month1 == month2;
    }

    //相差毫秒数
    public static long diffDate(Timestamp time1, Timestamp time2){
        return time1.getTime() - time2.getTime();
    }
    
    //判断两个Timestamp是否为同一天
    public static boolean isTimestampSameDay(Timestamp time1, Timestamp time2){

    	return true;
    }
    
    
    //计算TimeStamp的日期差
    public static double diffDateByDay(Timestamp time1, Timestamp time2){
        return round(((time1.getTime() - time2.getTime())/(1000*60*60*24.0)),0);
    }
    
    /**格式化两日期之间的差值(计算单位为秒)
     * diff<1000*60==秒   
     * 1000*60<diff<1000*60*60 ==分钟
     * 1000*60*60<diff<1000*60*60*24 == 小时
     * 1000*60*60*24 < diff < 1000*60*60*24*30 == 日
     * 1000*60*60*24*30 < diff == 月
     * */
    public static String formatDiff(Timestamp time1, Timestamp time2){
    	long diff = Math.abs(diffDate(time1, time2));
    	if(diff<=1000*60l){ 
    		return roundtostr(diff*1.0/1000,0) + "秒前";
    	}
    	else if(diff<=1000*60*60l){
    		return roundtostr(diff*1.0/(1000*60),0) + "分钟前";
    	}
    	else if(diff<=1000*60*60*24l){
    		return roundtostr(diff*1.0/(1000*60*60),0) + "小时前";
    	}
    	else if(diff<=1000*60*60*24*30l){
    		return roundtostr(diff*1.0/(1000*60*60*24l),0) + "日前";
    	}
    	else{
    		return roundtostr(diff*1.0/(1000*60*60*24*30l),0) + "月前";
    	}
    }
    
    
    

    // 四舍五入
    // scale:小数点后保留位数
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

    // 四舍五入返回double类型
    public static double round(Double d, int scale) {
        BigDecimal b = roundBase(d, scale);
        if (b == null)
            return 0;
        else
            return b.doubleValue();
    }

    // 四舍五入返回string类型
    public static String roundtostr(Double d, int scale) {
        BigDecimal b = roundBase(d, scale);
        if (b == null)
            return "";
        else
            return b.toString();
    }
	
    /**
     * 对象转化为数字
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
