package com.DAO;

/**
 * Vipinfo entity. @author MyEclipse Persistence Tools
 */

public class Vipinfo implements java.io.Serializable {

	// Fields

	private Integer vipid;
	private String vipaccount;
	private String vippassword;
	private String vipfaceing;
	private String vipphone;
	private Integer adminId;
	
	// Constructors

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	/** default constructor */
	public Vipinfo() {
	}

	/** full constructor */
	public Vipinfo(String vipaccount, String vippassword, String vipfaceing,
			String vipphone) {
		this.vipaccount = vipaccount;
		this.vippassword = vippassword;
		this.vipfaceing = vipfaceing;
		this.vipphone = vipphone;
	}

	// Property accessors

	public Integer getVipid() {
		return this.vipid;
	}

	public void setVipid(Integer vipid) {
		this.vipid = vipid;
	}

	public String getVipaccount() {
		return this.vipaccount;
	}

	public void setVipaccount(String vipaccount) {
		this.vipaccount = vipaccount;
	}

	public String getVippassword() {
		return this.vippassword;
	}

	public void setVippassword(String vippassword) {
		this.vippassword = vippassword;
	}

	public String getVipfaceing() {
		return this.vipfaceing;
	}

	public void setVipfaceing(String vipfaceing) {
		this.vipfaceing = vipfaceing;
	}

	public String getVipphone() {
		return this.vipphone;
	}

	public void setVipphone(String vipphone) {
		this.vipphone = vipphone;
	}

}