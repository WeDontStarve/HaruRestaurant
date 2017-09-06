package com.DAO;

/**
 * Orderdishes entity. @author MyEclipse Persistence Tools
 */

public class Orderdishes implements java.io.Serializable {

	// Fields

	private OrderdishesId id;
	private Integer num;

	// Constructors

	/** default constructor */
	public Orderdishes() {
	}

	/** full constructor */
	public Orderdishes(OrderdishesId id, Integer num) {
		this.id = id;
		this.num = num;
	}

	// Property accessors

	public OrderdishesId getId() {
		return this.id;
	}

	public void setId(OrderdishesId id) {
		this.id = id;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}