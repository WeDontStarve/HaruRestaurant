package com.hibernate.dao;

/**
 * InformationId entity. @author MyEclipse Persistence Tools
 */

public class InformationId implements java.io.Serializable {

	// Fields

	private String message;
	private String position;

	// Constructors

	/** default constructor */
	public InformationId() {
	}

	/** full constructor */
	public InformationId(String message, String position) {
		this.message = message;
		this.position = position;
	}

	// Property accessors

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof InformationId))
			return false;
		InformationId castOther = (InformationId) other;

		return ((this.getMessage() == castOther.getMessage()) || (this
				.getMessage() != null && castOther.getMessage() != null && this
				.getMessage().equals(castOther.getMessage())))
				&& ((this.getPosition() == castOther.getPosition()) || (this
						.getPosition() != null
						&& castOther.getPosition() != null && this
						.getPosition().equals(castOther.getPosition())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getMessage() == null ? 0 : this.getMessage().hashCode());
		result = 37 * result
				+ (getPosition() == null ? 0 : this.getPosition().hashCode());
		return result;
	}

}