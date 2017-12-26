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

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

/**
 * <b>ClassLocationHelper.java</b></br>
 * 
 * <pre>
 * 定位运行期Class的所在位置
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date Dec 25, 2017 10:54:48 PM
 * @since JDK 1.8
 */
public class ClassLocationHelper {
	
	public static void main(String[] args) {
		ClassLocationHelper classLocationHelper = new ClassLocationHelper();
		String classLocation = classLocationHelper.where(java.io.File.class);
		System.out.println(classLocation);
	}
	
	/**
	 * 
	 * <b>where</b> <br/>
	 * <br/>
	 * 
	 * 查找类所在位置<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @param classz
	 *            待查找的类
	 * @return String
	 *
	 */
	@SuppressWarnings("rawtypes")
	public String where(final Class classz) {
		if (classz == null)
			throw new IllegalArgumentException("The class is not allowed null!");
		URL result = null;
		final String clsAsResource = classz.getName().replace('.', '/').concat(".class");
		final ProtectionDomain pd = classz.getProtectionDomain();
		if (pd != null) {
			final CodeSource cs = pd.getCodeSource();
			if (cs != null)
				result = cs.getLocation();
			if (result != null) {
				if ("file".equals(result.getProtocol())) {
					try {
						if (result.toExternalForm().endsWith(".jar") || result.toExternalForm().endsWith(".zip"))
							result = new URL("jar:".concat(result.toExternalForm()).concat("!/").concat(clsAsResource));
						else if (new File(result.getFile()).isDirectory())
							result = new URL(result, clsAsResource);
					}
					catch (MalformedURLException ignore) {
					}
				}
			}
		}
		if (result == null) {
			final ClassLoader clsLoader = classz.getClassLoader();
			result = clsLoader != null ? clsLoader.getResource(clsAsResource) : ClassLoader.getSystemResource(clsAsResource);
		}
		return result.toString();
	}
	
}
