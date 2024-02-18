package com.vms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vms.model.BeenLogin;
import com.vms.service.LoginServiceEMS;

/**
 * Servlet implementation class LoginRegisterController
 */
@WebServlet("/LoginRegisterController")
public class LoginRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String login = "login.jsp";
	private static final String home = "home.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginRegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("cancel")) {
			response.sendRedirect(home);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("psw");
		String password1 = request.getParameter("psw1");
		String navigation = "";

		BeenLogin beenEMS = new BeenLogin();
		beenEMS.setUsername(username);
		beenEMS.setPassword(password);

		LoginServiceEMS loginServiceEMS = new LoginServiceEMS();
		if (password.equals(password1)) {
			int status = loginServiceEMS.register(beenEMS);
			if (status == 1) {
				request.setAttribute("msg", "Enter Username/Password added Sucessfully");
				navigation = login;
			} else {
				navigation = home;
			}
		} else {
			request.setAttribute("msg", "Enter Correct Password");
			navigation = "register.jsp";
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(navigation);
		requestDispatcher.forward(request, response);

	}

}
