package com.hp.cmcc.bboss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hp.cmcc.bboss.entity.GprsResult;

public interface GprsResultDao extends JpaRepository<GprsResult,Long>{

	@Query(value = "SELECT TO_CHAR(SYSDATE-1,'YYYYMMDD') FROM DUAL", nativeQuery = true)  
	String getBeforeDateStr();
	
	@Query(value = "SELECT TO_CHAR(SYSDATE,'YYYYMMDD') FROM DUAL", nativeQuery = true)  
	String getTodayDateStr();
}
