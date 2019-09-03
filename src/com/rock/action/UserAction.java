package com.rock.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rock.entities.User;
import com.rock.service.UserService;

/**
 * Servlet implementation class UserAction
 */
@WebServlet("/UserAction")
public class UserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAction() {
    	userService=new UserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method=request.getParameter("method");
		if("login".equals(method))
			this.login(request,response);
	}

	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		
		
		User user=userService.login(userid, password);
		if(user!=null){
			request.getSession(true).setAttribute("user",user);
			request.getRequestDispatcher("/RootAction").forward(request, response);
		}
		else{
			request.setAttribute("info", "用户名或密码输入有误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
