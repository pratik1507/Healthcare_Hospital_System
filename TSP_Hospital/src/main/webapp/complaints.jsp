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
<title>Complaints Page</title>
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
						<p class="fs-4 text-center">Add Complaint</p>

                        <c:if test="${ not empty sucMsg}">
                          <p class="text-center text-success fs-3">${sucMsg}</p>
                          <c:remove var="sucMsg" scope="session"/>
                        </c:if>
                        <c:if test="${ not empty errorMsg}">
                          <p class="text-center text-danger fs-3">${errorMsg}</p>
                          <c:remove var="errorMsg" scope="session"/>
                        </c:if>
						
						<form action="addComplaint" method="post">
						
                           <div class="mb-3">
                                  <label class="form-label">Doctor</label>
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
                           <div class="mb-3">
								<label class="form-label">Complaint </label> <input required
									name="complaint" type="text" class="form-control">
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