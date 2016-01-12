package com.rusproject.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class StringUtil 
{
	private static StringUtil __stringUtil= null;
	
	public StringUtil()
	{
	}
	
	public static StringUtil getInstance()
	{
		if(__stringUtil == null)
		{
			__stringUtil = new StringUtil();
		}
		
		return __stringUtil;
	}
	
	public String replaceHTML(String src)
	{
		if( src != null )
			return src.replaceAll("\'", "&#39;");
		else
			return src;
	}
	
	/**
	 * HTML���� �±� �κ��� ������ ������ ������ �Լ�
	 * @param src
	 * @return
	 */
	public static String stripHTML(String src)
	{
		if( src != null )
			src = src.replaceAll("\\<.*?\\>", "");
		else
			src = "";
		
		return src;
	}
	
	// :���� �����ϰ� ;���� ������ absolute�ױ׸� relative�� ��ȯ�ϱ� ����.
	public String getTagReplace(String src, String from, String to) 
	{
		if (src == null) return null;
		if (from == null)return src;
		if (to == null)	 to = "";
		
		StringBuffer buf = new StringBuffer();
		
		for (int pos;(pos = src.indexOf(from)) >= 0;) 
		{
			boolean check = true;
			String fSrc = src.substring(0, src.indexOf(from)).trim();
			
			if(fSrc.lastIndexOf(":") != fSrc.length()-1) check = false;
			if(src.substring(src.indexOf(from)+from.length()).trim().indexOf(";") != 0) check = false;
			
			if(check){
				buf.append(src.substring(0, pos));
				buf.append(to);
				src = src.substring(pos + from.length());
			}else{
				buf.append(src.substring(0, pos));
				buf.append(from);
				src = src.substring(pos + from.length());
			}
		}
		
		buf.append(src);
		
		return buf.toString();
	}
	
	public String getReplace(String src, String from, String to) 
	{
		if (src == null) return null;
		if (from == null)return src;
		if (to == null)	 to = "";
		
		StringBuffer buf = new StringBuffer();
		
		for (int pos;(pos = src.indexOf(from)) >= 0;) 
		{
			buf.append(src.substring(0, pos));
			buf.append(to);
			src = src.substring(pos + from.length());
		}
		
		buf.append(src);
		
		return buf.toString();
	}

	public String dotString(String value, int size)
	{
		if(value.length() > size)
		{
			value = value.substring(0, size)+"...";
		}
		
		return value;
	}
	
	public String dotString(Object value, int size)
	{
		return dotString(value == null ? "" : value.toString(), size);
	}
	
	public int parseInt(Object obj, int nvl)
	{
		return parseInt(obj == null ? "" : obj.toString(), nvl);
	}
	
	public float parseFloat(Object obj, float nvl)
	{
		return parseFloat(obj == null ? "" : obj.toString(), nvl);
	}
	
	public float parseFloat(String str, float nvl)
	{
		return ("".equals(str) || null == str) ? nvl : Float.parseFloat(str);
	}
	
	public int parseInt(String str, int nvl)
	{
		return ("".equals(str) || null == str) ? nvl : Integer.parseInt(str);
	}
	
	public String nvl(Object obj, Object replace)
	{
		return obj == null ? replace.toString() : obj.toString();
	}
	
	public String nvl(Object obj, String replace)
	{
		return obj == null ? replace : obj.toString();
	}
	
    public static String nvl(String str)
    {
        return (str == null) ? "" : str;
    }

    public static String nvl2(Object obj, String replace)
    {
        return (obj == null) ? replace : obj.toString();
    }    

    public static String nvl2(String str, String replace)
    {
        return (str == null || "".equals(str)) ? replace : str;
    }
    
    
	public String nvl(String str, String replace)
	{
		return (str == null || "".equals(str)) ? replace : str;
	}
	
	public int nvl(String str , int replace)
	{
		return str == null ? replace : Integer.parseInt(str);
	}
	
	@SuppressWarnings("unused")
	private Object[] keyNames(@SuppressWarnings("rawtypes") HashMap map)
	{
		return map.keySet().toArray();
	}
	
	/**
	 * filename ���� Ȯ���ڸ� ext�� �����Ѵ�
	 * @param filename
	 * @param ext
	 * @return
	 */
	public String changeExtension(String filename, String ext)
	{
		String strNewFilename = filename;
		if(filename != null)
		{
			int index = filename.lastIndexOf(".");
			if( index >=0 && index < filename.length() )
				strNewFilename = filename.substring(0, index+1) + ext;
		}
		
		return strNewFilename;
	}

	public String SLASH_DELIMITER = "/";
	public String BACK_SLASH_DELIMITER = "\\";
	
	public String getFileSeparator()
	{
		String fileSeparator = System.getProperty("file.separator");
		if(fileSeparator == null)
			fileSeparator = SLASH_DELIMITER;
		
		return fileSeparator;
	}

	/**
	 * URL�̳� File �� path ���� filename ���� path �� ã�Ƽ� �������ش�
	 * @param fullPath
	 * @return
	 */
	public String getPath(String fullPath)
	{
		String path = fullPath;
		if(fullPath != null)
		{
			int index = fullPath.lastIndexOf(BACK_SLASH_DELIMITER);
			if( index >=0 && index < fullPath.length() )
				path = fullPath.substring(0, index);
		}
		return path;
	}


	/**
	 * URL�̳� File �� path ���� filename �� ã�Ƽ� �������ش�
	 * @param fullPath
	 * @return
	 */
	public String getFilename(String fullPath)
	{
		return getFilename( fullPath, getFileSeparator() );
	}
	
	/**
	 * URL�̳� File �� path ���� filename �� ã�Ƽ� �������ش�
	 * @param fullPath
	 * @param delimiter
	 * @return
	 */
	public String getFilename(String fullPath, String delimiter)
	{
		String filename = fullPath;
		if(fullPath != null)
		{
			int index = fullPath.lastIndexOf(delimiter);
			if( index >=0 && index < fullPath.length() )
				filename = fullPath.substring(index+1, fullPath.length());
		}
		return filename;
	}
	
	/**
	 * filename ���� Ȯ���ڸ� �߶� �����Ѵ�
	 * @param filename
	 * @return
	 */
	public static String getExtension(String filename)
	{
		String extension = "";
		if( filename != null )
		{
			int index = filename.lastIndexOf(".");
			if( index >=0 && index < filename.length() )
				extension = filename.substring(index+1, filename.length());
			
		}
		return extension;
	}
	
	public static void printHashMap(@SuppressWarnings("rawtypes") HashMap map)
	{
		@SuppressWarnings("rawtypes")
		Iterator iter = map.keySet().iterator();
		while(iter.hasNext())
		{
			String key = (String)iter.next();
			@SuppressWarnings("unused")
			String value = (String)map.get(key);
		}
	}
	
	public static String sqlInjection(String value)
	{
		if( value != null )
		{
//			value = value.replaceAll("'", "");
//			value = value.replaceAll("--", "");
//			value.replaceAll("@", "");
//			value = value.replaceAll("\\+", "");
//			value = value.replaceAll("%", "");
//			value = value.replaceAll("=", "");
//			value = value.replaceAll(";", "");
			value = value.replaceAll("[';\\-\\+%=;@]", "");
		}
		
		return value;
	}

	public static String xss(String value)
	{
		if( value != null )
		{
			value = value.replaceAll("<", "&lt;");
			value = value.replaceAll(">", "&gt;");
		}
		return value;
	}

	public static String xss2(String value)
	{
		if( value != null )
		{
			value = value.replaceAll("\\(", "&#40;");
			value = value.replaceAll("\\)", "&#41;");
			value = value.replaceAll("javascript:", "x-javascript:");
		}
		return value;
	}

	public String toDateString(Object year, Object month, Object day)
	{
		return toDateString(year==null?"":year.toString(), month==null?"":month.toString(), day==null?"":day.toString());
	}
	
	public String toDateString(Object year, Object month)
	{
		return toDateString(year==null?"":year.toString(), month==null?"":month.toString());
	}
	
	public String toDateString(String year, String month, String day)
	{
		return toDateString(year, month)+(day.length()==1?"0"+day:day);
	}
	
	public String toDateString(String year, String month)
	{
		if(year != null && month != null)
			return year+(month.length() == 1 ? "0"+month : month);
		else 
			return "";
	}
	
	public String toDateString(int year, int month, int day)
	{
		return toDateString(year+"", month+"", day+"");
	}
	
	public String toDateString(int year, int month)
	{
		return toDateString(year+"", month+"");
	}
	
	public boolean hasKorean(String suspect) {
		if( suspect == null )
			return false;
		
		for (int i = 0; i < suspect.length(); i++) {

			char c = suspect.charAt(i);

			// korean : one character (consonant or vowel)
			if ((0xAC00 <= c && c <= 0xD7A3) || (0x3131 <= c && c <= 0x318E)) {
				return true;
			} else if ((0x61 <= c && c <= 0x7A) || (0x41 <= c && c <= 0x5A)) {
				// english
			} else if (0x30 <= c && c <= 0x39) {
				// integer/decimal
			} else {
				// unknown
			}
		}

		return false;
	}
	
	public String textViewConvertString(String content)
	{
		while(content.indexOf("FONT-SIZE:") > -1)
		{
			String a = content.substring(0,content.indexOf("FONT-SIZE:"));
			String b = content.substring(content.indexOf("FONT-SIZE:")+10,content.length());
			
			content = a + b.substring(b.indexOf("pt;")+3,b.length());
		}
		
		if(content.indexOf("<BODY")>-1)
		{
			content = content.substring(content.indexOf("<BODY"),content.length());
			content = content.substring(content.indexOf(">")+1,content.length());
			content = content.substring(0,content.indexOf("</BODY>"));
		}

		content = content.trim();

		return content;
	}
	
	/**
	 * integer �� cipher �� �Է��� �ڸ����� ���߱� ���� �տ� 0�� �ٿ��� ��Ʈ������ ��ȯ
	 * @param value
	 * @param cipher
	 * @return
	 */
	public static String toZeroString(int value, int cipher)
	{
		String retValue = Integer.toString(value);
		int count = retValue.length();
		
		if(cipher > count)
		{
			for(int i=0; i<cipher-count; i++)
			{
				retValue = "0" + retValue;
			}
		}
		
		return retValue;
	}
	
	public String clobToString(Clob clob)
	{
		StringBuffer strOut = new StringBuffer();
		
		try
		{
			if(clob != null)
			{
				String str = "";
				
				BufferedReader br = new BufferedReader(clob.getCharacterStream());
				
				while ((str = br.readLine()) != null) 
				{
					strOut.append(str + "\n");
				}
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		// ���⼭ �۾�����
		String html = strOut.toString();
////		System.out.println("******************************************************************");
////		System.out.println("html = "+html);
//		List<String> list = URLUtil.getFiles(html);
//		for(String filename : list)
//		{
////			System.out.println("filename = "+filename);
//			if( hasKorean(filename) )
//			{
//				String result = filename;
//				result = result.replaceAll("%", "");
////				String result = StringUtil.encode(filename);
//				int index = html.indexOf(filename);
//				int len = filename.length();
//				String front = html.substring(0, index);
//				String end = html.substring(index+len, html.length());
//				html = front + result + end;
//			}
//		}
//		System.out.println("new html = "+html);
		return html;
	}
	
    /**
     * Method
     * 
     * @param sb
     * @param apStr
     */
    public static void appendSbln(StringBuffer sb,
                                      String apStr)
    {
        sb.append(apStr + "\n");
        return;
    }

    /**
     * Method
     * 
     * @param orgStr
     * @param addStr
     */
    public static void appendStrln(String orgStr,
                                   String addStr)
    {
        orgStr = orgStr + addStr + "\n";
    }

    /**
     * Method
     * 
     * @param str
     */
    public static String appendStrln(String str)
    {
        return str + "\n";
    }
	
    /**
     * Method
     * 
     * @param str
     * @return
     */
    public static boolean isNullAllCase(String str)
    {
        if(str == null)
            return true;
        str = str.trim();
        if(str.length() == 0)
            return true;
        if(str.equals(""))
            return true;
        if(str.equals("null"))
            return true;

        return false;
    }

    /**
     * Method
     * 
     * @param str
     * @return
     */
    public static boolean isNotNullAllCase(String str)
    {
        return !isNullAllCase(str);
    }
    
    /**
     * YYYY?MM?DD -> YYYYMMDD
     * 
     * @param str
     *            Target String
     * @param deli
     *            Delimiter
     * @return String
     * @throws Exception
     */
    public static String removeDelimiter(String str,
                                         String deli)
    {

        String sData = "";

        if(str == null || str.equals(""))
        {
            return sData;
        }
        
        StringTokenizer st = new StringTokenizer(str, deli);

        while(st.hasMoreTokens())
        {
            sData += st.nextToken();
        }

        return sData;
    }    
    

    /**
     * Method ���ڹ��ڿ� Comma�� ����
     * @param number Comma�� �Է��� ���� 
     * @return
     */
    public static String addComma(String number)
    {
        return addComma(number, 0);
    }

    

    /**
     * Method ���ڹ��ڿ� Comma�� ����
     * @param number 
     *         Comma�� �Է��� ���� 
     * @param p 
     *         �Ҽ��� ����
     * @return
     */
    public static String addComma(String number, int p)
    {
        String format = "#,###,###,##0";
        
        if(number == null || number.equals(""))
            return number;
        
        if(p > 0)
        {
            format += ".";
            for(int i = 0; i < p; i++)
                format += "0";
        }
        
        DecimalFormat df = new DecimalFormat(format);
        
        try
        {
            return df.format(Double.parseDouble(number));
        }
        catch(Exception e)
        {
            return number;
        }
    }
    
    public static String getSysDate()
    {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd", java.util.Locale.KOREA);
        return formatter.format(new java.util.Date());
    }    
    
	/**
	���ڿ��� ������ ���ڿ��� ã�Ƽ� ���ο� ���ڿ��� �ٲٴ� �Լ�
	origianl	��� ���ڿ�
	oldstr		ã�� ���ڿ�
	newstr		�ٲ� ���ڿ�
	return		�ٲ� ���
	*/
	public String replace(String original, String oldstr, String newstr)
	{
		String convert = new String();
		int pos = 0;
		int begin = 0;
		pos = original.indexOf(oldstr);
	
		if(pos == -1)
			return original;
	
		while(pos != -1)
		{
			convert = convert + original.substring(begin, pos) + newstr;
			begin = pos + oldstr.length();
			pos = original.indexOf(oldstr, begin);
		}
		convert = convert + original.substring(begin);
	
		return convert;
	}
	
	/**
		������ HTML ������ȣ�� ���ڸ� HTML Ư����ȣ �������� ��ȯ�մϴ�.
		htmlstr		�ٲ� ����� ���ڿ�
		return		�ٲ� ���
		PHP�� htmlspecialchars�� ������ ����� ��ȯ�մϴ�.
	*/
	public String convertHtmlchars(String htmlstr)
	{
		String convert = new String();
		convert = replace(htmlstr, "<", "&lt;");
		convert = replace(convert, ">", "&gt;");
		convert = replace(convert, "\"", "&quot;");
		convert = replace(convert, "&nbsp;", "&amp;nbsp;");
		return convert;
	}
}
