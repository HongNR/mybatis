package com.emp.common;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionTemplate {
	public static SqlSession getSession() {
//		String path="mybatis-config.xml";
		String file="/mybatis-config.xml";
		SqlSession session=null;
		try {
			//Resources클래스가 제공하는 static메소드인 getResourcesAsStream()을 이용함
			InputStream is=Resources.getResourceAsStream(file);
			session=new SqlSessionFactoryBuilder().build(is).openSession(false);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return session;
	}
	
	public static SqlSession getSessionWeb() {
		String file="/mybatis-config.xml";
		SqlSession session=null;
		try {
			//Resources클래스가 제공하는 static메소드인 getResourcesAsStream()을 이용함
			InputStream is=Resources.getResourceAsStream(file);
			session=new SqlSessionFactoryBuilder().build(is,"web")
					.openSession(false);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return session;
	}
}
