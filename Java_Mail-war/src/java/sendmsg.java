import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import proj.Mailusers;
import proj.MailusersFacadeLocal;
import proj.MssginfoFacadeLocal;
@WebServlet(urlPatterns = {"/sendmsg"})
public class sendmsg extends HttpServlet
{

    @EJB
    private MailusersFacadeLocal mailusersFacade;

    @EJB
    private MssginfoFacadeLocal mssginfoFacade;
	Connection con;
	Statement st;
	PrintWriter out;
public void init(ServletConfig sc)throws ServletException
{
	try
	{
	super.init(sc);
//	Class.forName("com.mysql.jdbc.Driver");
//        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud","root","root");
//	st=con.createStatement();
	}catch(Exception e)
		{System.out.println(e.toString());}
}
public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
	try
	{
        Mailusers ms =(Mailusers)req.getSession().getAttribute("login");
	res.setContentType("text/html");
	out=res.getWriter();
	String to=req.getParameter("tto");
	String sub=req.getParameter("tsub");
	String msg=req.getParameter("ta");
//	String una=null;
//	Cookie[] c = req.getCookies();
//	if(c!=null)
//		for(int i=0;i<c.length;i++)
//		{
//			if(c[i].getName().equals("signin1"))
//				una=c[i].getValue();
//			break;
//		}
//        out.println(una);
	java.util.Date d = new java.util.Date();
	System.out.println("the date is " + d.getDate());
        Mailusers mm=mailusersFacade.get_user(to);
        System.out.println(mm.getUsername());
        boolean var=mssginfoFacade.add_msg(mm, sub, msg, ms.getUsername(),d);
        System.out.println(var);
	//st.execute("insert into "+to+" values('"+una+"','"+sub+"','"+msg+"','"+d.getDay()+"/"+d.getMonth()+"/"+d.getYear()+"')");
	out.println("<body bgcolor=teal><font color=white><h4>Your Message has been send suceffully,do u want to <FONT COLOR=YELLOW> <a href='http://localhost:8080/Java_Mail-war/compose.html'><I>send</I></FONT></a>  another message</h4></font></body>");
	}catch(Exception e)
	{out.println(e.toString());}
}
}