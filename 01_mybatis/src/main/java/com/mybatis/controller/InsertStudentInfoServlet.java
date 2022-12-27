package com.mybatis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.StudentService;
import com.mybatis.model.vo.Student;

/**
 * Servlet implementation class InsertNewStudentServlet
 */
@WebServlet("/insertStudentInfo.do")
public class InsertStudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStudentInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("name");
		String tel=request.getParameter("phone");
		String email=request.getParameter("email");
		String addr=request.getParameter("address");
		//여러개의 값은 하나로 만들어서 보내야함
		Student s=Student.builder()
				.studentName(name).studentTel(tel)
				.studentEmail(email).studentAddr(addr)
				.build();
		
		int result=new StudentService().insertStudentInfo(s);
		
		response.getWriter().append(result>0?"success":"fail");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
