package com.rock.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rock.service.NewsService;
@WebServlet("/NewsAction")
public class NewsAction extends HttpServlet {
	
	private NewsService newsService=null;
	public NewsAction(){
		newsService=new NewsService();
	}
	
	
	private static final long serialVersionUID = 1L;
	/**
	  * @Author	   :老张
	  * @Date	   :2019年8月28日 上午11:09:04
	  * @TODO	   :请求的分发
	  * @see 	   :@see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	  * @param request
	  * @param response
	  * @throws ServletException
	  * @throws IOException    :
	  */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		if("doDelete".equals(method))
			doNewsDelete(request,response);
		if("delBatch".equals(method))
			delBatch(request,response);
	}

	protected void doNewsDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newsid=request.getParameter("newsid");
		
		
//		HttpSession session=request.getSession(true);
//		Object obj=session.getAttribute("cpage");
//		String c=obj.toString();
//		
		String cpage=request.getSession(true).getAttribute("cpage").toString();
		
		int a=newsService.doDelete(newsid);
		if(a>0){
			request.getRequestDispatcher("/PageAction?cpage="+cpage).forward(request, response);
		}
		
		response.sendRedirect("main.jsp");
	}
	protected void delBatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("ids");
//		String ids[]=id.split(",");
		boolean flag=newsService.deleteBatch1(id);
		request.getRequestDispatcher("/PageAction?cpage="+request.getSession(true).getAttribute("cpage").toString()).forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
