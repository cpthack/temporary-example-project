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

import net.coobird.thumbnailator.Thumbnails;

/**
 * <b>ThumbnailatorExample.java</b></br>
 * 
 * <pre>
 * 基于thumbnailator的图像处理操作示例
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2018年1月11日 下午3:39:46
 * @since JDK 1.8
 */
public class ThumbnailatorExample {
	
	// 参考: http://blog.csdn.net/chenleixing/article/details/44685817
	public static void main(String[] arg) throws Exception {
		String sourceImageFilePath = "C:\\Users\\Administrator\\Desktop\\1.png";
		String outputImageFilePath = "C:\\Users\\Administrator\\Desktop\\1.1.png";
		
		// 按指定大小把图片进行缩和放（会遵循原图高宽比例）
		// 变为600*300,遵循原图比例缩或放到400*某个高度
		Thumbnails.of(sourceImageFilePath).size(600, 300).toFile(outputImageFilePath);
		
		// 按照比例进行缩小和放大
		Thumbnails.of(sourceImageFilePath).scale(0.2f).toFile(outputImageFilePath);// 按比例缩小
		
		// 不按比例，就按指定的大小进行缩放
		Thumbnails.of(sourceImageFilePath).size(100, 100).keepAspectRatio(false).toFile(outputImageFilePath);
		// 或者Thumbnails.of(sourceImageFilePath).forceSize(100,100).toFile(sourceImageFilePath);
		
		// 图片尺寸不变，压缩图片文件大小outputQuality实现,参数1为最高质量
		Thumbnails.of(sourceImageFilePath).scale(1f).outputQuality(0.25f).toFile(outputImageFilePath);
		
	}
	
}
