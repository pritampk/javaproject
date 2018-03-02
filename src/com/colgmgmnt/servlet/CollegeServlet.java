package com.colgmgmnt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.colgmgmnt.entity.College;
import com.colgmgmnt.exception.CollegeException;
import com.colgmgmnt.service.CollegeService;

public class CollegeServlet extends HttpServlet {

	private static final long serialVersionUID = -2095798111985547552L;

	private CollegeService collegeService = new CollegeService();
	College college = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List collegeList = null;
		RequestDispatcher dispatcher = null;
		PrintWriter pw = resp.getWriter();
		String option = req.getParameter("option");
		switch (option) {
		case "insert":
			System.out.println("insert do get");
			List cllgList = collegeService.getAllState();
			req.setAttribute("cllgList", cllgList);
			dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/insert.jsp");
			dispatcher.forward(req, resp);
			System.out.println("Forwared to insert.jsp");

			break;

		case "allCollege":

			try {
				collegeList = collegeService.getAllCollegeDetails();

			} catch (CollegeException e) {

				e.printStackTrace();
			}
			req.setAttribute("collegeList", collegeList);
			dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/allCollegeRecord.jsp");
			dispatcher.forward(req, resp);
			break;

		case "search":
			dispatcher = req.getRequestDispatcher("WEB-INF/html/search.html");
			dispatcher.forward(req, resp);
			break;

		case "update":
			dispatcher = req.getRequestDispatcher("WEB-INF/jsp/update.jsp");
			dispatcher.forward(req, resp);

			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = null;
		String sChoice = req.getParameter("choice");
		int choice = Integer.parseInt(sChoice);
		PrintWriter pw = resp.getWriter();

		switch (choice) {
		case 1:
			college = new College();
			// try {
			// college.setCollegeId(Integer.parseInt(req.getParameter("collegeId")));
			//
			// } catch (NumberFormatException nfe) {
			// req.setAttribute("errorCode", "college Id");
			// dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			// dispatcher.forward(req, resp);
			// }
			college.setCollegeName(req.getParameter("collegeName"));
			college.setEstd(req.getParameter("estd"));
			college.setStateId(req.getParameter("stateId"));

			try {
				college.setZip(Integer.parseInt(req.getParameter("zipCode")));
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
				req.setAttribute("errorCode", "Zip Code");
				dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(req, resp);
			}

			try {
				System.out.println(college);
				collegeService.insertCollegeDetails(college);
				dispatcher = req.getRequestDispatcher("/WEB-INF/html/success.html");
				dispatcher.forward(req, resp);

				// req.setAttribute("errorCode","Already Exist");
				// dispatcher =
				// req.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				// dispatcher.forward(req, resp);

			} catch (CollegeException e) {
				e.printStackTrace();
				req.setAttribute("errorCode", "Already Exist");
				dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(req, resp);
			}

			break;

		case 2:
			int collegeId = 0;
			try {
				collegeId = Integer.parseInt(req.getParameter("collegeId"));
			} catch (NumberFormatException nfe) {
				dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/insertionError.jsp");
				dispatcher.forward(req, resp);
			}

			try {
				college = collegeService.searchCollegeByCollegeId(collegeId);
			} catch (CollegeException e) {

				e.printStackTrace();
			}

			req.setAttribute("college", college);
			dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(req, resp);

			break;

		case 3:
			college = new College();
			college.setCollegeId(Integer.parseInt(req.getParameter("collegeId")));
			college.setCollegeName(req.getParameter("collegeName"));
			college.setEstd(req.getParameter("estd"));
			try {
				college.setZip(Integer.parseInt(req.getParameter("zipCode")));
			} catch (NumberFormatException nfe) {
				dispatcher = req.getRequestDispatcher("/WEB-INF/html/insertionError.html");
				dispatcher.forward(req, resp);
			}

			try {
				collegeService.updateCollegeDetails(college);
				dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/success.jsp");
				dispatcher.forward(req, resp);
			} catch (CollegeException collegeException) {
				dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/updateError.jsp");
				dispatcher.forward(req, resp);
			}
			break;

		default:
			break;
		}

	}
}
