package jp.co.planaria.favoriteanime.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.planaria.favoriteanime.entity.Anime;
import jp.co.planaria.favoriteanime.entity.AnimeCondition;

@Mapper //Mapperとして登録
public interface AnimeMapper {

	/**
	 * 全件検索する。
	 * @return 検索結果
	 */
	public List<Anime> selectAll();
	
	/**
	 * 検索条件に該当するリストを検索する。
	 * @return 検索結果
	 */
	public List<Anime> selectByCondition(AnimeCondition condition);
}
