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

import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.stream.Stream;

/**
 * <b>LineNumberReaderExample.java</b></br>
 * 
 * <pre>
 * 按行读取文本文件 - 示例操作
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2017年12月19日 下午2:08:56
 * @since JDK 1.8
 */
public class LineNumberReaderExample {
	
	// 统计文件的行数
	public long countFromFile(String filePath) {
		try (
		        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(filePath))) {
			 lineNumberReader.skip(Long.MAX_VALUE);// 跳过的字符数
			 long lineCount = lineNumberReader.getLineNumber();
			return lineCount;
			
			//return lineNumberReader.lines().count();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0L;
	}
	
	// 逐行读取文本
	public void readFromFile(String filePath, FileCallBack fileCallBack) {
		try (
		        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(filePath))) {
			// lineNumberReader.setLineNumber(2);// 指定开始读取的行数，当指定行数超过总行数时，会接着从头开始计算
			String line = null;
			while ((line = lineNumberReader.readLine()) != null) {
				fileCallBack.success("line " + lineNumberReader.getLineNumber() + ": " + line);
				if (lineNumberReader.getLineNumber() == 10) {
					break;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 指定特定行读取文本
	public void readFromFileOfLine(String filePath, int start, FileCallBack fileCallBack) {
		try (
		        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(filePath))) {
			Stream<String> stringStream = lineNumberReader.lines();
//			boolean isMatch = stringStream.anyMatch(new Predicate<String>() {
//				
//				@Override
//				public boolean test(String t) {
//					return t.contains("111") || t.contains("22222");
//				}
//				
//			});
//			System.out.println(isMatch);
			
//			System.out.println(stringStream.skip(start).findFirst().get());
			System.out.println(stringStream.skip(1000000).limit(10).iterator().next());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		LineNumberReaderExample lineNumberReader = new LineNumberReaderExample();
//		String filePath = "C:/Users/Administrator/Desktop/info09_1.txt";
		String filePath = "/Users/cptahck/Desktop/demo.txt";
		
		/**
		 * 测试获取文件总行数
		 */
		//long lineCount = lineNumberReader.countFromFile(filePath);
		//System.out.println("总行数:" + lineCount);
		
		/**
		 * 测试逐行读取文本
		 */
//		System.out.println("文本中的内容:");
//		lineNumberReader.readFromFile(filePath, new FileCallBack() {
//			@Override
//			public void success(String str) {
//				System.out.println(str);
//			}
//		});
		
		/**
		 * 测试
		 */
		lineNumberReader.readFromFileOfLine(filePath, 2, null);
	}
	
}
