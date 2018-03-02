package com.colgmgmnt.entity;

public class Department {
	private String deptId;
	private String deptName;
	private int strength;
	private int placement;
	private int collegeId;

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void setPlacement(int placement) {
		this.placement = placement;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getDeptId() {
		return deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public int getStrength() {
		return strength;
	}

	public int getPlacement() {
		return placement;
	}

	public int getCollegeId() {
		return collegeId;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", strength=" + strength + ", placement="
				+ placement + ", collegeId=" + collegeId + "]";
	}

}
