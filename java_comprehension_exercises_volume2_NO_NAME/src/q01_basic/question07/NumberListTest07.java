package q01_basic.question07;

import java.util.ArrayList; // テスト内でArrayListを使用するためインポート
import java.util.List;

/**
 * NumberListクラスのテストクラス (JUnitを使用しない手動テスト)
 * NumberListの各メソッドの動作を確認します。
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
public class NumberListTest07 {

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
	* テスト結果を検証するためのヘルパーメソッド (List<Integer>用)
	* リストの内容が期待値と一致するかを検証します。
	* @param actualList 実際のリスト
	* @param expectedList 期待されるリスト
	* @param testName テスト名
	*/
	private static void assertListEquals(List<Integer> actualList, List<Integer> expectedList, String testName) {
		boolean isEqual = true;
		if (actualList.size() != expectedList.size()) {
			isEqual = false;
		} else {
			for (int i = 0; i < actualList.size(); i++) {
				if (!actualList.get(i).equals(expectedList.get(i))) {
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
		System.out.println("=== NumberListクラスのテスト開始 ===");

		// テストケース1: addFromOneToメソッドのテスト
		testAddFromOneTo();

		// テストケース2: calcSumOfListメソッドのテスト
		testCalcSumOfList();

		// テストケース3: doubleListEachValueメソッドのテスト
		testDoubleListEachValue();

		// テストケース4: removeIndexOfFirstHalfメソッドのテスト
		testRemoveIndexOfFirstHalf();

		System.out.println("=== NumberListクラスのテスト終了 ===");
	}

	/**
	 * テストケース1: addFromOneToメソッドのテスト
	 * 指定した範囲の数値がリストに正しく追加されるか検証します。
	 */
	private static void testAddFromOneTo() {
		System.out.println("\n▶ テストケース1: addFromOneToメソッドのテスト");

		// テスト対象のインスタンスを作成
		NumberList numberList = new NumberList();

		// 1から5までの数値を追加
		numberList.addFromOneTo(5);

		// 期待されるリスト
		List<Integer> expectedList = new ArrayList<>();
		expectedList.add(1);
		expectedList.add(2);
		expectedList.add(3);
		expectedList.add(4);
		expectedList.add(5);

		// リストの内容を検証
		assertListEquals(numberList.getNumbers(), expectedList, "addFromOneTo(5)の検証");

		// リストをクリアして別の範囲で再テスト
		numberList = new NumberList(); // 新しいインスタンスまたはリストをクリア
		numberList.addFromOneTo(3);
		expectedList = new ArrayList<>();
		expectedList.add(1);
		expectedList.add(2);
		expectedList.add(3);
		assertListEquals(numberList.getNumbers(), expectedList, "addFromOneTo(3)の検証");

		// 0を渡した場合のテスト (何も追加されないことを期待)
		numberList = new NumberList();
		numberList.addFromOneTo(0);
		expectedList = new ArrayList<>(); // 空のリスト
		assertListEquals(numberList.getNumbers(), expectedList, "addFromOneTo(0)の検証");

		// 負の数を渡した場合のテスト (何も追加されないことを期待)
		numberList = new NumberList();
		numberList.addFromOneTo(-5);
		expectedList = new ArrayList<>(); // 空のリスト
		assertListEquals(numberList.getNumbers(), expectedList, "addFromOneTo(-5)の検証");
	}

	/**
	 * テストケース2: calcSumOfListメソッドのテスト
	 * リスト内の数値の合計が正しく計算されるか検証します。
	 */
	private static void testCalcSumOfList() {
		System.out.println("\n▶ テストケース2: calcSumOfListメソッドのテスト");

		// テスト対象のインスタンスを作成
		NumberList numberList = new NumberList();

		// テスト用のリストを作成し設定
		List<Integer> testList1 = new ArrayList<>();
		testList1.add(1);
		testList1.add(2);
		testList1.add(3);
		testList1.add(4);
		testList1.add(5);
		numberList.setNumbers(testList1);

		// 合計値の検証 (1+2+3+4+5 = 15)
		assertEquals(numberList.calcSumOfList(), 15, "calcSumOfList (1-5の合計)");

		// 別のリストで再テスト
		List<Integer> testList2 = new ArrayList<>();
		testList2.add(10);
		testList2.add(20);
		testList2.add(30);
		numberList.setNumbers(testList2);

		// 合計値の検証 (10+20+30 = 60)
		assertEquals(numberList.calcSumOfList(), 60, "calcSumOfList (10, 20, 30の合計)");

		// 空のリストの場合のテスト (合計が0になることを期待)
		numberList.setNumbers(new ArrayList<>());
		assertEquals(numberList.calcSumOfList(), 0, "calcSumOfList (空のリスト)");
	}

	/**
	 * テストケース3: doubleListEachValueメソッドのテスト
	 * リスト内の各数値が2倍にされるか検証します。
	 */
	private static void testDoubleListEachValue() {
		System.out.println("\n▶ テストケース3: doubleListEachValueメソッドのテスト");

		// テスト対象のインスタンスを作成
		NumberList numberList = new NumberList();

		// テスト用のリストを作成し設定
		List<Integer> testList = new ArrayList<>();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		numberList.setNumbers(testList);

		// doubleListEachValueメソッドを呼び出し
		numberList.doubleListEachValue();

		// 期待されるリスト (各要素が2倍)
		List<Integer> expectedList = new ArrayList<>();
		expectedList.add(2);
		expectedList.add(4);
		expectedList.add(6);

		// リストの内容を検証
		assertListEquals(numberList.getNumbers(), expectedList, "doubleListEachValueの検証");

		// 空のリストの場合のテスト (何も変更されないことを期待)
		numberList.setNumbers(new ArrayList<>());
		numberList.doubleListEachValue();
		expectedList = new ArrayList<>(); // 空のリスト
		assertListEquals(numberList.getNumbers(), expectedList, "doubleListEachValue (空のリスト)");
	}

	/**
	 * テストケース4: removeIndexOfFirstHalfメソッドのテスト
	 * リストの前半部分が削除されるか検証します。
	 * リストのサイズが奇数の場合と偶数の場合で確認します。
	 */
	private static void testRemoveIndexOfFirstHalf() {
		System.out.println("\n▶ テストケース4: removeIndexOfFirstHalfメソッドのテスト");

		// テスト対象のインスタンスを作成
		NumberList numberList = new NumberList();

		// 偶数サイズのリストでのテスト (サイズ6 -> 前半3つ削除)
		List<Integer> testList1 = new ArrayList<>();
		testList1.add(1);
		testList1.add(2);
		testList1.add(3);
		testList1.add(4);
		testList1.add(5);
		testList1.add(6);
		numberList.setNumbers(testList1);

		// removeIndexOfFirstHalfメソッドを呼び出し
		numberList.removeIndexOfFirstHalf();

		// 期待されるリスト (後半部分)
		List<Integer> expectedList1 = new ArrayList<>();
		expectedList1.add(4);
		expectedList1.add(5);
		expectedList1.add(6);

		// リストの内容を検証
		assertListEquals(numberList.getNumbers(), expectedList1, "removeIndexOfFirstHalf (偶数サイズ)");

		// 奇数サイズのリストでのテスト (サイズ5 -> 前半2つ削除)
		numberList = new NumberList(); // 新しいインスタンスまたはリストをクリア
		List<Integer> testList2 = new ArrayList<>();
		testList2.add(10);
		testList2.add(20);
		testList2.add(30);
		testList2.add(40);
		testList2.add(50);
		numberList.setNumbers(testList2);

		// removeIndexOfFirstHalfメソッドを呼び出し
		numberList.removeIndexOfFirstHalf();

		// 期待されるリスト (後半部分)
		List<Integer> expectedList2 = new ArrayList<>();
		expectedList2.add(30);
		expectedList2.add(40);
		expectedList2.add(50);

		// リストの内容を検証
		assertListEquals(numberList.getNumbers(), expectedList2, "removeIndexOfFirstHalf (奇数サイズ)");

		// サイズ1のリストでのテスト (前半0個削除)
		numberList = new NumberList();
		List<Integer> testList3 = new ArrayList<>();
		testList3.add(100);
		numberList.setNumbers(testList3);

		numberList.removeIndexOfFirstHalf();

		List<Integer> expectedList3 = new ArrayList<>();
		expectedList3.add(100);
		assertListEquals(numberList.getNumbers(), expectedList3, "removeIndexOfFirstHalf (サイズ1)");

		// 空のリストの場合のテスト (何も変更されないことを期待)
		numberList = new NumberList();
		numberList.setNumbers(new ArrayList<>());
		numberList.removeIndexOfFirstHalf();
		List<Integer> expectedList4 = new ArrayList<>(); // 空のリスト
		assertListEquals(numberList.getNumbers(), expectedList4, "removeIndexOfFirstHalf (空のリスト)");
	}

}
