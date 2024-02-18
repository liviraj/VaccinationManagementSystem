̥package com.vms.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vms.model.BabyBeen;
import com.vms.service.BabyService;

@WebServlet("/BabyController")
public class BabyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String REGISTER_BABY = "RegisterBaby.jsp";
	private static final String VIEW_BABY = "ViewBaby.jsp";
	private static final String login = "login.jsp";
	RequestDispatcher requestDispatcher = null;

	public BabyController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String check = (String) session.getAttribute("username");
		String action = request.getParameter("action");
		String navigation = "";
		if (action.equals("register")) {
			if (check != null) {
				request.setAttribute("name", "save");
				navigation = REGISTER_BABY;
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		} else if (action.equals("cancel")) {
			navigation = "home.jsp";
		} else if (action.equals("update")) {
			if (check != null) {
				BabyService babyService = new BabyService();
				BabyBeen babyBeen = new BabyBeen();
				int id = Integer.parseInt(request.getParameter("id"));
				try {
					babyBeen = babyService.getById(id);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.setAttribute("name", "update");
				request.setAttribute("details", babyBeen);
				navigation = REGISTER_BABY;
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		} else if (action.equals("delete")) {
			String confirm = request.getParameter("confirm");
			if (check != null) {
				if (!"false".equals(confirm)) {
					BabyService babyService = new BabyService();
					int id = Integer.parseInt(request.getParameter("id"));
					try {
						int reult = babyService.deleteBaby(id);
						if (reult == 1) {
							ArrayList<BabyBeen> babyBeens = new ArrayList<BabyBeen>();
							BabyService babyService2 = new BabyService();
							try {
								babyBeens = babyService2.get2();
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							}
							request.setAttribute("details", babyBeens);
							navigation = VIEW_BABY;
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					requestDispatcher = request.getRequestDispatcher(login);
				}
			}
		} else if (action.equals("add")) {
			if (check != null) {
				request.setAttribute("name", "save");
				navigation = REGISTER_BABY;
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		} else {
			if (check != null) {
				ArrayList<BabyBeen> babyBeens = new ArrayList<BabyBeen>();
				BabyService babyService = new BabyService();
				try {
					babyBeens = babyService.getAll();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.setAttribute("details", babyBeens);
				navigation = VIEW_BABY;
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		}
		requestDispatcher = request.getRequestDispatcher(navigation);
		requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String check = (String) session.getAttribute("username");
		String action = request.getParameter("submit");
		ArrayList<BabyBeen> arrayList = new ArrayList<BabyBeen>();
		if (action.equals("save")) {
			if (check != null) {
				BabyBeen babyBeen = new BabyBeen();
				BabyService babyService = new BabyService();
				String name = request.getParameter("name");
				String gender = request.getParameter("gender");
				String fatherName = request.getParameter("fatherName");

				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				java.util.Date dobReq = null;
				try {
					dobReq = dateFormat.parse(request.getParameter("dob"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Date dob = new Date(dobReq.getTime());

				String motherName = request.getParameter("motherName");
				String placeOfBirth = request.getParameter("placeOfBirth");

				babyBeen.setName(name);
				babyBeen.setDob(dob);
				babyBeen.setGender(gender);
				babyBeen.setFatherName(fatherName);
				babyBeen.setMotherName(motherName);
				babyBeen.setFatherName(fatherName);

				String result = babyService.nameCheck(name);
				arrayList.add(babyBeen);
				if (result.equals("success")) {
					request.setAttribute("name", "save");
					request.setAttribute("msg", "Name Already Exist");
					request.setAttribute("details", babyBeen);
					requestDispatcher = request.getRequestDispatcher(REGISTER_BABY);
				} else {
					int status = babyService.insert(babyBeen);
					if (status > 0) {
						ArrayList<BabyBeen> employeBeens = new ArrayList<BabyBeen>();
						BabyService employeService2 = new BabyService();
						try {
							employeBeens = employeService2.get2();
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						request.setAttribute("details", employeBeens);
						requestDispatcher = request.getRequestDispatcher(VIEW_BABY);
					}
				}
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		} else if (action.equals("Cancel")) {
			if (check != null) {
				ArrayList<BabyBeen> employeBeens = new ArrayList<BabyBeen>();
				BabyService employeService = new BabyService();
				try {
					employeBeens = employeService.get2();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.setAttribute("details", employeBeens);
				requestDispatcher = request.getRequestDispatcher(VIEW_BABY);
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		} else {
			if (check != null) {
				BabyBeen babyBeen = new BabyBeen();
				BabyService babyService = new BabyService();
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String gender = request.getParameter("gender");
				String fatherName = request.getParameter("fatherName");

				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				java.util.Date dobReq = null;
				try {
					dobReq = dateFormat.parse(request.getParameter("dob"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Date dob = new Date(dobReq.getTime());

				String motherName = request.getParameter("motherName");
				String placeOfBirth = request.getParameter("placeOfBirth");

				babyBeen.setName(name);
				babyBeen.setDob(dob);
				babyBeen.setGender(gender);
				babyBeen.setFatherName(fatherName);
				babyBeen.setMotherName(motherName);
				babyBeen.setFatherName(fatherName);
				try {
					int status = babyService.update(babyBeen);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				ArrayList<BabyBeen> babyBeens = null;
				try {
					babyBeens = babyService.get2();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.setAttribute("details", babyBeens);
				request.setAttribute("msg", "record updated successfully");
				requestDispatcher = request.getRequestDispatcher(VIEW_BABY);
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		}
		requestDispatcher.forward(request, response);
	}
}
