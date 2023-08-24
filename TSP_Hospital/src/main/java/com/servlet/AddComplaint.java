package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ComplaintDao;
import com.dao.PatientDao;
import com.db.DBConnect;
import com.entity.Complaint;
import com.entity.Patient;

@WebServlet("addComplaint")
public class AddComplaint extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          
		try {
			
			String doctor=req.getParameter("doctor");
			String complaint=req.getParameter("complaint");
			
			Complaint p=new Complaint( doctor,complaint);
			
			ComplaintDao dao=new ComplaintDao(DBConnect.getConn());
			HttpSession session=req.getSession();
			
			if(dao.registerComplaint(p)) {
				
				session.setAttribute("sucMsg", "Complaint Added Successfully");
				resp.sendRedirect("complaints.jsp");
			}else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("complaints.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
