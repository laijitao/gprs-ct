package com.hp.cmcc.bboss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.cmcc.bboss.dao.GprsLogDao;
import com.hp.cmcc.bboss.entity.GprsLog;
import com.hp.cmcc.bboss.utils.PubTools;

@Service
@Transactional
public class GprsLogService {
	@Autowired
	GprsLogDao gprsLogDao;
	
	public GprsLog saveOne(GprsLog gprsLog){
		GprsLog gprsLog2 = findByFileName(gprsLog.getFileName());
		if(PubTools.IsEmpty(gprsLog2)){
			return gprsLogDao.save(gprsLog);
		}else{
			gprsLogDao.updateIsStoreByFileName("F", gprsLog.getFileName());
			return gprsLog;
		}
	}
	
	public GprsLog findByFileName(String fileName){
		return gprsLogDao.findByFileName(fileName);
	}
	
	public GprsLog findByFileNameLike(String date){
		return gprsLogDao.findByFileNameLike(date);
	}
	
	public int updateIsStoreByFileName(GprsLog gprsLog){
		return gprsLogDao.updateIsStoreByFileName(gprsLog.getIsStore(), gprsLog.getFileName());
	}
	
	public int updateIsComparedByFileName(GprsLog gprsLog){
		return gprsLogDao.updateIsComparedByFileNameLike(gprsLog.getIsCompared(), gprsLog.getFileName());
	}
	
}
