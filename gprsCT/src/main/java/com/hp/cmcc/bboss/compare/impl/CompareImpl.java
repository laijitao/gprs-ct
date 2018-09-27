package com.hp.cmcc.bboss.compare.impl;

import java.util.ArrayList;
import java.util.List;

import com.hp.cmcc.bboss.compare.Compare;
import com.hp.cmcc.bboss.config.SpringUtil;
import com.hp.cmcc.bboss.dao.GprsComDao;
import com.hp.cmcc.bboss.dao.GprsDao;
import com.hp.cmcc.bboss.entity.GprsCom;
import com.hp.cmcc.bboss.entity.GprsCt;
import com.hp.cmcc.bboss.entity.GprsResult;
import com.hp.cmcc.bboss.utils.PubTools;

public class CompareImpl implements Compare{
	
	GprsDao gprsDao = SpringUtil.getBean(GprsDao.class);
	GprsComDao gprsComDao = SpringUtil.getBean(GprsComDao.class);

	/* (non-Javadoc)
	 * <p>Title: 比对文件中的数据（以加载的数据为比较对象）
	 * <p>Description: </p> 
	 * @param date
	 * @return 
	 * @see com.hp.cmcc.bboss.compare.Compare#fileCompare(java.lang.String) 
	 */ 
	@Override
	public List<GprsResult> fileCompare(String date) {
		List<GprsResult> result = new ArrayList<>();
		List<GprsCt> list = gprsDao.findByFileNameLike("%"+date+"%");
		for(GprsCt gprs : list){
			GprsResult gprsResult = new GprsResult();
			gprsResult.setFileDate(date);
			gprsResult.setMsisdn(gprs.getMsisdn());
			gprsResult.setServiceid(gprs.getServiceid());
			gprsResult.setDataValue(gprs.getDataValue());
			GprsCom com = gprsComDao.findByMsisdnAndServiceid(gprs.getMsisdn(), gprs.getServiceid());
			if(PubTools.IsEmpty(com)){
				gprsResult.setMark("M");
			} else if(PubTools.strNumberIsEqual(gprs.getDataValue(),com.getDataValue())){
				gprsResult.setMark("T");
			} else {
				gprsResult.setMark("F");
			}
			result.add(gprsResult);
		}
		return result;
	}

	/* (non-Javadoc)
	 * <p>Title: 比对加载的数据（以入库的文件中的数据为比较对象）
	 * <p>Description: </p> 
	 * @param date
	 * @return 
	 * @see com.hp.cmcc.bboss.compare.Compare#dataCompare(java.lang.String) 
	 */ 
	@Override
	public List<GprsResult> dataCompare(String date) {
		List<GprsResult> result = new ArrayList<>();
		List<GprsCom> list = gprsComDao.findAll();
		for(GprsCom comGprs : list){
			GprsCt com = gprsDao.findByMsisdnAndServiceidAndFileNameLike(comGprs.getMsisdn().trim(), comGprs.getServiceid().trim(),"%"+date+"%");
			if(PubTools.IsEmpty(com)){
				GprsResult gprsResult = new GprsResult();
				gprsResult.setMark("H");
				gprsResult.setFileDate(date);
				gprsResult.setMsisdn(comGprs.getMsisdn());
				gprsResult.setServiceid(comGprs.getServiceid());
				gprsResult.setDataValue(comGprs.getDataValue());
				result.add(gprsResult);
			}
		}
		return result;
	}

}
