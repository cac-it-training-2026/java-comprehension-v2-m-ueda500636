package q02_advanced.question03;

/**
 * LoginServiceクラスのテストクラス (JUnitを使用しない手動テスト)
 * LoginServiceの doLogin メソッドの動作を確認します。
 * MemberStorage, Member, Coupon クラスを関連クラスとして利用します。
 * MemberTest01を参考にしています。
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
public class LoginServiceTest01 {

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
		System.out.println("=== LoginServiceクラスのテスト開始 ===");

		// LoginServiceが依存するMemberStorageのインスタンスを作成
		// MemberStorageのコンストラクタで初期メンバーが設定されます。
		MemberStorage memberStorage = new MemberStorage();

		// LoginServiceのインスタンスを作成
		LoginService loginService = new LoginService(memberStorage);

		// テストケース1: 正常なログイン (存在するIDと正しいパスワード)
		testSuccessfulLogin(loginService);

		System.out.println("\n--- 次のテストに進みます ---");

		// テストケース2: パスワードが間違っている場合のログイン
		testLoginWithIncorrectPassword(loginService);

		System.out.println("\n--- 次のテストに進みます ---");

		// テストケース3: 存在しないIDでのログイン
		testLoginWithNonExistingId(loginService);

		System.out.println("\n--- 次のテストに進みます ---");

		// テストケース4: nullパスワードでのログイン (NullPointerExceptionが発生しないか確認)
		testLoginWithNullPassword(loginService);

		System.out.println("\n=== LoginServiceクラスのテスト終了 ===");
	}

	/**
	 * テストケース1: 正常なログイン (存在するIDと正しいパスワード)
	 * 存在するメンバーのIDと正しいパスワードでログインし、対応するMemberオブジェクトが返されるか検証します。
	 * @param loginService テストに使用するLoginServiceインスタンス
	 */
	private static void testSuccessfulLogin(LoginService loginService) {
		System.out.println("\n▶ テストケース1: 正常なログイン");

		// MemberStorageに存在するメンバーのIDとパスワードを使用
		int existingId = 1; // MemberStorageの初期データにあるMiura ManabuのID
		String correctPassword = "Passw0rd"; // Miura Manabuの正しいパスワード

		// doLoginメソッドを呼び出し
		Member loggedInMember = loginService.doLogin(existingId, correctPassword);

		// ログインが成功し、nullでないMemberオブジェクトが返されることを検証
		assertEquals(loggedInMember != null, true, "正常なログイン - 戻り値がnullでないこと");

		// 返されたMemberオブジェクトのIDが期待されるIDと一致するか検証
		if (loggedInMember != null) {
			assertEquals(loggedInMember.getId(), existingId, "正常なログイン - ログインしたメンバーのID");
			// 必要に応じて、他のフィールド（名前など）も検証できます
			assertEquals(loggedInMember.getName(), "Miura Manabu", "正常なログイン - ログインしたメンバーの名前");
		}
	}

	/**
	 * テストケース2: パスワードが間違っている場合のログイン
	 * 存在するメンバーのIDと間違ったパスワードでログインし、nullが返されるか検証します。
	 * @param loginService テストに使用するLoginServiceインスタンス
	 */
	private static void testLoginWithIncorrectPassword(LoginService loginService) {
		System.out.println("\n▶ テストケース2: パスワードが間違っている場合のログイン");

		// MemberStorageに存在するメンバーのIDを使用
		int existingId = 2; // Sato KensukeのID
		String incorrectPassword = "wrong_password"; // 間違ったパスワード

		// doLoginメソッドを呼び出し
		Member loggedInMember = loginService.doLogin(existingId, incorrectPassword);

		// ログインが失敗し、nullが返されることを検証
		assertEquals(loggedInMember, null, "パスワードが間違っている場合のログイン - 戻り値がnullであること");
	}

	/**
	 * テストケース3: 存在しないIDでのログイン
	 * MemberStorageに存在しないIDでログインし、nullが返されるか検証します。
	 * @param loginService テストに使用するLoginServiceインスタンス
	 */
	private static void testLoginWithNonExistingId(LoginService loginService) {
		System.out.println("\n▶ テストケース3: 存在しないIDでのログイン");

		// 存在しないIDを使用
		int nonExistingId = 999;
		String anyPassword = "any_password"; // パスワードは何でもよい

		// doLoginメソッドを呼び出し
		Member loggedInMember = loginService.doLogin(nonExistingId, anyPassword);

		// ログインが失敗し、nullが返されることを検証
		assertEquals(loggedInMember, null, "存在しないIDでのログイン - 戻り値がnullであること");
	}

	/**
	 * テストケース4: nullパスワードでのログイン
	 * nullパスワードでログインした場合に、NullPointerExceptionが発生しないか、
	 * そしてnullが返されるか検証します。
	 * @param loginService テストに使用するLoginServiceインスタンス
	 */
	private static void testLoginWithNullPassword(LoginService loginService) {
		System.out.println("\n▶ テストケース4: nullパスワードでのログイン");

		// 存在するIDとnullパスワードを使用
		int existingId = 3; // Goto AyaのID
		String nullPassword = null; // nullパスワード

		try {
			// doLoginメソッドを呼び出し
			Member loggedInMember = loginService.doLogin(existingId, nullPassword);

			// ログインが失敗し、nullが返されることを検証
			assertEquals(loggedInMember, null, "nullパスワードでのログイン - 戻り値がnullであること");
			System.out.println("✓ nullパスワードでのログイン - NullPointerExceptionが発生しないこと - 成功");

		} catch (NullPointerException e) {
			// NullPointerExceptionが発生した場合は失敗
			System.err.println("✗ nullパスワードでのログイン - NullPointerExceptionが発生しないこと - 失敗");
			System.err.println("  NullPointerExceptionが発生しました: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("✗ nullパスワードでのログイン - 予期しない例外が発生しました: " + e.getClass().getName());
			e.printStackTrace();
		}
	}
}
