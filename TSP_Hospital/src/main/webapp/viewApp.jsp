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
<title>Patient page</title>
  <%@include file="/component/allcss.jsp" %>
  <style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%@include file="/component/staff_navbar.jsp" %>
  <div class="container-fluid p-3">

  <div class="row">
        
         <div class="col-md-12">
            <div class="card paint-card">
               <div class="card-body">
                 <p class="fs-3 text-center">Patient Details</p>
                 
                 <c:if test="${ not empty sucMsg}">
                          <p class="text-center text-success fs-3">${sucMsg}</p>
                          <c:remove var="sucMsg" scope="session"/>
                        </c:if>
                        <c:if test="${ not empty errorMsg}">
                          <p class="text-center text-danger fs-3">${errorMsg}</p>
                          <c:remove var="errorMsg" scope="session"/>
                        </c:if> 
                        
                 <table class="table">
                   <thead>
                     <tr> 
                          <th scope="col">First Name</th>
                          <th scope="col">Last Name</th>
                          <th scope="col">Appointment Date</th>
                          <th scope="col">Specialist</th>
                          <th scope="col">Doctor Assigned</th>
                          <th scope="col">Action</th>
                     </tr>
                   </thead>
                   <tbody>
                     <%
                     PatientDao dao2=new PatientDao(DBConnect.getConn());
                     List<Patient> list2=dao2.getAllPatient();
                     for(Patient d:list2)
                     {%>
                    	 <tr>
                    	 <td><%=d.getFname() %></td>
                    	 <td><%=d.getLname() %></td>
                    	 <td><%=d.getAppdate() %></td>
                    	 <td><%=d.getSpec() %></td>
                    	 <td><%=d.getDoctor() %></td>
                    	 <td>
                    	 <a href="deletePatient?id=<%= d.getId() %>" class="btn btn-sm btn-danger">Completed</a></td>
                    	 </tr>
                    <%}
                     
                     %>
                   </tbody>
                 </table>
               </div>
            </div>
         </div>
        
  </div>
</div>

</body>
</html>