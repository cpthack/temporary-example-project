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
package com.github.cpthack.temporary.file;

/**
 * <b>RunningTimeCountHelper.java</b></br>
 * 
 * <pre>
 * 程序运行时间统计辅助工具类
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2017年12月20日 下午1:53:08
 * @since JDK 1.8
 */
public class RunningTimeCountHelper {
	
	public static boolean run(RunningTimeCountHelper.Program program) {
		try {
			System.out.println("program is started!!!");
			long startTime = System.currentTimeMillis();
			program.run();
			long endTime = System.currentTimeMillis();
			System.out.println("程序运行时间:" + (endTime - startTime) / 1000 + "s");
			return true;
		}
		catch (Exception e) {
			throw new RuntimeException("程序执行失败.", e);
		}finally{
			System.out.println("program is end!!!");
		}
	}
	
	public interface Program {
		
		void run();
	}
	
	public static void main(String[] arg) {
		RunningTimeCountHelper.run(new Program() {
			@Override
			public void run() {
				System.out.println("my name is test.");
			}
		});
	}
}
