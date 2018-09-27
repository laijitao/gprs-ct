package com.hp.cmcc.bboss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.cmcc.bboss.dao.GprsResultDao;
import com.hp.cmcc.bboss.entity.GprsResult;

@Service
@Transactional
public class GprsResultService {
	@Autowired
	GprsResultDao gprsResultDao;
	
	public List<GprsResult> findAll(){
		return gprsResultDao.findAll();
	}
	
	public List<GprsResult> saveAll(List<GprsResult> list){
		return gprsResultDao.save(list);
	}
}
