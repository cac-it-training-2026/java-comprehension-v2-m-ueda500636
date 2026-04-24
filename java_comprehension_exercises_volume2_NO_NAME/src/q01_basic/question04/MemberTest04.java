package q01_basic.question04;

/**
 * MemberTest04クラス - 前回のMemberクラスとの差分を中心にテスト
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
public class MemberTest04 {

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
		System.out.println("=== MemberTest04 - 差分テスト開始 ===");

		// テストケース1: 新しく追加されたフィールド(id, password)のゲッター・セッターのテスト
		testNewFields();

		// テストケース2: 更新されたパラメータ付きコンストラクタのテスト
		testUpdatedConstructor();

		// テストケース3: 更新されたshowMemberメソッドのテスト
		testUpdatedShowMember();

		System.out.println("=== MemberTest04 - 差分テスト終了 ===");
	}

	/**
	 * テストケース1: 新しく追加されたフィールド(id, password)のテスト
	 */
	private static void testNewFields() {
		System.out.println("\n▶ テストケース1: 新しく追加されたフィールドのテスト");

		// デフォルトコンストラクタでインスタンスを作成
		Member member = new Member();

		// 新しいフィールドのデフォルト値を検証
		assertEquals(member.getId(), 0, "id初期値");
		assertEquals(member.getPassword(), null, "password初期値");

		// 新しいフィールドに値を設定
		int testId = 12345;
		String testPassword = "securePassword123";

		member.setId(testId);
		member.setPassword(testPassword);

		// ゲッターで値を取得して検証
		assertEquals(member.getId(), testId, "setId/getId");
		assertEquals(member.getPassword(), testPassword, "setPassword/getPassword");

		// 値を更新して再検証
		member.setId(54321);
		member.setPassword("newPassword456");

		assertEquals(member.getId(), 54321, "setId/getId - 更新後");
		assertEquals(member.getPassword(), "newPassword456", "setPassword/getPassword - 更新後");
	}

	/**
	 * テストケース2: 更新されたパラメータ付きコンストラクタのテスト
	 */
	private static void testUpdatedConstructor() {
		System.out.println("\n▶ テストケース2: 更新されたパラメータ付きコンストラクタのテスト");

		// 新しいコンストラクタパラメータを準備
		int testId = 7890;
		String testPassword = "p@ssw0rd";
		String testName = "山田太郎";
		int testAge = 30;
		int testRank = 2;

		// パラメータ付きコンストラクタでインスタンスを作成
		Member member = new Member(testId, testPassword, testName, testAge, testRank);

		// 全てのフィールドが正しく設定されているか検証（特に新しいフィールドに注目）
		assertEquals(member.getId(), testId, "コンストラクタ - id");
		assertEquals(member.getPassword(), testPassword, "コンストラクタ - password");
		assertEquals(member.getName(), testName, "コンストラクタ - name");
		assertEquals(member.getAge(), testAge, "コンストラクタ - age");
		assertEquals(member.getRank(), testRank, "コンストラクタ - rank");

		// 別の値でも検証
		Member member2 = new Member(1001, "admin123", "佐藤花子", 25, 3);
		assertEquals(member2.getId(), 1001, "コンストラクタ2 - id");
		assertEquals(member2.getPassword(), "admin123", "コンストラクタ2 - password");
	}

	/**
	 * テストケース3: 更新されたshowMemberメソッドのテスト
	 */
	private static void testUpdatedShowMember() {
		System.out.println("\n▶ テストケース3: 更新されたshowMemberメソッドのテスト");

		// テスト用のデータを準備
		Member member = new Member(1234, "test123", "鈴木一郎", 40, 5);

		// showMemberメソッドの出力を確認（フォーマット変更とID/パスワード表示の確認）
		System.out.println("更新されたshowMemberメソッドの出力結果:");
		member.showMember();

		// デフォルトコンストラクタで作成したオブジェクトでも確認
		Member defaultMember = new Member();
		defaultMember.setId(9999);
		defaultMember.setPassword("defaultPass");
		defaultMember.setName("デフォルト太郎");

		System.out.println("\nデフォルトコンストラクタで作成したオブジェクトのshowMember出力:");
		defaultMember.showMember();
	}
}