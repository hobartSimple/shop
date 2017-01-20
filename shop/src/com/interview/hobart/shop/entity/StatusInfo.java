package com.interview.hobart.shop.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Status entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="status_info")
@Component("statusInfo")
public class StatusInfo implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -7704879254663733646L;
	private Integer id;
	private String status;
	private Set<ForderInfo> forders = new HashSet<ForderInfo>(0);

	// Constructors

	/** default constructor */
	public StatusInfo() {
	}

	
	public StatusInfo(String status) {
		super();
		this.status = status;
	}


	/** full constructor */
	public StatusInfo(String status, Set<ForderInfo> forders) {
		this.status = status;
		this.forders = forders;
	}
	
	public StatusInfo(Integer id, String status, Set<ForderInfo> forders) {
		super();
		this.id = id;
		this.status = status;
		this.forders = forders;
	}


	public StatusInfo(Integer id) {
		super();
		this.id = id;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "status", length = 10)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "status")
	public Set<ForderInfo> getForders() {
		return this.forders;
	}

	public void setForders(Set<ForderInfo> forders) {
		this.forders = forders;
	}

	@Override
	public String toString() {
		return "StatusInfo [id=" + id + ", status=" + status + ", forders=" + forders + "]";
	}
	
}