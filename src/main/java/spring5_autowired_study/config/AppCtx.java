package spring5_autowired_study.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx { // Assembler와 다른건 여기서는 Composite 관계임

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("printer1")
	public MemberPrinter memberPrinter1() {
		return new MemberPrn1();
	}
	
	@Bean
	@Qualifier("printer2")
	public MemberPrinter memberPrinter2() {
		return new MemberPrn2();
	}
	
	@Bean
	public MemberListPrinter memberListPrinter() {
		return new MemberListPrinter(memberDao(), memberPrinter());
	}
	
	@Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		
		/*@Autowired로 아래부분 생략 가능*/
		
//		infoPrinter.setMemberDao(memberDao());
//		infoPrinter.setPrinter(memberPrinter());
		return infoPrinter;
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
