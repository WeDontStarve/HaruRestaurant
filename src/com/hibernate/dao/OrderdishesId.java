package com.hibernate.dao;

/**
 * OrderdishesId entity. @author MyEclipse Persistence Tools
 */

public class OrderdishesId implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Integer dishId;

	// Constructors

	/** default constructor */
	public OrderdishesId() {
	}

	/** full constructor */
	public OrderdishesId(Integer orderId, Integer dishId) {
		this.orderId = orderId;
		this.dishId = dishId;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getDishId() {
		return this.dishId;
	}

	public void setDishId(Integer dishId) {
		this.dishId = dishId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderdishesId))
			return false;
		OrderdishesId castOther = (OrderdishesId) other;

		return ((this.getOrderId() == castOther.getOrderId()) || (this
				.getOrderId() != null && castOther.getOrderId() != null && this
				.getOrderId().equals(castOther.getOrderId())))
				&& ((this.getDishId() == castOther.getDishId()) || (this
						.getDishId() != null && castOther.getDishId() != null && this
						.getDishId().equals(castOther.getDishId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getOrderId() == null ? 0 : this.getOrderId().hashCode());
		result = 37 * result
				+ (getDishId() == null ? 0 : this.getDishId().hashCode());
		return result;
	}

}