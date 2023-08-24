package com.entity;

public class Complaint {
    int id;
    String doctor;
    String complaint;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	public Complaint(String doctor, String complaint) {
		super();
		this.doctor = doctor;
		this.complaint = complaint;
	}
	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Complaint(int id, String doctor, String complaint) {
		super();
		this.id = id;
		this.doctor = doctor;
		this.complaint = complaint;
	}
    
}
