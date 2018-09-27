package com.hp.cmcc.bboss.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hp.cmcc.bboss.config.SpringUtil;
import com.hp.cmcc.bboss.service.CompareService;

public class CompareTaskTimer {
	
	private static Logger logger = LoggerFactory.getLogger(CompareTaskTimer.class);
	CompareService compareService = SpringUtil.getBean(CompareService.class);
	
	/** 
	 * @Title: compareTaskTimer 
	 * @Description: 定时任务，每天23:30执行比对任务
	 * @param     参数 
	 * @return void    返回类型 
	 * @throws 
	 */ 
	public void compareTaskTimer(){
        long daySpan = 24 * 60 * 60 * 1000;
        // 规定的每天时间23:30:00运行
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:30:00");
        // 首次运行时间
        try {
            Date startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sdf.format(new Date()));
            // 如果今天的已经过了 首次运行时间就改为明天
            if (System.currentTimeMillis() > startTime.getTime()){
                startTime = new Date(startTime.getTime() + daySpan);
            }
            Timer t = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                	compareService.compare();
                }
            };
            // 以每24小时执行一次
            t.schedule(task, startTime, daySpan);
        } catch (Exception e) {
            logger.error("timer exception!",e);
        }
    }
}
