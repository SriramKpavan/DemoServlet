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
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = new User();
		user.setName(request.getParameter("name"));
		user.setNumber(request.getParameter("num"));
		user.setUname(request.getParameter("uname"));
		user.setPwd(request.getParameter("psw"));
		
		RepoImplementation repo = new RepoImplementation();
		try {
			repo.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//call repo method repo.save(user);
		
		response.sendRedirect("Login.html");	
	}

}
