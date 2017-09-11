package com.DAO;

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
	private Float cheifSalary;
	private Float cheifBonus;
	private Integer adminId;

	// Constructors

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	/** default constructor */
	public Cheifinfo() {
	}

	/** full constructor */
	public Cheifinfo(String cheifAccount, String cheifPassword,
			String cheifFaceing, String cheifPhone, Float cheifSalary,
			Float cheifBonus) {
		this.cheifAccount = cheifAccount;
		this.cheifPassword = cheifPassword;
		this.cheifFaceing = cheifFaceing;
		this.cheifPhone = cheifPhone;
		this.cheifSalary = cheifSalary;
		this.cheifBonus = cheifBonus;
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

	public Float getCheifSalary() {
		return this.cheifSalary;
	}

	public void setCheifSalary(Float cheifSalary) {
		this.cheifSalary = cheifSalary;
	}

	public Float getCheifBonus() {
		return this.cheifBonus;
	}

	public void setCheifBonus(Float cheifBonus) {
		this.cheifBonus = cheifBonus;
	}

}