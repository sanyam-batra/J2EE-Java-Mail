
//import com.proj.AuthImplRemote;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import proj.Mailusers;
import proj.MailusersFacadeLocal;


@WebServlet(urlPatterns = {"/userloginn"})  
public class userloginn extends HttpServlet
{

    @EJB
    private MailusersFacadeLocal mailusersFacade;

   
//    private MailusersFacadeLocal mailusersFacade;

    
    

//	Connection con;
//	Statement st;
//	PrintWriter out;
//	PreparedStatement prest;

    
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
    System.out.println("abc");
            res.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
            res.setHeader("Pragma","no-cache"); //HTTP 1.0
            res.setDateHeader ("Expires", 0); 
    try
	{
            
            

//            InitialContext ic = new InitialContext();
//            AuthImplRemote authImpl = (AuthImplRemote)ic.lookup("authentic");
//            out=res.getWriter();
//            out.println("Hello");
//	Class.forName("com.mysql.jdbc.Driver");
//        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emailjava","root","root");
//	st=con.createStatement();  
	
    
    
//    out.println("Hello");
	
	res.setContentType("text/html");
//	out=res.getWriter();
	String username=req.getParameter("t1");
	String password=req.getParameter("t2");
	int age=Integer.parseInt(req.getParameter("t4"));
	String gender=req.getParameter("r1");
	String sex=null;
	if(gender.equals("Male"))
		sex="Male";
	else if(gender.equals("Female"))
		sex="Female";
	String city=req.getParameter("t6");
	String state=req.getParameter("t7");
	int pincode=Integer.parseInt(req.getParameter("t8"));
	String nation=req.getParameter("t9");
        
//	Cookie cook1=new Cookie("signin1",username);
//				res.addCookie(cook1);

                             
        boolean ss=mailusersFacade.add_user(username,password,age,city,state,pincode,nation,sex);
        System.out.println(ss);
//	String Query="insert into mailusers values('"+username+"','"+password+"',"+age+",'"+sex+"','"+city+"','"+state+"',"+pincode+",'"+nation+"')";
//	st.execute(Query);
//	String UserTabCre ="create table "+username+"(msgfrom varchar(20),subject varchar(20),msg varchar(20),msgdate varchar(20))";
//	String UserAddCre ="create table "+username+"addbook (name varchar(20),nick varchar(20),addr varchar(20))";
//	String UserFolder="create table "+username+"folder(foldername varchar(20) primary key,totalmails integer)";
//	System.out.println(UserTabCre);
//	prest=con.prepareStatement(UserTabCre);
//	prest.execute();
//	prest=con.prepareStatement(UserAddCre);
//	prest.execute();
//	prest=con.prepareStatement(UserFolder);
//	prest.execute();
//        out.println("Ho GYa BRO");
//	res.sendRedirect("http://localhost:8080/inbox1.html");
//        String result=authImpl.SignUp(username, password, age, gender, city, nation, sex, pincode, state);
//	req.getRequestDispatcher("/inbox.html").forward(req, res);
        Mailusers rs = mailusersFacade.login_user(username,password);
        System.out.println(rs);
        req.getSession().setAttribute("login", rs);
        req.getSession().setMaxInactiveInterval(10);
//        if(req.getSession().getAttribute("login")==null)
//        res.sendRedirect("home.html");
        req.getRequestDispatcher("/inbox.html").forward(req, res);
	}catch(Exception e)
		{System.out.println(e.toString());}
	//res.sendRedirect("http://localhost:8080/Java_Mail/usersignup.html");}
}

}
