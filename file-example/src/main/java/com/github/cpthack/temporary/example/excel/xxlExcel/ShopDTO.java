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

import org.apache.poi.hssf.util.HSSFColor;

import com.xuxueli.poi.excel.annotation.ExcelField;
import com.xuxueli.poi.excel.annotation.ExcelSheet;

/**
 * <b>ShopDTO.java</b></br>
 * 
 * <pre>
 * EXCEL导入导出测试实体对象
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2017年12月27日 下午12:13:14
 * @since JDK 1.8
 */
@ExcelSheet(name = "商户列表",
        headColor = HSSFColor.HSSFColorPredefined.LIGHT_GREEN)
public class ShopDTO {
	
	@ExcelField(name = "商户ID", width = 5000)
	private int    shopId;
	
	@ExcelField(name = "商户名称")
	private String shopName;
	
	public ShopDTO() {
	}
	
	public ShopDTO(int shopId, String shopName) {
		this.shopId = shopId;
		this.shopName = shopName;
	}
	
	public int getShopId() {
		return shopId;
	}
	
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	
	public String getShopName() {
		return shopName;
	}
	
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
}
