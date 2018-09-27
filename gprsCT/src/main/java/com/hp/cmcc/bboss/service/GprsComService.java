package com.hp.cmcc.bboss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.cmcc.bboss.dao.GprsComDao;
import com.hp.cmcc.bboss.entity.GprsCom;

@Service
@Transactional
public class GprsComService {

	@Autowired
	GprsComDao gprsComDao;
	
	public List<GprsCom> findAll(){
		return gprsComDao.findAll();
	}
	
	public List<GprsCom> saveAll(List<GprsCom> list){
		return gprsComDao.save(list);
	}
	
	public void deleteAll(){
		gprsComDao.deleteAll();
	}
}
