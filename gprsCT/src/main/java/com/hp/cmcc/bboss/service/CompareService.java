package com.hp.cmcc.bboss.service;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.cmcc.bboss.compare.Compare;
import com.hp.cmcc.bboss.compare.impl.CompareImpl;
import com.hp.cmcc.bboss.config.SpringUtil;
import com.hp.cmcc.bboss.dao.GprsComDao;
import com.hp.cmcc.bboss.dao.GprsDao;
import com.hp.cmcc.bboss.dao.GprsLogDao;
import com.hp.cmcc.bboss.dao.GprsResultDao;
import com.hp.cmcc.bboss.entity.GprsLog;
import com.hp.cmcc.bboss.utils.PubTools;

@Service
@Transactional
public class CompareService {
	
	@Autowired
	GprsDao gprsDao;
	@Autowired
	GprsComDao gprsComDao;
	@Autowired
	GprsLogDao gprsLogDao;
	@Autowired
	GprsResultDao gprsResultDao;
	public static Compare compare = new CompareImpl();
	public static Logger logger = LoggerFactory.getLogger(CompareService.class);
	private static JdbcTemplate jdbc = SpringUtil.getBean("Template",JdbcTemplate.class);

	/** 
	 * @Title: compare 
	 * @Description: 数据比对任务，当月第一天不执行比对任务，最后一天执行当天和前一天的任务
	 * @param     参数 
	 * @return void    返回类型 
	 * @throws 
	 */ 
	public void compare(){
		Calendar calendar = Calendar.getInstance();
		String date = gprsResultDao.getBeforeDateStr();
		if(calendar.get(Calendar.DATE) == 1){//更改
			//当月第一天不执行操作
		} else {
			if(calendar.get(Calendar.DAY_OF_MONTH) == 
					calendar.getActualMaximum(Calendar.DAY_OF_MONTH)){//当月最后一天执行当天和前一天的任务
				//执行前一天的任务
				handleCompare(date);
				//比对当天的数据
				date = gprsResultDao.getTodayDateStr();
				handleCompare(date);
			}else {
				handleCompare(date);
			}
		}
	}
	
	/** 
	 * @Title: handleCompare 
	 * @Description: 执行数据比对
	 * @param @param date：比对文件名中的日期
	 * @param @return    参数 
	 * @return String    返回类型 
	 * @throws 
	 */ 
	public String handleCompare(String date){
		GprsLog gprsLog = gprsLogDao.findByFileNameLike("%"+date+"%");
		if(PubTools.IsEmpty(gprsLog) || !"T".equals(gprsLog.getIsStore())){
			logger.error("this file is not stored!");
			return "this file is not stored!";
		}else if("T".equals(gprsLog.getIsCompared())){
			logger.error("this file is already compared!");
			return "this file is already compared!";
		}else{
			gprsComDao.deleteAll();
			jdbc.update(PubTools.setSql(PubTools.SQL, date.substring(0,date.length()-2)+";"+date));//加载数据
			gprsResultDao.save(compare.fileCompare(date));
			gprsResultDao.save(compare.dataCompare(date));
			gprsLogDao.updateIsComparedByFileNameLike("T", "%"+date+"%");
			return "OK";
		}
	}
}
