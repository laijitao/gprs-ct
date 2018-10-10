package com.hp.cmcc.bboss.main;

import com.hp.cmcc.bboss.config.SpringUtil;
import com.hp.cmcc.bboss.file.FileScanTask;
import com.hp.cmcc.bboss.service.GprsService;
import com.hp.cmcc.bboss.timer.CompareTaskTimer;

public class DoMain {

	GprsService gprsService = SpringUtil.getBean(GprsService.class);
	private static FileScanTask fileScanTask = new FileScanTask();
	private static CompareTaskTimer compareTaskTimer = new CompareTaskTimer();
	
	/** 
	 * @Title: doTask 
	 * @Description: 主任务，开启文件扫描任务和数据比对任务
	 * @param     参数 
	 * @return void    返回类型 
	 * @throws 
	 */ 
	public void doTask(){
		compareTaskTimer.compareTaskTimer();//比对任务
		fileScanTask.fileScan();//文件扫描
	}
}
