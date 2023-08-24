package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Complaint;
import com.entity.Doctor;
import com.entity.Patient;

public class ComplaintDao {
   private Connection conn;

public ComplaintDao(Connection conn) {
	super();
	this.conn = conn;
}
public boolean registerComplaint(Complaint p) {
	boolean f=false;
	try {
		String sql="insert into complaint(doctor,complaint) values(?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,p.getDoctor());
		ps.setString(2,p.getComplaint());
		
		int i=ps.executeUpdate();
		if(i==1) {
			f=true;
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return f;
}
public List<Complaint> getAllComplaints(){
	List<Complaint> list=new ArrayList<>();
	Complaint p=null;
	try {
		String sql="select * from complaint order by id desc";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			p=new Complaint();
			p.setId(rs.getInt(1));
			p.setDoctor(rs.getString(2));
			p.setComplaint(rs.getString(3));
			list.add(p);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}

public boolean deleteComplaint(int id) {
	boolean f=false;
	try {
		String sql="delete from complaint where id=?";
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
