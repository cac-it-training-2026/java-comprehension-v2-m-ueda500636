package q02_advanced.question02;

import java.util.ArrayList; // テスト内でArrayListを使用するためインポート
import java.util.List;

// MemberクラスとCouponクラスが同じパッケージ (q02_advanced.question02) に存在することを前提とします。

/**
 * MemberManagerクラスのテストクラス (JUnitを使用しない手動テスト)
 * MemberManagerの静的メソッド showAllMembers および updatePassword の動作を確認します。
 * テスト結果の一部はコンソール出力の目視確認が必要です。
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
public class MemberManagerTest02 {

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
	* テスト結果を検証するためのヘルパーメソッド (List<Coupon>用)
	* クーポンリストの内容が期待値と一致するかを検証します。
	* Couponクラスに適切なequalsメソッドがない場合、この比較はオブジェクト参照の比較になります。
	* 内容比較を行うには、Couponクラスにequalsメソッドを実装するか、各フィールドを個別に比較する必要があります。
	* ここでは簡易的にリストのサイズと各要素のtoString()の結果を比較します。
	* @param actualList 実際のリスト
	* @param expectedList 期待されるリスト
	* @param testName テスト名
	*/
	private static void assertCouponListEquals(List<Coupon> actualList, List<Coupon> expectedList, String testName) {
		boolean isEqual = true;
		if (actualList == null || expectedList == null) {
			isEqual = (actualList == expectedList); // 両方nullならtrue、片方だけnullならfalse
		} else if (actualList.size() != expectedList.size()) {
			isEqual = false;
		} else {
			for (int i = 0; i < actualList.size(); i++) {
				Coupon actualCoupon = actualList.get(i);
				Coupon expectedCoupon = expectedList.get(i);
				// CouponクラスのtoString()の結果を比較して内容が一致するか確認
				if (actualCoupon == null || expectedCoupon == null
						|| !actualCoupon.toString().equals(expectedCoupon.toString())) {
					isEqual = false;
					break;
				}
			}
		}

		if (isEqual) {
			System.out.println("✓ " + testName + " - 成功");
		} else {
			System.err.println("✗ " + testName + " - 失敗");
			System.out.println("  期待値: " + expectedList);
			System.out.println("  実際値: " + actualList);
		}
	}

	/**
	 * メインメソッド - テストケースを実行
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		System.out.println("=== MemberManagerクラスのテスト開始 ===");

		// Memberオブジェクトを作成するためのダミーデータ
		List<Member> members = new ArrayList<>();
		// Member.getInstanceメソッドを使用してインスタンスを作成
		members.add(Member.getInstance(1, "pass1", "山田太郎", 30, 2));
		members.add(Member.getInstance(2, "pass2", "佐藤花子", 25, 3));
		members.add(Member.getInstance(3, "pass3", "鈴木一郎", 40, 1));

		// テストケース1: showAllMembersメソッドのテスト
		testShowAllMembers(members);

		System.out.println("\n--- 次のテストに進みます ---");

		// テストケース2: updatePasswordメソッドのテスト (該当者あり)
		testUpdatePasswordExisting(members);

		System.out.println("\n--- 次のテストに進みます ---");

		// テストケース3: updatePasswordメソッドのテスト (該当者なし)
		testUpdatePasswordNonExisting(members);

		System.out.println("\n=== MemberManagerクラスのテスト終了 ===");
	}

	/**
	 * テストケース1: showAllMembersメソッドのテスト
	 * Memberリストを渡し、各メンバーの情報がコンソールに正しく出力されるか確認します。
	 * このテストはコンソール出力の目視確認が必要です。
	 * @param members テストに使用するMemberリスト
	 */
	private static void testShowAllMembers(List<Member> members) {
		System.out.println("\n▶ テストケース1: showAllMembersメソッドのテスト");
		System.out.println("指示: 以下の出力が、各メンバー情報（id, password, name, age, rank, coupons）を正しく表示しているか目視で確認してください。");

		System.out.println("--- MemberManager.showAllMembers の出力開始 ---");
		// showAllMembersメソッドを呼び出し
		MemberManager.showAllMembers(members);
		System.out.println("--- MemberManager.showAllMembers の出力終了 ---");

		// 出力内容を人が確認する必要があります。
		System.out.println("上記の出力が期待通りであれば、テストケース1は成功です。");
	}

	/**
	 * テストケース2: updatePasswordメソッドのテスト (該当者あり)
	 * 存在するメンバーのパスワードが正しく更新されるか検証します。
	 * @param members テストに使用するMemberリスト
	 */
	private static void testUpdatePasswordExisting(List<Member> members) {
		System.out.println("\n▶ テストケース2: updatePasswordメソッドのテスト (該当者あり)");

		int targetId = 2; // 佐藤花子のID
		String newPassword = "new_password_for_hana";

		// updatePasswordメソッドを呼び出し
		MemberManager.updatePassword(members, targetId, newPassword);

		// IDがtargetIdのメンバーのパスワードが更新されているか検証
		String actualPassword = null;
		for (Member member : members) {
			if (member.getId() == targetId) {
				actualPassword = member.getPassword();
				break;
			}
		}

		assertEquals(actualPassword, newPassword, "updatePassword - 存在するメンバーのパスワード更新");

		// 他のメンバーのパスワードが変更されていないことも確認（オプション）
		assertEquals(members.get(0).getPassword(), "pass1", "updatePassword - 他メンバーのパスワードが変更されていないか (山田太郎)");
		assertEquals(members.get(2).getPassword(), "pass3", "updatePassword - 他メンバーのパスワードが変更されていないか (鈴木一郎)");

		// 更新後のリスト全体を表示して目視確認することも有効です
		// System.out.println("\n--- パスワード更新後のメンバーリスト ---");
		// MemberManager.showAllMembers(members);
		// System.out.println("------------------------------------");
	}

	/**
	 * テストケース3: updatePasswordメソッドのテスト (該当者なし)
	 * 存在しないメンバーのIDを指定した場合に、パスワードが更新されず、
	 * "該当者はいませんでした。"というメッセージが表示されるか確認します。
	 * メッセージの表示はコンソール出力の目視確認が必要です。
	 * @param members テストに使用するMemberリスト
	 */
	private static void testUpdatePasswordNonExisting(List<Member> members) {
		System.out.println("\n▶ テストケース3: updatePasswordメソッドのテスト (該当者なし)");
		System.out.println("指示: 「該当者はいませんでした。」というメッセージがコンソールに表示されるか目視で確認してください。");

		int targetId = 999; // 存在しないID
		String newPassword = "should_not_be_set";

		// updatePassword呼び出し前のパスワードを記録
		String originalPassword1 = members.get(0).getPassword();
		String originalPassword2 = members.get(1).getPassword();
		String originalPassword3 = members.get(2).getPassword();

		System.out.println("--- updatePassword (該当者なし) の出力開始 ---");
		// updatePasswordメソッドを呼び出し
		MemberManager.updatePassword(members, targetId, newPassword);
		System.out.println("--- updatePassword (該当者なし) の出力終了 ---");

		// どのメンバーのパスワードも変更されていないことを検証
		assertEquals(members.get(0).getPassword(), originalPassword1,
				"updatePassword - 該当者なしの場合パスワードが変更されていないか (山田太郎)");
		assertEquals(members.get(1).getPassword(), originalPassword2,
				"updatePassword - 該当者なしの場合パスワードが変更されていないか (佐藤花子)"); // 佐藤花子はテストケース2でパスワードが変更されている可能性があります
		// テストケース2の後に実行されるため、佐藤花子のパスワードは"new_password_for_hana"になっているはずです。
		// したがって、ここでは "new_password_for_hana" と比較するのが適切です。
		// テストケースの実行順序に依存しないように、各テストケースで新しいメンバーリストを作成することも検討できます。
		// 今回はシンプルに、テストケース2の変更後の状態を前提とします。
		assertEquals(members.get(1).getPassword(), "new_password_for_hana",
				"updatePassword - 該当者なしの場合パスワードが変更されていないか (佐藤花子)");
		assertEquals(members.get(2).getPassword(), originalPassword3,
				"updatePassword - 該当者なしの場合パスワードが変更されていないか (鈴木一郎)");

		// "該当者はいませんでした。" のメッセージが表示されたか、人が確認する必要があります。
		System.out.println("上記の出力開始行と終了行の間に「該当者はいませんでした。」と表示されていれば、テストケース3は成功です。");
	}
}
