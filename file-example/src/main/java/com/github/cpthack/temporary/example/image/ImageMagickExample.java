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
package com.github.cpthack.temporary.example.image;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;

/**
 * <b>ImageMagickExample.java</b></br>
 * 
 * <pre>
 * 基于imageMagic的图像处理示例
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2018年1月11日 下午3:26:51
 * @since JDK 1.8
 */
public class ImageMagickExample {
	
	public static void main(String[] arg) throws Exception {
		IMOperation operation = new IMOperation();
		operation.addImage("C:\\Users\\Administrator\\Desktop\\1.1.png");
		operation.colorspace("GRAY");// 灰度化
		operation.monochrome();// 二值化
		
		ConvertCmd cmd = new ConvertCmd();
		//cmd.setSearchPath("C:\\Program Files\\ImageMagick-7.0.5-Q16");  // Windows需要设置，Linux不需要
		cmd.run(operation);
	}
}
