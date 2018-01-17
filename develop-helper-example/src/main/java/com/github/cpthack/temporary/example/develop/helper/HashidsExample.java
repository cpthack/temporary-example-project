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
package com.github.cpthack.temporary.example.develop.helper;

import org.hashids.Hashids;

/**
 * <b>HashidsExample.java</b></br>
 * 
 * <pre>
 * 基于hashids的生成唯一hash值的示例
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2018年1月17日 下午6:14:52
 * @since JDK 1.8
 */
public class HashidsExample {
	
	// 参考示例: @link https://github.com/jiecao-fm/hashids-java
	public static void main(String[] args) {
		Hashids hashids = new Hashids("this is my salt");
		String hash = hashids.encode(683L, 94108L, 123L, 5L);
		System.out.println(hash);
	}
	
}
