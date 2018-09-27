package com.hp.cmcc.bboss.file;

import java.io.File;
import java.util.concurrent.Callable;

public class FileScanThread implements Callable<File[]>{

	private String src;
	
	@Override
	public File[] call(){
		File file = new File(src);
		File[] files = file.listFiles();
		return files;
	}
	
	public FileScanThread(String src) {
		super();
		this.src = src;
	}
	
	public String getSrc() {
		return src;
	}
	
	public void setSrc(String src) {
		this.src = src;
	}

}
