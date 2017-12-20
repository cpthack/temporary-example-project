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
package com.github.cpthack.temporary.example.file;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <b>FileExtensionName.java</b></br>
 * 
 * <pre>
 * 文件扩展名操作 - 示例
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2017年12月20日 下午4:05:53
 * @since JDK 1.8
 */
public class FileExtensionName {
	
	private final static String SUFFIXES = "avi|mpeg|3gp|mp3|mp4|wav|jpeg|gif|jpg|png|apk|exe|pdf|rar|zip|docx|doc";
	
	/**
	 * 
	 * <b>getFromFileName</b> <br/>
	 * <br/>
	 * 
	 * 根据文件名称获取扩展名<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @param fileName
	 *            文件名称
	 * @return String
	 *
	 */
	public static String getFromFileName(String fileName) {
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		return suffix;
	}
	
	/**
	 * 
	 * <b>getFromUrl</b> <br/>
	 * <br/>
	 * 
	 * 根据远程URL地址获取文件扩展名<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @param url
	 *            文件远程下载地址
	 * @return String
	 *
	 */
	public static String getFromUrl(String url) {
		Pattern pat = Pattern.compile("[\\w]+[\\.](" + SUFFIXES + ")");// 正则判断
		Matcher mc = pat.matcher(url);// 条件匹配
		String fileName = null;
		while (mc.find()) {
			fileName = mc.group();// 截取文件名后缀名
			break;
		}
		if (null == fileName) {
			return null;
		}
		return getFromFileName(fileName);
	}
	
	public static void main(String[] args) {
		String url = "http://codrim-dev.oss-cn-shenzhen.aliyuncs.com/testIMG/20171208/temp.jpg#-=13?name=123213";
		String extensionName = null;
		extensionName = getFromUrl(url);
		System.out.println("extensionName =[" + extensionName + "]");
		
		String fileName = "cpthack.xlsx";
		extensionName = getFromFileName(fileName);
		System.out.println("extensionName =[" + extensionName + "]");
	}
	
}
