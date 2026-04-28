package q01_basic.question05;

public class NonMember extends AbstMember {

	/**
	 * 
	 */
	public NonMember(String name) {
		this.name = name;

		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void buyItem() {
		System.out.println(name + " purchased the item at a fixed price");

	}

	public void showMember() {
		System.out.println("***MEMBER DATA***");
		System.out.println(name + "is a nonmember");
		System.out.println("*****************");

	}

}
