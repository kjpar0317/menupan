package com.rusproject.common.util;

import java.util.Stack;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Object�몴占� JSON 占쎌굨占쎄묶嚥∽옙 �빊�뮆�젾占쎈퉸餓ο옙占쎈뼄. static 占쎈맙占쎈땾�몴占� 占쎄텢占쎌뒠占쎈퉸占쎄퐣 獄쏅뗀以� 占쎈쑅占쎈즲 占쎈┷�⑨옙,
 * instance�몴占� 筌띾슢諭억옙堉깍옙苑� �넫占� 占쎈쐭 占쎄쉭獄쏉옙占쎈립 占쎌긿占쎈�∽옙�뱽 筌욑옙占쎌젟占쎈퉸占쎄퐣 占쎈쑅占쎈즲 占쎈쭆占쎈뼄.
 *
 * ex) static
 * System.out.println( JSONUtil.toJSON( src ) );
 *
 * ex) instance)
 * JSONUtil ju = new JSONUtil( src )
 *                                  .setOutputType( OutputType.PRETTY )
 *                                  .setIndentSize( 2 )
 *                                  .setSerializeNull( true );
 * System.out.println( ju.toJSON() );
 *
 * @author cmpark
 *
*/
public class JSONUtil {
	private OutputType outputType = OutputType.DEFAULT;
	private boolean serializeNull = true;
	private boolean escapeHtmlChars = false;
	private int indentSize = 4;
	private Object src;
	
	public enum OutputType {
		/**
		 * 占쎈립餓κ쑴肉� 癰귣똻肉т빳占쏙옙�뼄.
		 */
		DEFAULT,
		/**
		 * 占쎈뼊占쎌뵬 揶쏆빘猿쒙옙�뮉 占쎈립餓κ쑴肉�, array 占쎌뒄占쎈꺖占쎈굶占쏙옙 占쎈뼄�몴紐꾩Ø占쎈퓠 癰귣똻肉т빳占쏙옙�뼄.
		 */
		ARRAY,
		/**
		 * 筌ㅼ뮆占쏙옙釉� 餓κ쑬而�饔낅뜆�뱽占쎈퉸占쎄퐣 癰귣똻肉т빳占쏙옙�뼄.
		 */
		PRETTY;
	}

	public JSONUtil() {
	}
	
	public JSONUtil(Object src) {
		this.src = src;
	}

	public void setJSONObj(Object src) {
		this.src = src;
	}
	
	public static String toJSON(Object src) {
		return toJSON(src, OutputType.DEFAULT);
	}

	public static String toJSON(Object src, boolean escapeHtmlChars) {
		return toJson(src, OutputType.DEFAULT, escapeHtmlChars);
	}

	public static String toJSON(Object src, OutputType outputType) {
		JSONUtil util = new JSONUtil(src);
		util.setOutputType(outputType);
		return util.toJson();
	}

	public static String toJson(Object src, OutputType outputType, boolean escapeHtmlChars) {
		JSONUtil util = new JSONUtil(src);
		util.setOutputType(outputType);
		util.setEscapeHtmlChars(escapeHtmlChars);
		return util.toJson();
	}

	public String toJson() {
		GsonBuilder gb = new GsonBuilder();

		if( !this.escapeHtmlChars ) {
			gb.disableHtmlEscaping();
		}

		if (this.serializeNull)
			gb.serializeNulls();

		Gson gson = gb.create();

		String output = gson.toJson(src);

		switch (this.outputType) {
			default:
			case DEFAULT:
				return output;
			case ARRAY:
				return arrayPrint(output);
			case PRETTY:
				return prettyPrint(output);
		}
	}

	/**
	 * �빊�뮆�젾 野껉퀗�궢�몴占� 占쎈선占쎈섯野껓옙 癰귣똻肉т빳袁⑼옙 野껉퀣�젟占쎈립占쎈뼄.
	 *
	 * @see OutputType
	 *
	 * @param outputType
	 * @return
	 */
	 public JSONUtil setOutputType(OutputType outputType) {
		this.outputType = outputType;
		return this;
	}


	public JSONUtil setSerializeNull(boolean serializeNull) {
		this.serializeNull = serializeNull;
		return this;
	}


	public JSONUtil setIndentSize(int indentSize) {
		this.indentSize = indentSize;
		return this;
	}

	public JSONUtil setEscapeHtmlChars(boolean escapeHtmlChars) {
		this.escapeHtmlChars = escapeHtmlChars;
		return this;
	}

	private String prettyPrint(String output) {
		StringBuilder ret = new StringBuilder();
		StringBuffer leading = new StringBuffer("\n");

		for (int n = 0; n < output.length(); ++n) {
			char c = output.charAt(n);
			if (c == '{' || c == '[') {
				leading.append("    ");
				ret.append(c);
				ret.append(leading);
			} else if (c == '}' || c == ']') {
				leading.delete(leading.length() - indentSize, leading.length());
				ret.append(leading);
				ret.append(c);
			} else if (c == ',') {
				ret.append(c);
				ret.append(leading);
			} else {
				ret.append(c);
			}
		}
		return ret.toString();
	}

	private String arrayPrint(String output) {
		StringBuilder ret = new StringBuilder();
		StringBuffer leading = new StringBuffer("\n");
		Stack<Character> stack = new Stack<Character>();

		for (int n = 0; n < output.length(); ++n) {
			char c = output.charAt(n);

			if (c == '[') {
				stack.push(c);
				leading.append("    ");
				ret.append(c);
				ret.append(leading);
			} else if (c == '{') {
				stack.push(c);
				ret.append(c);
			} else if (c == ']') {
				stack.pop();
				leading.delete(leading.length() - indentSize, leading.length());
				ret.append(leading);
				ret.append(c);
			} else if (c == '}') {
				stack.pop();
				ret.append(c);
			} else if (stack.size() > 0 && stack.peek() == '[' && c == ',') {
				ret.append(c);
				ret.append(leading);
			} else {
				ret.append(c);
			}
		}

		return ret.toString();
	}
}


 
