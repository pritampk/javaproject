package com.colgmgmnt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.colgmgmnt.entity.Department;

public class DepartmentDAO {

	private String SQL_INSERT_DEPT_DETAILS = "INSERT INTO DEPARTMENT VALUES (?,?,?,?,?)";
private String SQL_VIEW_ALL_DEPT_DETAILS="SELECT * FROM DEPARTMENT";
	private Connection con = null;
	private PreparedStatement pstmt = null;
	public Department department = null;
	ResultSet rs = null;


	public DepartmentDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println(" Deriver Class Not loaded");
		}
	}

	public void insertDeptDetails(Department department) throws SQLException {
		pstmt = con.prepareStatement(SQL_INSERT_DEPT_DETAILS);
		pstmt.setString(1, department.getDeptId());
		pstmt.setString(2, department.getDeptName());
		pstmt.setInt(3, department.getStrength());
		pstmt.setInt(4, department.getPlacement());
		pstmt.setInt(5, department.getCollegeId());
		pstmt.executeQuery();

	}

public List getAllDeptDetails() throws SQLException{
	pstmt =con.prepareStatement(SQL_VIEW_ALL_DEPT_DETAILS);
	rs=pstmt.executeQuery();
	List deptList =new ArrayList();
	while(rs.next()){
		department =new Department();
		department.setDeptId(rs.getString(1));
		department.setDeptName(rs.getString(2));
		department.setStrength(rs.getInt(3));
		department.setPlacement(rs.getInt(4));
		department.setCollegeId(rs.getInt(5));
		deptList.add(department);
	}
	return deptList;
}
	
}
