package com.rusproject.common.util;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class ParameterUtil 
{
	public ParameterUtil()
	{
	}
	
	@SuppressWarnings("unchecked")
	public HashMap setAttribute(HttpServletRequest request)
	{
		Enumeration<String> enu = request.getAttributeNames();
		HashMap param = new HashMap();
		
		while(enu.hasMoreElements())
		{
			String key = enu.nextElement();
			Object value = request.getAttribute(key);
			param.put(key, value);
		}
		return param;
	}
	
	@SuppressWarnings("unchecked")
	public HashMap setParameter(HttpServletRequest request)
	{
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		Enumeration<String> enu = request.getParameterNames();
		HashMap param = new HashMap();
		
		while(enu.hasMoreElements())
		{
			String key = enu.nextElement();
			String value = request.getParameter(key);
//			if( key.equals("cbContent") == false)
//			{
//				System.out.println("--- value before="+value);
//				// SQL Injection 
//				value = value.replaceAll("'", "");
//				value = value.replaceAll("--", "");
//				//value.replaceAll("@", "");
//				value = value.replaceAll("\\+", "");
//				value = value.replaceAll("%", "");
//				value = value.replaceAll("=", "");
//				value = value.replaceAll("[';\\-\\+%=;@]", "");
//				// XSS 
//				value = value.replaceAll("<", "&lt;");
//				value = value.replaceAll(">", "&gt;");
//				System.out.println("--- value after="+value);
//			}
			
//					System.out.println("8859_1 : " + new String(value.getBytes("UTF-8"), "8859_1"));
//					System.out.println("8859_1 : " + new String(value.getBytes("UTF-8"), "KSC5601"));
//					System.out.println("UTF-8  : " + new String(value.getBytes("UTF-8"), "EUC-KR"));
//					System.out.println("UTF-8  : " + new String(value.getBytes("UTF-8"), "ISO-8859-1"));
//					
//					System.out.println("EUC-KR : " + new String(value.getBytes("EUC-KR"), "UTF-8"));
//					System.out.println("EUC-KR1 : " + new String(value.getBytes("EUC-KR"), "KSC5601"));
//					System.out.println("EUC-KR : " + new String(value.getBytes("EUC-KR"), "ISO-8859-1"));
//					System.out.println("EUC-KR : " + new String(value.getBytes("EUC-KR"), "8859_1"));
//					
//					System.out.println("KSC5601  : " + new String(value.getBytes("KSC5601"), "UTF-8"));
//					System.out.println("8859_1  : " + new String(value.getBytes("KSC5601"),"8859_1"));
//					System.out.println("8859_1  : " + new String(value.getBytes("KSC5601"),"ISO-8859-1"));
//					System.out.println("8859_12  : " + new String(value.getBytes("KSC5601"),"EUC-KR"));
//					
//					
//					System.out.println("8859_1 : " + new String(value.getBytes("8859_1"), "UTF-8"));
//					System.out.println("KSC5601  : " + new String(value.getBytes("8859_1"),"KSC5601"));
//					System.out.println("KSC5601  : " + new String(value.getBytes("8859_1"),"EUC-KR"));
//					System.out.println("KSC5601  : " + new String(value.getBytes("8859_1"),"ISO-8859-1"));
			
//			System.out.println(request.getMethod() + "변환전 ,  " +  key + " :: " + value);


			if("GET".equals(request.getMethod())){
				// 서버가 톰캣인지 확인
			//	if(CommonConst.SERVER_MODE == 0) {
					//아파치와 CHAR SET 을 맞쳐주기 위하여..(아파치 사용시)
					try {
						value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		//		}
			} 
			
//			System.out.println(request.getMethod() + "변환후 ,  " +  key + " :: " + value);
			param.put(key, value);
		}
		
		return param;
	}
	
	@SuppressWarnings("unchecked")
	public HashMap setParameters(HttpServletRequest request)
	{
		Enumeration<String> enu = request.getParameterNames();
		HashMap param = new HashMap();
		
		while(enu.hasMoreElements())
		{
			String key = enu.nextElement();
			String values[] = request.getParameterValues(key);
			
			param.put(key, values.length == 1 ? values[0] : values);
		}
		
		return param;
	}
	@SuppressWarnings("unchecked")
	public String getParameterHTMLForm(HttpServletRequest request)
	{
		HashMap map = setParameter(request);
		
		StringBuffer sb = new StringBuffer();
		
		Set s = map.keySet();
		Object[] arr = s.toArray();
		
		for(int i = 0 ; i < arr.length; i++)
		{
			sb.append("<input type=\"text\" name=\""+arr[i]+"\" value=\""+StringUtil.getInstance().nvl(map.get(arr[i]), "")+"\" />\n");
		}

		return sb.toString();
	}
}
