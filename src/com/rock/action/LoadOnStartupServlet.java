package com.rock.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadOnStartupServlet
 */
@WebServlet(value="/LoadOnStartupServlet",loadOnStartup=0)
public class LoadOnStartupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadOnStartupServlet() {
       System.out.println("LoadOnStartupServlet.LoadOnStartupServlet()");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("LoadOnStartupServlet.doGet()");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void destroy() {
	System.out.println("LoadOnStartupServlet.destroy()");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("LoadOnStartupServlet.init()");
		super.init();
	}

}
