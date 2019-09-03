package cn.rock.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.rock.service.IUserService;
import cn.rock.serviceimpl.IUserServiceImpl;

/**
 * Servlet implementation class UserAction
 */
@WebServlet(name = "UserAction1", value = { "/UserAction1" })
public class UserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  userid=request.getParameter("userid");
		String password=request.getParameter("password");
		
		IUserService iUserService=new IUserServiceImpl();
		boolean flag=iUserService.login(userid, password);
				
		if(flag){
			//合法
			request.getRequestDispatcher("/web-main.jsp").forward(request, response);
		}
		else{
			request.setAttribute("info", "非法的登录信息");
			request.getRequestDispatcher("/web-login.jsp").forward(request, response);
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
