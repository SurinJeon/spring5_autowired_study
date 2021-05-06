package spring5_autowired_study.config;

public class MemberPrn2 extends MemberPrinter {

	@Override
	public void print(Member member) {
		System.out.printf("회원정보: 이름 >> %s, 등록일 >> %tF%n"
				, member.getName(), member.getRegisterDateTime());
	}

}
