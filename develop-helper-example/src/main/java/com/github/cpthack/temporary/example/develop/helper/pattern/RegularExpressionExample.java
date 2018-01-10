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

import java.util.List;

/**
 * <b>RegularExpressionExample.java</b></br>
 * 
 * <pre>
 * 正则表达式操作示例
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2018年1月9日 下午6:11:01
 * @since JDK 1.8
 */
public class RegularExpressionExample {
	
	// 参考：http://tools.jb51.net/regex/create_reg
	// 一、常用元字符
	// 代码 说明
	// . 匹配除换行符以外的任意字符
	// \w 匹配字母或数字或下划线
	// \s 匹配任意的空白符
	// \d 匹配数字
	// \b 匹配单词的开始或结束
	// ^ 匹配字符串的开始
	// $ 匹配字符串的结束
	
	// 二、常用限定符
	// 代码/语法 说明
	// * 重复零次或更多次
	// + 重复一次或更多次
	// ? 重复零次或一次
	// {n} 重复n次
	// {n,} 重复n次或更多次
	// {n,m} 重复n到m次
	
	// 三、常用反义词
	// 代码/语法 说明
	// \W 匹配任意不是字母，数字，下划线，汉字的字符
	// \S 匹配任意不是空白符的字符
	// \D 匹配任意非数字的字符
	// \B 匹配不是单词开头或结束的位置
	// [^x] 匹配除了x以外的任意字符
	// [^aeiou] 匹配除了aeiou这几个字母以外的任意字符
	public static void main(String[] args) {
		/**
		 * 正则校验及提取
		 */
		System.out.println("=================正则校验及提取=================");
		RegularExpressionCheckAndExtractHelper regularExpressionCheckAndExtractHelper = new RegularExpressionCheckAndExtractHelper();
		List<String> extractKeyWords = regularExpressionCheckAndExtractHelper.extractKeyWords("dubbo-2.5.3.jar", "dubbo-.+\\.jar");
		for (String keyword : extractKeyWords) {
			System.out.println("提取关键字:" + keyword);
		}
		boolean isMatche = regularExpressionCheckAndExtractHelper.checkRegex("dubbo-2.5.3.jar", "dubbo-.+\\.jar");
		System.out.println("正则匹配结果:" + isMatche);
		
		/**
		 * 正则表达式生成
		 */
		System.out.println("=================正则表达式生成=================");
		String source = "192.168.225.255.我是中国人,/jb51@163.com/320102199002102937,CCD6E1CD-8C4B-40CB-8A62-4BBC7AFE07D6,18826410784,123,aBc,123Abc,http://www.baidu.com?name=cpthack#,1055669847";
		String regex = new RegularExpressionBuilder()
		        .IP()
		        .append(".")
		        .CHINESE()
		        .append(",/")
		        .EMAIL()
		        .append("/")
		        .ID_CARD_18()
		        .append(",")
		        .IDFA()
		        .append(",")
		        .MOBILE_PHONE()
		        .append(",")
		        .NUMBER().BETWEENT_COUNT(1, 3)// 1~3个数字
		        .append(",")
		        .ENGLISH().MIN_COUNT(1)// 至少1个英文字母
		        .append(",")
		        .ENGLISH_AND_NUMBER().MIN_COUNT(1)// 至少1个英文数字字符
		        .append(",")
		        .URL()
		        .append(",")
		        .QQ()
		        .create();
		
		// regex = new RegularExpressionBuilder().LIKE("Abc%").toString();//Like语法使用示例
		
		// regex = new RegularExpressionBuilder().URL().toString();//匹配URL
		// regularExpressionCheckAndExtractHelper.extractKeyWords(source, regex);
		
		System.out.println("字符串内容:" + source);
		System.out.println("生成的正则:" + regex);
		isMatche = regularExpressionCheckAndExtractHelper.checkRegex(source, regex);
		System.out.println("正则匹配结果:" + isMatche);
	}
}
