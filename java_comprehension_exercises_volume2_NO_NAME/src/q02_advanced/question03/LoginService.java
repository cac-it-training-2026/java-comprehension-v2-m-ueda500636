package q02_advanced.question03;

/**
 * MemberStorageにアクセスし、ログイン処理を行う
 */
class LoginService {

	/**
	 * memberStorage Memberクラスのリスト一覧
	 */
	private MemberStorage memberStorage;

	//TODO ここから処理を記述

	/**
	 * @param memberStorage
	 */
	public LoginService(MemberStorage memberStorage) {
		this.memberStorage = memberStorage;
	}

	public Member doLogin(int id, String password) {

		Member loginMember = null;
		boolean correct = false;
		for (int i = 0; i < memberStorage.getMembers().size(); i++) {
			if (memberStorage.getMembers().get(i).getId() == id &&
					memberStorage.getMembers().get(i).getPassword().equals(password)) {
				loginMember = memberStorage.getMembers().get(i);
				correct = true;

			} else {
				correct = false;
			}
		}
		return loginMember;

	}

}
