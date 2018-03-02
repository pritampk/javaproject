package com.colgmgmnt.service;

import java.sql.SQLException;
import java.util.List;
import com.colgmgmnt.dao.CollegeDAO;
import com.colgmgmnt.dao.CollegeDAOHibernate;
import com.colgmgmnt.entity.College;
import com.colgmgmnt.exception.CollegeException;

public class CollegeService {

	private CollegeDAO collegeDAO = new CollegeDAO();
	private List collegeList = null;
	College college = null;
	private List stateList = null;

	public void insertCollegeDetails(College college) throws CollegeException {
		try {
			// collegeDAO.checkCollegeId(college.getCollegeId());
			collegeDAO.insertCollegeDetails(college);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new CollegeException();
		}
	}

	public List getAllCollegeDetails() throws CollegeException {
		try {
			college = new College();
			collegeList = collegeDAO.getAllCollegeDetails();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CollegeException("sql excp", e);
		}
		return collegeList;
	}

	public College searchCollegeByCollegeId(int collegeId) throws CollegeException {

		CollegeDAOHibernate collegeDAOHibernate = new CollegeDAOHibernate();
		college = collegeDAOHibernate.getCollegeRecordById(collegeId);
		return college;

	}

	public College updateCollegeDetails(College college) throws CollegeException {
		try {
			collegeDAO.updateCollegeDetails(college);
		} catch (SQLException e) {
			throw new CollegeException();
		}
		return null;
	}

	public List getAllState() {
		collegeDAO = new CollegeDAO();
		try {
			stateList = collegeDAO.getAllState();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stateList;
	}

}
