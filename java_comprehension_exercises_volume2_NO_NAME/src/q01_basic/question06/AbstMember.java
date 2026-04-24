package q01_basic.question06;

/**
 * 会員、非会員の基盤クラス
 * Memberクラス、NonMemberクラスに継承する
 * 
 */
abstract class AbstMember {

	/**
	 * name protected access
	 */
	protected String name;

	/**
	 * 商品を購入する（メッセージ出力）
	 * 抽象メソッド
	 */
	public abstract void buyItem();

	/**
	 * メンバー情報を表示する（メッセージ出力）
	 * 抽象メソッド
	 * 
	 */
	public abstract void showMember();

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
