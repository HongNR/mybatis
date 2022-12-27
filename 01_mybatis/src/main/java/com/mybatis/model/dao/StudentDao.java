package com.mybatis.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Student;

public class StudentDao {
	
	public int insertStudent(SqlSession session) {
		//mybatis를 이용해서 sql구문을 실행할 때는
		//session객체가 제공하는 메소드를 이용해서 실행함
		//실행될 sql구문은 mapper로 등록되어있는 xml파일을 선택해서 실행
		int result=session.insert("student.insertStudent");
		//	==student mapper에 insertStudent라는 쿼리문 실행해
		return result;
	}
	
	public int insertStudentName(SqlSession session, String name) {
		return session.insert("student.insertStudentName",name);
	}
	
	public int insertStudentInfo(SqlSession session,Student s) {
		return session.insert("student.insertStudentInfo",s);
	}
}
