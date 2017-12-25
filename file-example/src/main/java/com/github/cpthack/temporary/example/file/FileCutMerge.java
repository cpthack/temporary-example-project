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

import java.io.File;
import java.io.RandomAccessFile;

/**
 * <b>FileCutMerge.java</b></br>
 * 
 * <pre>
 * 文件切割合并示例
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2017年12月25日 下午2:09:58
 * @since JDK 1.8
 */
public class FileCutMerge {
	
	public static void main(String[] args) {
		FileCutMerge fileCutMerge = new FileCutMerge();
		String filePath = FileConstants.getFilePath();
		
		int fileNum = 10;
		fileCutMerge.cutFileByFileNum(filePath, fileNum);
		fileCutMerge.mergeFileFile(filePath, fileNum);
	}
	
	/**
	 * 
	 * <b>cutFileByFileNum</b> <br/>
	 * <br/>
	 * 
	 * 按照切分文件数量来分割文件<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @param filePath
	 *            文件所在绝对路径，切割后的文件也默认在同级目录下，切割文件命名规则：(源文件名称+"."+递增数字序号)
	 * @param fileNum
	 *            切分数量
	 *
	 * @return boolean
	 */
	public boolean cutFileByFileNum(String filePath, int fileNum) {
		File sourceBigFile = new File(filePath);
		if (!sourceBigFile.exists()) {
			throw new IllegalArgumentException("The filePath is not allowed Null.");
		}
		
		try (
		        RandomAccessFile sourceAccessFile = new RandomAccessFile(sourceBigFile, "r")) {
			
			int len = -1;
			RandomAccessFile cutAccessFile = null;
			String cutSmallFileName = null;
			File cutSmallFile = null;
			long cutSmallFileLength = sourceBigFile.length() / fileNum;// 计算每个文件的大小
			byte[] b = new byte[1024];// 每次读取文件的字节数
			for (int i = 0; i < fileNum; i++) {
				cutSmallFileName = sourceBigFile.getPath() + sourceBigFile.getName() + "." + (i + 1);
				cutSmallFile = new File(cutSmallFileName);
				cutSmallFile.createNewFile();
				cutAccessFile = new RandomAccessFile(cutSmallFile, "rw");
				while ((len = sourceAccessFile.read(b)) != -1) {
					cutAccessFile.write(b, 0, len);
					if (cutAccessFile.length() > cutSmallFileLength)// 如果当前切割文件已经写满，则继续切割生成下个文件
						break;
				}
				cutAccessFile.close();
			}
		}
		catch (Exception e) {
			throw new RuntimeException("切割文件发生错误.", e);
		}
		return true;
	}
	
	/**
	 * 
	 * <b>mergeFileFile</b> <br/>
	 * <br/>
	 * 
	 * 合并切割后的文件<br/>
	 * 
	 * @author cpthack 1044559878@qq.com
	 * @param filePath
	 *            合并后的文件所在路径，切割后的文件也默认在同级目录下，切割文件命名规则：(源文件名称+"."+递增数字序号)
	 * @param fileNum
	 *            切割文件的数量
	 * @return boolean
	 *
	 */
	public boolean mergeFileFile(String filePath, int fileNum) {
		
		File mergeFile = new File(filePath);
		try {
			mergeFile.createNewFile();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try (
		        RandomAccessFile mergeAccessFile = new RandomAccessFile(mergeFile, "rw")) {
			mergeAccessFile.setLength(0);
			mergeAccessFile.seek(0);
			byte[] bytes = new byte[1024];
			int len = -1;
			File[] cutSmallFiles = new File[fileNum];
			String cutSmallFileName = null;
			for (int i = 0; i < fileNum; i++) {
				cutSmallFileName = mergeFile.getPath() + mergeFile.getName() + "." + (i + 1);
				cutSmallFiles[i] = new File(cutSmallFileName);
				RandomAccessFile cutSmallAccessFile = new RandomAccessFile(cutSmallFiles[i], "rw");
				while ((len = cutSmallAccessFile.read(bytes)) != -1) {
					mergeAccessFile.write(bytes, 0, len);
				}
				cutSmallAccessFile.close();
			}
		}
		catch (Exception e) {
			throw new RuntimeException("合并文件发生错误.", e);
		}
		
		return true;
	}
}
