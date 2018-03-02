package com.colgmgmnt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.colgmgmnt.entity.College;
import com.colgmgmnt.entity.State;

public class CollegeDAO {

	College college = null;
	PreparedStatement pstmt = null;
	Connection con = null;
	ResultSet rs = null;
	 State state = null;

	private String SQL_INSERT_COLLEGE_DETAILS = "INSERT INTO COLLEGE VALUES (?,?,?,?,?,?)";
	private String SQL_FETCH_ALL_COLLEGE_DETAILS = "SELECT COLLID,COLLNAME,TO_CHAR(ESTD,'DD-MM-YYYY'),ZIP,DIST_ID,STATE_ID FROM COLLEGE";
	private String SQL_SEARCH_COLLEGE_BY_COLLEGE_ID = "SELECT * FROM COLLEGE WHERE COLLID=?";
	private String SQL_GET_COUNT_COLLEGE_ID = "SELECT COUNT(*) FROM COLLEGE WHERE COLLID=?";
	private String SQL_UPDATE_COLLEGE_DETAILS = "UPDATE COLLEGE SET COLLNAME=?,ZIP=? WHERE COLLID=? ";
	private String SQL_GET_ALL_STATE = "SELECT * FROM STATE";
	private String SQL_CREATE_SEQUENCE_FOR_COLLEGE_ID = "SELECT collegeid_seq.NEXTVAL FROM college";

	public CollegeDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Class not loaded.");
			e.printStackTrace();
		}
	}

	public void insertCollegeDetails(College college) throws SQLException {

		pstmt = con.prepareStatement(SQL_CREATE_SEQUENCE_FOR_COLLEGE_ID);
		rs = pstmt.executeQuery();
		rs.next();
		int collegeId = rs.getInt(1);
		pstmt = con.prepareStatement(SQL_INSERT_COLLEGE_DETAILS);
		pstmt.setInt(1, collegeId);
		pstmt.setString(2, college.getCollegeName());
		String stringDate = college.getEstd();
		System.out.println(" str " + stringDate);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yy");
		java.sql.Date sqlDate = null;
		Date utilDate = null;
		try {
			utilDate = simpleDateFormat.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long longDate = utilDate.getTime();
		sqlDate = new java.sql.Date(longDate);
		System.out.println("sq " + sqlDate);
		pstmt.setDate(3, sqlDate);
		pstmt.setInt(4, college.getZip());
		pstmt.setString(5, college.getStateId());
		pstmt.setString(6, "null");
		pstmt.executeQuery();
		System.out.println("Data successfully inserted.");
	}

	public List getAllCollegeDetails() throws SQLException {
		pstmt = con.prepareStatement(SQL_FETCH_ALL_COLLEGE_DETAILS);
		rs = pstmt.executeQuery();
		List collegeList = new ArrayList();
		while (rs.next()) {
			college = new College();
			college.setCollegeId(rs.getInt(1));
			college.setCollegeName(rs.getString(2));
			college.setEstd(rs.getString(3));
			college.setZip(rs.getInt(4));
			college.setDistId(rs.getString(5));
			college.setStateId(rs.getString(6));
			collegeList.add(college);
		}
		return collegeList;
	}

	public College searchCollegeByCollegeId(int collegeId) throws SQLException {

		pstmt = con.prepareStatement(SQL_SEARCH_COLLEGE_BY_COLLEGE_ID);
		pstmt.setInt(1, collegeId);
		rs = pstmt.executeQuery();
		college = new College();
		while (rs.next()) {
			college.setCollegeId(rs.getInt(1));
			college.setCollegeName(rs.getString(2));
			college.setEstd(rs.getString(3));
			college.setZip(rs.getInt(4));
		}
		return college;
	}

	public void updateCollegeDetails(College college) throws SQLException {

		pstmt = con.prepareStatement(SQL_UPDATE_COLLEGE_DETAILS);
		pstmt.setString(1, college.getCollegeName());
		pstmt.setInt(2, college.getZip());
		pstmt.setInt(3, college.getCollegeId());
		pstmt.executeQuery();
		System.out.println("Data Updated  Succefully.");
	}

	public int checkCollegeId(int collegeId) throws SQLException {
		pstmt = con.prepareStatement(SQL_GET_COUNT_COLLEGE_ID);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		return count;
	}

	public List getAllState() throws SQLException {
		pstmt = con.prepareStatement(SQL_GET_ALL_STATE);
		rs = pstmt.executeQuery();
		List stateList = new ArrayList();
		while (rs.next()) {
			state = new State();
			state.setStateId(rs.getString(1));
			state.setStateName(rs.getString(2));
			stateList.add(state);
		}
		return stateList;
	}

}
