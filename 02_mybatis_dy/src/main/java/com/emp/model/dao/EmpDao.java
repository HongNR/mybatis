package com.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.emp.model.vo.Department;
import com.emp.model.vo.Employee;

public class EmpDao {
	
	public List<Employee> selectEmpList(SqlSession session,int cPage,int numPerpage){
		RowBounds rb=new RowBounds((cPage-1)*numPerpage,numPerpage);
		return session.selectList("emp.selectEmpList",null,rb);
	}
	
	public int selectEmpCount(SqlSession session) {
		return session.selectOne("emp.selectEmpCount");
	}
	
	public List<Employee> searchEmp(SqlSession session,Map<String,Object> param){
		return session.selectList("emp.searchEmp",param);
	}
	
	public Department selectDept(SqlSession session,String deptId) {
		return session.selectOne("emp.selectDept",deptId);
	}
}
