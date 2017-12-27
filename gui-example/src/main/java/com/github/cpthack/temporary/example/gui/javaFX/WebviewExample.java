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
package com.github.cpthack.temporary.example.gui.javaFX;

import java.util.Observable;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebErrorEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.concurrent.*;

/**
 * <b>JxbrowserExample.java</b></br>
 * 
 * <pre>
 * 基于JavaFX的WebviewExample示例
 * </pre>
 *
 * @author cpthack 1044559878@qq.com
 * @date 2017年12月27日 下午1:58:34
 * @since JDK 1.8
 */
public class WebviewExample extends Application {
	
	private final static String DEFAULT_URL = "http://www.baidu.com";
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		init(primaryStage);
		primaryStage.show();
	}
	
	public void init(Stage stage) {
		Group root = new Group();
		stage.setScene(new Scene(root));
		stage.setTitle("test");
		
		WebView webView = new WebView();
		final WebEngine engine = webView.getEngine();
		engine.setJavaScriptEnabled(true);
		engine.setOnError(new EventHandler<WebErrorEvent>() {
			
			@Override
			public void handle(WebErrorEvent event) {
				System.err.println("errorType:"+event.getEventType()+",errorMsg:"+event.getMessage());
			}
		});
		engine.load(DEFAULT_URL);
		
        /** 
         * 设置标题栏为当前访问页面的标题。 
         */  
        engine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>(){  
            @Override  
            public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {  
                if(newValue==Worker.State.SUCCEEDED){  
                    stage.setTitle(engine.getTitle());  
                }  
            }  
        }); 
		
		
		// 水平方向线性增加控件
		HBox hBox = new HBox();
		hBox.setMinHeight(100);
		
		Button backBt = new Button("返回上一页");
		backBt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				engine.executeScript("window.history.go(-1)");
			}
		});
		
		Button forwardBt = new Button("返回下一页");
		backBt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				engine.executeScript("window.history.forward();");
			}
		});
		
		TextField urlText = new TextField();
		urlText.setMinWidth(1000);
		urlText.setText(DEFAULT_URL);
		
		Button accessBt = new Button("点此访问");
		accessBt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("点击了按钮.");
				String newUrl = urlText.getText().startsWith("http://") ? urlText.getText().trim() : "http://" + urlText.getText().trim();
				System.out.println("newUr="+newUrl);
				engine.load(newUrl);
			}
		});
		
		hBox.getChildren().addAll(backBt,forwardBt,urlText, accessBt);
		
		/**修改输入栏的地址，也就是访问那个网站，这个地址栏显示那个网站的地址 
         * locationProperty()是获得当前页面的url封装好的ReadOnlyStringProperty对象 
         */  
        engine.locationProperty().addListener(new ChangeListener<String>(){

			@Override
            public void changed(ObservableValue<? extends String> paramObservableValue, String oldValue, String newValue) {
				urlText.setText(newValue);
            }  
        });  
		
		
		// 垂直方向线性增加控件
		VBox vBox = new VBox();
		vBox.getChildren().addAll(hBox, webView);
		
		root.getChildren().add(vBox);
	}
}
