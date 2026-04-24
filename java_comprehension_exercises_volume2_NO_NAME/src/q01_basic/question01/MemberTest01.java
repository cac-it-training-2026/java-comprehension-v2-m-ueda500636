package q01_basic.question01;

/**
 * Memberクラスのテストクラス
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
public class MemberTest01 {

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

		// テストケース1: 基本的なメンバー情報の設定と取得
		testBasicMemberInfo();

		// テストケース2: 異なる値での検証
		testDifferentMemberValues();

		// テストケース3: デフォルト値の検証
		testDefaultValues();

		System.out.println("=== Memberクラスのテスト終了 ===");
	}

	/**
	 * テストケース1: 基本的なメンバー情報の設定と取得をテスト
	 */
	private static void testBasicMemberInfo() {
		System.out.println("\n▶ テストケース1: 基本的なメンバー情報の設定と取得");

		// テスト対象のインスタンスを作成
		Member member = new Member();

		// 値を設定
		member.name = "山田太郎";
		member.age = 30;
		member.rank = 2;

		// 期待値の検証
		assertEquals(member.name, "山田太郎", "メンバー名の設定");
		assertEquals(member.age, 30, "年齢の設定");
		assertEquals(member.rank, 2, "ランクの設定");

		// showMemberメソッドの動作確認（出力のみ、自動検証はなし）
		System.out.println("showMemberメソッドの出力結果:");
		member.showMember();
	}

	/**
	 * テストケース2: 異なる値での検証
	 */
	private static void testDifferentMemberValues() {
		System.out.println("\n▶ テストケース2: 異なる値での検証");

		// テスト対象のインスタンスを作成
		Member member = new Member();

		// 値を設定
		member.name = "佐藤花子";
		member.age = 25;
		member.rank = 3;

		// 期待値の検証
		assertEquals(member.name, "佐藤花子", "メンバー名の設定(2回目)");
		assertEquals(member.age, 25, "年齢の設定(2回目)");
		assertEquals(member.rank, 3, "ランクの設定(2回目)");

		// 値を変更して再検証
		member.name = "鈴木一郎";
		member.age = 40;
		member.rank = 1;

		assertEquals(member.name, "鈴木一郎", "メンバー名の変更");
		assertEquals(member.age, 40, "年齢の変更");
		assertEquals(member.rank, 1, "ランクの変更");
	}

	/**
	 * テストケース3: デフォルト値の検証
	 */
	private static void testDefaultValues() {
		System.out.println("\n▶ テストケース3: デフォルト値の検証");

		// テスト対象のインスタンスを作成（値を設定せずにデフォルト値を確認）
		Member member = new Member();

		// Javaでの参照型のデフォルト値はnull、プリミティブ型intのデフォルト値は0
		assertEquals(member.name, null, "メンバー名のデフォルト値");
		assertEquals(member.age, 0, "年齢のデフォルト値");
		assertEquals(member.rank, 0, "ランクのデフォルト値");
	}
}