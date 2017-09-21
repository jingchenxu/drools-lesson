package testhttpservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示如何将java对象显示在jsp当中的
 * 
 * @author semantic
 *
 */
public class JspServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		User user = new User();
		user.setAge(26);
		user.setName("jingchenxu");
		request.setAttribute("user", user);
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}

}
