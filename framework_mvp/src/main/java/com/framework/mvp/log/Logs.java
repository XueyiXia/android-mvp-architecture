package com.framework.mvp.log;

import android.text.TextUtils;
import android.util.Log;

import com.framework.log.action.LogLevel;
import com.framework.log.action.LogMode;
import com.framework.log.action.LogRecodeUtils;


/**
 * @author: xiaxueyi
 * @date: 2017-11-29
 * @time: 11:30
 * @说明: 日志记录输出工具
 */
public class Logs {

	/**
	 * 输出异常信息
	 * @Description
	 * @author Aiven
	 * @param e
	 */
	public static void logE(Exception e) {
		try {
			if (e == null)
                return;
			if (LogConfig.Debug) {
                LogRecodeUtils.sharedInstance().addLog(new LogMode( LogLevel.e,"ERROR:",e.getMessage()));
            }
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 通过Logcat输出日志信息
	 * 
	 * @param tag
	 * @param msg
	 */
	public static void logError(String tag, String msg) {
		if (tag == null) {
			tag = "noTag";
		}
		if (msg == null){
			msg = "null";
		}
		if (LogConfig.Debug) {
			Log.e(tag,msg);

			if (LogConfig.enableRecording){
				LogRecodeUtils.sharedInstance().addLog(new LogMode( LogLevel.e,tag, msg));
			}
		}
	}

	/**
	 * 通过打印模式输出日志
	 * 
	 * @Description
	 * @author Aiven
	 * @param msg
	 */
	public static void logPint(Object msg) {
		if (msg == null) {
			msg = "null";
		}
		if (LogConfig.Debug) {
			printOut(msg.toString());
		}
	}

	/**
	 * 打印语句
	 * @param result
     */
	private static void printOut(String result){
		if (TextUtils.isEmpty(result)){
			return;
		}
		if(result.length() > 4000) {
			for(int i=0;i<result.length();i+=4000){
				if(i+4000<result.length()){
					Log.e( LogConfig.logTag,result.substring(i, i+4000));

					if (LogConfig.enableRecording){
						LogRecodeUtils.sharedInstance().addLog(new LogMode( LogLevel.v, LogConfig.logTag, result.substring(i, i+4000)));
					}
				}else {
					Log.e( LogConfig.logTag,result.substring(i, result.length()));
					if (LogConfig.enableRecording){
						LogRecodeUtils.sharedInstance().addLog(new LogMode( LogLevel.v, LogConfig.logTag, result.substring(i, result.length())));
					}
				}
			}
		} else{
			Log.e( LogConfig.logTag,result);
			if (LogConfig.enableRecording){
				LogRecodeUtils.sharedInstance().addLog(new LogMode( LogLevel.v, LogConfig.logTag, result));
			}
		}
	}
}
