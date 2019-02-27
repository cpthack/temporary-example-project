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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.util.StringUtils;

import com.jfinal.plugin.IPlugin;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * <b>SpringMongodbPlugin.java</b></br>
 * 
 * <pre>
 * 基于springMongodb的JFinal插件
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date Feb 26, 2019 12:39:00 PM
 * @since JDK 1.8
 */
public class SpringMongodbPlugin implements IPlugin {
	
	private final static Logger	logger = LoggerFactory.getLogger(SpringMongodbPlugin.class);
	
	/**
	 * mongodb链接URI
	 */
	private String				uri;
	
	/**
	 * mongodb数据库名称
	 */
	private String				databaseName;
	
	@Override
	public boolean start() {
		if (StringUtils.isEmpty(uri) || StringUtils.isEmpty(databaseName)) {
			throw new IllegalArgumentException("the uri or databaseName is not allow empty.");
		}
		MongoDbFactory mongoDbFactory = dmpMongoDbFactory(this.uri, this.databaseName);
		MongoTemplate mongoTemplate = createMongoTemplate(mongoDbFactory);
		SpringMongodbHelper.init(mongoTemplate);
		logger.debug("spring mongodb plugin start successfully!");
		return true;
	}
	
	@Override
	public boolean stop() {
		return true;
	}
	
	public String getUri() {
		return uri;
	}
	
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public String getDatabaseName() {
		return databaseName;
	}
	
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	
	private MongoDbFactory dmpMongoDbFactory(String uri, String databaseName) {
		MongoClient mongoClient = new MongoClient(new MongoClientURI(uri));
		return new SimpleMongoDbFactory(mongoClient, databaseName);
	}
	
	private MongoTemplate createMongoTemplate(MongoDbFactory mongoDbFactory) {
		DefaultDbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
		MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, new MongoMappingContext());
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, converter);
		return mongoTemplate;
	}
	
}
