package com.hibernate.dao;

/**
 * Cheifinfo entity. @author MyEclipse Persistence Tools
 */

public class Cheifinfo implements java.io.Serializable {

	// Fields

	private Integer cheifId;
	private String cheifAccount;
	private String cheifPassword;
	private String cheifFaceing;
	private String cheifPhone;

	// Constructors

	/** default constructor */
	public Cheifinfo() {
	}

	/** full constructor */
	public Cheifinfo(String cheifAccount, String cheifPassword,
			String cheifFaceing, String cheifPhone) {
		this.cheifAccount = cheifAccount;
		this.cheifPassword = cheifPassword;
		this.cheifFaceing = cheifFaceing;
		this.cheifPhone = cheifPhone;
	}

	// Property accessors

	public Integer getCheifId() {
		return this.cheifId;
	}

	public void setCheifId(Integer cheifId) {
		this.cheifId = cheifId;
	}

	public String getCheifAccount() {
		return this.cheifAccount;
	}

	public void setCheifAccount(String cheifAccount) {
		this.cheifAccount = cheifAccount;
	}

	public String getCheifPassword() {
		return this.cheifPassword;
	}

	public void setCheifPassword(String cheifPassword) {
		this.cheifPassword = cheifPassword;
	}

	public String getCheifFaceing() {
		return this.cheifFaceing;
	}

	public void setCheifFaceing(String cheifFaceing) {
		this.cheifFaceing = cheifFaceing;
	}

	public String getCheifPhone() {
		return this.cheifPhone;
	}

	public void setCheifPhone(String cheifPhone) {
		this.cheifPhone = cheifPhone;
	}

}