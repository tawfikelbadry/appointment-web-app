package com.tawfik.appointment.gateway.model.enums;

public enum UserType {

	DOCTOR("doctor"), PATIENT("patient");

	private String type;

	private UserType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
