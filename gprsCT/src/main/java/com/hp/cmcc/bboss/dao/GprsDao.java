package com.hp.cmcc.bboss.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hp.cmcc.bboss.entity.GprsCt;

public interface GprsDao  extends JpaRepository<GprsCt,Long>{

	@Query(value = "select * from  GPRSDOM_CT where FILE_NAME  like ?1 ", nativeQuery = true) 
	List<GprsCt> findByFileNameLike(String date);

	@Query(value = "SELECT * FROM  GPRSDOM_CT WHERE MSISDN=?1 AND SERVICEID=?2 AND FILE_NAME LIKE ?3 ", nativeQuery = true) 
	GprsCt findByMsisdnAndServiceidAndFileNameLike(String msisdn,String serviceid,String date);
	
}
