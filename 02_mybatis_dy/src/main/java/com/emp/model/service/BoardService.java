package com.emp.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import static com.emp.common.SessionTemplate.getSessionWeb;
import com.emp.model.dao.BoardDao;
import com.emp.model.vo.Board;

public class BoardService {
	private BoardDao dao=new BoardDao();
	
	public Board selectBoard(int boardNo){
		SqlSession session=getSessionWeb();
		Board b=dao.selectBoard(session,boardNo);
		session.close();
		return b;
	}
	
}
