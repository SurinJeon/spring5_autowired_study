package spring5_autowired_study.config;

@SuppressWarnings("serial")
public class DuplicateMemberException extends RuntimeException {

	public DuplicateMemberException() {
	}

	public DuplicateMemberException(String message) {
		super(message);
	}

	
}
