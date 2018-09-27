package com.hp.cmcc.bboss.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GPRSDOM_CT_LOG database table.
 * 日志记录表
 */
@Entity
@Table(name="GPRSDOM_CT_LOG")
public class GprsLog implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOG_SEQENCE")
	@SequenceGenerator(name = "LOG_SEQENCE", sequenceName = "GPRSDOM_CT_LOG_SEQENCE", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name="FILE_NAME")
	private String fileName;
	
	@Column(name="IS_STORE")
	private String isStore;
	
	@Column(name="STORE_TIME")
	private String storeDate;
	
	@Column(name="IS_COMPARED")
	private String isCompared;

	@Column(name="COMPARED_TIME")
	private String comparedDate;

	public GprsLog() {
	}
	
	public GprsLog(String fileName,String isStore) {
		super();
		this.fileName = fileName;
		this.isStore = isStore;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getIsCompared() {
		return this.isCompared;
	}

	public void setIsCompared(String isCompared) {
		this.isCompared = isCompared;
	}

	public String getIsStore() {
		return this.isStore;
	}

	public void setIsStore(String isStore) {
		this.isStore = isStore;
	}

	public String getStoreDate() {
		return storeDate;
	}

	public void setStoreDate(String storeDate) {
		this.storeDate = storeDate;
	}

	public String getComparedDate() {
		return comparedDate;
	}

	public void setComparedDate(String comparedDate) {
		this.comparedDate = comparedDate;
	}

}