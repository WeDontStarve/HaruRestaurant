package com.hibernate.dao;

/**
 * Orderdishes entity. @author MyEclipse Persistence Tools
 */

public class Orderdishes implements java.io.Serializable {

	// Fields

	private OrderdishesId id;
	private Orderinfo orderinfo;
	private Integer num;
	private String dishName;
	private Integer state;
	// Constructors

	/** default constructor */
	public Orderdishes() {
	}

	/** full constructor */
	public Orderdishes(OrderdishesId id, Orderinfo orderinfo, Integer num,
			String dishName) {
		this.id = id;
		this.orderinfo = orderinfo;
		this.num = num;
		this.dishName = dishName;
	}

	// Property accessors

	public OrderdishesId getId() {
		return this.id;
	}

	public void setId(OrderdishesId id) {
		this.id = id;
	}

	public Orderinfo getOrderinfo() {
		return this.orderinfo;
	}

	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getDishName() {
		return this.dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}