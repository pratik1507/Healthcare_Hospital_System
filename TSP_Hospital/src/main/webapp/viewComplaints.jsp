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
<title>Complaint page</title>
  <%@include file="/component/allcss.jsp" %>
  <style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%@include file="/component/management_navbar.jsp" %>
  <div class="container-fluid p-3">

  <div class="row">
        
         <div class="col-md-12">
            <div class="card paint-card">
               <div class="card-body">
                 <p class="fs-3 text-center">Management Details</p>
                 
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
                          <th scope="col">Doctor</th>
                          <th scope="col">Complaint</th>
                          <th scope="col">Action</th>
                     </tr>
                   </thead>
                   <tbody>
                     <%
                     ComplaintDao dao2=new ComplaintDao(DBConnect.getConn());
                     List<Complaint> list2=dao2.getAllComplaints();
                     for(Complaint d:list2)
                     {%>
                    	 <tr>
                    	 <td><%=d.getDoctor() %></td>
                    	 <td><%=d.getComplaint() %></td>
                    	 <td>
                    	 <a href="deleteComplaint?id=<%= d.getId() %>" class="btn btn-sm btn-danger">Completed</a></td>
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