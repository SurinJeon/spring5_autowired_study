package spring5_autowired_study.config;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {

	@Autowired
	private MemberDao memberDao;
	
//	@Autowired
	private MemberPrinter printer;

	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);

		if (member == null) {
			System.out.println("데이터가 없습니다.\n");
			return;
		}
		printer.print(member);

		System.out.println();

	}
	

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Autowired
//	@Qualifier("printer1")
	public void setPrinter(MemberPrinter memberPrinter) {
		this.printer = memberPrinter;
	}

}
