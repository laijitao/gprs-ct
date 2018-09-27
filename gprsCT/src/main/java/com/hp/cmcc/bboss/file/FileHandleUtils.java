package com.hp.cmcc.bboss.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileHandleUtils {
	private static Logger logger = LoggerFactory.getLogger(FileHandleUtils.class);

	/** 
	 * @Title: getFileBody 
	 * @Description: TODO
	 * @param @param file:清单文件
	 * @param @param path:备份目录
	 * @param @return
	 * @param @throws IOException    参数 
	 * @return List<String>    返回类型 
	 * @throws 
	 */ 
	public List<String> getFileBody(File file,String path) throws IOException{
		List<String> list = new LinkedList<>();
		if(file.isFile()){
			BufferedReader in = null;
			try {
				in = new BufferedReader(new FileReader(file));
				String line = "";
				while((line = in.readLine()) != null){
					list.add(line);
				}
			} catch (FileNotFoundException e) {
				logger.error("file is not exist,pls check!",e);
			} catch (IOException e) {
				logger.error("reading file error,pls check!",e);
			}finally{
				in.close();
				Files.copy(file.toPath(), new File(path+"/"+file.getName()).toPath());//备份文件
				file.delete();
			}
			return list;
		}else{
			return null;
		}
	}
}
