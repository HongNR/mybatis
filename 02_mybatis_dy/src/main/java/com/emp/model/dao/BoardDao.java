package com.emp.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.emp.model.vo.Board;

public class BoardDao {
	
	public Board selectBoard(SqlSession session,int boardNo){
		return session.selectOne("board.selectBoard",boardNo);
	}
}
