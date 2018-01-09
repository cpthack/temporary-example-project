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

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <b>RegularExpressionCheckAndExtractHelper.java</b></br>
 * 
 * <pre>
 * 正则表达式检查和提取辅助工具类
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date Jan 9, 2018 11:16:50 AM
 * @since JDK 1.8
 */
public class RegularExpressionCheckAndExtractHelper {
	
	/**
	 * 
	 * <b>extractKeyWords</b> <br/>
	 * <br/>
	 * 
	 * 正则提取关键字<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @param source
	 *            原始内容
	 * @param regex
	 *            正则表达式
	 * @return List<String>
	 *
	 */
	public List<String> extractKeyWords(String source, String regex) {
		List<String> keyWordList = new ArrayList<String>();
		Pattern pat = Pattern.compile(regex.toLowerCase());// 正则判断
		Matcher mc = pat.matcher(source.toLowerCase());// 条件匹配
		String keyWord = null;
		while (mc.find()) {
			keyWord = mc.group();// 提取关键字
			keyWordList.add(keyWord);
		}
		return keyWordList;
	}
	
	/**
	 * 
	 * <b>checkRegex</b> <br/>
	 * <br/>
	 * 
	 * 检查字符串是否匹配当前的正则表达式<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @param source
	 *            当前待匹配的字符串
	 * @param regex
	 *            当前待匹配的正则表达式
	 * @return boolean
	 *
	 */
	public boolean checkRegex(String source, String regex) {
		return Pattern.matches(regex, source);
	}
	
}
