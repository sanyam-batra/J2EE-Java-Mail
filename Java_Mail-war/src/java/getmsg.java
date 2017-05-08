import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import proj.Mailusers;
import proj.Mssginfo;
import proj.MssginfoFacadeLocal;
@WebServlet(urlPatterns = {"/getmsg"})
public class getmsg extends HttpServlet
{

    @EJB
    private MssginfoFacadeLocal mssginfoFacade;
//	Connection con;
//	Statement st;
	PrintWriter out;
//	ResultSet rs;
	boolean b=false;
	public void init(ServletConfig sc)throws ServletException
	{
		try
		{
			super.init(sc);
//			Class.forName("com.mysql.jdbc.Driver");
//                        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud","root","root");
//			st=con.createStatement();
		}catch(Exception e){System.out.println(e.toString());}
	}
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{ 
		try
		{
 		res.setContentType("text/html");
		out=res.getWriter();
		String mfrom=req.getParameter("msgf");
		String uid=req.getParameter("msgd");
//		
                Mailusers ms =(Mailusers)req.getSession().getAttribute("login");
                List<Mssginfo> rs=mssginfoFacade. get_msg_date(uid);
                    int i;
                
		//String selst="select * from "+una+" where msgfrom='"+mfrom+"' and msgdate='"+mdate+"'";
		//rs=st.executeQuery(selst);
		for(i=0;i<rs.size();i++)
		{
			//out.println("<a href=http://localhost:8080/servlet/inboxlocalhost target=rightf>Inbox</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href= target=rightf>Next</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href= target=rightf>Previous</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href= target=rightf>Reply</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href= target=rightf>Reply all</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href= target=rightf>Delete</a><p>");
			out.println("<body><table><tr><td align=right width=100> Message From  :<td width=200>"+rs.get(i).getFromm()+"</tr>");
			out.println("<tr><td align=right width=100> Subject : <td width=200>"+rs.get(i).getSubjectt()+"</table>");
			out.println("<h4><i>"+mfrom+"</i> Wrote </h4><br>"+rs.get(i).getBodyy());
			out.println("&nbsp;<a href=http://localhost:8080/Java_Mail-war/deletemail?msgd="+rs.get(i).getMid()+" target=rightf>Delete</a>");
		}
		}catch(Exception e)
		{out.println(e.toString());}
	}
}
