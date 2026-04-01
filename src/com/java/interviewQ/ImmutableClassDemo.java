package com.java.interviewQ;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableClassDemo {
	
	private final int studentId;
	private final String studentName;
	private final String studentMail;
	private final List<String> subjects;
	
	public ImmutableClassDemo(int studentId,String studentName,String studentMail,List<String> subjects) {
		this.studentId=studentId;
		this.studentName=studentName;
		this.studentMail=studentMail;
		this.subjects=new ArrayList<>(subjects);
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public String getStudentMail() {
		return studentMail;
	}
	
	public List<String> getSubjects(){
		return new ArrayList<>(subjects);
	}
}
