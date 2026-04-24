package q01_basic.question05;

/**
 * NonMemberクラスのテストクラス (JUnitを使用しない手動テスト)
 * AbstMemberから継承したメソッドと、NonMemberで実装したメソッドの動作を確認します。
 * 
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
public class NonMemberTest05 {

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
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		System.out.println("=== NonMemberクラスのテスト開始 ===");

		// テストケース1: コンストラクタとgetNameメソッドのテスト
		testConstructorAndGetName();

		// テストケース2: buyItemメソッドのテスト (出力の目視確認)
		testBuyItem();

		// テストケース3: showMemberメソッドのテスト (出力の目視確認)
		testShowMember();

		System.out.println("=== NonMemberクラスのテスト終了 ===");
	}

	/**
	 * テストケース1: コンストラクタとgetNameメソッドのテスト
	 * コンストラクタで名前を設定し、getNameメソッドで正しく取得できるか検証します。
	 */
	private static void testConstructorAndGetName() {
		System.out.println("\n▶ テストケース1: コンストラクタとgetNameメソッドのテスト");

		// テスト用の名前
		String testName = "ゲストユーザー";

		// テスト対象のインスタンスを作成 (コンストラクタを使用)
		NonMember nonMember = new NonMember(testName);

		// getNameメソッドで取得した値が正しいか検証
		// NonMemberはAbstMemberからgetNameメソッドを継承しています。
		assertEquals(nonMember.getName(), testName, "コンストラクタで設定した名前の取得");
	}

	/**
	 * テストケース2: buyItemメソッドのテスト
	 * buyItemメソッドが呼び出され、期待される出力が行われるか確認します。
	 * このテストはコンソール出力の目視確認が必要です。
	 */
	private static void testBuyItem() {
		System.out.println("\n▶ テストケース2: buyItemメソッドのテスト");

		// テスト対象のインスタンスを作成
		NonMember nonMember = new NonMember("購入テスト非会員"); // buyItemの出力に使用される名前を設定

		System.out.println("--- buyItemメソッドの出力開始 ---");
		// buyItemメソッドを呼び出し
		nonMember.buyItem();
		System.out.println("--- buyItemメソッドの出力終了 ---");

		// 出力内容を人が確認する必要があります。
		System.out.println("上記の出力に「購入テスト非会員 purchased the item at a fixed price」と表示されていれば成功です。");
	}

	/**
	 * テストケース3: showMemberメソッドのテスト
	 * showMemberメソッドが呼び出され、期待される出力が行われるか確認します。
	 * このテストはコンソール出力の目視確認が必要です。
	 */
	private static void testShowMember() {
		System.out.println("\n▶ テストケース3: showMemberメソッドのテスト");

		// テスト対象のインスタンスを作成
		NonMember nonMember = new NonMember("表示テスト非会員"); // showMemberの出力に使用される名前を設定

		System.out.println("--- showMemberメソッドの出力開始 ---");
		// showMemberメソッドを呼び出し
		nonMember.showMember();
		System.out.println("--- showMemberメソッドの出力終了 ---");

		// 出力内容を人が確認する必要があります。
		System.out.println("上記の出力に「表示テスト非会員 is a non-member」と表示されていれば成功です。");
	}
}
