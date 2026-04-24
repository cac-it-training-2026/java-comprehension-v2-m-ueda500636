package q01_basic.question06;

import java.io.IOException;

/**
 * ConsoleReaderクラスのテストクラス (JUnitを使用しない手動テスト)
 * コンソールからの文字列および数値入力メソッドの動作を確認します。
 * テストの実行時には、ユーザーがコンソールに値を入力し、出力結果を目視で確認する必要があります。
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
public class ConsoleReaderTest06 {

	// ConsoleReaderのテストでは、入力と出力の対話的な確認が主なため、
	// MemberTest01のようなassertEqualsヘルパーメソッドは直接は使用しません。
	// 代わりに、テストケース内でSystem.out.printlnを使用してテストの指示と結果の観察を促します。

	/**
	 * メインメソッド - テストケースを実行
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		System.out.println("=== ConsoleReaderクラスのテスト開始 ===");

		// テスト対象のインスタンスを作成
		ConsoleReader reader = new ConsoleReader();

		// テストケース1: inputStringメソッドのテスト
		testInputString(reader);

		System.out.println("\n--- 次のテストに進みます ---");

		// テストケース2: inputNumberメソッドのテスト (正常系と異常系)
		testInputNumber(reader);

		System.out.println("\n=== ConsoleReaderクラスのテスト終了 ===");
	}

	/**
	 * テストケース1: inputStringメソッドのテスト
	 * ユーザーに文字列を入力してもらい、それが正しく読み取られて表示されるか確認します。
	 * @param reader テストに使用するConsoleReaderインスタンス
	 */
	private static void testInputString(ConsoleReader reader) {
		System.out.println("\n▶ テストケース1: inputStringメソッドのテスト");
		System.out.println("指示: コンソールに任意の文字列を入力し、Enterキーを押してください。");
		System.out.print("input string>>");

		try {
			// inputStringメソッドを呼び出し
			String input = reader.inputString();

			System.out.println("--- inputStringメソッドの出力 ---");
			System.out.println("読み取られた文字列: " + input);
			System.out.println("-----------------------------");

			// 出力内容を人が確認する必要があります。
			System.out.println("上記の「読み取られた文字列」が、あなたが入力した文字列と一致していれば成功です。");

		} catch (IOException e) {
			System.err.println("✗ テストケース1 - 失敗: IOExceptionが発生しました。");
			e.printStackTrace(); // 例外の詳細を表示
		} catch (Exception e) {
			System.err.println("✗ テストケース1 - 失敗: 予期しない例外が発生しました: " + e.getClass().getName());
			e.printStackTrace();
		}
	}

	/**
	 * テストケース2: inputNumberメソッドのテスト
	 * ユーザーに数値を入力してもらい、それが正しく読み取られて表示されるか確認します。
	 * また、数値を入力しない場合のNumberFormatExceptionの発生も確認します。
	 * @param reader テストに使用するConsoleReaderインスタンス
	 */
	private static void testInputNumber(ConsoleReader reader) {
		System.out.println("\n▶ テストケース2: inputNumberメソッドのテスト");

		// 正常系のテスト
		System.out.println("指示: コンソールに整数を入力し、Enterキーを押してください。");
		System.out.print("input number>>");

		try {
			// inputNumberメソッドを呼び出し (正常系)
			int inputNum = reader.inputNumber();

			System.out.println("--- inputNumberメソッドの出力 (正常系) ---");
			System.out.println("読み取られた数値: " + inputNum);
			System.out.println("-----------------------------------");

			// 出力内容を人が確認する必要があります。
			System.out.println("上記の「読み取られた数値」が、あなたが入力した整数と一致していれば成功です。");

		} catch (IOException e) {
			System.err.println("✗ テストケース2 (正常系) - 失敗: IOExceptionが発生しました。");
			e.printStackTrace(); // 例外の詳細を表示
		} catch (NumberFormatException e) {
			// 正常系ではNumberFormatExceptionは期待しない
			System.err.println("✗ テストケース2 (正常系) - 失敗: NumberFormatExceptionが発生しました。");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("✗ テストケース2 (正常系) - 失敗: 予期しない例外が発生しました: " + e.getClass().getName());
			e.printStackTrace();
		}

		System.out.println("\n--- inputNumberメソッドの異常系テスト ---");
		// 異常系 (NumberFormatException) のテスト
		System.out.println("指示: コンソールに数値を**入力せず**、文字列などを入力し、Enterキーを押してください。");
		System.out.println("NumberFormatExceptionが発生することが期待されます。");
		System.out.print("input string>>");

		try {
			// inputNumberメソッドを呼び出し (異常系)
			int inputNum = reader.inputNumber(); // ここでNumberFormatExceptionが発生することを期待

			// 例外が発生しなかった場合は失敗
			System.err.println("✗ テストケース2 (異常系) - 失敗: NumberFormatExceptionが発生しませんでした。");
			System.out.println("予期せず読み取られた数値: " + inputNum);

		} catch (IOException e) {
			System.err.println("✗ テストケース2 (異常系) - 失敗: IOExceptionが発生しました（NumberFormatExceptionが期待されました）。");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// 期待通りの例外が発生した場合
			System.out.println("✓ テストケース2 (異常系) - 成功: 期待通りNumberFormatExceptionが発生しました。");
			// 例外の詳細を表示する場合はコメントアウトを外す
			// e.printStackTrace();
		} catch (Exception e) {
			System.err.println("✗ テストケース2 (異常系) - 失敗: 予期しない例外が発生しました: " + e.getClass().getName());
			e.printStackTrace();
		}

		// 結果を人が確認する必要があります。
		System.out.println("上記の出力で、数値を入力した際に正しく表示され、数値を入力しなかった際にNumberFormatExceptionが発生していれば成功です。");
	}
}
