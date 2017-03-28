package javamarathon15km.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javamarathon15km.domain.Shops;
import javamarathon15km.service.ShopsService;
import net.arnx.jsonic.JSON;

@Controller
public class ShopsController {
	@Autowired
	private ShopsService service;
	
	/**
	 *フロント画面を表示
	 */
	@RequestMapping("SearchShops")
	String inputForm() {	   
	 return "SearchShops";
	}
	/**
	 *フロント画面から値を取得し、アイテムリストを返却
	 */
	@RequestMapping(value = "/shops", method = RequestMethod.GET)
	@ResponseBody//メソッドへのリクエスト結果がJSON形式になる
	List<Shops> getItems(String data) {
		//取得したJson値をPOJOにデコードする
		Shops shops=JSON.decode(data,Shops.class);
		
		 //サービスクラスを利用し、アイテムリストを取得
		List<Shops> hotels=service.searchShops(shops.getColor(),shops.getGender());   
	 return hotels;
	}
	
	/**
	 *フロント画面からgender値を取得し、colorを返却
	 */
	@RequestMapping(value = "/gender", method = RequestMethod.GET)
	@ResponseBody//メソッドへのリクエスト結果がJSON形式になる
	List<String> checkColor(String data) {
		//取得したJson値をPOJOにデコードする
		Shops shops=JSON.decode(data,Shops.class);
		
		 //サービスクラスを利用し、アイテムリストを取得
		List<String> color=service.selectColor(shops.getGender());   
	 return color;
	}
	

}
