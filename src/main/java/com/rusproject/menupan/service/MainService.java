package com.rusproject.menupan.service;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.rusproject.menupan.dao.MainDAO;


@Service
public class MainService {
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private MainDAO dao;
	
	/**
	 * getUserInfo LOV 정보 가지고 오기
	 * 
	 * @author Park KwangJoo
	 * @param model
	 * @param request  
	 * @param response
	 * @return
	 */
	public List getCarte(HashMap<String,String> param) {
		return dao.getCarte(param);
	}
}