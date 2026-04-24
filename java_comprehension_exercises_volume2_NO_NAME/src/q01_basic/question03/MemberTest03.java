package q01_basic.question03;

/**
 * コンストラクタを持つMemberクラスのテストクラス
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
public class MemberTest03 {

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

		// テストケース1: デフォルトコンストラクタのテスト
		testDefaultConstructor();

		// テストケース2: パラメータ付きコンストラクタのテスト
		testParameterizedConstructor();

		// テストケース3: ゲッターとセッターのテスト
		testGettersAndSetters();

		System.out.println("=== Memberクラスのテスト終了 ===");
	}

	/**
	 * テストケース1: デフォルトコンストラクタのテスト
	 */
	private static void testDefaultConstructor() {
		System.out.println("\n▶ テストケース1: デフォルトコンストラクタのテスト");

		// デフォルトコンストラクタでインスタンスを作成
		Member member = new Member();

		// デフォルト値の検証
		assertEquals(member.getName(), null, "デフォルトコンストラクタ - name");
		assertEquals(member.getAge(), 0, "デフォルトコンストラクタ - age");
		assertEquals(member.getRank(), 0, "デフォルトコンストラクタ - rank");

		// showMemberメソッドの出力確認
		System.out.println("デフォルトコンストラクタで生成したMemberのshowMember出力:");
		member.showMember();
	}

	/**
	 * テストケース2: パラメータ付きコンストラクタのテスト
	 */
	private static void testParameterizedConstructor() {
		System.out.println("\n▶ テストケース2: パラメータ付きコンストラクタのテスト");

		// パラメータ付きコンストラクタでインスタンスを作成
		String testName = "山田太郎";
		int testAge = 30;
		int testRank = 2;
		Member member = new Member(testName, testAge, testRank);

		// 設定された値の検証
		assertEquals(member.getName(), testName, "パラメータ付きコンストラクタ - name");
		assertEquals(member.getAge(), testAge, "パラメータ付きコンストラクタ - age");
		assertEquals(member.getRank(), testRank, "パラメータ付きコンストラクタ - rank");

		// 別の値でも検証
		Member member2 = new Member("佐藤花子", 25, 3);
		assertEquals(member2.getName(), "佐藤花子", "パラメータ付きコンストラクタ2 - name");
		assertEquals(member2.getAge(), 25, "パラメータ付きコンストラクタ2 - age");
		assertEquals(member2.getRank(), 3, "パラメータ付きコンストラクタ2 - rank");

		// showMemberメソッドの出力確認
		System.out.println("パラメータ付きコンストラクタで生成したMemberのshowMember出力:");
		member.showMember();
	}

	/**
	 * テストケース3: ゲッターとセッターのテスト
	 */
	private static void testGettersAndSetters() {
		System.out.println("\n▶ テストケース3: ゲッターとセッターのテスト");

		// パラメータ付きコンストラクタでインスタンスを作成
		Member member = new Member("初期値", 20, 1);

		// 初期値の確認
		assertEquals(member.getName(), "初期値", "初期値 - name");
		assertEquals(member.getAge(), 20, "初期値 - age");
		assertEquals(member.getRank(), 1, "初期値 - rank");

		// セッターで値を変更
		member.setName("鈴木一郎");
		member.setAge(40);
		member.setRank(5);

		// 変更後の値をゲッターで取得して検証
		assertEquals(member.getName(), "鈴木一郎", "setName後 - name");
		assertEquals(member.getAge(), 40, "setAge後 - age");
		assertEquals(member.getRank(), 5, "setRank後 - rank");
	}

}