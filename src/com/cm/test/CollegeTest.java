package com.cm.test;

import java.sql.SQLException;
import java.util.List;

import com.colgmgmnt.dao.CollegeDAO;

public class CollegeTest {

	public static void main(String[] args) throws SQLException {
		CollegeDAO collegeDAO = new CollegeDAO();
		List collegeList = collegeDAO.getAllState();
		System.out.println(collegeList);
	}
	
}
