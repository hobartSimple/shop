package com.interview.hobart.shop.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * CategoryInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "category_info")
@Component("categoryInfo")
public class CategoryInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private AccountInfo account;
	private String type;
	private Boolean hot;
	private Set<ProductInfo> products = new HashSet<ProductInfo>(0);

	// Constructors

	/** default constructor */
	public CategoryInfo() {
	}

	@Override
	public String toString() {
		return "CategoryInfo [id=" + id + ", account=" + account + ", type=" + type + ", hot=" + hot + "]";
	}

	/** full constructor */
	public CategoryInfo(AccountInfo account, String type, Boolean hot, Set<ProductInfo> products) {
		this.account = account;
		this.type = type;
		this.hot = hot;
		this.products = products;
	}

	public CategoryInfo(AccountInfo account, String type, Boolean hot) {
		this.account = account;
		this.type = type;
		this.hot = hot;
	}

	public CategoryInfo(Integer id, String type, Boolean hot) {
		super();
		this.id = id;
		this.type = type;
		this.hot = hot;
	}

	public CategoryInfo(String type, Boolean hot) {
		super();
		this.type = type;
		this.hot = hot;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aid")
	public AccountInfo getAccount() {
		return this.account;
	}

	public void setAccount(AccountInfo account) {
		this.account = account;
	}

	@Column(name = "type", length = 20)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "hot")
	public Boolean getHot() {
		return this.hot;
	}

	public void setHot(Boolean hot) {
		this.hot = hot;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
	public Set<ProductInfo> getProducts() {
		return this.products;
	}

	public void setProducts(Set<ProductInfo> products) {
		this.products = products;
	}

}