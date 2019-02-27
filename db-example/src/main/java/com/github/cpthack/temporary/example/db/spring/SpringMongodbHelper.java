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
package com.github.cpthack.temporary.example.db.spring;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * <b>MongodbHelper.java</b></br>
 * 
 * <pre>
 * mongodb操作工具辅助类
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date Feb 26, 2019 12:44:07 PM
 * @since JDK 1.8
 */
public class SpringMongodbHelper {
	
	private MongoTemplate			   mongoTemplate = null;
	private static SpringMongodbHelper instance		 = null;
	
	private SpringMongodbHelper() {
	}
	
	/**
	 * 
	 * <b>init</b> <br/>
	 * <br/>
	 * 
	 * 初始化mongoTemplate对象<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @param mongoTemplate
	 *
	 */
	public static void init(MongoTemplate mongoTemplate) {
		synchronized (SpringMongodbHelper.class) {
			if (instance == null) {
				instance = new SpringMongodbHelper();
				instance.setMongoTemplate(mongoTemplate);
			}
		}
	}
	
	/**
	 * 
	 * <b>getInstance</b> <br/>
	 * <br/>
	 * 
	 * 单例方式获取mongodb辅助操作工具类<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @return SpringMongodbHelper
	 *
	 */
	public static SpringMongodbHelper getInstance() {
		if (instance == null) {
			throw new RuntimeException("pleace init mongoDbPlugin before use this.");
		}
		return instance;
	}
	
	// TODO 继续扩展增删改查的方法
	// TODO ....
	
	// 插入数据
	public void insert(Object objectToSave, String collectionName) {
		this.mongoTemplate.insert(objectToSave, collectionName);
	}
	
	// 根据单个简单字段查询数据
	public <T> List<T> findByField(String fieldName, Object fieldValue, Class<T> entityClass) {
		return this.mongoTemplate.find(new Query(Criteria.where(fieldName).is(fieldValue)), entityClass);
	}
	
	// 删除某个对象
	public long remove(Object object, String collectionName) {
		return this.mongoTemplate.remove(object, collectionName).getDeletedCount();
	}
	
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}
	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
}
