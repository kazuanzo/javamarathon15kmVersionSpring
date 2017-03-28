package javamarathon15km.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javamarathon15km.domain.Shops;
import javamarathon15km.repository.ShopsRepository;

@Service
public class ShopsService {
	@Autowired
	private ShopsRepository repository;

	// 色と性別からアイテム一覧を取得するメソッド
	@Transactional//トランザクション処理
	public List<Shops> searchShops(String color,int gender) {
		//repositoryを利用してショップリストを取得
		List<Shops> shops=repository.findByNamedQuery(color,gender);
		return shops;
	}
	// 性別から選択できる色を取得するメソッド
		@Transactional//トランザクション処理
		public List<String> selectColor(int gender) {
			//repositoryを利用してショップリストを取得
			List<String> color=repository.findBySelectColor(gender);
			return color;
		}

}
