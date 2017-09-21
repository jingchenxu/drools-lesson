package testhttpservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,
			  HttpServletResponse response)throws IOException,ServletException{
		// 接收到请求后生成http相应结果
		String show = "show.jsp";
		response.sendRedirect(show);
		return;
		
	}
}
