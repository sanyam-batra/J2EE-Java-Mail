import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import proj.Mailusers;
import proj.Mssginfo;
import proj.MssginfoFacadeLocal;

@WebServlet(urlPatterns = {"/inboxservlett"}) 
public class inboxservlet extends HttpServlet
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
//                st=con.createStatement();
		
		}catch(Exception e)
		{System.out.println(e.toString());}
	}
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	try
	{	
//		res.setContentType("text/html");
                Mailusers ms =(Mailusers)req.getSession().getAttribute("login"); 
//                System.out.println(ms.getUsername());
		out=res.getWriter();
//		String una=null;
//		Cookie[] c = req.getCookies();
//		if(c!=null)
//		for(int i=0;i<c.length;i++)
//		{
//			if(c[i].getName().equals("signin1"))
//			{
//				una=c[i].getValue();
//				break;
//			}
//		}
                
                List<Mssginfo> rs=mssginfoFacade.get_msgs(ms);
                System.out.println("yes");
//		String mailsel = "select msgfrom,subject,msgdate from "+una;
//		rs=st.executeQuery(mailsel);
		out.println("<html><BODY BGCOLOR=AQUA><form action=http://localhost:8080/Java_Mail-war/selectfolder  method=post name=f1><h2>Welcome <FONT COLOR=PINK>"+ms.getUsername()+"@QuickMail.com </FONT></h2>");
		out.println("<h3>Messages in Inbox</h3><TABLE BORDER=1><TR><TH>Check</TH><TH>From</TH><TH>Subject</TH><TH>Date</TH></TR>");
            int i;
                              	for(i=0;i<rs.size();i++)
			 {	
			String from=rs.get(i).getFromm();
			String sub=rs.get(i).getSubjectt();
			java.util.Date dat;
                    dat = rs.get(i).getDate();
//                    System.out.println(dat.getHours());
                    System.out.println("uuu"+dat);
//                        req.setAttribute("dateee", dat);
			out.println("<TR><TD><INPUT TYPE=CHECKBOX NAME="+from+"|"+dat.toString()+">");
			out.println("<TD width=200 align=center><A href=http://localhost:8080/Java_Mail-war/getmsg?msgf="+from+"&msgd="+rs.get(i).getMid()+" target=rightf>"+from+"</A>");
			out.println("<TD width=200 align=center>"+sub+"<TD width=200 align=center>"+dat.toString()+"</TR>");
			}
			//out.println("</Table><p><input type=button name=b1 value=Delete onclick=location.href='http://localhost:8080/Java_Mail-war/deletemail'>");
			//out.print("<INPUT TYPE=submit  VALUE='MoveSelected To'><select name='li'>");
//			String foldsel="select foldername from "+una+"folder";
//			rs=st.executeQuery(foldsel);
//			while(rs.next())
//				{out.println("<option>"+rs.getString(1));}
//			out.println("</select></form></body></html>");
			}catch(Exception e)
			{
                            if(e.toString().equals("java.lang.NullPointerException"))
                            out.print("Your Session has expired . Please Re-login!");
                        }
	}
}