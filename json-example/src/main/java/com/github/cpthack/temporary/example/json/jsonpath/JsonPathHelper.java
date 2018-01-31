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

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

/**
 * <b>JsonPathHelper.java</b></br>
 * 
 * <pre>
 * 基于jsonpath的json解析辅助工具类
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2018年1月31日 下午5:47:58
 * @since JDK 1.8
 */
public class JsonPathHelper {
	private final static JsonPathHelper jsonPathHelper = new JsonPathHelper();
	
	private JsonPathHelper() {
	}
	
	public static JsonPathHelper getInstance() {
		return jsonPathHelper;
	}
	
	public List<Map<String, Object>> getTargetDataByRule(JsonPathRule jsonPathRule, URL json) {
		ReadContext context = null;
		try {
			context = JsonPath.parse(json);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return getTargetData(jsonPathRule, context);
	}
	
	public List<Map<String, Object>> getTargetDataByRule(JsonPathRule jsonPathRule, File json) {
		ReadContext context = null;
		try {
			context = JsonPath.parse(json);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return getTargetData(jsonPathRule, context);
	}
	
	public List<Map<String, Object>> getTargetDataByRule(JsonPathRule jsonPathRule, String json) {
		ReadContext context = JsonPath.parse(json);
		return getTargetData(jsonPathRule, context);
	}
	
	@SuppressWarnings("rawtypes")
	private List<Map<String, Object>> getTargetData(JsonPathRule jsonPathRule, ReadContext context) {
		List<Map<String, Object>> targetDataList = new ArrayList<Map<String, Object>>();
		
		int targetDataCount = ((List) context.read(jsonPathRule.getTargetDataCountRule())).size();// 获取目标数据总数
		if (targetDataCount <= 0) {
			System.out.println("targetDataCount<=0,查询不到数据.");
			return targetDataList;
		}
		
		Map<String, Object> targetDataMap = null;
		String targetDataMapKey = null;
		String targetDataMapValue = null;
		for (int i = 0; i < targetDataCount; i++) {
			targetDataMap = new HashMap<String, Object>();
			
			for (Entry<String, String> itemRule : jsonPathRule.getTargetDataItemRule().entrySet()) {
				targetDataMapKey = itemRule.getKey();
				targetDataMapValue = context.read(itemRule.getValue().replace("$i", i + "")).toString();
				targetDataMap.put(targetDataMapKey, targetDataMapValue);
			}
			
			targetDataList.add(targetDataMap);
		}
		return targetDataList;
	}
}
