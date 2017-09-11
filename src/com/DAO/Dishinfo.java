package com.DAO;

/**
 * Dishinfo entity. @author MyEclipse Persistence Tools
 */

public class Dishinfo implements java.io.Serializable {

	// Fields

	private Integer dishId;
	private String dishName;
	private String dishDiscript;
	private String dishImg;
	private Float dishPrice;
	private Integer recommend;
	private Integer adminId;
	
	// Constructors

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	/** default constructor */
	public Dishinfo() {
	}

	/** full constructor */
	public Dishinfo(String dishName, String dishDiscript, String dishImg,
			Float dishPrice, Integer recommend) {
		this.dishName = dishName;
		this.dishDiscript = dishDiscript;
		this.dishImg = dishImg;
		this.dishPrice = dishPrice;
		this.recommend = recommend;
	}

	// Property accessors

	public Integer getDishId() {
		return this.dishId;
	}

	public void setDishId(Integer dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return this.dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDishDiscript() {
		return this.dishDiscript;
	}

	public void setDishDiscript(String dishDiscript) {
		this.dishDiscript = dishDiscript;
	}

	public String getDishImg() {
		return this.dishImg;
	}

	public void setDishImg(String dishImg) {
		this.dishImg = dishImg;
	}

	public Float getDishPrice() {
		return this.dishPrice;
	}

	public void setDishPrice(Float dishPrice) {
		this.dishPrice = dishPrice;
	}

	public Integer getRecommend() {
		return this.recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

}