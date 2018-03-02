package com.colgmgmnt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.colgmgmnt.entity.Department;
import com.colgmgmnt.exception.CollegeException;
import com.colgmgmnt.service.CollegeService;
import com.colgmgmnt.service.DepartmentService;

public class DepartmentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8605697408567092057L;

	private DepartmentService departmentService = new DepartmentService();
	private RequestDispatcher dispatcher = null;
	public Department department = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String option = req.getParameter("option");

		switch (option) {
		case "insert":
			List cllgList = null;
			;
			try {
				CollegeService collegeService = new CollegeService();
				cllgList = collegeService.getAllCollegeDetails();
			} catch (CollegeException e1) {
				e1.printStackTrace();
			}
			req.setAttribute("cllgList", cllgList);
			dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/insertDept.jsp");
			dispatcher.forward(req, resp);

			System.out.println("Request forwared");

			break;

		case "update":
			
			break;
			
		case "view":
			
			List deptList=departmentService.getAllDeptDetails();
			req.setAttribute("deptList", deptList);
			System.out.println(deptList);
			dispatcher=req.getRequestDispatcher("/WEB-INF/jsp/viewDept.jsp");
			dispatcher.forward(req, resp);
			
		default:
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String strChoice = req.getParameter("choice");
		int choice = Integer.parseInt(strChoice);
		System.out.println(choice);
		switch (choice) {
		case 1:
			department = new Department();
			department.setDeptId(req.getParameter("deptId"));
			department.setDeptName(req.getParameter("deptName"));
			department.setStrength(Integer.parseInt(req.getParameter("strength")));
			department.setPlacement(Integer.parseInt(req.getParameter("placement")));
			department.setCollegeId(Integer.parseInt(req.getParameter("collegeId")));

			try {

				departmentService.insertDeptDetails(department);
				dispatcher = req.getRequestDispatcher("/WEB-INF/html/success.html");
				dispatcher.forward(req, resp);
			} catch (CollegeException e) {
				e.printStackTrace();
			}
			break;

		default:
			break;
		}

	}

}
