package com.vms.controller;

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
import com.vms.model.BookingModel;
import com.vms.service.BabyService;
import com.vms.service.BookingService;

@WebServlet("/BookingController")
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String REGISTER_BABY = "RegisterBaby.jsp";
	private static final String VIEW_BABY = "ViewBaby.jsp";
	private static final String login = "login.jsp";
	private static final String BOOKING = "Booking.jsp";
	RequestDispatcher requestDispatcher = null;

	public BookingController() {
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

		if (action.equals("booking")) {
			int babyId = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("babyId", babyId);
			navigation = BOOKING;
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

		if (action.equals("Book An Appointment")) {
			String doctorName = request.getParameter("doctorName");
			String vaccinationType = request.getParameter("vaccinationType");

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date opReq = null;
			try {
				opReq = dateFormat.parse(request.getParameter("date"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Date oppintmentDate = new Date(opReq.getTime());
			int babyId = Integer.parseInt(request.getParameter("babyId"));

			BookingModel bookingModel = new BookingModel();
			bookingModel.setDate(oppintmentDate);
			bookingModel.setDoctorName(doctorName);
			bookingModel.setVaccinationType(vaccinationType);
			bookingModel.setBabyId(babyId);

			BookingService bookingService = new BookingService();
			bookingService.insert(bookingModel);

			request.setAttribute("msg", "Appointment booked successfully");

			BabyService babyService = new BabyService();
			ArrayList<BabyBeen> list = null;
			try {
				list = babyService.getAll();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("details", list);
			requestDispatcher = request.getRequestDispatcher(VIEW_BABY);
		} else if (action.equals("Cancel")) {
			BabyService babyService = new BabyService();
			ArrayList<BabyBeen> list = null;
			try {
				list = babyService.getAll();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("details", list);
			requestDispatcher = request.getRequestDispatcher(VIEW_BABY);
		}

		requestDispatcher.forward(request, response);
	}
}
