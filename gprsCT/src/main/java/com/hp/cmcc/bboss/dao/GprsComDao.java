package com.hp.cmcc.bboss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hp.cmcc.bboss.entity.GprsCom;

public interface GprsComDao extends JpaRepository<GprsCom,Long>{

	@Query(value = "SELECT * FROM GPRSDOM_CT_COMP WHERE MSISDN=?1 AND SERVICEID=?2 ", nativeQuery = true)  
	GprsCom findByMsisdnAndServiceid(String msisdn,String serviceid);
	
}
