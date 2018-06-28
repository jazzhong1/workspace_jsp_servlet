package com.kh.mybatis.model.vo;

public class Student {
	
	
	private String studentName;
	private String studentTel;
	private String studentEmail;
	private String studentAddr;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Student(String studentName, String studentTel, String studentEmail, String studentAddr) {
		this.studentName = studentName;
		this.studentTel = studentTel;
		this.studentEmail = studentEmail;
		this.studentAddr = studentAddr;
	}



	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentTel() {
		return studentTel;
	}
	public void setStudentTel(String studentTel) {
		this.studentTel = studentTel;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getStudentAddr() {
		return studentAddr;
	}
	public void setStudentAddr(String studentAddr) {
		this.studentAddr = studentAddr;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentTel=" + studentTel + ", studentEmail=" + studentEmail
				+ ", studentAddr=" + studentAddr + "]";
	}
	
}
