package com.rusproject.menupan.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("MainDAO")
public class MainDAO extends SqlSessionDaoSupport {
	
	/** 
	 * lovAccountUnit 회계단위 LOV 
	 * @author niceyys
	 * @param param 쿼리 수행시 들어갈 값
	 * @throws DataAccessException
	 * @return 쿼리 결과 (복수 행)
	 */
/*
	public List lovAccountUnit(HashMap param) throws DataAccessException {		
		return getSqlSession().selectList("lov.lovAccountUnit", param);
	}
	*/
	/** 
	 * lovAccountUnitCnt 회계단위 갯수 
	 * @author niceyys
	 * @param param 쿼리 수행시 들어갈 값

	 * @throws DataAccessException
	 * @return Object (갯수) 
	 */
	public List getCarte(HashMap param) throws DataAccessException {
//		수정
		return getSqlSession().selectList("main.getCarte", param);
	}

}
