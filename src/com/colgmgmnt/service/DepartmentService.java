package com.colgmgmnt.service;

import java.sql.SQLException;
import java.util.List;

import com.colgmgmnt.dao.CollegeDAO;
import com.colgmgmnt.dao.DepartmentDAO;
import com.colgmgmnt.entity.Department;
import com.colgmgmnt.exception.CollegeException;

public class DepartmentService {

	public DepartmentDAO departmentDAO = new DepartmentDAO();

	public void insertDeptDetails(Department department) throws CollegeException {

		try {
			System.out.println("dao methos call");
			departmentDAO.insertDeptDetails(department);
			System.out.println("serive" + department);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new CollegeException();
		}
	}

	/*public List getAllCollegeDetails() throws CollegeException {
		List collegeList = null;
		CollegeDAO collageDAO = new CollegeDAO();
		try {
			collegeList = collageDAO.getAllCollegeDetails();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CollegeException();
		}

		return collegeList;
	}*/

	public List getAllDeptDetails() {
		departmentDAO = new DepartmentDAO();
		List deptList=null;
		try {
			deptList = departmentDAO.getAllDeptDetails();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deptList;
	}

}
