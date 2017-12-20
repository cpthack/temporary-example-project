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

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import com.github.cpthack.temporary.file.RunningTimeCountHelper.Program;

/**
 * <b>FileWriteExample.java</b></br>
 * 
 * <pre>
 * 文件写操作 - 示例
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date Dec 20, 2017 12:28:36 AM
 * @since JDK 1.8
 */
public class FileWriteExample {
	
	public static void main(String[] args) throws Exception {
		RunningTimeCountHelper.run(new Program() {
			@Override
			public void run() {
				/**
				 * 普通4核8G机器上，大约需要耗费：1700s的时间
				 */
				String filePath = FileConstants.getFilePath();
				long lineCount = 10000 * 10000;// 总共写入1亿行数据
				long eachWriteNum = 10 * 10000;// 每次写入10W行
				createFile(filePath, lineCount, eachWriteNum);
			}
		});
		
	}
	
	/**
	 * 
	 * <b>createFile</b> <br/>
	 * <br/>
	 * 
	 * 随机内容生成指定行数的文件<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @param filePath
	 *            生成的目标文件的完整路径
	 * @param lineCount
	 *            生成文件的内容行数
	 * @param eachWriteNum
	 *            每次写入数据行数
	 */
	public static void createFile(String filePath, long lineCount, long eachWriteNum) {
		File file = new File(FileConstants.getFilePath());
		if (!file.exists()) {
			try {
				file.createNewFile();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		Path path = Paths.get(FileConstants.getFilePath());
		List<String> list = new ArrayList<String>();
		
		for (int i = 1; i <= lineCount; i++) {
			list.add(Math.random() + "");
			if (list.size() == eachWriteNum) {
				writeContentToFile(path, list);
			}
			if (i == lineCount) {
				writeContentToFile(path, list);
			}
			System.out.println("成功写入行数:i =" + i);
		}
	}
	
	// 往文件中以追加方式写入内容
	private static boolean writeContentToFile(Path path, List<String> contentList) {
		try {
			Files.write(path, contentList, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
			contentList.clear();
			return true;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
