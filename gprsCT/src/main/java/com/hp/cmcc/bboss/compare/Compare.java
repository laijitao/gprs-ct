package com.hp.cmcc.bboss.compare;

import java.util.List;

import com.hp.cmcc.bboss.entity.GprsResult;

public interface Compare {

	List<GprsResult> fileCompare(String date);
	
	List<GprsResult> dataCompare(String date);
	
}
