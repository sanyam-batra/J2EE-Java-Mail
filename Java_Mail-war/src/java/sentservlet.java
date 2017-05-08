import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import proj.Mailusers;
import proj.Mssginfo;
import proj.MssginfoFacadeLocal;
@WebServlet(urlPatterns = {"/sentservlet"})
public class sentservlet extends HttpServlet
{

    @EJB
    private MssginfoFacadeLocal mssginfoFacade;
//	Connection con;
//	ResultSet rs=null;
//	Statement st;
	PrintWriter out;
	public void init(ServletConfig sc)throws ServletException
	{
	try
	{
		super.init(sc);
//		Class.forName("com.mysql.jdbc.Driver");
//                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emailjava","root","root");
//		st=con.createStatement();
	}catch(Exception e)
		{System.out.println(e.toString());}
	}
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	try
	{
		res.setContentType("text/html");
		out=res.getWriter();
                System.out.println("hello");
                Mailusers m = (Mailusers)req.getSession().getAttribute("login");
                System.out.println(m.getUsername());
                List<Mssginfo> rs=mssginfoFacade.sent_mail(m.getUsername());
                out.println("<html><BODY BGCOLOR=AQUA><form action=http://localhost:8080/Java_Mail-war/selectfolder  method=post name=f1><h2>Welcome <FONT COLOR=PINK>"+m.getUsername()+"@QuickMail.com </FONT></h2>");
		out.println("<h3>Messages in SentBox</h3><TABLE BORDER=1><TR><TH>Check</TH><TH>To</TH><TH>Subject</TH><TH>Date</TH></TR>");
                int i;
                for(i=0;i<rs.size();i++)
			 {	
			String too=rs.get(i).getToo().getUsername();
			String sub=rs.get(i).getSubjectt();
			java.util.Date dat;
                    dat = rs.get(i).getDate();
//                    System.out.println(dat.getHours());
                    System.out.println("uuu"+dat);
//                        req.setAttribute("dateee", dat);
			out.println("<TR><TD><INPUT TYPE=CHECKBOX NAME="+too+"|"+dat.toString()+">");
			out.println("<TD width=200 align=center><A href=http://localhost:8080/Java_Mail-war/getmsg?msgf="+too+"&msgd="+rs.get(i).getMid()+" target=rightf>"+too+"</A>");
			out.println("<TD width=200 align=center>"+sub+"<TD width=200 align=center>"+dat.toString()+"</TR>");
			}
			
//		Cookie[] c = req.getCookies();
//		if(c!=null)
//		for(int i=0;i<c.length;i++)
//		{
//			if(c[i].getName().equals("signin1"))
//			{
//			una=c[i].getValue();
//			break;
//			}
//		}
//	//Deleting the unwanted mails
//		Enumeration names = req.getParameterNames();
//		StringTokenizer str; 	
//         	while(names.hasMoreElements())
//         	{
//           	String name = (String)names.nextElement();
//           	String value = req.getParameter(name);
//	if(value.equals("on"))
//		{
//		str=new StringTokenizer(name,"|");
//		while(str.hasMoreTokens())
//			{
//			String mfrom=str.nextToken();
//			String mdat=str.nextToken();
//			String del="delete from "+una+" where msgfrom='"+mfrom+"' and msgdate='"+mdat+"'";
//			st.executeUpdate(del);
//			con.commit();
//
//			}
//		}
//	}
	
	//Remaining mails
				
//		String mailsel="select msgfrom,subject,msgdate from "+una;
//		rs=st.executeQuery(mailsel);
//		out.println("<html><BODY BGCOLOR=AQUA><form action='http://localhost:8080/Java-Mail-war/deletemail' method=post><h2>Welcome <FONT COLOR=PINK>"+una+"@QuickMail.com </FONT></h2>");
//		out.println("<input type=submit name=t1 value=Delete><h3>Messages in inbox</h3><TABLE BORDER=1><TR><TH>Check</TH><TH>From</TH><TH>Subject</TH><TH>Date</TH></TR>");
//		while(rs.next())
//		 {	
//			String from=rs.getString(1);
//			String sub=rs.getString(2);
//			String dat=rs.getString(3);
//			out.println("<TR><TD><INPUT TYPE=CHECKBOX NAME="+from+"|"+dat+">");
//			out.println("<TD width=200 align=center><A href=http://localhost:8080/Java-Mail-war/getmsg?msgf="+from+"&msgd="+dat+" target=rightf>"+from+"</A>");
//			out.println("<TD width=200 align=center>"+sub+"<TD width=200 align=center>"+dat+"</TR>");
//		}
//		out.println("</Table><p><input type=submit name=b1 value=Delete></form></BODY>");
		}catch(Exception e)
		{if(e.toString().equals("java.lang.NullPointerException"))
                            out.print("Your Session has expired . Please Re-login!");}
	}
}