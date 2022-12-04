package com.framework.mvp.log.action;
/**
 * @author Aiven
 * @date 2014-6-3 下午6:11:10
 * @email aiven163@sina.com
 * @Description 日志记录工具类
 */
public class LogRecodeUtils {
	private static LogRecodeUtils mInstance;

	private LogRecodeUtils() {

	};

	public static LogRecodeUtils sharedInstance() {
		if (mInstance == null){
			mInstance = new LogRecodeUtils();
		}
		return mInstance;
	}

	/**
	 * 写入一个日志模型
	 * @param mode
     */
	public void addLog(LogMode mode) {
		try{
			if (mode==null){
				return;
			}
			new LogWrite(mode).start();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
