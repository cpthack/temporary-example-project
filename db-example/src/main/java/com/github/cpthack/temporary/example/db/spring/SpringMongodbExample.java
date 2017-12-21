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

import java.util.HashMap;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * <b>SpringMongodbExample.java</b></br>
 * 
 * <pre>
 * 基于springdatamongo的MongoTemplate - 示例
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date Dec 21, 2017 2:25:57 AM
 * @since JDK 1.8
 */
public class SpringMongodbExample {
	
	public static void main(String[] args) {
		String uri = "mongodb://online.test.com:27017/admin";
		String databaseName = "test";
		
		SpringMongodbExample springMongodbExample = new SpringMongodbExample();
		MongoDbFactory mongoDbFactory = springMongodbExample.dmpMongoDbFactory(uri,databaseName);
		MongoTemplate mongoTemplate = springMongodbExample.createMongoTemplate(mongoDbFactory);
		
		CollectionExample  collection  = new CollectionExample();
		collection.setName("cpthack");
		collection.setAge(18);
		collection.setDescp("my name is cpthack.");
		mongoTemplate.save(collection,"test");
		System.out.println(collection.get("_id"));
		
	}
	
	public MongoDbFactory dmpMongoDbFactory(String uri,String databaseName){
		MongoClient mongoClient = new MongoClient(new MongoClientURI(uri));
		return new SimpleMongoDbFactory(mongoClient, databaseName);
	}
	
	public MongoTemplate createMongoTemplate(MongoDbFactory mongoDbFactory){
		DefaultDbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
		MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, new MongoMappingContext());
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, converter);
		return mongoTemplate;
	}
	
}
