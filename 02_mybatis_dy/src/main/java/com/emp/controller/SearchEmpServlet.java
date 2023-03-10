package com.emp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.model.service.EmpService;
import com.emp.model.vo.Employee;


/**
 * Servlet implementation class SearchEmpServlet
 */
@WebServlet("/searchEmp.do")
public class SearchEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String type=request.getParameter("type");
		String keyword=request.getParameter("keyword");
		
		
		Map<String,Object> param=new HashMap();
		param.put("type", type);
		param.put("keyword", keyword);
		param.put("gender", request.getParameter("gender"));
		param.put("salary", Integer.parseInt(
				request.getParameter("salary").equals("")?"0":request.getParameter("salary")));//검색금액
		param.put("salFlag", request.getParameter("salFlag"));//이상 or 이하
		
		//yyyy-MM-dd -> yyyy/MM/dd
		param.put("hireDate", request.getParameter("hiredate").replace("-","/"));//입사일
		param.put("hireFlag", request.getParameter("hireFlag"));
		param.put("jobs", request.getParameterValues("job"));
		
		List<Employee> searchResult=new EmpService().searchEmp(param);
		
		request.setAttribute("employees", searchResult);
		request.getRequestDispatcher("/views/emp/empList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
