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
package com.github.cpthack.temporary.example.db.jfinal;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.c3p0.C3p0Plugin;

/**
 * <b>JFinalMysqlExample.java</b></br>
 * 
 * <pre>
 * 基于jfinal的db操作 - 示例
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2017年12月20日 下午6:31:15
 * @since JDK 1.8
 */
public class JFinalMysqlExample {
	
	public static void main(String[] args) {
		/**
		 * 启动数据库插件
		 */
		String jdbcUrl = "jdbc:mysql://192.168.1.3:3306/test?characterEncoding=UTF-8";
		String userName = "root";
		String password = "123456";
		String driverClass = "com.mysql.jdbc.Driver";
		C3p0Plugin jdbcPlugin = new C3p0Plugin(jdbcUrl, userName, password, driverClass);
		jdbcPlugin.start();
		
		String configName = "test";
		
		ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(configName, jdbcPlugin);
		activeRecordPlugin.start();
		
		Record user = Db.use(configName).findFirst("select * from user");
		System.out.println("username = " + user.getStr("username"));
		
	}
	
}
