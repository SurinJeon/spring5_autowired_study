package spring5_autowired_study.config;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService{
	
	@Autowired
	private MemberDao memberDao;

	public MemberRegisterService() {
	}

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public Long regist(RegistRequest req) {
		// dao 여러개 쓰지만 transaction 쓰지 않는 이유 >> 하나는 select이기 때문에 쓰지 않아도 됨
		Member member = memberDao.selectByEmail(req.getEmail());
		
		if(member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		
		memberDao.insert(newMember);
		
		return newMember.getId();
		
	}
}
