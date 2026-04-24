package q01_basic.question02;

/**
 * カプセル化されたMemberクラスのテストクラス
 * 実行して以下の表示が出れば実装OKです
 * "✓ " + testName + " - 成功"
 * 
 * 実行して以下の表示が出る場合は実装にエラーがあります。修正してください
 * "✗ " + testName + " - 失敗"
 * 
 * ！注意 テストクラスの内容は変更しないでください
 * 
 * 
 */
public class MemberTest02 {

	/**
	 * テスト結果を検証するためのヘルパーメソッド
	 * @param actual 実際の値
	 * @param expected 期待値
	 * @param testName テスト名
	 */
	private static void assertEquals(Object actual, Object expected, String testName) {
		if ((actual == null && expected == null) || (actual != null && actual.equals(expected))) {
			System.out.println("✓ " + testName + " - 成功");
		} else {
			System.err.println("✗ " + testName + " - 失敗");
			System.out.println("  期待値: " + expected);
			System.out.println("  実際値: " + actual);
		}
	}

	/**
	 * メインメソッド - テストケースを実行
	 */
	public static void main(String[] args) {
		System.out.println("=== Memberクラスのテスト開始 ===");

		// テストケース1: ゲッターとセッターのテスト
		testGettersAndSetters();

		// テストケース2: rankUpメソッドのテスト
		testRankUp();

		// テストケース3: 複数のデータでの検証
		testMultipleValues();

		// テストケース4: showMemberメソッドのテスト
		testShowMember();

		System.out.println("=== Memberクラスのテスト終了 ===");
	}

	/**
	 * テストケース1: ゲッターとセッターの動作を確認
	 */
	private static void testGettersAndSetters() {
		System.out.println("\n▶ テストケース1: ゲッターとセッターのテスト");

		// テスト対象のインスタンスを作成
		Member member = new Member();

		// 初期値のテスト (全てnullまたは0のはず)
		assertEquals(member.getName(), null, "初期値のname");
		assertEquals(member.getAge(), 0, "初期値のage");
		assertEquals(member.getRank(), 0, "初期値のrank");

		// setterを使用して値を設定
		member.setName("山田太郎");
		member.setAge(30);
		member.setRank(2);

		// getterを使用して値を取得し検証
		assertEquals(member.getName(), "山田太郎", "setNameとgetName");
		assertEquals(member.getAge(), 30, "setAgeとgetAge");
		assertEquals(member.getRank(), 2, "setRankとgetRank");

		// 値を更新して再検証
		member.setName("佐藤花子");
		member.setAge(25);
		member.setRank(3);

		assertEquals(member.getName(), "佐藤花子", "name値の更新");
		assertEquals(member.getAge(), 25, "age値の更新");
		assertEquals(member.getRank(), 3, "rank値の更新");
	}

	/**
	 * テストケース2: rankUpメソッドの動作確認
	 */
	private static void testRankUp() {
		System.out.println("\n▶ テストケース2: rankUpメソッドのテスト");

		// テスト対象のインスタンスを作成
		Member member = new Member();

		// 初期ランクを設定
		member.setRank(1);
		assertEquals(member.getRank(), 1, "初期ランク設定");

		// rankUpを1回実行
		member.rankUp();
		assertEquals(member.getRank(), 2, "rankUp実行後（1回目）");

		// rankUpを2回実行
		member.rankUp();
		member.rankUp();
		assertEquals(member.getRank(), 4, "rankUp実行後（合計3回）");

		// ランクが0の状態からrankUp
		member.setRank(0);
		member.rankUp();
		assertEquals(member.getRank(), 1, "ランク0からrankUp");
	}

	/**
	 * テストケース3: 複数のオブジェクトでの検証
	 */
	private static void testMultipleValues() {
		System.out.println("\n▶ テストケース3: 複数のデータでの検証");

		// 1つ目のメンバー
		Member member1 = new Member();
		member1.setName("鈴木一郎");
		member1.setAge(40);
		member1.setRank(5);

		// 2つ目のメンバー
		Member member2 = new Member();
		member2.setName("田中二郎");
		member2.setAge(35);
		member2.setRank(3);

		// 各メンバーの値が独立していることを確認
		assertEquals(member1.getName(), "鈴木一郎", "member1のname");
		assertEquals(member1.getAge(), 40, "member1のage");
		assertEquals(member1.getRank(), 5, "member1のrank");

		assertEquals(member2.getName(), "田中二郎", "member2のname");
		assertEquals(member2.getAge(), 35, "member2のage");
		assertEquals(member2.getRank(), 3, "member2のrank");

		// member1のランクを上げる
		member1.rankUp();

		// 変更が他のオブジェクトに影響しないことを確認
		assertEquals(member1.getRank(), 6, "member1のrankUp後");
		assertEquals(member2.getRank(), 3, "member2は変化なし");
	}

	/**
	 * テストケース4: showMemberメソッドの出力確認
	 */
	private static void testShowMember() {
		System.out.println("\n▶ テストケース4: showMemberメソッドの出力テスト");

		// テスト対象のインスタンスを作成
		Member member = new Member();
		member.setName("高橋三郎");
		member.setAge(28);
		member.setRank(4);

		// showMemberメソッドの実行結果（コンソール出力の確認）
		System.out.println("showMemberメソッドの出力結果:");
		member.showMember();
		// 注: コンソール出力の自動検証は行わず、目視確認を行う
	}
}