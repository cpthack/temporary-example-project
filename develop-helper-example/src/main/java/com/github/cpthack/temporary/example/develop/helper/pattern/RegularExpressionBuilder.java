/**
 * Copyright (c) 2013-2020, cpthack 成佩涛 (1044559878@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.cpthack.temporary.example.develop.helper.pattern;

/**
 * <b>RegularExpressionBuilder.java</b></br>
 * 
 * <pre>
 * 常规正则表达式生成 - 辅助示例
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2018年1月9日 下午5:43:46
 * @since JDK 1.8
 */
public class RegularExpressionBuilder {
	private StringBuffer regexBuffer = null;
	
	public RegularExpressionBuilder() {
		regexBuffer = new StringBuffer();
	}
	
	/**
	 * 
	 * <b>append</b> <br/>
	 * <br/>
	 * 
	 * 自定义追加字符串<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @param str
	 *            追加的字符串
	 * @return RegularExpressionBuilder
	 *
	 */
	public RegularExpressionBuilder append(String str) {
		this.regexBuffer.append(str);
		return this;
	}
	
	/**
	 * 
	 * <b>IP</b> <br/>
	 * <br/>
	 * 
	 * 追加IP正则规则<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @return RegularExpressionBuilder
	 *
	 */
	public RegularExpressionBuilder IP() {
		this.regexBuffer.append("(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)");
		return this;
	}
	
	/**
	 * 
	 * <b>EMAIL</b> <br/>
	 * <br/>
	 * 
	 * 追加邮箱正则规则<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @return RegularExpressionBuilder
	 *
	 */
	public RegularExpressionBuilder EMAIL() {
		this.regexBuffer.append("\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}");
		return this;
	}
	
	/**
	 * 
	 * <b>MOBILE_PHONE</b> <br/>
	 * <br/>
	 * 
	 * 追加移动手机号码正则规则(国内)<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @return RegularExpressionBuilder
	 *
	 */
	public RegularExpressionBuilder MOBILE_PHONE() {
		this.regexBuffer.append("(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}");
		return this;
	}
	
	/**
	 * 
	 * <b>URL</b> <br/>
	 * <br/>
	 * 
	 * 追加网址URL正则规则<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @return RegularExpressionBuilder
	 *
	 */
	public RegularExpressionBuilder URL() {
		this.regexBuffer.append("(https|http|ftp|rtsp|mms){1}://.+\\.").append(ENGLISH().COUNT(3));
		return this;
	}
	
	/**
	 * 
	 * <b>ANY_CHAR</b> <br/>
	 * <br/>
	 * 
	 * 追加任意字符正则规则<br/>
	 * 匹配除换行符以外的任意字符
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @return RegularExpressionBuilder
	 *
	 */
	public RegularExpressionBuilder ANY_CHAR() {
		this.regexBuffer.append(".");
		return this;
	}
	
	/**
	 * 
	 * <b>ID_CARD_18</b> <br/>
	 * <br/>
	 * 
	 * 追加18位身份证正则规则<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @return RegularExpressionBuilder
	 *
	 */
	public RegularExpressionBuilder ID_CARD_18() {
		this.regexBuffer.append("(\\d{17}[\\d|x]|\\d{15})");
		return this;
	}
	
	/**
	 * 
	 * <b>IDFA</b> <br/>
	 * <br/>
	 * 
	 * 追加IDFA正则规则<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @return RegularExpressionBuilder
	 *
	 */
	public RegularExpressionBuilder IDFA() {
		this.regexBuffer.append("([0-9a-zA-Z]{1,})(([/\\s-][0-9a-zA-Z]{1,}){4})");
		return this;
	}
	
	/**
	 * 
	 * <b>CHINESE</b> <br/>
	 * <br/>
	 * 
	 * 追加中文正则规则<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @return RegularExpressionBuilder
	 *
	 */
	public RegularExpressionBuilder CHINESE() {
		this.regexBuffer.append("[\u4e00-\u9fa5]+");
		return this;
	}
	
	/**
	 * 
	 * <b>ENGLISH</b> <br/>
	 * <br/>
	 * 
	 * 追加英文正则规则<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @return RegularExpressionBuilder
	 *
	 */
	public RegularExpressionBuilder ENGLISH() {
		this.regexBuffer.append("[A-Za-z]");
		return this;
	}
	
	/**
	 * 
	 * <b>ENGLISH_AND_NUMBER</b> <br/>
	 * <br/>
	 * 
	 * 追加英文数字正则规则<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @return RegularExpressionBuilder
	 *
	 */
	public RegularExpressionBuilder ENGLISH_AND_NUMBER() {
		this.regexBuffer.append("[A-Za-z0-9]");
		return this;
	}
	
	/**
	 * 
	 * <b>NUMBER</b> <br/>
	 * <br/>
	 * 
	 * 追加数字的正则规则<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @return RegularExpressionBuilder
	 *
	 */
	public RegularExpressionBuilder NUMBER() {
		this.regexBuffer.append("\\d");
		return this;
	}
	
	/**
	 * 
	 * <b>MIN_COUNT</b> <br/>
	 * <br/>
	 * 
	 * 邻近的正则规则至少循环的次数<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @param num
	 *            规则循环的次数
	 * @return RegularExpressionBuilder
	 *
	 */
	public RegularExpressionBuilder MIN_COUNT(int num) {
		this.regexBuffer.append("{").append(num).append(",}");
		return this;
	}
	
	/**
	 * 
	 * <b>COUNT</b> <br/>
	 * <br/>
	 * 
	 * 邻近的正则规则刚好循环的次数<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @param num
	 *            规则循环的次数
	 * @return RegularExpressionBuilder
	 *
	 */
	public RegularExpressionBuilder COUNT(int num) {
		this.regexBuffer.append("{").append(num).append("}");
		return this;
	}
	
	/**
	 * 
	 * <b>BETWEENT_COUNT</b> <br/>
	 * <br/>
	 * 
	 * 邻近的正则规则循环在minNum到maxNum之间的次数<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @param minNum
	 *            规则循环的最小次数
	 * @param maxNum
	 *            规则循环的最大次数
	 * @return RegularExpressionBuilder
	 *
	 */
	public RegularExpressionBuilder BETWEENT_COUNT(int minNum, int maxNum) {
		this.regexBuffer.append("{").append(minNum).append(",").append(maxNum).append("}");
		return this;
	}
	
	/**
	 * 
	 * <b>LIKE</b> <br/>
	 * <br/>
	 * 
	 * 仿照sql中like语法追加规则<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @param keyword
	 * @return RegularExpressionBuilder
	 *
	 */
	public RegularExpressionBuilder LIKE(String keyword) {
		if (keyword.startsWith("%")) {
			keyword = keyword.replace("%", "");
			this.regexBuffer.append("^").append(keyword).append(".+");
			return this;
		}
		if (keyword.endsWith("%")) {
			keyword = keyword.replace("%", "");
			this.regexBuffer.append(".+").append(keyword).append("$");
			return this;
		}
		this.regexBuffer.append("(.+").append(keyword).append(".+)");
		return this;
	}
	
	@Override
	public String toString() {
		return regexBuffer.toString();
	}
}
