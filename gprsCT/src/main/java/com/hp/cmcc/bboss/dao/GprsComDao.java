package com.hp.cmcc.bboss.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hp.cmcc.bboss.entity.GprsCom;

public interface GprsComDao extends JpaRepository<GprsCom,Long>{

	@Query(value = "INSERT INTO GPRSDOM_CT_COMP "
			+ "SELECT GPRSDOM_CT_COMP_SEQENCE.NEXTVAL, "
			+ "MSISDN, SERVICE_ID, DATA_VALUE,PROVCODE, "
			+ "substr(dup_time,1,8)  FROM ?1 "
			+ "where service_id='1710000037' and substr(dup_time,1,8)=?2 "
			+ "and msisdn in ("
			+ "'15911153213','18319017944','15002107478','15822555445','15023076567' ,"
			+ "'15840548437','15189443858','18272395184','15928045990','18809290709', "
			+ "'18730414331','18334868709','15038318785','13604439329','18246102596', "
			+ "'13948924501','17865299415','15256559839','13606877084','15880306449', "
			+ "'13975193343','18277135575','18720053776','18785143047','18760789049', "
			+ "'13518992731','18389499623','15293277023','13409595585','15719755737', "
			+ "'15199426203')", nativeQuery = true)  
	@Modifying 
	List<GprsCom> loadData(String tableName, String date);
	
	@Query(value = "SELECT * FROM GPRSDOM_CT_COMP WHERE MSISDN=?1 AND SERVICEID=?2 ", nativeQuery = true)  
	GprsCom findByMsisdnAndServiceid(String msisdn,String serviceid);
	
}
