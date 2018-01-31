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

import java.util.Map;

/**
 * <b>JsonPathRule.java</b></br>
 * 
 * <pre>
 * 基于jsonpath的规则实体对象
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2018年1月31日 下午5:43:10
 * @since JDK 1.8
 */
public class JsonPathRule {
	
	/**
	 * 获取目标总数jsonpath规则
	 */
	private String              targetDataCountRule;
	
	/**
	 * 目标数据子项的规则，key=目标子项名称，value=目标子项的jsonpath规则
	 */
	private Map<String, String> targetDataItemRule;
	
	public String getTargetDataCountRule() {
		return targetDataCountRule;
	}
	
	public void setTargetDataCountRule(String targetDataCountRule) {
		this.targetDataCountRule = targetDataCountRule;
	}
	
	public Map<String, String> getTargetDataItemRule() {
		return targetDataItemRule;
	}
	
	public void setTargetDataItemRule(Map<String, String> targetDataItemRule) {
		this.targetDataItemRule = targetDataItemRule;
	}
	
}
