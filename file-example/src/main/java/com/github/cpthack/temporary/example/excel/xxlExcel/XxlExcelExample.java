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
package com.github.cpthack.temporary.example.excel.xxlExcel;

import java.util.ArrayList;
import java.util.List;

import com.xuxueli.poi.excel.ExcelExportUtil;
import com.xuxueli.poi.excel.ExcelImportUtil;

/**
 * <b>XxlExcelExample.java</b></br>
 * 
 * <pre>
 * 基于xxl - excel的Excel操作示例<br/>
 * XXL-EXCEL 是一个灵活的Java对象和Excel文档相互转换的工具
 * 相关文档地址：http://www.xuxueli.com/xxl-excel
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2017年12月27日 上午11:42:21
 * @since JDK 1.8
 */
public class XxlExcelExample {
	
	public static void main(String[] args) {
		
		String filePath = "C:/Users/Administrator/Desktop/test.xlsx";
		exportToFileExample(filePath);
		
		importExcelExample(filePath, ShopDTO.class);
	}
	
	@SuppressWarnings("rawtypes")
	public static List<Object> importExcelExample(String filePath, Class cls) {
		/**
		 * Excel导入：Excel 转换为 Object
		 */
		List<Object> list = ExcelImportUtil.importExcel(cls, filePath);
		for (int i = 0; i < list.size(); i++) {
			ShopDTO shop = (ShopDTO) list.get(i);
			System.out.println(shop.getShopId() + " --- " + shop.getShopName());
		}
		return list;
	}
	
	// 导出对象到excel文件中
	public static void exportToFileExample(String filePath) {
		List<ShopDTO> shopDTOList = new ArrayList<ShopDTO>();
		ShopDTO shop = new ShopDTO();
		shop.setShopId(1);
		shop.setShopName("test");
		shopDTOList.add(shop);
		/**
		 * Excel导出：Object 转换为 Excel
		 */
		ExcelExportUtil.exportToFile(filePath, shopDTOList);
	}
	
}
