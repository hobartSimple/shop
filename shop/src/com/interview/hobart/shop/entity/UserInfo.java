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
 * User entity. @author 
 */
@Entity
@Table(name="user_info")
@Component("userInfo")
public class UserInfo implements java.io.Serializable {

	private static final long serialVersionUID = 2168953634726960707L;
	// Fields

	private Integer id;
	private String login;
	private String name;
	private String pass;
	private String sex;
	private String phone;
	private String email;
	private Set<ForderInfo> forders = new HashSet<ForderInfo>(0);

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** full constructor */
	public UserInfo(String login, String name, String pass, String sex,
			String phone, String email, Set<ForderInfo> forders) {
		this.login = login;
		this.name = name;
		this.pass = pass;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.forders = forders;
	}
	
	public UserInfo(Integer id, String login, String name, String pass, String sex, String phone, String email,
			Set<ForderInfo> forders) {
		super();
		this.id = id;
		this.login = login;
		this.name = name;
		this.pass = pass;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.forders = forders;
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

	@Column(name = "sex", length = 20)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email", length = 20)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<ForderInfo> getForders() {
		return this.forders;
	}

	public void setForders(Set<ForderInfo> forders) {
		this.forders = forders;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", login=" + login + ", name=" + name + ", pass=" + pass + ", sex=" + sex
				+ ", phone=" + phone + ", email=" + email + ", forders=" + forders + "]";
	}
	
}