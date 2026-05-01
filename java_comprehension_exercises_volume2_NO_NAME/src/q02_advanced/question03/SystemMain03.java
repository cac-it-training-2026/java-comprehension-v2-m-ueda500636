package q02_advanced.question03;

import java.io.IOException;

public class SystemMain03 {

	public static void main(String[] args) {

		LoginService loginService = new LoginService(new MemberStorage());
		System.out.println("ログイン情報を入力してください");
		boolean isLogin = false;
		//TODO ここから実装する

		ConsoleReader consolereader = new ConsoleReader();
		MemberStorage memberstorage = new MemberStorage();
		LoginService loginservice = new LoginService(memberstorage);

		int inputId = 0;
		String inputPassword = null;

		while (isLogin) {

			System.out.println("input target id>>");

			try {
				inputId = consolereader.inputNumber();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			} catch (NumberFormatException e) {
				e.printStackTrace();

				return;
			}
			System.out.println("input new password>>");

			try {
				inputPassword = consolereader.inputString();
			} catch (IOException e) {
				e.printStackTrace();
				return;

			}

			Member loginUser = null;

			loginUser = loginservice.doLogin(inputId, inputPassword);
			if (loginUser == null) {
				System.out.println("IDまたはパスワードが違っています。再度入力してください。");
				continue;
			} else {
				System.out.println("ログインに成功しました");
				isLogin = true;
				break;
			}
		}
	}

}
