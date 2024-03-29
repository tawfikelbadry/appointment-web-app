package com.tawfik.appointment.gateway.constants;

public class Constants {

	// base urls
	public static final String DOCTORS_SERVICE_BASE_URL = "http://localhost:8000/";
	public static final String PATIENTS_SERVICE_BASE_URL = "http://localhost:8001/";

	public static final String PATIENTS_SAVE_PATIENT_URL = PATIENTS_SERVICE_BASE_URL + "api/patients/save";
	public static final String DOCTORS_SAVE_DOCTOR_URL = DOCTORS_SERVICE_BASE_URL + "api/doctors/save";
	public static final String NOT_AVAILABLE = "N/A";

}
