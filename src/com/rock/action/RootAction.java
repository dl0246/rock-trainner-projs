package com.rock.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rock.entities.PageInfo;
import com.rock.service.NewsService;

/**
 * Servlet implementation class RootAction
 */
@WebServlet("/RootAction")
public class RootAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RootAction() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RootAction.doGet()");
		
//		�ѵ㣺����ȷ���Ƿ��¼���أ�
		
		HttpSession session=request.getSession(true);
		if(session.getAttribute("user")!=null){
			NewsService  newsService=new NewsService();
			PageInfo pi=newsService.pageList(1);
			request.setAttribute("pageinfo", pi);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}
		else{
			request.setAttribute("info", "����û�е�¼�����¼������������");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
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
