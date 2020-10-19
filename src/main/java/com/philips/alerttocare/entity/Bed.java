package com.philips.alerttocare.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "BED")
public class Bed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BED_ID")
	private Integer bedId;

	@Column(name = "BED_STATUS")
	private String bedStatus;

	@Column(name = "TIMESTAMP")
	private Timestamp timestamp;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ICU_ID", referencedColumnName = "ICU_ID")    
	private Icu icu;

	public Integer getBedId() {
		return bedId;
	}

	public void setBedId(Integer bedId) {
		this.bedId = bedId;
	}

	public String getBedStatus() {
		return bedStatus;
	}

	public void setBedStatus(String bedStatus) {
		this.bedStatus = bedStatus;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	@JsonIgnore
	public Icu getIcu() {
		return icu;
	}

	public void setIcu(Icu icu) {
		this.icu = icu;
	}

}
