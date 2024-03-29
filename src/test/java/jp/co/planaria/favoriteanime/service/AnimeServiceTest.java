package jp.co.planaria.favoriteanime.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.planaria.favoriteanime.entity.Anime;
import jp.co.planaria.favoriteanime.entity.AnimeCondition;

@SpringBootTest
public class AnimeServiceTest {

	@Autowired
	AnimeService target;
	
	@Test
	void 全件検索できること_正常終了() {
		List<Anime> animeList = target.getAnimeList();
		
		// 検索結果が3件あること
		assertThat(animeList.size()).isEqualTo(3);
		
		// 検索結果の1件の項目を確認する
		Anime maoyu = animeList.get(0);
		assertThat(maoyu.getTitleNo()).isEqualTo(1);
		assertThat(maoyu.getTitle()).isEqualTo("まおゆう");
	}
	
	@Test
	void 前方一致テスト_てんを指定して検索できる() {
		AnimeCondition condition = new AnimeCondition();
		condition.setTitle("てん");
		List<Anime> animeList = target.searchAnimeListByCondition(condition);
		
		// 検索結果が1件あること
		assertThat(animeList.size()).isEqualTo(1);
		
		// 検索結果の1件の項目を確認する
		Anime tensura = animeList.get(0);
		assertThat(tensura.getTitleNo()).isEqualTo(2);
		assertThat(tensura.getTitle()).isEqualTo("てんすら");
	}

	@Test
	void 前方一致テスト_きめを指定して検索できる() {
		AnimeCondition condition = new AnimeCondition();
		condition.setTitle("きめ");
		List<Anime> animeList = target.searchAnimeListByCondition(condition);
		
		// 検索結果が1件あること
		assertThat(animeList.size()).isEqualTo(1);
		
		// 検索結果の1件の項目を確認する
		Anime tensura = animeList.get(0);
		assertThat(tensura.getTitleNo()).isEqualTo(3);
		assertThat(tensura.getTitle()).isEqualTo("きめつ");
	}

	@Test
	void 前方一致テスト_検索条件なしで検索できる_null() {
		AnimeCondition condition = new AnimeCondition();
		condition.setTitle(null);
		List<Anime> animeList = target.searchAnimeListByCondition(condition);
		
		// 検索結果が3件あること
		assertThat(animeList.size()).isEqualTo(3);
	}

	@Test
	void 前方一致テスト_検索条件なしで検索できる_空文字() {
		AnimeCondition condition = new AnimeCondition();
		condition.setTitle("");
		List<Anime> animeList = target.searchAnimeListByCondition(condition);
		
		// 検索結果が3件あること
		assertThat(animeList.size()).isEqualTo(3);
	}
}
