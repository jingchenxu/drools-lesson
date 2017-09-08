package testhttpservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	 public void doGet(HttpServletRequest request,
	  HttpServletResponse response)throws IOException,ServletException{
	  //请求http://localhost:8080/DroolsTest/hello？clientName=me 访问
	  String clientName=request.getParameter("clientName");
	  if(clientName!=null)
	   clientName=new String(clientName.getBytes("ISO-8859-1"),"GB2312");
	  else
	   clientName="我的朋友";

	  //第四步：生成HTTP响应结果
	  PrintWriter out;
	  String title="HelloServlet";
	  String heading1="HelloServlet的doGet方法的输出：";
	  //set content type
	  response.setContentType("text/html;charset=UTF-8");
	  //write html page
	  out=response.getWriter();
	  out.print("<HTML><HEAD><TITLE>"+title+"</TITLE>");
	  out.print("</HEAD><BODY>");
	  out.print(heading1);
	  out.println("<h1><p>"+clientName+":您好</h1>");
	  out.print("</BODY></HTML>");

	  out.close();
	 }
}
