package com.DAO;

/**
 * Admininfo entity. @author MyEclipse Persistence Tools
 */

public class Admininfo implements java.io.Serializable {

	// Fields

	private Integer adminId;
	private String adminAccount;
	private String adminPassword;
	private String adminFaceing;
	private String adminPersonalld;
	private String adminPhone;
	private String restaurantName;
	private String restaurantAddress;

	// Constructors

	/** default constructor */
	public Admininfo() {
	}

	/** full constructor */
	public Admininfo(String adminAccount, String adminPassword,
			String adminFaceing, String adminPersonalld, String adminPhone,
			String restaurantName, String restaurantAddress) {
		this.adminAccount = adminAccount;
		this.adminPassword = adminPassword;
		this.adminFaceing = adminFaceing;
		this.adminPersonalld = adminPersonalld;
		this.adminPhone = adminPhone;
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
	}

	// Property accessors

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminAccount() {
		return this.adminAccount;
	}

	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}

	public String getAdminPassword() {
		return this.adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminFaceing() {
		return this.adminFaceing;
	}

	public void setAdminFaceing(String adminFaceing) {
		this.adminFaceing = adminFaceing;
	}

	public String getAdminPersonalld() {
		return this.adminPersonalld;
	}

	public void setAdminPersonalld(String adminPersonalld) {
		this.adminPersonalld = adminPersonalld;
	}

	public String getAdminPhone() {
		return this.adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public String getRestaurantName() {
		return this.restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantAddress() {
		return this.restaurantAddress;
	}

	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}

}