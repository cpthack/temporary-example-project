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
package com.github.cpthack.temporary.example.file;

/**
 * <b>FileCallBack.java</b></br>
 * 
 * <pre>
 * 文件读取callback接口
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2017年12月19日 下午2:56:53
 * @since JDK 1.8
 */
public interface FileCallBack<T> {
	
	void success(T t);
}
