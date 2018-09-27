package com.hp.cmcc.bboss.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GPRSDOM_CT database table.
 * 清单文件入库表
 */
@Entity
@Table(name="GPRSDOM_CT")
public class GprsCt implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CT_SEQENCE")
	@SequenceGenerator(name = "CT_SEQENCE", sequenceName = "GPRSDOM_CT_SEQUENCE", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name="DATA_VALUE")
	private String dataValue;

	@Column(name="FILE_NAME")
	private String fileName;

	@Column(name="MSISDN")
	private String msisdn;

	@Column(name="REC_MARK")
	private String recMark;

	@Column(name="SERVICEID")
	private String serviceid;

	public GprsCt() {
	}

	public GprsCt(Long id, String dataValue, String fileName, String msisdn, String recMark, String serviceid) {
		super();
		this.id = id;
		this.dataValue = dataValue;
		this.fileName = fileName;
		this.msisdn = msisdn;
		this.recMark = recMark;
		this.serviceid = serviceid;
	}

	public String getDataValue() {
		return this.dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getRecMark() {
		return this.recMark;
	}

	public void setRecMark(String recMark) {
		this.recMark = recMark;
	}

	public String getServiceid() {
		return this.serviceid;
	}

	public void setServiceid(String serviceid) {
		this.serviceid = serviceid;
	}

}