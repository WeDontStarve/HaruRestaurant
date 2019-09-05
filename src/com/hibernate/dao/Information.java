package com.hibernate.dao;

/**
 * Information entity. @author MyEclipse Persistence Tools
 */

public class Information implements java.io.Serializable {

	// Fields

	private InformationId id;

	// Constructors

	/** default constructor */
	public Information() {
	}

	/** full constructor */
	public Information(InformationId id) {
		this.id = id;
	}

	// Property accessors

	public InformationId getId() {
		return this.id;
	}

	public void setId(InformationId id) {
		this.id = id;
	}

}