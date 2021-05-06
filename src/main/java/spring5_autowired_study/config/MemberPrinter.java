package spring5_autowired_study.config;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

public class MemberPrinter {

	private DateTimeFormatter dateTimeFormatter; // 날짜 표시
	
	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}

	public void print(Member member) {
		if (dateTimeFormatter == null) { // 주입되지 않았다면
			System.out.printf("회원정보: 아이디 >> %s, 이메일 >> %s, 이름 >> %s, 등록일 >> %tF%n", member.getId(), member.getEmail(),
					member.getName(), member.getRegisterDateTime());
		} else { // 주입되었다면
			System.out.printf("회원정보: 아이디 >> %s, 이메일 >> %s, 이름 >> %s, 등록일 >> %s%n", member.getId(), member.getEmail(),
					member.getName(), dateTimeFormatter.format(member.getRegisterDateTime()));
		}

	}

	@Autowired (required = false) // false option 붙이면 안 들어와도 된다는 뜻 << 생성자에서 만들어진게 그대로 들어오게됨
	public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}

}
