package spring5_autowired_study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberInfoPrinter {

	private MemberDao memberDao;
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
	
	/* Autowired anotation은 field 뿐만 아니라 method에서도 사용 가능함*/
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Autowired
	@Qualifier("printer")
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}

//	@Autowired
////	@Qualifier("printer1")
//	public void setPrinter(MemberPrinter memberPrinter) {
//		this.printer = memberPrinter;
//	}

}
