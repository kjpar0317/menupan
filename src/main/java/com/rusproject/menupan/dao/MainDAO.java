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
	 * lovAccountUnit ȸ����� LOV 
	 * @author niceyys
	 * @param param ���� ����� �� ��
	 * @throws DataAccessException
	 * @return ���� ��� (���� ��)
	 */
/*
	public List lovAccountUnit(HashMap param) throws DataAccessException {		
		return getSqlSession().selectList("lov.lovAccountUnit", param);
	}
	*/
	/** 
	 * lovAccountUnitCnt ȸ����� ���� 
	 * @author niceyys
	 * @param param ���� ����� �� ��

	 * @throws DataAccessException
	 * @return Object (����) 
	 */
	public List getCarte(HashMap param) throws DataAccessException {
//		����
		return getSqlSession().selectList("main.getCarte", param);
	}

}
