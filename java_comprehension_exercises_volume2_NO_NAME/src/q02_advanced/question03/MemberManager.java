package q02_advanced.question03;

import java.util.List;

import q02_advanced.question02.Member;

public class MemberManager {

	private MemberManager() {

	}

	public static void showAllMembers(List<Member> members) {
		for (Member member : members) {
			member.showMember();

		}
	}

	public static void updatePassword(List<Member> members, int targetId, String newPassword) {
		boolean correct = false;
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getId() == targetId) {
				members.get(i).getPassword();
				members.get(i).setPassword(newPassword);
				correct = true;

			} else {
				correct = false;
			}
		}

		if (correct) {
			System.out.println("該当者はいませんでした。");
		}

	}
}
