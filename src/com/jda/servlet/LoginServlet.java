package com.jda.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.repo.RepoImplementation;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("uname");
		String password = request.getParameter("psw");
		if((username == null || username.trim().isEmpty()) || (password == null || password.trim().isEmpty())){
			RequestDispatcher req = request.getRequestDispatcher("login.jsp");
			request.setAttribute("error", "1");
			req.forward(request, response);
		}
		else{
			RepoImplementation repo = new RepoImplementation();
			try {
				if(repo.check(username, password) ){
					HttpSession session = request.getSession();
					session.setAttribute("name", username);
					response.sendRedirect("home.jsp");
				}	
				else {
					RequestDispatcher req = request.getRequestDispatcher("login.jsp");
					request.setAttribute("error", "2");
					req.forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
