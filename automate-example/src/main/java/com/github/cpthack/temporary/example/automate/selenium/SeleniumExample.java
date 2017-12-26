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
package com.github.cpthack.temporary.example.automate.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * <b>SeleniumExample.java</b></br>
 * 
 * <pre>
 * 基于selenium自动化框架的Java示例
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2017年12月26日 下午3:34:49
 * @since JDK 1.8
 */
public class SeleniumExample {
	
	public static void main(String[] arg) {
		SeleniumExample seleniumExample = new SeleniumExample();
//		seleniumExample.simulateAccessBaidu();
		seleniumExample.simulateAccessJianzhimao();
	}
	
	// 模拟访问百度
	public void simulateAccessBaidu() {
		System.setProperty("webdriver.chrome.driver",
		        "src/main/resources/chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		
		webDriver.get("https://www.baidu.com");
		
		WebElement inputText = webDriver.findElement(By.name("wd"));
		inputText.sendKeys("cpthack");
		WebElement button = webDriver.findElement(By.id("su"));
		button.submit();
		
		webDriver.close();
	}
	
	public void simulateAccessJianzhimao() {
		System.setProperty("webdriver.chrome.driver",
		        "src/main/resources/chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		
		webDriver.get("https://www.jianzhimao.com/task/");
		
		WebElement ulElement = webDriver.findElement(By.className("list"));
		System.out.println(ulElement.getLocation());
		System.out.println(ulElement.findElements(By.cssSelector(".miao_task .panel li .info a")).get(0).getText());
	}
}
