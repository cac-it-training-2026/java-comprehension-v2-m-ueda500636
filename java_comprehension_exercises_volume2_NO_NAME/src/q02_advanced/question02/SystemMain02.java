package q02_advanced.question02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SystemMain02 {

	public static void main(String[] args) {

		//TODO ここから実装する
		ConsoleReader consolereader = new ConsoleReader();

		List<Member> members = new ArrayList<>();
		Member member1 = Member.getInstance(1, "passwOrd", "Miura Manabu", 28, 2);
		Member member2 = Member.getInstance(2, "aaaAAA", "Sato Kensuke", 43, 1);

		members.add(member1);
		members.add(member2);

		System.out.println("===会員情報を表示します===");
		MemberManager.showAllMembers(members);
		System.out.println("**************");

		System.out.println("===パスワードを変更します===");
		System.out.println("input target id>>");
		int num;

		try {
			num = consolereader.inputNumber();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return;
		}

		System.out.println("input new password>>");
		String pass;

		try {
			pass = consolereader.inputString();
		} catch (IOException e) {
			e.printStackTrace();
			return;

		}

		MemberManager.updatePassword(members, num, pass);
		MemberManager.showAllMembers(members);

	}

}
