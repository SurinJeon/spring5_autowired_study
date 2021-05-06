package spring5_autowired_study.config;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {

	@Autowired
	private MemberDao memberDao;

//	public void setMemberDao(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	} << autowired 할 것이기 때문에 따로 setting이 필요 없음

	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			throw new MemberNotFoundException();
		}

		member.changePassword(oldPwd, newPwd); // 원래는 true면 update해야하기 때문에 try-catch 필요한데 일단은 그냥 한거임

		memberDao.update(member);
	}

}
