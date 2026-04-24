package q01_basic.question05;

/**
 * bstMemberを継承したMemberクラスのテストクラス (JUnitを使用しない手動テスト)
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
public class MemberTest05 {

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
	 * テスト結果を検証するためのヘルパーメソッド (int型用)
	 * @param actual 実際の値
	 * @param expected 期待値
	 * @param testName テスト名
	 */
	private static void assertEquals(int actual, int expected, String testName) {
		if (actual == expected) {
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
		System.out.println("=== Memberクラスのテスト開始 ===");

		// テストケース1: デフォルトコンストラクタとsetter/getterのテスト
		testDefaultConstructorAndSettersGetters();

		// テストケース2: 引数付きコンストラクタとgetterのテスト
		testParameterizedConstructorAndGetters();

		// テストケース3: buyItemメソッドのテスト (出力の目視確認)
		testBuyItem();

		// テストケース4: showMemberメソッドのテスト (出力の目視確認)
		testShowMember();

		System.out.println("=== Memberクラスのテスト終了 ===");
	}

	/**
	 * テストケース1: デフォルトコンストラクタとsetter/getterのテスト
	 * デフォルトコンストラクタでインスタンスを作成し、各setterで値を設定後、getterで正しく取得できるか検証します。
	 */
	private static void testDefaultConstructorAndSettersGetters() {
		System.out.println("\n▶ テストケース1: デフォルトコンストラクタとsetter/getterのテスト");

		// テスト対象のインスタンスを作成 (デフォルトコンストラクタを使用)
		Member member = new Member();

		// 各setterで値を設定
		int testId = 1;
		String testPassword = "password123";
		String testName = "テストメンバーA"; // AbstMemberから継承したname
		int testAge = 25;
		int testRank = 3;

		member.setId(testId);
		member.setPassword(testPassword);
		member.setName(testName); // AbstMemberから継承したsetter
		member.setAge(testAge);
		member.setRank(testRank);

		// 各getterで取得した値が正しいか検証
		assertEquals(member.getId(), testId, "getIdメソッドのテスト");
		assertEquals(member.getPassword(), testPassword, "getPasswordメソッドのテスト");
		assertEquals(member.getName(), testName, "getNameメソッドのテスト"); // AbstMemberから継承したgetter
		assertEquals(member.getAge(), testAge, "getAgeメソッドのテスト");
		assertEquals(member.getRank(), testRank, "getRankメソッドのテスト");
	}

	/**
	 * テストケース2: 引数付きコンストラクタとgetterのテスト
	 * 引数付きコンストラクタでインスタンスを作成し、各getterで正しく値が取得できるか検証します。
	 */
	private static void testParameterizedConstructorAndGetters() {
		System.out.println("\n▶ テストケース2: 引数付きコンストラクタとgetterのテスト");

		// テスト用の値
		int testId = 2;
		String testPassword = "secure_password";
		String testName = "テストメンバーB";
		int testAge = 35;
		int testRank = 1;

		// テスト対象のインスタンスを作成 (引数付きコンストラクタを使用)
		Member member = new Member(testId, testPassword, testName, testAge, testRank);

		// 各getterで取得した値が正しいか検証
		assertEquals(member.getId(), testId, "getIdメソッドのテスト (コンストラクタ)");
		assertEquals(member.getPassword(), testPassword, "getPasswordメソッドのテスト (コンストラクタ)");
		assertEquals(member.getName(), testName, "getNameメソッドのテスト (コンストラクタ)"); // AbstMemberから継承
		assertEquals(member.getAge(), testAge, "getAgeメソッドのテスト (コンストラクタ)");
		assertEquals(member.getRank(), testRank, "getRankメソッドのテスト (コンストラクタ)");
	}

	/**
	 * テストケース3: buyItemメソッドのテスト
	 * buyItemメソッドが呼び出され、期待される出力が行われるか確認します。
	 * このテストはコンソール出力の目視確認が必要です。
	 */
	private static void testBuyItem() {
		System.out.println("\n▶ テストケース3: buyItemメソッドのテスト");

		// テスト対象のインスタンスを作成
		Member member = new Member();
		member.setName("購入テストメンバー"); // buyItemの出力に使用される名前を設定

		System.out.println("--- buyItemメソッドの出力開始 ---");
		// buyItemメソッドを呼び出し
		member.buyItem();
		System.out.println("--- buyItemメソッドの出力終了 ---");

		// 出力内容を人が確認する必要があります。
		System.out.println("上記の出力に「購入テストメンバー purchased the item at 50% off」と表示されていれば成功です。");
	}

	/**
	 * テストケース4: showMemberメソッドのテスト
	 * showMemberメソッドが呼び出され、期待される出力が行われるか確認します。
	 * このテストはコンソール出力の目視確認が必要です。
	 */
	private static void testShowMember() {
		System.out.println("\n▶ テストケース4: showMemberメソッドのテスト");

		// テスト対象のインスタンスを作成し、値を設定
		Member member = new Member(99, "show_pass", "表示テストメンバー", 45, 5);

		System.out.println("--- showMemberメソッドの出力開始 ---");
		// showMemberメソッドを呼び出し
		member.showMember();
		System.out.println("--- showMemberメソッドの出力終了 ---");

		// 出力内容を人が確認する必要があります。
		System.out.println("上記の出力にID, password, name, age, rankが正しく表示されていれば成功です。");
	}
}
