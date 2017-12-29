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
package com.github.cpthack.temporary.example.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * <b>JsoupExample.java</b></br>
 * 
 * <pre>
 * 基于jsoup的爬虫示例<br/>
 * 相关文档:http://blog.csdn.net/wangjunjun2008/article/details/50513528
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2017年12月29日 下午4:08:46
 * @since JDK 1.8
 */
public class JsoupExample {
	
	public static void main(String[] args) throws Exception {
		testLinks();
		// testCompany();
	}
	
	public static void testLinks() throws Exception {
		String url = "http://www.baijingapp.com/company";
		Document doc = (Document) Jsoup.connect(url).get();
		Elements links = doc.select("div[class=list]").select("a[href]");
		for (Element link : links) {
			System.out.println(link.attr("href"));
		}
	}
	
	public static void testCompany() throws Exception {
		String url = "http://www.baijingapp.com/people/35138";
		Document doc = (Document) Jsoup.connect(url).get();
		
		// 公司名称
		Element titileElement = doc.getElementById("title");
		System.out.println("1.公司名称:" + titileElement.text().split(">")[2].trim());
		
		// 公司logo
		String logo = "http://www.baijingapp.com" + doc.select("img[class=user-img]").attr("src");
		System.out.println("2.公司logo:" + logo);
		
		// 官网
		String site = doc.select("div[class=company-information]").select("span[class=glyphicon glyphicon-link]").select("a").attr("href");
		System.out.println("3.公司官网:" + site);
		
		// 产品列表
		System.out.println("4.产品列表:");
		Elements productList = doc.getElementById("pro_download").children();
		for (Element element : productList) {
			System.out.println("product-title:" + element.select("p[class=qspanh3]").text());
			System.out.println("product-icon:" + "http://www.baijingapp.com" + element.select("img[src]").attr("src"));
			System.out.println("product-url:" + element.select("a").attr("href"));
		}
		
		// 产品介绍
		String descp = doc.select("div[class=mod-body aw-user-center-details company]").select("dt:contains(公司介绍)").next().html();
		System.out.println("5.公司介绍:");
		System.out.println(descp);
		
		String scale = doc.select("div[class=mod-heads clearfix]").select("p:contains(公司规模)").prev().html();
		System.out.println("6.公司规模:" + scale);
		
		String financingState = doc.select("div[class=mod-heads clearfix]").select("p:contains(融资状态)").prev().html();
		System.out.println("7.融资状态:" + financingState);
		
		String domain = doc.select("div[class=mod-body aw-user-center-details company]").select("dt:contains(公司行业)").next("dd").html();
		System.out.println("8.公司领域:" + domain);
	}
	
}
