package q02_advanced.question01;

import java.util.ArrayList;
import java.util.List;

/**
 * Memberクラスのテストクラス (JUnitを使用しない手動テスト)
 * Memberクラスのコンストラクタ、getter/setter、showMember、toStringメソッドの動作を確認します。
 * Couponクラスとの連携も考慮します。
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
public class MemberTestWithCoupons01 {

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
		System.out.println("=== Memberクラスのテスト開始 ===");

		// テストケース1: デフォルトコンストラクタとsetter/getterのテスト
		testDefaultConstructorAndSettersGetters();

		// テストケース2: 引数付きコンストラクタとgetterのテスト
		testParameterizedConstructorAndGetters();

		// テストケース3: showMemberメソッドのテスト (toStringメソッドを含む出力の目視確認)
		testShowMemberAndToString();

		// テストケース4: クーポンリストの初期状態のテスト (引数付きコンストラクタ)
		testCouponListInitialization();

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
		int testId = 101;
		String testPassword = "default_pass";
		String testName = "デフォルトメンバー";
		int testAge = 20;
		int testRank = 5;

		member.setId(testId);
		member.setPassword(testPassword);
		member.setName(testName);
		member.setAge(testAge);
		member.setRank(testRank);

		// 各getterで取得した値が正しいか検証
		assertEquals(member.getId(), testId, "getIdメソッドのテスト (デフォルトコンストラクタ)");
		assertEquals(member.getPassword(), testPassword, "getPasswordメソッドのテスト (デフォルトコンストラクタ)");
		assertEquals(member.getName(), testName, "getNameメソッドのテスト (デフォルトコンストラクタ)");
		assertEquals(member.getAge(), testAge, "getAgeメソッドのテスト (デフォルトコンストラクタ)");
		assertEquals(member.getRank(), testRank, "getRankメソッドのテスト (デフォルトコンストラクタ)");

		// デフォルトコンストラクタでクーポンリストがnullであることを期待する場合の検証
		// 提供されたMember.javaのデフォルトコンストラクタはcouponsを初期化しないためnullです。
		assertEquals(member.getCoupons(), null, "クーポンリストの初期状態 (デフォルトコンストラクタ)"); // privateフィールドへの直接アクセス
	}

	/**
	 * テストケース2: 引数付きコンストラクタとgetterのテスト
	 * 引数付きコンストラクタでインスタンスを作成し、各getterで正しく値が取得できるか検証します。
	 */
	private static void testParameterizedConstructorAndGetters() {
		System.out.println("\n▶ テストケース2: 引数付きコンストラクタとgetterのテスト");

		// テスト用の値
		int testId = 202;
		String testPassword = "secure_pass_456";
		String testName = "パラメータメンバー";
		int testAge = 30;
		int testRank = 1;

		// テスト対象のインスタンスを作成 (引数付きコンストラクタを使用)
		Member member = new Member(testId, testPassword, testName, testAge, testRank);

		// 各getterで取得した値が正しいか検証
		assertEquals(member.getId(), testId, "getIdメソッドのテスト (引数付きコンストラクタ)");
		assertEquals(member.getPassword(), testPassword, "getPasswordメソッドのテスト (引数付きコンストラクタ)");
		assertEquals(member.getName(), testName, "getNameメソッドのテスト (引数付きコンストラクタ)");
		assertEquals(member.getAge(), testAge, "getAgeメソッドのテスト (引数付きコンストラクタ)");
		assertEquals(member.getRank(), testRank, "getRankメソッドのテスト (引数付きコンストラクタ)");

		// 引数付きコンストラクタでクーポンリストが初期化されることを期待
		// 提供されたMember.javaの引数付きコンストラクタはcoupons = new ArrayList<>();で初期化しています。
		assertEquals(member.getCoupons() != null, true, "クーポンリストが初期化されているか (引数付きコンストラクタ)"); // privateフィールドへの直接アクセス
	}

	/**
	 * テストケース3: showMemberメソッドのテスト
	 * showMemberメソッドが呼び出され、toStringメソッドの出力内容がコンソールに表示されるか確認します。
	 * このテストはコンソール出力の目視確認が必要です。
	 */
	private static void testShowMemberAndToString() {
		System.out.println("\n▶ テストケース3: showMemberメソッドとtoStringメソッドのテスト");

		// テスト対象のインスタンスを作成し、値を設定
		Member member = new Member(303, "show_pass", "表示テストメンバー", 40, 2);

		System.out.println("--- showMemberメソッドの出力開始 ---");
		// showMemberメソッドを呼び出し
		member.showMember();
		System.out.println("--- showMemberメソッドの出力終了 ---");

		// toStringメソッドの出力内容も確認
		System.out.println("--- toStringメソッドの出力 ---");
		System.out.println(member.toString());
		System.out.println("--------------------------");

		// 出力内容を人が確認する必要があります。
		System.out.println("上記の出力に、ID, password, name, age, rank, およびクーポンリストの情報が正しく表示されていれば成功です。");
	}

	/**
	 * テストケース4: クーポンリストの初期状態のテスト (引数付きコンストラクタ)
	 * 引数付きコンストラクタで作成されたMemberインスタンスのクーポンリストが、
	 * 期待される初期クーポンで正しく初期化されているか検証します。
	 * クーポンリストを取得するためのgetter (例: getCoupons()) がMemberクラスに必要です。
	 * 提供されたMember.javaにはgetCoupons()がないため、テストするためにはMemberクラスにgetterを追加するか、
	 * リフレクションを使用する必要があります。ここではprivateフィールドに直接アクセスして検証します。
	 */
	private static void testCouponListInitialization() {
		System.out.println("\n▶ テストケース4: クーポンリストの初期状態のテスト (引数付きコンストラクタ)");

		// テスト用の値 (コンストラクタに渡す値)
		int testId = 404;
		String testPassword = "coupon_test_pass";
		String testName = "クーポンテストメンバー";
		int testAge = 35;
		int testRank = 3;

		// テスト対象のインスタンスを作成 (引数付きコンストラクタを使用)
		Member member = new Member(testId, testPassword, testName, testAge, testRank);

		// 期待されるクーポンリストを作成
		List<Coupon> expectedCoupons = new ArrayList<>();
		expectedCoupons.add(new Coupon(1, 0.5, "最初の特典"));
		expectedCoupons.add(new Coupon(2, 0.25, "今月の特典"));

		// Memberクラスのprivateフィールドに直接アクセスしてクーポンリストを取得
		List<Coupon> actualCoupons = member.getCoupons();

		// クーポンリストの内容が期待されるリストと一致するかassertCouponListEqualsで検証
		assertCouponListEquals(actualCoupons, expectedCoupons, "クーポンリストの初期状態の検証 (引数付きコンストラクタ)");
	}
}
