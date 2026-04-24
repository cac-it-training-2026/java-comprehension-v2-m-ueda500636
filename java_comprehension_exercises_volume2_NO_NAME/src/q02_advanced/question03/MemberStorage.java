package q02_advanced.question03;

import java.util.ArrayList;
import java.util.List;

class MemberStorage {

	private List<Member> members;

	/**
	 * @param members
	 */
	public MemberStorage() {
		this.members = new ArrayList<>();
		members.add(Member.getInstance(1, "Passw0rd", "Miura Manabu", 28, 2));
		members.add(Member.getInstance(2, "aaaaAAAA", "Sato Kensuke", 53, 1));
		members.add(Member.getInstance(3, "xxxxXXXX", "Goto Aya", 20, 3));
		members.add(Member.getInstance(4, "4f0sf7dm", "Enoki Shiho", 43, 2));
		members.add(Member.getInstance(5, "System3sss", "Asano Chika", 14, 1));

	}

	/**
	 * @return members
	 */
	public List<Member> getMembers() {
		return members;
	}

	/**
	 * @param members セットする members
	 */
	public void setMembers(List<Member> members) {
		this.members = members;
	}

}
