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
package com.github.cpthack.temporary.file;

/**
 * <b>FileConstants.java</b></br>
 * 
 * <pre>
 * 文件操作常量类
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2017年12月20日 上午11:28:35
 * @since JDK 1.8
 */
public class FileConstants {
	
//	private final static String FILE_PATH = "/Users/cptahck/Desktop/demo.txt";
	private final static String FILE_PATH = "C:/Users/Administrator/Desktop/info09_1.txt";
//	private final static String FILE_PATH = "C:/Users/Administrator/Desktop/line.log";
//	private final static String FILE_PATH = "C:/Users/Administrator/Desktop/line-129393969.log";
//	private final static String FILE_PATH = "C:/Users/Administrator/Desktop/new.log";
	
	public static String getFilePath() {
		return FILE_PATH;
	}
	
}
