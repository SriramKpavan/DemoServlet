package com.jda.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jda.model.User;

import dao.repo.RepoImplementation;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name  = request.getParameter("name");
		String number = request.getParameter("num");
		String username = request.getParameter("uname");
		String password = request.getParameter("psw");
		String psw1 = request.getParameter("psw1");
		if((name.equals(null )|| name.trim().isEmpty()) ||(number.equals(null )|| number.trim().isEmpty()) || (username.equals(null ) ||username.trim().isEmpty())  || (password.equals(null ) || password.trim().isEmpty()) || (psw1.equals(null ) || psw1.trim().isEmpty()) ){
			request.getRequestDispatcher("register.jsp");
			
		}
		else{
			User user = new User();
			user.setName(name);
			user.setNumber(number);
			user.setUname(username);
			user.setPwd(password);
			
			RepoImplementation repo = new RepoImplementation();
			try {
				repo.save(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//call repo method repo.save(user);
			response.sendRedirect("login.jsp");	
		}
	}

}
