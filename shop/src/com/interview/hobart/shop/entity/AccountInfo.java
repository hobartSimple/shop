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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * AccountInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="account_info")
@Component("accountInfo")
public class AccountInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3516237640139159811L;
	private Integer id;
	private String login;
	private String name;
	private String pass;
	private Set<CategoryInfo> categories = new HashSet<CategoryInfo>(0);

	
	// Constructors

	/** default constructor */
	public AccountInfo() {
	}

	@Override
	public String toString() {
		return "AccountInfo [id=" + id + ", login=" + login + ", name=" + name
				+ ", pass=" + pass + "]";
	}

	/** full constructor */
	public AccountInfo(String login, String name, String pass,
			Set<CategoryInfo> categories) {
		this.login = login;
		this.name = name;
		this.pass = pass;
		this.categories = categories;
	}
	

	public AccountInfo(String login, String name, String pass) {
		super();
		this.login = login;
		this.name = name;
		this.pass = pass;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "login", length = 20)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "pass", length = 20)
	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
	public Set<CategoryInfo> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<CategoryInfo> categories) {
		this.categories = categories;
	}

}