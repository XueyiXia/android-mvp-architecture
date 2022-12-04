package com.framework.mvp.log.action;

import java.util.Calendar;

/**
 * @author Aiven
 * @date 2014-6-3  下午6:11:24
 * @email aiven163@sina.com
 * @Description 日志输出时间生成器
 */
public class LogTimeUtils {

	private Calendar calendar;

	private static LogTimeUtils mInstance;

	private LogTimeUtils() {
	}

	public static LogTimeUtils getInstance() {
		if (mInstance == null){
			mInstance = new LogTimeUtils();
		}
		return mInstance;
	}

	public String getTime() {
		if (calendar == null){
			calendar = Calendar.getInstance();
		}
		StringBuffer bf = new StringBuffer();
		bf.append(getData());
		bf.append(" ");
		bf.append(calendar.get( Calendar.HOUR_OF_DAY) < 10 ? "0" + calendar.get( Calendar.HOUR_OF_DAY) : calendar.get( Calendar.HOUR_OF_DAY));
		bf.append(":");
		bf.append(calendar.get( Calendar.MINUTE) < 10 ? "0" + calendar.get( Calendar.MINUTE) : calendar.get( Calendar.MINUTE));
		bf.append(":");
		bf.append(calendar.get( Calendar.SECOND) < 10 ? "0" + calendar.get( Calendar.SECOND) : calendar.get( Calendar.SECOND));
		return bf.toString();
	}

	public String getData() {
		if (calendar == null){
			calendar = Calendar.getInstance();
		}

		calendar.setTimeInMillis( System.currentTimeMillis());
		StringBuffer bf = new StringBuffer();
		bf.append(calendar.get( Calendar.YEAR));
		bf.append("-");
		bf.append(calendar.get( Calendar.MONTH) < 9 ? "0" + (calendar.get( Calendar.MONTH) + 1) : (calendar.get( Calendar.MONTH) + 1));
		bf.append("-");
		bf.append(calendar.get( Calendar.DAY_OF_MONTH) < 10 ? "0" + calendar.get( Calendar.DAY_OF_MONTH) : calendar.get( Calendar.DAY_OF_MONTH));
		return bf.toString();
	}

}
