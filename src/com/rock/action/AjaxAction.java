package com.rock.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rock.service.UserService;

/**
 * Servlet implementation class AjaxAction
 */
@WebServlet("/AjaxAction")
public class AjaxAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		
		UserService userService=new UserService();
		boolean flag=userService.isExist(userid);
		
//		设置相应的编码方式为UTF-8，这样jsp中页采用了UTF-8编码方式就能解决汉字乱码问题
		response.setCharacterEncoding("UTF-8");
		if(!flag){
			response.getWriter().write("yes 可用  yes");
		}
		else{
			response.getWriter().write("no 不可用  no");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
