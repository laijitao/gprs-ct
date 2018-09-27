package com.hp.cmcc.bboss.utils;

import java.util.ArrayList;
import java.util.List;

import com.hp.cmcc.bboss.entity.GprsCt;

public class GprsCtTools {

	public static GprsCt Str2Obj(String record,String fileName){
		String S[] = record.split(";",-1);
		GprsCt gprsCt = new GprsCt();
		gprsCt.setFileName(fileName);
		gprsCt.setRecMark(getValue(S,0).trim());
		gprsCt.setMsisdn(getValue(S,1).trim());
		gprsCt.setServiceid(getValue(S,2).trim());
		gprsCt.setDataValue(getValue(S,3).trim());
		return gprsCt;
	}
	
	public static List<GprsCt> getObjList(List<String> list1,String fileName){
		List<GprsCt> list = new ArrayList<>();
		for(String str : list1){
			list.add(Str2Obj(str,fileName));
		}
		return list;
	}
	
	public static String getValue(String[] S, int index){
		return PubTools.IsEmpty(S[index]) ? null : S[index];
	}
	
}
