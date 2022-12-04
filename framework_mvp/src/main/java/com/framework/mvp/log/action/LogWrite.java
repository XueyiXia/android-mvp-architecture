package com.framework.mvp.log.action;


import android.text.TextUtils;

import com.framework.utils.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;


/**
 * @author Aiven
 * @date 2014-6-3 下午6:11:55
 * @email aiven163@sina.com
 * @Description 日志写入文件工具类
 */
public class LogWrite extends Thread {

    private LogMode mLogMode;

    public LogWrite(LogMode logMode){
        this.mLogMode=logMode;
    }

    @Override
    public void run() {
        try {
            writeLog(mLogMode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 写日志文件
     * @param mode
     */
    synchronized private void writeLog(LogMode mode) {
        if(mode==null || TextUtils.isEmpty(mode.getMsg())){
            return;
        }
        //Log 日志存放路径
        String filePath = FileUtils.getInstance().getLogPath()+ LogTimeUtils.getInstance().getData()+ ".html";
        PrintWriter mOs=null;
        File file = new File(filePath);
        try{
            if (!file.exists()){
                if(null!=file.getParentFile()){
                    file.getParentFile().mkdirs();
                }

                file.createNewFile();
            }
            mOs = new PrintWriter(new FileOutputStream(file, true));
            mOs.println(mode.toHtml());
            mOs.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (mOs!=null){
                mOs.close();
                mOs=null;
                file=null;
            }
        }
    }
}
