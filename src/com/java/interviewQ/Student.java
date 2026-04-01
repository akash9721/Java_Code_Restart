package com.java.interviewQ;

import java.util.ArrayList;
import java.util.List;

public class Student {

	public static void main(String[] args) {
		
		List<String> subject=new ArrayList<>();
		subject.add("english");
		subject.add("hindi");
		
		ImmutableClassDemo imcd=new ImmutableClassDemo(1, "akash", "akash@gmail.com", subject);
		System.out.println(imcd.getStudentId()+" "+imcd.getStudentName()+" "+imcd.getStudentMail()+" "+imcd.getSubjects());
		
		subject.add("cpp");
		subject.add("java");
		System.out.println(imcd.getStudentId()+" "+imcd.getStudentName()+" "+imcd.getStudentMail()+" "+imcd.getSubjects());

		
	}
}
