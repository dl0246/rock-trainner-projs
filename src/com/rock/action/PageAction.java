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
 * Servlet implementation class PageAction
 */
@WebServlet("/PageAction")
public class PageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpage=request.getParameter("cpage");
		if(null==cpage||"".equals(cpage))
			cpage="1";
		NewsService newsService=new NewsService();
		PageInfo pi=newsService.pageList(Integer.parseInt(cpage));
		
		request.setAttribute("pageinfo", pi);
		
		HttpSession session=request.getSession(true);
		session.setAttribute("cpage", cpage);
		
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
