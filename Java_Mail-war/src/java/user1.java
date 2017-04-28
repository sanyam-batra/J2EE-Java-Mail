import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import proj.Mailusers;
import proj.MailusersFacadeLocal;
@WebServlet(urlPatterns = {"/user1"})
public class user1 extends HttpServlet
{

    @EJB
    private MailusersFacadeLocal mailusersFacade;
//	Connection con;
//	Statement st;
	PrintWriter out;
//	ResultSet rs;
//	boolean b=false;
	public void init(ServletConfig sc)throws ServletException
	{
//		try
//		{
//			super.init(sc);
//			Class.forName("com.mysql.jdbc.Driver");
//                        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emailjava","root","root");
//                        st=con.createStatement();
//			
//		}catch(Exception e){System.out.println(e.toString());}
	}
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{ 
		try
		{
 		res.setContentType("text/html");
		out=res.getWriter();
		String u=req.getParameter("una");
		String p=req.getParameter("pwd");
		System.out.println("in the service" +u);
//		rs=st.executeQuery("select pwd from mailusers where uname='"+u+"'");
                Mailusers rs = mailusersFacade.login_user(u, p);
                
		if(rs.getPassword().equals(p))

		{
			
                                
                                System.out.println("in the service in password");
                                //System.out.println(rs.getUsername());
//				Cookie cook=new Cookie("signin1",u);
//				res.addCookie(cook);
                                //out.println("correct username <a href='http://localhost:8080/Java_Mail-war/inbox.html'> inbox");
				req.getSession().setAttribute("login", rs);
                                req.getRequestDispatcher("/inbox.html").forward(req, res);
				
			
			
		}
		else
			out.println("<h1>Invalid user Name,press back button and try again....</h1>"); 
		}catch(Exception e)
		{out.println("Error"+e.toString());}
	}
}