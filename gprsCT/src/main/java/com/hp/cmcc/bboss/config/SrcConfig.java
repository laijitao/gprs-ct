package com.hp.cmcc.bboss.config;

import java.io.FileInputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SrcConfig {

	private static Logger logger = LoggerFactory.getLogger(SrcConfig.class);
	private static final String path = System.getenv("BBOSS_HOME")+"/"+System.getenv("BBOSS_APPID");
	private static final String PROPERTIES_FILE = "../config/MyResource.properties";
//	private static final String PROPERTIES_FILE = "C:/Users/Administrator/Desktop/conf/MyResource.properties";
	public static String INCOMING_SRC = null;
	public static String BAK_SRC = null;
	
	static{
		FileInputStream in = null;
		try{
			Properties properties = new Properties();
			in = new FileInputStream(PROPERTIES_FILE);
			properties.load(in);
			INCOMING_SRC = 
					path+
					properties.getProperty("incoming_src");
			System.out.println("INCOMING_SRC:"+INCOMING_SRC);
			BAK_SRC = 
					path+
					properties.getProperty("bak_src");
			System.out.println("BAK_SRC:"+BAK_SRC);
			logger.info("read configure successful!");
		}catch(Exception e){
			logger.info("load configure failed!",e);
		}finally{
			if(in != null){
				try{
					in.close();
				}catch(Exception e){
					logger.error("close FileInputStream failed!",e);
				}
			}
		}
	}
}
