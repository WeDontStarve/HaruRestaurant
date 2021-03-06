package com.hibernate.dao;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Orderinfo entity. @author MyEclipse Persistence Tools
 */

public class Orderinfo implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Timestamp orderBegin;
	private Timestamp orderEnd;
	private Integer waiterId;
	private Integer tableId;
	private Integer orderState;
	private Float totalPrice;
	private Set orderdisheses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Orderinfo() {
	}

	/** minimal constructor */
	public Orderinfo(Timestamp orderBegin, Integer waiterId, Integer tableId,
			Integer orderState) {
		this.orderBegin = orderBegin;
		this.waiterId = waiterId;
		this.tableId = tableId;
		this.orderState = orderState;
	}

	/** full constructor */
	public Orderinfo(Timestamp orderBegin, Timestamp orderEnd,
			Integer waiterId, Integer tableId, Integer orderState,
			Float totalPrice, Set orderdisheses) {
		this.orderBegin = orderBegin;
		this.orderEnd = orderEnd;
		this.waiterId = waiterId;
		this.tableId = tableId;
		this.orderState = orderState;
		this.totalPrice = totalPrice;
		this.orderdisheses = orderdisheses;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Timestamp getOrderBegin() {
		return this.orderBegin;
	}

	public void setOrderBegin(Timestamp orderBegin) {
		this.orderBegin = orderBegin;
	}

	public Timestamp getOrderEnd() {
		return this.orderEnd;
	}

	public void setOrderEnd(Timestamp orderEnd) {
		this.orderEnd = orderEnd;
	}

	public Integer getWaiterId() {
		return this.waiterId;
	}

	public void setWaiterId(Integer waiterId) {
		this.waiterId = waiterId;
	}

	public Integer getTableId() {
		return this.tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public Integer getOrderState() {
		return this.orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	public Float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Set getOrderdisheses() {
		return this.orderdisheses;
	}

	public void setOrderdisheses(Set orderdisheses) {
		this.orderdisheses = orderdisheses;
	}

}