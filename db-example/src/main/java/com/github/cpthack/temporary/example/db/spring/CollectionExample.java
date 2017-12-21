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

import org.bson.Document;

/**
 * <b>CollectionExample.java</b></br>
 * 
 * <pre>
 * mongo集合示例
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date Dec 21, 2017 5:08:49 PM
 * @since JDK 1.8
 */
@SuppressWarnings("serial")
public class CollectionExample extends Document{
	
	private String name;
	
	private int age;
	
	private String descp;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDescp() {
		return descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}
	
}
