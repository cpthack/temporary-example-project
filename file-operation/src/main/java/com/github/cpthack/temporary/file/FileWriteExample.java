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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

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
		File file = new File("/Users/cptahck/Desktop/demo.txt");
		if(!file.exists()){
			file.createNewFile();
		}
		Path path = Paths.get("/Users/cptahck/Desktop", "demo.txt");
		List<String> list = new ArrayList<String>();
		for(int i=1;i<100000;i++){
			list.add(0, i+"");
			Files.write(path, list, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
			System.out.println("insert success. i ="+i);
		}
	}
	
}
