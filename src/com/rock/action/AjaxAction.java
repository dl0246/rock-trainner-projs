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
		
//		������Ӧ�ı��뷽ʽΪUTF-8������jsp��ҳ������UTF-8���뷽ʽ���ܽ��������������
		response.setCharacterEncoding("UTF-8");
		if(!flag){
			response.getWriter().write("yes ����  yes");
		}
		else{
			response.getWriter().write("no ������  no");
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
