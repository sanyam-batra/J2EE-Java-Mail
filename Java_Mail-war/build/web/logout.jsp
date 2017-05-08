

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    System.out.println("yesss");
    session.invalidate();
    session=request.getSession(false);
    response.sendRedirect("home.html");
    
    %>