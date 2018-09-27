package com.hp.cmcc.bboss.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GPRSDOM_CT_COMP database table.
 * 临时数据，用于提取UR表中的数据
 */
@Entity
@Table(name="GPRSDOM_CT_COMP")
public class GprsCom implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COM_SEQENCE")
	@SequenceGenerator(name = "COM_SEQENCE", sequenceName = "GPRSDOM_CT_COMP_SEQENCE", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name="DATA_VALUE")
	private String dataValue;

	@Column(name="DUP_TIME")
	private String dupTime;

	@Column(name="MSISDN")
	private String msisdn;

	@Column(name="PROVCODE")
	private String provcode;

	@Column(name="SERVICEID")
	private String serviceid;

	public GprsCom() {
	}

	public String getDataValue() {
		return this.dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	public String getDupTime() {
		return this.dupTime;
	}

	public void setDupTime(String dupTime) {
		this.dupTime = dupTime;
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

	public String getProvcode() {
		return this.provcode;
	}

	public void setProvcode(String provcode) {
		this.provcode = provcode;
	}

	public String getServiceid() {
		return this.serviceid;
	}

	public void setServiceid(String serviceid) {
		this.serviceid = serviceid;
	}

}