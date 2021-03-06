package com.hibernate.dao;

/**
 * Tableinfo entity. @author MyEclipse Persistence Tools
 */

public class Tableinfo implements java.io.Serializable {

	// Fields

	private Integer tableId;
	
	private Integer tableSeat;
	private Integer tableStatus;

	// Constructors

	/** default constructor */
	public Tableinfo() {
	}

	/** full constructor */
	public Tableinfo( Integer tableSeat, Integer tableStatus) {
		
		this.tableSeat = tableSeat;
		this.tableStatus = tableStatus;
	}

	// Property accessors

	public Integer getTableId() {
		return this.tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	

	public Integer getTableSeat() {
		return this.tableSeat;
	}

	public void setTableSeat(Integer tableSeat) {
		this.tableSeat = tableSeat;
	}

	public Integer getTableStatus() {
		return this.tableStatus;
	}

	public void setTableStatus(Integer tableStatus) {
		this.tableStatus = tableStatus;
	}

}