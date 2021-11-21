package jp.co.planaria.favoriteanime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.planaria.favoriteanime.entity.Anime;
import jp.co.planaria.favoriteanime.entity.AnimeCondition;
import jp.co.planaria.favoriteanime.mapper.AnimeMapper;

@Service //ServiceとしてDIに登録
public class AnimeService {
	
	@Autowired
	AnimeMapper mapper;

	/**
	 * アニメリストを全件取得する。
	 * @return アニメリスト
	 */
	public List<Anime> getAnimeList() {
		return mapper.selectAll();
	}
	
	/**
	 * アニメリストを検索条件で検索する。
	 * @return アニメリスト
	 */
	public List<Anime> searchAnimeListByCondition(AnimeCondition condition) {
		return mapper.selectByCondition(condition);
	}
}
