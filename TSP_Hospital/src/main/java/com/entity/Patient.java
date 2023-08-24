package com.entity;

public class Patient {
    private int id;
    private String fname;
 	private String lname;
 	private String appdate;
 	private String spec;
 	private String doctor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAppdate() {
		return appdate;
	}
	public void setAppdate(String appdate) {
		this.appdate = appdate;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public Patient(String fname, String lname, String appdate, String spec, String doctor) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.appdate = appdate;
		this.spec = spec;
		this.doctor = doctor;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
 	
}
