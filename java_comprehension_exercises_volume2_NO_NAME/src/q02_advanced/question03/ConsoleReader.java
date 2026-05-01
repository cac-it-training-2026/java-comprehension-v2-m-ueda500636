package q02_advanced.question03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
	public String inputString() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str1 = reader.readLine();
		return str1;
	}

	public int inputNumber() throws IOException, NumberFormatException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str2 = reader.readLine();
		int num = Integer.parseInt(str2);

		return num;
	}

}
