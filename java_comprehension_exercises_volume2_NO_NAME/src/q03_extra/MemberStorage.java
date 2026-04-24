package q03_extra;

import java.util.ArrayList;
import java.util.List;

public class MemberStorage {

	private List<Member> members;

	/**
	 * @param members
	 */
	public MemberStorage() {
		this.members = new ArrayList<>();
		members.add(Member.getInstance(1, "Passw0rd", "Miura Manabu", "1998/02/21"));
		members.add(Member.getInstance(2, "aaaaAAAA", "Sato Kensuke", "1986/04/16"));
		members.add(Member.getInstance(3, "xxxxXXXX", "Goto Aya", "1948/03/01"));
		members.add(Member.getInstance(4, "4f0sf7dm", "Enoki Shiho", "1966/12/31"));
		members.add(Member.getInstance(5, "System3sss", "Asano Chika", "2004/08/08"));

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
