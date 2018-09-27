package com.hp.cmcc.bboss.file;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hp.cmcc.bboss.config.SpringUtil;
import com.hp.cmcc.bboss.config.SrcConfig;
import com.hp.cmcc.bboss.dao.GprsLogDao;
import com.hp.cmcc.bboss.entity.GprsLog;
import com.hp.cmcc.bboss.service.GprsLogService;
import com.hp.cmcc.bboss.service.GprsService;
import com.hp.cmcc.bboss.utils.GprsCtTools;
import com.hp.cmcc.bboss.utils.PubTools;

public class FileScanTask {
	
	GprsService gprsService = SpringUtil.getBean(GprsService.class);
	GprsLogService gprsLogService = SpringUtil.getBean(GprsLogService.class);
	GprsLogDao gprsLogDao = SpringUtil.getBean(GprsLogDao.class);
	private static FileHandleUtils fileHandleUtils = new FileHandleUtils();
	private static Logger logger = LoggerFactory.getLogger(FileScanTask.class);

	/** 
	 * @Title: fileScan 
	 * @Description: 文件扫描任务，扫描到一个文件就入库并且写入日志表
	 * @param     参数 
	 * @return void    返回类型 
	 * @throws 
	 */ 
	public void fileScan(){
		Timer t = new Timer();
        TimerTask task = new TimerTask() {//文件扫描任务
            @Override
            public void run() {
	           	try {
		            	File[] files = new FileScanThread(SrcConfig.INCOMING_SRC).call();
		 				if(files.length > 0){
		 					for(File f : files){
		 						GprsLog gprsLog2 = gprsLogDao.findByFileName(f.getName());
		 						List<String> list = fileHandleUtils.getFileBody(f,SrcConfig.BAK_SRC);
		 						if(PubTools.IsEmpty(gprsLog2) || "F".equals(gprsLog2.getIsStore())){
		 							gprsLogService.saveOne(new GprsLog(f.getName(),"F"));
		 							gprsService.storeAll(GprsCtTools.getObjList(list, f.getName()), f.getName());
		 						}
		 					}
		 				}
	           	} catch (Exception e) {
	           		logger.error("file save to database failed",e);
	           	}
            }
        };
        t.schedule(task, new Date(), 60 * 1000);
	}
}
