package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Doctor;
import com.entity.Patient;

public class PatientDao {
   private Connection conn;

public PatientDao(Connection conn) {
	super();
	this.conn = conn;
}
public boolean registerPatient(Patient p) {
	boolean f=false;
	try {
		String sql="insert into patient(fname,lname,appdate,spec,doctor) values(?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,p.getFname());
		ps.setString(2,p.getLname());
		ps.setString(3,p.getAppdate());
		ps.setString(4,p.getSpec());
		ps.setString(5,p.getDoctor());
		
		int i=ps.executeUpdate();
		if(i==1) {
			f=true;
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return f;
}
public List<Patient> getAllPatient(){
	List<Patient> list=new ArrayList<>();
	Patient p=null;
	try {
		String sql="select * from patient order by id desc";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			p=new Patient();
			p.setId(rs.getInt(1));
			p.setFname(rs.getString(2));
			p.setLname(rs.getString(3));
			p.setAppdate(rs.getString(4));
			p.setSpec(rs.getString(5));
			p.setDoctor(rs.getString(6));
			list.add(p);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}

public boolean deletePatient(int id) {
	boolean f=false;
	try {
		String sql="delete from patient where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		
		int i=ps.executeUpdate();
		if(i==1) {
			f=true;
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return f;
}



   
}
