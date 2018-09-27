package com.hp.cmcc.bboss.utils;

public class PubTools {
	
	public static String SQL = "INSERT INTO IMPORT.GPRSDOM_CT_COMP "
			+ "SELECT "
			+ "GPRSDOM_CT_COMP_SEQENCE.NEXTVAL,"
			+ "MSISDN,"
			+ "SERVICE_ID,"
			+ "DATA_VALUE,"
			+ "PROVCODE,"
			+ "substr(dup_time,1,8) "
			+ "FROM IMPORT.UR_GPRSDOM_?_T "
			+ "where service_id = '1710000037' "
			+ "and substr(dup_time,1,8)='?' "
			+ "and msisdn in ("
			+ "'15911153213','18319017944','15002107478','15822555445','15023076567', "
			+ "'15840548437','15189443858','18272395184','15928045990','18809290709', "
			+ "'18730414331','18334868709','15038318785','13604439329','18246102596', "
			+ "'13948924501','17865299415','15256559839','13606877084','15880306449', "
			+ "'13975193343','18277135575','18720053776','18785143047','18760789049', "
			+ "'13518992731','18389499623','15293277023','13409595585','15719755737', "
			+ "'15199426203')";

	public static String setSql(String sql, String str) {
		return replaceAll("\\?",sql,str.split(";",-1));
	}
	
	public static String replaceAll(String regex,String str,String... S) {
		for(String s : S) {
			str = str.replaceFirst(regex, s);
		}
		return str;
	}

	public static String getTimeFromTitle(String fileName) {
		return fileName.substring(4, 10);//yyyyMM
	}
	
	public String str2UpperCase(String s) {
		return s.toUpperCase();
	}
	
	public static boolean IsEmpty(String str) {
		return str == null ? true : str.length() == 0 ? true : false;
	}

	public static boolean IsBlank(String str) {
		return str == null ? true : str.length() == 0 ? true : str.trim().length() == 0 ? true : false;
	}
	public static boolean IsEmpty(Object obj) {
		return obj == null ? true : false;
	}
	
	public static boolean strNumberIsEqual(String number1,String number2){
		return Long.parseLong(number1.trim()) == Long.parseLong(number2.trim()) ? true : false;
	}
	
}
