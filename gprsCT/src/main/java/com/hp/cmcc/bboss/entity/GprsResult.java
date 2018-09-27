package com.hp.cmcc.bboss.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GPRSDOM_CT_COM_RESULT database table.
 * 比对结果表
 */
@Entity
@Table(name="GPRSDOM_CT_COM_RESULT")
public class GprsResult implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESULT_SEQUENCE")
	@SequenceGenerator(name = "RESULT_SEQUENCE", sequenceName = "GPRSDOM_CT_COM_RESULT_SEQUENCE", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name="DATA_VALUE")
	private String dataValue;

	@Column(name="FILE_DATE")
	private String fileDate;

	@Column(name="MARK")
	private String mark;

	@Column(name="MSISDN")
	private String msisdn;

	@Column(name="SERVICEID")
	private String serviceid;

	public GprsResult() {
	}

	public String getDataValue() {
		return this.dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	public String getFileDate() {
		return this.fileDate;
	}

	public void setFileDate(String fileDate) {
		this.fileDate = fileDate;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getServiceid() {
		return this.serviceid;
	}

	public void setServiceid(String serviceid) {
		this.serviceid = serviceid;
	}

}