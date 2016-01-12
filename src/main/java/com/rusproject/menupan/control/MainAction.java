package com.rusproject.menupan.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rusproject.common.util.JSONUtil;
import com.rusproject.common.util.ParameterUtil;
import com.rusproject.menupan.service.MainService;


@Controller
public class MainAction {
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private MainService service;
	
	/**
	 * getAlSrchLovPopUp LOV 
	 *
	 * @author Park KwangJoo
	 * @param model
	 * @param request  
	 * @param response
	 * @return
	 */
	/*
	@RequestMapping("/main")
	public ModelMap getMainInfo(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		ParameterUtil p = new ParameterUtil();
		HashMap<String, String> param = p.setParameter(request);
		JSONUtil jsonUtil = new JSONUtil(); 

		response.setContentType("text/xml;charset=UTF-8"); 
		response.setHeader("Cache-Control", "no-cache"); 
		response.setCharacterEncoding("UTF-8"); 

		PrintWriter out = response.getWriter();
		
		try { 
	
			//HashMap map = service.getLovInfo(param); 
			HashMap inmap = new HashMap();
			
			inmap.put("lunch_a", "test1");
			inmap.put("lunch_a_dir", "test1");
			
			List list = new ArrayList();

			list.add(inmap);
			
			HashMap map = new HashMap();
			
			map.put("list", list);

			out.print(jsonUtil.toJSON(map)); 
		} catch(NullPointerException e) { 
			out.print(""); 
		} 
		
		//메모리 풀어줌 
		out.flush(); 
	}
	*/
	
	@RequestMapping("/main")
	public ModelMap getMain(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {		ParameterUtil p = new ParameterUtil();
		HashMap<String, String> param = p.setParameter(request);
		Calendar cal = Calendar.getInstance();
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd"); 
		
		model.addAttribute("list", service.getCarte(param));
		model.addAttribute("today", format1.format(cal.getTime()));
		
		return model;
	}
}
