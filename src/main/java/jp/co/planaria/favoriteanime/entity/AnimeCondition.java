package jp.co.planaria.favoriteanime.entity;

/**
 * 検索条件
 * 
 * @author HyunwookPark
 */
public class AnimeCondition {

	// アニメタイトル
	private String title;

	/**
	 * アニメタイトルを取得する。
	 * @return アニメタイトル
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * アニメタイトルを設定する。
	 * @param title アニメタイトル
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
}
