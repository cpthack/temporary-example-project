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
package com.github.cpthack.temporary.example.json.jsonpath;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <b>JsonPathExample.java</b></br>
 * 
 * <pre>
 * 基于jsonpath的json操作示例
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2018年1月31日 下午5:38:49
 * @since JDK 1.8
 */
public class JsonPathExample {
	
	/**
	 * 参考示例:http://blog.csdn.net/koflance/article/details/63262484
	 */
	public static void main(String[] args) throws Exception {
		JsonPathExample jsonPathExample = new JsonPathExample();
		//jsonPathExample.example1();// 示例1
		//jsonPathExample.example2();// 示例2
		jsonPathExample.example3();// 示例3
	}
	
	public void example1() {
		
		URL jsonUrl = Thread.currentThread().getContextClassLoader().getResource("exampleJson/offer.json");
		
		JsonPathRule jsonPathRule = new JsonPathRule();
		jsonPathRule.setTargetDataCountRule("$.*");
		Map<String, String> targetDataItemRule = new HashMap<String, String>();
		targetDataItemRule.put("name", "$.[$i].name");// $i可以在遍历时可以被替换成数字
		targetDataItemRule.put("age", "$.[$i].age");// $i可以在遍历时可以被替换成数字
		jsonPathRule.setTargetDataItemRule(targetDataItemRule);
		
		List<Map<String, Object>> targetDataList = JsonPathHelper.getInstance().getTargetDataByRule(jsonPathRule, jsonUrl);
		
		// 遍历结果集
		for (Map<String, Object> targetDataItemMap : targetDataList) {
			for (Entry<String, Object> itemRule : targetDataItemMap.entrySet()) {
				System.out.println("key=[" + itemRule.getKey() + "],value=[" + itemRule.getValue() + "]");
			}
		}
	}
	
	public void example2() {
		
		URL jsonUrl = Thread.currentThread().getContextClassLoader().getResource("exampleJson/long_text_2018-01-30.txt");
		
		JsonPathRule jsonPathRule = new JsonPathRule();
		jsonPathRule.setTargetDataCountRule("$.*");
		Map<String, String> targetDataItemRule = new HashMap<String, String>();
		targetDataItemRule.put("name", "$.[?(@._nodeName=='name')]._value");// $i可以在遍历时可以被替换成数字
		targetDataItemRule.put("description", "$.[?(@._nodeName=='description')]._value");// $i可以在遍历时可以被替换成数字
		targetDataItemRule.put("payouts", "$.[?(@._nodeName=='payouts')].items[0]._value");// $i可以在遍历时可以被替换成数字
		jsonPathRule.setTargetDataItemRule(targetDataItemRule);
		
		List<Map<String, Object>> targetDataList = JsonPathHelper.getInstance().getTargetDataByRule(jsonPathRule, jsonUrl);
		
		// 遍历结果集
		for (Map<String, Object> targetDataItemMap : targetDataList) {
			for (Entry<String, Object> itemRule : targetDataItemMap.entrySet()) {
				System.out.println("key=[" + itemRule.getKey() + "],value=[" + itemRule.getValue() + "]");
			}
		}
	}
	
	public void example3() {
		
		URL jsonUrl = Thread.currentThread().getContextClassLoader().getResource("exampleJson/offers.json");
		
		JsonPathRule jsonPathRule = new JsonPathRule();
		jsonPathRule.setTargetDataCountRule("$..*");
		Map<String, String> targetDataItemRule = new HashMap<String, String>();
		targetDataItemRule.put("name", "$[$i].[?(@._nodeName=='name')]._value");// $i可以在遍历时可以被替换成数字
		targetDataItemRule.put("description", "$[$i].[?(@._nodeName=='description')]._value");// $i可以在遍历时可以被替换成数字
		targetDataItemRule.put("payouts", "$[$i].[?(@._nodeName=='payouts')].items[0]._value");// $i可以在遍历时可以被替换成数字
		jsonPathRule.setTargetDataItemRule(targetDataItemRule);
		
		List<Map<String, Object>> targetDataList = JsonPathHelper.getInstance().getTargetDataByRule(jsonPathRule, jsonUrl);
		
		// 遍历结果集
		for (Map<String, Object> targetDataItemMap : targetDataList) {
			for (Entry<String, Object> itemRule : targetDataItemMap.entrySet()) {
				System.out.println("key=[" + itemRule.getKey() + "],value=[" + itemRule.getValue() + "]");
			}
		}
	}
	
}
