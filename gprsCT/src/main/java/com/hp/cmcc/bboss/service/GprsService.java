package com.hp.cmcc.bboss.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.hp.cmcc.bboss.dao.GprsDao;
import com.hp.cmcc.bboss.dao.GprsLogDao;
import com.hp.cmcc.bboss.entity.GprsCt;

@Service
@Transactional
public class GprsService {

	@Autowired
	GprsDao gprsDao;
	@Autowired
	GprsLogDao gprsLogDao;
	
	public List<GprsCt> findAll(String date){
		return gprsDao.findByFileNameLike("%"+date+"%");
	}
	
	public List<GprsCt> storeAll(List<GprsCt> list, String fileName){
		List<GprsCt> result = gprsDao.save(list);
		gprsLogDao.updateIsStoreByFileName("T", fileName);
		return result;
	}
	
}
