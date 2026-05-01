package q01_basic.question06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 標準入力を制御するクラス
 */
class ConsoleReader {

	/**
	 * 文字列の標準入力。
	 * 
	 * @return 入力文字列
	 * @throws IOException
	 */
	public String inputString() throws IOException {
		//TODO ここから実装する
		System.out.println("input id>>");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String inputId = reader.readLine();

		return inputId;
	}

	/**
	 * 整数の標準入力。
	 * 
	 * @return 入力整数
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public int inputNumber() throws IOException, NumberFormatException {
		//TODO ここから実装する
		System.out.println("input password>>");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str2 = reader.readLine();
		int inputPassword = Integer.parseInt(str2);

		return inputPassword;

	}

}
