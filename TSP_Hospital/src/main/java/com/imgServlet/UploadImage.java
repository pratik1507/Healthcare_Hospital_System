package com.imgServlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 
@WebServlet("/uploadImage")
@MultipartConfig(maxFileSize = 16177216)
public class UploadImage extends HttpServlet{
 
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
throws ServletException, IOException {
String connectionURL = "jdbc:mysql://localhost:3306/hp";
String user = "root";
String pass = "Pratik@1507";
 
int result = 0;
Connection con = null;
Part part = req.getPart("image");
 
if(part != null){
try{
Class.forName("com.mysql.cj.jdbc.Driver");
    con = DriverManager.getConnection(connectionURL, user, pass);
    
    PreparedStatement ps = con.prepareStatement("insert into data(image) values(?)");
    InputStream is = part.getInputStream();
    ps.setBlob(1, is);
    result = ps.executeUpdate();
}
catch(Exception e){
e.printStackTrace();
}
finally{
if(con != null){
try{
con.close();
}
catch(Exception e){
e.printStackTrace();
}
}
}
}
if(result > 0){
     resp.sendRedirect("result.jsp?message=Image+Uploaded");
    }
else{
resp.sendRedirect("result.jsp?message=Some+Error+Occurred");
}
}
}