package com.interview.hobart.shop.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Sorder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="sorder_info")
@Component("sorderInfo")
public class SorderInfo implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 7004305359110519370L;
	private Integer id;
	private ForderInfo forder;
	private ProductInfo product;
	private String name;
	private BigDecimal price;
	private Integer number;

	// Constructors

	/** default constructor */
	public SorderInfo() {
	}

	/** minimal constructor */
	public SorderInfo(Integer number) {
		this.number = number;
	}

	/** full constructor */
	public SorderInfo(ForderInfo forder, ProductInfo product, String name, BigDecimal price,
			Integer number) {
		this.forder = forder;
		this.product = product;
		this.name = name;
		this.price = price;
		this.number = number;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fid")
	public ForderInfo getForder() {
		return this.forder;
	}

	public void setForder(ForderInfo forder) {
		this.forder = forder;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pid")
	public ProductInfo getProduct() {
		return this.product;
	}

	public void setProduct(ProductInfo product) {
		this.product = product;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", precision = 8)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "number", nullable = false)
	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "SorderInfo [id=" + id + ", forder=" + forder + ", product=" + product + ", name=" + name + ", price="
				+ price + ", number=" + number + "]";
	}

}