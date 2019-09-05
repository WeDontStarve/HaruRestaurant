package com.hibernate.dao;

/**
 * Waiterinfo entity. @author MyEclipse Persistence Tools
 */

public class Waiterinfo implements java.io.Serializable {

	// Fields

	private Integer waiterId;
	private String waiterAccount;
	private String waiterPassword;
	private String waiterFaceing;
	private String waiterPhone;

	// Constructors

	/** default constructor */
	public Waiterinfo() {
	}

	/** minimal constructor */
	public Waiterinfo(String waiterAccount, String waiterPassword,
			String waiterPhone) {
		this.waiterAccount = waiterAccount;
		this.waiterPassword = waiterPassword;
		this.waiterPhone = waiterPhone;
	}

	/** full constructor */
	public Waiterinfo(String waiterAccount, String waiterPassword,
			String waiterFaceing, String waiterPhone) {
		this.waiterAccount = waiterAccount;
		this.waiterPassword = waiterPassword;
		this.waiterFaceing = waiterFaceing;
		this.waiterPhone = waiterPhone;
	}

	// Property accessors

	public Integer getWaiterId() {
		return this.waiterId;
	}

	public void setWaiterId(Integer waiterId) {
		this.waiterId = waiterId;
	}

	public String getWaiterAccount() {
		return this.waiterAccount;
	}

	public void setWaiterAccount(String waiterAccount) {
		this.waiterAccount = waiterAccount;
	}

	public String getWaiterPassword() {
		return this.waiterPassword;
	}

	public void setWaiterPassword(String waiterPassword) {
		this.waiterPassword = waiterPassword;
	}

	public String getWaiterFaceing() {
		return this.waiterFaceing;
	}

	public void setWaiterFaceing(String waiterFaceing) {
		this.waiterFaceing = waiterFaceing;
	}

	public String getWaiterPhone() {
		return this.waiterPhone;
	}

	public void setWaiterPhone(String waiterPhone) {
		this.waiterPhone = waiterPhone;
	}

}