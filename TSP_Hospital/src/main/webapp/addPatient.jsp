<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"  %>
<%@page import="com.dao.*" %>
<%@page import="com.db.*" %>
<%@page import="com.entity.*" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Patient Page</title>
<%@include file="component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="component/staff_navbar.jsp"%>

	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Add Patient</p>

                        <c:if test="${ not empty sucMsg}">
                          <p class="text-center text-success fs-3">${sucMsg}</p>
                          <c:remove var="sucMsg" scope="session"/>
                        </c:if>
                        <c:if test="${ not empty errorMsg}">
                          <p class="text-center text-danger fs-3">${errorMsg}</p>
                          <c:remove var="errorMsg" scope="session"/>
                        </c:if>
						
						<form action="addPatient" method="post">
						<div class="mb-3">
								<label class="form-label">First Name</label> <input required
									name="fname" type="text" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Last Name</label> <input required
									name="lname" type="text" class="form-control">
							</div>
						
							<div class="mb-3">
								<label class="form-label">Appointment Date</label> <input required
									name="appdate" type="date" class="form-control">
							</div>
							<div class="mb-3">
                                  <label class="form-label">Appintment Related To</label>
                                 <select type="text" required name="spec" class="form-control">
                                   <option>---Select---</option>
                
                                    <% SpecialistDao dao=new SpecialistDao(DBConnect.getConn());
                                     List<Specialist> list=dao.getAllSpecialist();
                                     for(Specialist s:list)
                                     {%>
                	                <option><%=s.getSpecialistName() %></option>
                                     <%}
                                     %>
                                 </select>
                           </div>
                           <div class="mb-3">
                                  <label class="form-label">Doctor Assigned</label>
                                 <select type="text" required name="doctor" class="form-control">
                                   <option>---Select---</option>
                
                                    <% DoctorDao dao2=new DoctorDao(DBConnect.getConn());
                                     List<Doctor> list2=dao2.getAllDoctor();
                                     for(Doctor s:list2)
                                     {%>
                	                <option><%=s.getFullName() %></option>
                                     <%}
                                     %>
                                 </select>
                           </div>
							<button type="submit" class="btn bg-success text-white col-md-12">Add</button>
						</form>

						

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>