package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.dao.PatientDao;
import com.db.DBConnect;

@WebServlet("/deletePatient")
public class DeletePatient extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
	       PatientDao dao=new PatientDao(DBConnect.getConn());
			HttpSession session=req.getSession();
			
			if(dao.deletePatient(id)) {
				
				session.setAttribute("sucMsg", "Patient removed Successfully");
				resp.sendRedirect("viewApp.jsp");
			}else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("viewApp.jsp");
			}
	}

}
