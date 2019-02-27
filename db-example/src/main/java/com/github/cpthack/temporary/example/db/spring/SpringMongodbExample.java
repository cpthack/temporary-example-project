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

import org.springframework.util.CollectionUtils;

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
		
		SpringMongodbPlugin springMongodbPlugin = new SpringMongodbPlugin();
		springMongodbPlugin.setUri("mongodb://127.0.0.1:27017/admin");
		springMongodbPlugin.setUri("test");
		springMongodbPlugin.start();
		
		String collectionName = "test";
		CollectionExample saveCollection = new CollectionExample();
		saveCollection.setName("cpthack");
		saveCollection.setAge(18);
		saveCollection.setDescp("my name is cpthack.");
		SpringMongodbHelper.getInstance().insert(saveCollection, collectionName);// 插入数据
		System.out.println("插入数据成功，插入的_id=" + saveCollection.getId());
		
		// 查询某个对象
		List<CollectionExample> selectCollectionList = SpringMongodbHelper.getInstance().findByField("_id", saveCollection.getId(), CollectionExample.class);
		if (!CollectionUtils.isEmpty(selectCollectionList)) {
			System.out.println("查询数据成功，查询到的第一个_id=" + selectCollectionList.get(0).getId());
		}
		
		// 删除某个对象
		long delectCount = SpringMongodbHelper.getInstance().remove(saveCollection, collectionName);
		System.out.println("成功删除" + delectCount + "个数据.");
		
		// 具体优化扩展参考网络博客：https://blog.csdn.net/mazhen1991/article/details/78161784
	}
	
}
