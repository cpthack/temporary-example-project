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
package com.github.cpthack.temporary.example.company.codrim.bbs;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>DataDictSqlCreateExample.java</b></br>
 * 
 * <pre>
 * 数据字典表SQL生成
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2017年12月27日 下午5:53:25
 * @since JDK 1.8
 */
public class DataDictSqlCreateExample {
	
	/**
	 * SQL模板内容
	 */
	private static String DEFAULT_SQL_TEMPLATE = ""
	                                                   + "SET @type=8;\n"
	                                                   + "SET @name='$name';\n"
	                                                   + "INSERT INTO `community_data_dict`(`NAME`, `CODE`, `TYPE`)\n"
	                                                   + "VALUES(@name, CONCAT(@type,'-',(LAST_INSERT_ID()+1)),@type);\n";
	
	public static void main(String[] args) throws Exception {
		
		/**
		 * 示例文件：src/main/resources/vertical整理20171227.xlsx.<br/>
		 * 1、先把文件导入到数据库中以临时表形式保存数据.<br/>
		 * 2、导出标准化后的字段列表到新的文件temp-offers-kinds.txt，示例文件在src/main/resources下<br/>
		 * 3、执行以下程序生成SQL文件并执行（需要跳过异常，插入时可能存在重复项）.<br/>
		 * 4、执行以下SQL来进行映射表的插入数据.<br/>
		 * INSERT INTO community_standard_field_mapping (identification_id, rules,type) <br/>
		 * SELECT b.id,a.source_kinds,b.type FROM `temp-offers-kinds` a,community_data_dict b <br/>
		 * WHERE a.new_kinds = b.`name` AND b.type=8; <br/>
		 * 5、完毕.
		 */
		String importFilePath = "C:/Users/Administrator/Desktop/temp-offers-kinds.txt";
		File importFile = new File(importFilePath);
		if (!importFile.exists()) {
			importFile.createNewFile();
		}
		Path importPath = Paths.get(importFilePath);
		List<String> importStrList = Files.readAllLines(importPath);
		
		String exportFilePath = "C:/Users/Administrator/Desktop/dataDictSql.txt";
		File exportFile = new File(exportFilePath);
		if (!exportFile.exists()) {
			exportFile.createNewFile();
		}
		Path exportPath = Paths.get(exportFilePath);
		List<String> contentList = new ArrayList<String>();
		
		for (String importStr : importStrList) {
			contentList.add(DEFAULT_SQL_TEMPLATE.replace("$name", importStr));
		}
		
		Files.write(exportPath, contentList, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
	}
}
