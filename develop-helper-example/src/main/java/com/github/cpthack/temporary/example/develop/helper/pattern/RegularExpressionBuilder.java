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
	 * <b>ID</b> <br/>
	 * <br/>
	 * 
	 * 追加身份证规则<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @return RegularExpressionBuilder
	 *
	 */
	public RegularExpressionBuilder ID() {
		this.regexBuffer.append("(\\d{17}[\\d|x]|\\d{15})");
		return this;
	}
	
	/**
	 * 
	 * <b>IDFA</b> <br/>
	 * <br/>
	 * 
	 * 追加IDFA规则<br/>
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
	
	@Override
	public String toString() {
		return regexBuffer.toString();
	}
}
