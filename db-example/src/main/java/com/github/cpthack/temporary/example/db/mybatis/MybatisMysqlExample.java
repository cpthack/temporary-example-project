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
package com.github.cpthack.temporary.example.db.mybatis;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * <b>MybatisMysqlExample.java</b></br>
 * 
 * <pre>
 * 基于mybatis框架的mysql操作示例
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2018年1月29日 下午3:16:18
 * @since JDK 1.8
 */
@SuppressWarnings("rawtypes")
public class MybatisMysqlExample {
	
	public DataSource getDataSource(String jdbcUrl, String userName, String password, String driverClass) {
		int maxPoolSize = 100;
		int minPoolSize = 10;
		int initialPoolSize = 10;
		int maxIdleTime = 20;
		int acquireIncrement = 2;
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setUser(userName);
		dataSource.setPassword(password);
		try {
			dataSource.setDriverClass(driverClass);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		dataSource.setMaxPoolSize(maxPoolSize);
		dataSource.setMinPoolSize(minPoolSize);
		dataSource.setInitialPoolSize(initialPoolSize);
		dataSource.setMaxIdleTime(maxIdleTime);
		dataSource.setAcquireIncrement(acquireIncrement);
		return dataSource;
	}
	
	// 参考文档:http://www.mybatis.org/mybatis-3/zh/getting-started.html
	public static void main(String[] args) {
		MybatisMysqlExample mybatisMysqlExample = new MybatisMysqlExample();
		
		// 初始化数据源
		String jdbcUrl = "jdbc:mysql://192.168.1.3:3306/test?characterEncoding=UTF-8";
		String userName = "root";
		String password = "123456";
		String driverClass = "com.mysql.jdbc.Driver";
		DataSource dataSource = mybatisMysqlExample.getDataSource(jdbcUrl, userName, password, driverClass);
		
		// 实例化SqlSessionFactory对象
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(UserMapper.class);
		configuration.addMapper(GeneralMapper.class);
		configuration.addLoadedResource("com/github/cpthack/temporary/example/db/mybatis/UserMapper.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		
		/**
		 * 使用Mapper查询测试
		 */
		try (SqlSession session = sqlSessionFactory.openSession();) {
			String mapperNamespace = UserMapper.class.getName();
			String mapperMethod = "selectList";
			String statement = mapperNamespace + "." + mapperMethod;
			List<User> userList = session.selectList(statement, null, new RowBounds(20, 10));
			for (User user : userList) {
				System.out.println("id=" + user.getId() + ",userName=" + user.getUsername());
			}
		}
		
		/**
		 * 直接SQL查询测试
		 */
		try (SqlSession session = sqlSessionFactory.openSession();) {
			GeneralMapper mapper = session.getMapper(GeneralMapper.class);
			List<Map> mapList = mapper.selectList("select * from user");
			for (Map map : mapList) {
				System.out.println("id=" + map.get("id"));
			}
		}
		
	}
}
