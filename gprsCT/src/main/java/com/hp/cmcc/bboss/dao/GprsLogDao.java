package com.hp.cmcc.bboss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hp.cmcc.bboss.entity.GprsLog;

public interface GprsLogDao extends JpaRepository<GprsLog,Long>{

	GprsLog findByFileNameLike(String date);
	
	GprsLog findByFileName(String fileName);
	
	@Query(value = "update GPRSDOM_CT_LOG set IS_STORE=?1,STORE_TIME=SYSDATE where FILE_NAME=?2 ", nativeQuery = true)  
	@Modifying  
	public int updateIsStoreByFileName(String isStore, String fileName); 

	@Query(value = "update GPRSDOM_CT_LOG set IS_COMPARED=?1,COMPARED_TIME=SYSDATE where FILE_NAME LIKE ?2 ", nativeQuery = true)  
	@Modifying 
	public int updateIsComparedByFileNameLike(String isCompared, String date); 
}
