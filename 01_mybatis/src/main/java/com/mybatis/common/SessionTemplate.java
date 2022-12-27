package com.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionTemplate {
	//mybatis가 제공하는 SqlSession객체를 생성해주는 static메소드를 가지고있는 클래스
	//== JDBCTemplate과 유사
	//SqlSession객체를 생성해주는 메소드 외에 선언할 것은 없다!
	public static SqlSession getSession() {
		//SlqSession객체를 생성하는 방법
		//1. SqlSessionFactoryBuilder 클래스를 생성
		//2. 설정파일인 mybatis-config.xml파일을 가져옴(InputStream);
		//3. SqlSessionFactoryBuilder의 build()메소드를 이용해서 SqlSessionFactory를 생성
		//4. SqlSessionFactory의 openSession()메소드를 이용해서 SqlSession객체를 생성
		// openSession매개변수로 true/false(transaction처리에 대한 옵션)
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		String path="/mybatis-config.xml";
		SqlSession session=null;
		try {
			//Resources클래스가 제공하는 static메소드인 getResourcesAsStream()을 이용함
			InputStream is=Resources.getResourceAsStream(path);
			SqlSessionFactory factory=builder.build(is);
			session=factory.openSession(false);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
	
}
