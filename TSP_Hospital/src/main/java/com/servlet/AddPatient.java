package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.PatientDao;
import com.db.DBConnect;
import com.entity.Patient;

@WebServlet("/addPatient")
public class AddPatient extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         try {
			
			String fname=req.getParameter("fname");
			String lname=req.getParameter("lname");
			String appdate=req.getParameter("appdate");
			String spec=req.getParameter("spec");
			String doctor=req.getParameter("doctor");
			
			Patient p=new Patient(fname, lname, appdate, spec, doctor);
			
			PatientDao dao=new PatientDao(DBConnect.getConn());
			HttpSession session=req.getSession();
			
			if(dao.registerPatient(p)) {
				
				session.setAttribute("sucMsg", "Patient Added Successfully");
				resp.sendRedirect("addPatient.jsp");
			}else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("addPatient.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
