package com.colgmgmnt.entity;

import java.io.Serializable;

public class College implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6634168431175722504L;
	private int collegeId;
	private String collegeName;
	private String estd;
	private int zip;
	private String stateId;
	private String distId;

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public void setEstd(String estd) {
		this.estd = estd;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public void setDistId(String distId) {
		this.distId = distId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public String getEstd() {
		return estd;
	}

	public int getZip() {
		return zip;
	}

	public String getStateId() {
		return stateId;
	}

	public String getDistId() {
		return distId;
	}

	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", "
				+ (collegeName != null ? "collegeName=" + collegeName + ", " : "")
				+ (estd != null ? "estd=" + estd + ", " : "") + "zip=" + zip + ", "
				+ (stateId != null ? "stateId=" + stateId + ", " : "") + (distId != null ? "distId=" + distId : "")
				+ "]";
	}

	
	

}
