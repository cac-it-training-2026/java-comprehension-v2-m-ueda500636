package q01_basic.question04;

/**
 * MemberManagerクラスのテストクラス (JUnitを使用しない手動テスト)
 * MemberTest01を参考に、showAllMembersメソッドの動作を確認します。
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
public class MemberManagerTest04 {

	// MemberManager.showAllMembersはコンソール出力が主な動作のため、
	// このメソッドは直接的な出力検証には使用しませんが、テスト構造をMemberTest01に合わせるために定義します。
	/**
	 * テスト結果を検証するためのヘルパーメソッド (今回は出力検証がメインのため、主にprint文で結果を確認します)
	 * @param actual 実際の値
	 * @param expected 期待値
	 * @param testName テスト名
	 */
	private static void assertEquals(Object actual, Object expected, String testName) {
		// showAllMembersのテストでは、このメソッドによる自動検証は行いません。
		// 代わりに、テストケース内のSystem.out.printlnを使用して、
		// ユーザーがコンソール出力を目視で確認することを促します。
		if ((actual == null && expected == null) || (actual != null && actual.equals(expected))) {
			System.out.println("✓ (出力確認が必要) " + testName + " - 成功の可能性");
		} else {
			System.err.println("✗ (出力確認が必要) " + testName + " - 失敗の可能性");
			System.err.println("  期待値: " + expected);
			System.err.println("  実際値: " + actual);
		}
	}

	/**
	 * メインメソッド - テストケースを実行
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		System.out.println("=== MemberManagerクラスのテスト開始 ===");

		// テストケース1: 複数のメンバーを含む配列でのテスト
		testShowAllMembersWithMultipleMembers();

		// テストケース2: 空のメンバー配列でのテスト
		testShowAllMembersWithEmptyArray();

		// テストケース3: nullを含むメンバー配列でのテスト (NullPointerExceptionが発生する)
		// MemberManagerの実装ではNullPointerExceptionが発生します。
		testShowAllMembersWithNullMembers();

		System.out.println("=== MemberManagerクラスのテスト終了 ===");
	}

	/**
	 * テストケース1: 複数のメンバーを含む配列でshowAllMembersメソッドをテスト
	 * コンソール出力を見て、各メンバーの情報が正しく表示されているか手動で確認してください。
	 * @param memberClass テストに使用するMemberクラス
	 */
	private static void testShowAllMembersWithMultipleMembers() {
		System.out.println("\n▶ テストケース1: 複数のメンバーを含む配列でのテスト");

		try {
			Member member1 = new Member();
			member1.setName("山田太郎");
			member1.setAge(30);
			member1.setRank(2);

			Member member2 = new Member();
			member2.setName("佐藤花子");
			member2.setAge(25);
			member2.setRank(3);

			Member member3 = new Member();
			member3.setName("鈴木一郎");
			member3.setAge(40);
			member3.setRank(1);

			// Memberオブジェクトの配列を作成
			Member[] members = { member1, member2, member3 };

			System.out.println("--- MemberManager.showAllMembers の出力開始 ---");
			// showAllMembersメソッドを呼び出し
			MemberManager.showAllMembers(members);
			System.out.println("--- MemberManager.showAllMembers の出力終了 ---");

			// 出力内容を人が確認する必要があります。
			System.out.println("上記の出力が各メンバー情報（山田太郎, 佐藤花子, 鈴木一郎）を正しく表示していれば成功です。");

		} catch (Exception e) {
			System.err.println("✗ テストケース1 - エラーが発生しました: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * テストケース2: 空のメンバー配列でshowAllMembersメソッドをテスト
	 * 何も出力されないことを手動で確認してください。
	 * @param memberClass テストに使用するMemberクラス
	 */
	private static void testShowAllMembersWithEmptyArray() {
		System.out.println("\n▶ テストケース2: 空のメンバー配列でのテスト");

		try {
			// 空のMember配列を作成
			Member[] members = {};

			System.out.println("--- MemberManager.showAllMembers (空配列) の出力開始 ---");
			// showAllMembersメソッドを呼び出し
			MemberManager.showAllMembers(members);
			System.out.println("--- MemberManager.showAllMembers (空配列) の出力終了 ---");

			// 出力内容を人が確認する必要があります。
			System.out.println("上記の出力開始行と終了行の間に何も出力されていなければ成功です。");

		} catch (Exception e) {
			System.err.println("✗ テストケース2 - エラーが発生しました: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * テストケース3: nullを含むメンバー配列でshowAllMembersメソッドをテスト
	 * NullPointerExceptionが発生するか、あるいはMember.showMember()がnullを適切に扱えるか手動で確認してください。
	 * MemberManagerの実装ではNullPointerExceptionが発生します。
	 * @param memberClass テストに使用するMemberクラス
	 */
	private static void testShowAllMembersWithNullMembers() {
		System.out.println("\n▶ テストケース3: nullを含むメンバー配列でのテスト");

		try {
			// nullを含むMember配列を作成
			Member member1 = new Member();
			member1.setName("山田太郎");
			member1.setAge(30);
			member1.setRank(2);

			Member[] members = { member1, null }; // 2番目の要素をnullにする

			System.out.println("--- MemberManager.showAllMembers (null含む配列) の出力開始 ---");
			// showAllMembersメソッドを呼び出し
			MemberManager.showAllMembers(members);
			System.out.println("--- MemberManager.showAllMembers (null含む配列) の出力終了 ---");
			System.err.println("✗ テストケース3 - 失敗: NullPointerExceptionが発生しませんでした。");

		} catch (NullPointerException e) {
			System.out.println("--- MemberManager.showAllMembers (null含む配列) の出力終了 ---");
			System.out.println("✓ テストケース3 - 成功: 期待通りNullPointerExceptionが発生しました。");
			// スタックトレースを表示する場合はコメントアウトを外す
			// e.printStackTrace();
		} catch (Exception e) {
			System.out.println("--- MemberManager.showAllMembers (null含む配列) の出力終了 ---");
			System.err.println("✗ テストケース3 - 失敗: 予期しない例外が発生しました: " + e.getClass().getName());
			e.printStackTrace();
		}

		// 出力内容と例外発生を人が確認する必要があります。
		System.out.println("山田太郎の情報が出力され、その後NullPointerExceptionが発生していれば成功です。");
	}
}
