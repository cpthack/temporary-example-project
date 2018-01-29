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

import org.apache.ibatis.annotations.Select;

/**
 * <b>GeneralMapper.java</b></br>
 * 
 * <pre>
 * 支持直接sql的Mapper
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2018年1月29日 下午5:35:40
 * @since JDK 1.8
 */
@SuppressWarnings("rawtypes")
public interface GeneralMapper {
	
	@Select("${_parameter}")
	public List<Map> selectList(String selectList);
}
