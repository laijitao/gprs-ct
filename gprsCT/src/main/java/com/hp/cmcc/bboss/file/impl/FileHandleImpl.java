package com.hp.cmcc.bboss.file.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.hp.cmcc.bboss.entity.GprsLog;
import com.hp.cmcc.bboss.file.FileHandle;
import com.hp.cmcc.bboss.service.GprsLogService;
import com.hp.cmcc.bboss.service.GprsService;
import com.hp.cmcc.bboss.utils.GprsCtTools;

@Transactional
public class FileHandleImpl implements FileHandle{
	@Autowired
	GprsService gprsService;
	@Autowired
	GprsLogService gprsLogService;

	/* (non-Javadoc)
	 * <p>Title: storage</p> 
	 * <p>Description: </p> 
	 * @param list:文件体
	 * @param fileName:文件名
	 * @see com.hp.cmcc.bboss.file.FileHandle#storage(java.util.List, java.lang.String) 
	 */ 
	@Override
	public void storage(List<String> list,String fileName) {
		GprsLog gprsLog = new GprsLog();
		gprsLog.setFileName(fileName);
		gprsLogService.saveOne(gprsLog);
		int result = 0;
		result = gprsService.storeAll(GprsCtTools.getObjList(list, fileName), fileName).size();
		if(result == list.size()){
			gprsLog.setIsStore("T");
			gprsLog.setStoreDate("sysdate");
			gprsLogService.updateIsStoreByFileName(gprsLog);
		}else{
			throw new RuntimeException("file store failed!");
		}
	}

}

